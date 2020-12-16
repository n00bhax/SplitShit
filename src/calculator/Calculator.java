package calculator;

import database.Database;
import objects.Person;
import objects.tickets.Ticket;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

//Kijk naar mathias code
//https://gitlab.com/WatcherWhale/softwaredesign/-/blob/master/MoneyTracker/src/main/java/be/montra/bills/Bill.java#L21

public class Calculator {

    private final Database<Ticket> tickets = Database.getTicketDatabase();
    private final Database<Person> persons = Database.getPersonDatabase();

    public LinkedHashMap<Person, LinkedHashMap<Person, Double>> createBill() {

        LinkedHashMap<Person, LinkedHashMap<Person, Double>> result = new LinkedHashMap<>();
        for (Person lender : persons) {

            LinkedHashMap<Person, Double> debtors = new LinkedHashMap<>();

            for (Ticket t : tickets) {

                for (Person d : t.getDebtors()) {
                    if (d != lender && t.isLender(lender)) {

                        Double debt = debtors.get(d);
                        if (debt == null)
                            debt = 0.0;

                        debt += t.getDebt(d);
                        debtors.put(d, debt);
                    }
                }
            }

            result.put(lender, debtors);
        }

        return SimplifyBill(result);
    }

    private LinkedHashMap<Person, LinkedHashMap<Person, Double>> SimplifyBill(LinkedHashMap<Person, LinkedHashMap<Person, Double>> bill){

        for (Person p1: persons){
            for (Person p2: persons){

                if (p1 != p2){

                    if (bill.get(p1).get(p2) != null && bill.get(p2).get(p1) != null){

                        double simplifiedDebt = Math.abs(bill.get(p1).get(p2) - bill.get(p2).get(p1));

                        if (bill.get(p1).get(p2) > bill.get(p2).get(p1)){

                            bill.get(p1).put(p2, simplifiedDebt);
                            bill.get(p2).remove(p1);
                        } else {
                            bill.get(p2).put(p1, simplifiedDebt);
                            bill.get(p1).remove(p2);
                        }
                    }
                }
            }
        }

        return bill;
    }

}

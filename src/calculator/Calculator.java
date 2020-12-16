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

    public LinkedHashMap<Person, LinkedHashMap<Person, Double>> createBill(){

        LinkedHashMap<Person, LinkedHashMap<Person, Double>> result = new LinkedHashMap<>();
        for (Person lender: persons){

            LinkedHashMap<Person, Double> debtors = new LinkedHashMap<>();

            for (Person debtor: persons){
                if (debtor != lender){
                    Double debt = 0.0;

                    for (Ticket t: tickets){

                        if (t.isLender(lender))
                            if (t.getDebt(debtor) != null)
                                debt += t.getDebt(debtor);
                    }

                    debtors.put(debtor, debt);
                }

            }

            result.put(lender, debtors);

        }

        return SimplifyBill(result);
    }

    public LinkedHashMap<Person, LinkedHashMap<Person, Double>> SimplifyBill(LinkedHashMap<Person, LinkedHashMap<Person, Double>> bill){

        for (Person lender: persons){
            for (Person debtor: persons){
                if (debtor != lender)
                    if (bill.get(lender).get(debtor) == 0.0)
                        bill.get(lender).remove(debtor);
            }
        }

        LinkedHashMap<Person, LinkedHashMap<Person, Double>> newBill = null;

        for (Person p1: persons){
            for (Person p2: persons){
                if (p1 != p2){
                    if (bill.get(p1).get(p2) != null && bill.get(p2).get(p1) != null){
                        double debt = bill.get(p1).get(p2);
                        debt -= bill.get(p2).get(p1);
                        newBill.get(p1).put(p2, debt);
                    }
                }
            }
        }

        return newBill;
    }

}

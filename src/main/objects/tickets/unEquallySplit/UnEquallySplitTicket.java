package objects.tickets.unEquallySplit;

import objects.Person;
import objects.tickets.Ticket;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public abstract class UnEquallySplitTicket extends Ticket {

    private final LinkedHashMap<Person, Double> distribution = new LinkedHashMap<>();
    //Persons Doubles contain how much they are in debt (need to pay back). (shouldn't be 0)

    public UnEquallySplitTicket(String ticketName, double debtAmount, Person lender) {
        super(ticketName, debtAmount, lender);
    }

    @Override
    public void addPerson(Person p, double debtAmount) {
        if (debtAmount > 0){

            double sum = 0;
            for (double v :distribution.values())
                sum += v;

            if (sum + debtAmount <= totalPrice)
                distribution.put(p, debtAmount);
            else
                System.out.println("The total price of the ticket and the debt of this person don't add up");
        }
        else
            System.out.println("Debt should be higher than 0.0");
    }

    public ArrayList<Person> getDebtors(){
        return new ArrayList<>(distribution.keySet());
    }

    public Double getDebt(Person p){
        return distribution.get(p);
    }

    public boolean isEquallySplit(){
        return false;
    }

    @Override
    public String toString() {
        String lendingPeople = distribution.keySet().stream().map(key -> key.getName() + " " + distribution.get(key)).collect(Collectors.joining(", "));
        return name + ": " + lender.getName() + " payed " + totalPrice + " [" + lendingPeople + "]";
    }
}

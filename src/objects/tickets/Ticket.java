package objects.tickets;

import objects.Person;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public abstract class Ticket {

    private String name;
    private double totalPrice;
    private final LinkedHashMap<Person, Double> distribution = new LinkedHashMap<>();
    //Persons Doubles contain how much they are in debt (need to pay back). (=0 when split equally)
    private Person lender;


    //public PropertyChangeSupport support = new PropertyChangeSupport(this);

    public Ticket(String ticketName, double totalPrice, Person lender) {
        this.name = ticketName;
        this.totalPrice = totalPrice;
        this.lender = lender;
        //addPerson(lender, 0);
        //support.firePropertyChange("newTicket", null, null);
    }

    //public void addPropertyChangeListener(PropertyChangeListener pcl) {
    //    support.addPropertyChangeListener(pcl);
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setLender(Person lender) {
        this.lender = lender;
     //   support.firePropertyChange("newLender", null, null);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addPerson(Person p, double debtAmount) {
        distribution.put(p, debtAmount);
      //  support.firePropertyChange("addPerson", null, null);
    }

    @Override
    public String toString() {
        return name + ": " + lender.getName() + " payed " + totalPrice + " (" + distribution.keySet().stream().map(key -> key.getName() + " " + distribution.get(key)).collect(Collectors.joining(", ")) + ")";
    }

}

package objects;

import java.util.ArrayList;
import java.util.HashMap;

public class Ticket {

    private String name;
    private double totalPrice;
    private HashMap<Person, Double> distribution = new HashMap<>();

    public Ticket(String name, double totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addPerson(Person p, double payed) {
        distribution.put(p, payed);
    }

    public void printDistribution() {
        System.out.println(distribution.toString());
    }
}

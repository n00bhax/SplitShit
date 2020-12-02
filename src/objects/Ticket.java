package objects;

import database.Database;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ticket {

    private String name;
    private double totalPrice;
    private LinkedHashMap<Person, Double> distribution = new LinkedHashMap<>();

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
        //HEEFT PROPERTYCHANGE DING NODIG
        distribution.put(p, payed);
    }

    public void printDistribution() {
        System.out.println(distribution.toString());
    }


    @Override
    public String toString() {
        return "Ticket: " + name +
                "\n\tTotal Price: " + totalPrice +
                //"\n\t" + distribution.keySet().stream().map( key -> "Key:" + key ).collect(Collectors.joining("\t"));
                "\n\t" + distribution.keySet().stream().map(key -> key.getName() + distribution.get(key) ).collect(Collectors.joining("\t"));//distribution.keySet().forEach((k, v) -> "\t" + k.getName() + ": " + v );

        //.map(key -> key + " "+ distribution.get(key));//
    }

}

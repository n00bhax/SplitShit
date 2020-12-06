package objects;

import database.Database;
import org.w3c.dom.ls.LSOutput;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ticket {

    private String name;
    private double totalPrice;
    private LinkedHashMap<Person, Double> distribution = new LinkedHashMap<>();

    // Ik gebruik geen Observers wegens depcricated in java 15. Jens zei dat het goed was.
    public PropertyChangeSupport support = new PropertyChangeSupport(this);

    public Ticket(String name, double totalPrice) {
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
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
        support.firePropertyChange("addPerson", null, p);
    }

    public void printDistribution() {
        System.out.println(distribution.toString());
    }


    @Override
    public String toString() {
        return "\nTicket: " + name +
                "\n\tTotal Price: " + totalPrice +
                //"\n\t" + distribution.keySet().stream().map( key -> "Key:" + key ).collect(Collectors.joining("\t"));
                "\n\t" + distribution.keySet().stream().map(key -> key.getName() + " " + distribution.get(key) ).collect(Collectors.joining("\t"));//distribution.keySet().forEach((k, v) -> "\t" + k.getName() + ": " + v );

        //.map(key -> key + " "+ distribution.get(key));//
    }

}

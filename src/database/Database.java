package database;

import objects.Person;
import objects.tickets.Ticket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Database<E> implements Iterable<E>{

    // Ik gebruik geen Observers wegens depcricated in java 15. Jens zei dat het goed was.
    public PropertyChangeSupport support = new PropertyChangeSupport(this);

    //Naam is key, Object is value
    protected LinkedHashMap<String, E> data = new LinkedHashMap<>();

    private static Database<Ticket> ticketDatabase = null;
    private static Database<Person> personDatabase = null;

    public static Database<Ticket> getTicketDatabase(){
        if (ticketDatabase == null)
            ticketDatabase = new Database<>();
        return ticketDatabase;
    }

    public static Database<Person> getPersonDatabase(){
        if (personDatabase == null)
            personDatabase = new Database<>();
        return personDatabase;
    }

    public Database() {

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void add(String name, E e) {
        if (data.put(name, e) == null)
            support.firePropertyChange("add", null, null);
        else
            System.out.println(name + " bestaat al");

    }

    public void remove(String key){
        data.remove(key);
        support.firePropertyChange("remove", null, null);
    }

    public E get(String name){
        return data.get(name);
    }


    @Override
    public Iterator<E> iterator() {
        return this.data.values().iterator();
    }


}

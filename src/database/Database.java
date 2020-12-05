package database;

import objects.Person;
import objects.Ticket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Database<E> implements Iterable<E>{

    // Ik gebruik geen Observers wegens depcricated in java 15. Jens zei dat het goed was.
    public PropertyChangeSupport support = new PropertyChangeSupport(this);
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
        data.put(name, e);
        support.firePropertyChange("add", this.data, e);

        //this.pcs.firePropertyChange("value", oldValue, newValue);
    }

    public void getListUI(){

    }

    @Override
    public Iterator<E> iterator() {
        return this.data.values().iterator();
    }

    public E get(String name){
        return data.get(name);
    }
}

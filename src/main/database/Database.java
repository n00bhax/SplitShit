package database;

import objects.Person;
import objects.tickets.Ticket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Database<E> implements Iterable<E>{

    // I don't use Observers since they are deprecated in java 15. Jens said it was okay.
    public PropertyChangeSupport support = new PropertyChangeSupport(this);

    //Name is key, Ticket/Person is value
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

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void add(String name, E e) {

        if (data.put(name, e) == null)
            support.firePropertyChange("add", null, null);
        else
            System.out.println(name + " already exist");
    }

    public void remove(String key){
        data.remove(key);
        support.firePropertyChange("remove", null, null);
    }

    public String[] getKeys(){
        return data.keySet().toArray(new String[0]);
    }

    public E get(String name){
        return data.get(name);
    }


    @Override
    public Iterator<E> iterator() {
        return this.data.values().iterator();
    }


}

package database;

import objects.Object;
import objects.Person;
import objects.Ticket;

import java.util.ArrayList;
import java.util.Iterator;

public class Database implements Iterable<Object>{

    //HashMap<String, Ticket[]> data;
    protected ArrayList<Object> data = new ArrayList<>();

    public void add(Object e) {
        data.add(e);
    }

    @Override
    public Iterator<Object> iterator() {
        return this.data.iterator();
    }

    public Object getObject(String name){
        for (Object e: data){
            if (e.getName().equals(name))
                return e;
        }
        return null;
    }

}

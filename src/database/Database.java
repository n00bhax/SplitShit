package database;

import objects.Person;
import objects.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Database<E> implements Iterable<E>{

    //HashMap<String, Ticket[]> data;
    protected LinkedHashMap<String, E> data = new LinkedHashMap<>();

    public void add(String name, E e) {
        data.put(name, e);
    }

    @Override
    public Iterator<E> iterator() {
        return this.data.values().iterator();
    }

    public E getObject(String name){
        return data.get(name);
    }
}

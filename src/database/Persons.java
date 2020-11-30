package database;

import objects.Person;

import java.util.ArrayList;


public class Persons implements Database{

    //HashMap<String, Ticket[]> data;
    ArrayList<Person> data = new ArrayList<>();

    @Override
    public <E> void add(E e) {
        data.add((Person) e);
    }

    @Override
    public <E> ArrayList<E> get() {
        return (ArrayList<E>) data;
    }


}

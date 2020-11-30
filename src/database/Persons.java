package database;

import objects.Person;

import java.util.ArrayList;


public class Persons {

    //HashMap<String, Ticket[]> data;
    ArrayList<Person> data = new ArrayList<>();

    public void add(Person p) {
        data.add(p);
    }

    public ArrayList<Person> get() {
        return data;
    }


}

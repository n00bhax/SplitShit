package database;

import objects.Person;
import objects.Ticket;

import java.util.ArrayList;


public class Persons {

    private static Persons single_instance = null;
    //HashMap<String, Ticket[]> data;
    ArrayList<Person> data = new ArrayList<>();

    public static Persons getInstance(){
        if (single_instance == null)
            single_instance = new Persons();
        return single_instance;
    }

    public void add(Person p) {
        data.add(p);
    }

    public ArrayList<Person> get() {
        return data;
    }

    public Person getPerson(String name){
        for (Person p: data){
            if (p.getName().equals(name))
                return p;
        }
        return null;
    }

}

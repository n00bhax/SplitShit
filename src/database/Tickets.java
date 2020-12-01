package database;

import controller.Controller;
import objects.Ticket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Tickets extends Database{


    private static Tickets single_instance = null;
    //ArrayList<Ticket> data = new ArrayList<>();

    public static Tickets getInstance(){
        if (single_instance == null)
            single_instance = new Tickets();
        return single_instance;
    }
/*
    public void add(Ticket t) {
        data.add(t);
    }

    public ArrayList<Ticket> get() {
        return data;
    }

    public Ticket getTicket(String name){
        for (Ticket t: this.data){
            if (t.getName().equals(name))
                return t;
        }
        return null;
    }
*/


}

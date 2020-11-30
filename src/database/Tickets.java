package database;

import objects.Ticket;

import java.util.ArrayList;

public class Tickets {

    ArrayList<Ticket> data = new ArrayList<>();

    public void add(Ticket t) {
        data.add(t);
    }

    public ArrayList<Ticket> get() {
        return data;
    }
}

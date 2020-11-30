package database;

import objects.Ticket;

import java.util.ArrayList;

public class Tickets implements Database {

    ArrayList<Ticket> data = new ArrayList<>();

    @Override
    public <E> void add(E e) {
        data.add((Ticket) e);
    }

    @Override
    public <E> ArrayList<E> get() {
        return  (ArrayList<E>) data;
    }
}

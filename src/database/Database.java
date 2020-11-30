package database;

import java.util.ArrayList;
// deze klasse is useless
public class Database
{
    private Tickets tickets;
    private Persons persons;

    public Database(Tickets tickets, Persons persons) {
        this.tickets = tickets;
        this.persons = persons;
    }
}
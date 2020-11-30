package database;

import java.util.ArrayList;

public interface Database
{
    < E > void add(E e);
    < E > ArrayList < E > get();
}
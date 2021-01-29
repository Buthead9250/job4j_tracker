package ru.job4j.tracker;

import java.util.Comparator;

public class SortByNameAsc implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2) {
        return a1.getName().compareTo(a2.getName());
    }
}

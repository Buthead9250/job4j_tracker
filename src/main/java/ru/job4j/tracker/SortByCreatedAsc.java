package ru.job4j.tracker;

import java.util.Comparator;

public class SortByCreatedAsc implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2) {
        return a1.getCreated().compareTo(a2.getCreated());
    }
}

package ru.job4j.tracker.bank;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByNameAsc implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2) {
        return a1.getName().compareTo(a2.getName());
    }
}

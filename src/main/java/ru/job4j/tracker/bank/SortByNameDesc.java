package ru.job4j.tracker.bank;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByNameDesc implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2) {
        return a2.getName().compareTo(a1.getName());
    }
}

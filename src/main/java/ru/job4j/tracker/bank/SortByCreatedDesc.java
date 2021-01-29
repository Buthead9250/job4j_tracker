package ru.job4j.tracker.bank;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByCreatedDesc implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2) {
        return a2.getCreated().compareTo(a1.getCreated());
    }
}

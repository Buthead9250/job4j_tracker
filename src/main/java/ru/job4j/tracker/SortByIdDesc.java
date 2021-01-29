package ru.job4j.tracker;

import java.util.Comparator;

public class SortByIdDesc implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2) {
        return Integer.compare(a2.getId(), a1.getId());
    }
}

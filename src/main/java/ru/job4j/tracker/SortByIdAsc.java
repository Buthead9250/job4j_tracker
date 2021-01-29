package ru.job4j.tracker;

import java.util.Comparator;

public class SortByIdAsc implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2) {
        return Integer.compare(a1.getId(), a2.getId());
    }
}

package ru.job4j.tracker.bank;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByIdDesc implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2) {
        return Integer.compare(a2.getId(), a1.getId());
    }
}

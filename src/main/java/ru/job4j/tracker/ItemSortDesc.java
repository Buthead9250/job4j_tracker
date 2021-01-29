package ru.job4j.tracker;

import ru.job4j.tracker.Item;
import java.util.Comparator;

public class ItemSortDesc implements Comparator<Item> {
    @Override
    public int compare(Item a1, Item a2) {
        return a2.compareTo(a1);
    }
}

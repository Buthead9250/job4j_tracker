package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int count = 0;
        Item[] itemWithoutNull = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                itemWithoutNull[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(itemWithoutNull, count);
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] itemWithEqName = new Item[size];
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                itemWithEqName[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(itemWithEqName, count);
    }
}
package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Item implements Comparable<Item> {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name='"
                + name + '\'' + ", created="
                + created + '}';
    }

    @Override
    public int compareTo(Item anotherItem) {
        return Integer.compare(this.id, anotherItem.getId());
    }
}

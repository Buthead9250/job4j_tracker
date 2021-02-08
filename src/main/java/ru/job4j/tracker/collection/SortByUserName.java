package ru.job4j.tracker.collection;

import java.util.Comparator;

public class SortByUserName implements Comparator<User> {

    @Override
    public int compare(User first, User second) {
        return first.getName().compareTo(second.getName());
    }
}

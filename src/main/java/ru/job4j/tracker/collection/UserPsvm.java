package ru.job4j.tracker.collection;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UserPsvm {
    public static void main(String[] args) {
        Set<User> users = new TreeSet<>();
        users.add(new User("Alex", 26));
        users.add(new User("Alex", 27));
        users.add(new User("Alex", 28));
        System.out.println(users);
    }
}

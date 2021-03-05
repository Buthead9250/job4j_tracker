package ru.job4j.tracker.collection;

import java.util.Set;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originArray = origin.split("[.,!?:; ]");
        String[] lineArray = line.split("[.,!?:; ]");
        Set<String> hashSet = new HashSet<>();
        for (String value : originArray) {
            hashSet.add(value);
        }
        for (String value : lineArray) {
            if (!hashSet.contains(value)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}

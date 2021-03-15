package ru.job4j.tracker.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filterSize(List<Folder> list) {
        Predicate<Folder> function = new Predicate<Folder>() {
            @Override
            public boolean test(Folder folder) {
                return folder.getSize() > 100;
            }
        };
        return filter(list, function);
    }

    public static List<Folder> filterName(List<Folder> list) {
        Predicate<Folder> function = new Predicate<Folder>() {
            @Override
            public boolean test(Folder folder) {
                return folder.getName().contains("bug");
            }
        };
        return filter(list, function);
    }

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}

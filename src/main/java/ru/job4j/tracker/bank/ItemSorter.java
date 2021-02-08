package ru.job4j.tracker.bank;

import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("Item 1", 1),
                new Item("Item 4", 4),
                new Item("Item 2", 2),
                new Item("Item 3", 3)
        );
        System.out.println("Стартовый список");
        System.out.println(items);
        System.out.println("Отсортирован по возрастанию по дате создания");
        Collections.sort(items, new SortByCreatedAsc());
        System.out.println(items);
        System.out.println("Отсортирован по убыванию по дате создания");
        Collections.sort(items, new SortByCreatedDesc());
        System.out.println(items);
        System.out.println("Отсортирован по возрастанию по имени");
        Collections.sort(items, new SortByNameAsc());
        System.out.println(items);
        System.out.println("Отсортирован по убыванию по имени");
        Collections.sort(items, new SortByNameDesc());
        System.out.println(items);
        System.out.println("Отсортирован по возрастанию по id");
        Collections.sort(items, new SortByIdAsc());
        System.out.println(items);
        System.out.println("Отсортирован по убыванию по id");
        Collections.sort(items, new SortByIdDesc());
        System.out.println(items);
    }
}

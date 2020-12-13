package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime dateTime = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(dateTime.format(formatter));
        Tracker tracker = new Tracker();
        tracker.add(item);
        System.out.println(tracker.findById(item.getId()));
        Item item1 = new Item("Object", 22);
        System.out.println(item1);
    }


}

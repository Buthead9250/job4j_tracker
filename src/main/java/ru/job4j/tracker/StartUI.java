package ru.job4j.tracker;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import javax.sound.midi.Track;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = false;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                addItem(input, tracker);
            } else if (select == 1) {
                allItem(tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = exit();
            }
            System.out.println();
        }
    }

    public static void addItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
    }

    public static void allItem(Tracker tracker) {
        System.out.println("=== All items ===");
        Item[] item1 = tracker.findAll();
        for (Item item : item1) {
            System.out.println(item);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter a new name for changed item: ");
        Item itemEdit = new Item();
        itemEdit.setName(name);
        if (tracker.replace(id, itemEdit)) {
            System.out.println("Item with id: " + id + " was edit");
        } else {
            System.out.println("Item with id: " + id + "wasn't edit");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id for delete: ");
        if (tracker.delete(id)) {
            System.out.println("Item with id: " + id + " was delete");
        } else {
            System.out.println("Item with id: " + id + " wasn't delete");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by ID ===");
        int id = input.askInt("Enter id: ");
        Item itemById = tracker.findById(id);
        if (itemById != null) {
            System.out.println(itemById);
        } else {
            System.out.println("Item not found");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by Name ===");
        String name = input.askStr("Enter name: ");
        Item[] itemByName = tracker.findByName(name);
        if (itemByName.length > 0) {
            for (Item item : itemByName) {
                System.out.println(itemByName);
            }
        } else {
            System.out.println("Item not found");
        }
        System.out.println("Result: " + System.lineSeparator() + itemByName);
    }

    public static boolean exit() {
        return false;
    }

    private static void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select: ");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

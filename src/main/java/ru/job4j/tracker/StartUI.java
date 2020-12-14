package ru.job4j.tracker;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = false;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All items ===");
                Item[] item1 = tracker.findAll();
                for (Item item : item1) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter a new name for changed item: ");
                String name = scanner.nextLine();
                Item itemEdit = new Item();
                itemEdit.setName(name);
                if (tracker.replace(id, itemEdit)) {
                    System.out.println("Item with id: " + id + " was edit");
                } else {
                    System.out.println("Item with id: " + id + "wasn't edit");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Enter id for delete: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item with id: " + id + " was delete");
                } else {
                    System.out.println("Item with id: " + id + " wasn't delete");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by ID ===");
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item itemById = tracker.findById(id);
                if (itemById != null) {
                    System.out.println(itemById);
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by Name ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] itemByName = tracker.findByName(name);
                if (itemByName.length > 0) {
                    for (Item item : itemByName) {
                        System.out.println(itemByName);
                    }
                } else {
                    System.out.println("Item not found");
                }
                System.out.println("Result: " + System.lineSeparator() + itemByName);
            } else if (select == 6) {
                run = false;
            }
            System.out.println();
        }
    }

    private void showMenu() {
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

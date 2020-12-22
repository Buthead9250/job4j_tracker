package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Name ===";
    }

    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] itemByName = tracker.findByName(name);
        if (itemByName.length > 0) {
            for (Item item : itemByName) {
                System.out.println(itemByName);
            }
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}

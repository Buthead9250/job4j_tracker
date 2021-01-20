package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Name ===";
    }

    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> itemByName = tracker.findByName(name);
        if (!itemByName.isEmpty()) {
            for (Item item : itemByName) {
                out.println(itemByName);
            }
        } else {
            out.println("Item not found");
        }
        return true;
    }
}

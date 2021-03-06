package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== All items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> item1 = tracker.findAll();
        for (Item item : item1) {
            out.println(item);
        }
        return true;
    }
}

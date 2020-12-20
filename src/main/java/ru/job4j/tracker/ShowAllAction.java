package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "=== All items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] item1 = tracker.findAll();
        for (Item item : item1) {
            System.out.println(item);
        }
        return true;
    }
}

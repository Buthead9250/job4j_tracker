package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "=== Find item by ID ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item itemById = tracker.findById(id);
        if (itemById != null) {
            System.out.println(itemById);
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}

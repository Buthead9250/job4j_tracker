package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for delete: ");
        if (tracker.delete(id)) {
            System.out.println("Item with id: " + id + " was delete");
        } else {
            System.out.println("Item with id: " + id + " wasn't delete");
        }
        return true;
    }
}

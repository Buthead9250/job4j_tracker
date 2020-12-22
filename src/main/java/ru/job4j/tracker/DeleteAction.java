package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for delete: ");
        if (tracker.delete(id)) {
            out.println("Item with id: " + id + " was delete");
        } else {
            out.println("Item with id: " + id + " wasn't delete");
        }
        return true;
    }
}

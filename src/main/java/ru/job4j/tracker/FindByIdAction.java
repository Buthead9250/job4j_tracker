package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by ID ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item itemById = tracker.findById(id);
        if (itemById != null) {
            out.println(itemById);
        } else {
            out.println("Item not found");
        }
        return true;
    }
}

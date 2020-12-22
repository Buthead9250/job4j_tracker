package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter a new name for changed item: ");
        Item itemEdit = new Item();
        itemEdit.setName(name);
        if (tracker.replace(id, itemEdit)) {
            out.println("Item with id: " + id + " was edit");
        } else {
            out.println("Item with id: " + id + "wasn't edit");
        }
        return true;
    }
}

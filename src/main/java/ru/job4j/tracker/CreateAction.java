package ru.job4j.tracker;

import javax.sound.midi.Track;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
        return true;
    }
}

package ru.job4j.tracker;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSortDescTest {

    @Test
    public void compare() {
        Item item = new Item(2, "item1");
        Item anotherItem = new Item(4, "item2");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(anotherItem);
        Collections.sort(tracker.findAll(), new SortItemDesc());
        assertThat(tracker.findAll().get(0).getName(), is("item2"));
    }
}
package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SortItem;
import ru.job4j.tracker.Tracker;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSortAscTest {

    @Test
    public void compare() {
        Item item = new Item(2, "item1");
        Item anotherItem = new Item(4, "item2");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(anotherItem);
        Collections.sort(tracker.findAll(), new SortItemAsc());
        assertThat(tracker.findAll().get(0).getName(), is("item1"));
    }
}
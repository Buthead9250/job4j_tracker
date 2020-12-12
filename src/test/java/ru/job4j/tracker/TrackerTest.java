package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findItemID() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("one", 1);
        Item item2 = new Item("two", 2);
        Item item3 = new Item("three", 3);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById(2);
        assertThat(result, is(item2));
    }

    @Test
    public void findAllTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("one", 1);
        Item item2 = new Item("two", 2);
        Item item3 = new Item("three", 3);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findAll();
        Item[] expected = {item1, item2, item3};
        assertThat(result, is(expected));
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("one", 1);
        Item item2 = new Item("two", 2);
        Item item3 = new Item("three", 3);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findByName("three");
        Item[] expected = {item3};
        assertThat(result, is(expected));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }
}

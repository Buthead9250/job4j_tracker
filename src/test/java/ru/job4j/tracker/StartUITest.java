package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === All items ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === All items ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdZero() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find item by ID ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
                        + "Item not found" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find item by ID ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        Input input = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find item by ID ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
                        + "Item{"
                        + "id=" + item.getId()
                        + ", name='" + item.getName() + '\''
                        + ", created=" + item.getCreated().toString()
                        + "}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find item by ID ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameNull() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "Name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find item by Name ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
                        + "Item not found" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find item by Name ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        Input input = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find item by Name ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
                        + "[Item{"
                        + "id=" + item.getId()
                        + ", name='" + item.getName() + '\''
                        + ", created=" + item.getCreated().toString()
                        + "}]" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find item by Name ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"9", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit ===%n"
                                + "Wrong input, you can select: 0.. 0%n"
                                + "Menu.%n"
                                + "0. === Exit ===%n"
                )
        ));
    }
}

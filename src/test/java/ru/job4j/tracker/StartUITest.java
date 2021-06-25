package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItemAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }
}
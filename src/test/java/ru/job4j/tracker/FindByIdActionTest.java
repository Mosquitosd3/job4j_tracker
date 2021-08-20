package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.Output;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {
    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Find by id");
        tracker.add(item);
        FindByIdAction find = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        assertNotNull(tracker.findById(1));
        assertThat(out.toString(), is(item + System.lineSeparator()));
    }
}
package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.Output;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class DeleteActionTest {
    @Test
    public void whenDeleteAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("delete item"));
        DeleteAction delete = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        delete.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Delete Item" + ln + "delete successfully" + ln));
        assertNull(tracker.findById(1));
    }
}
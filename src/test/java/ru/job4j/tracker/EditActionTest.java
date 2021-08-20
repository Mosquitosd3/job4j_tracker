package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.Output;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class EditActionTest {
    @Test
    public void whenEditAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Edit item"));
        String editName = "New item name";
        EditAction edit = new EditAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(editName);
        edit.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Edit item" + ln + "Edit successfully" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(editName));
    }

    @Test
    public void whenNotEditAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Edit item"));
        EditAction edit = new EditAction(out);
        Input input = mock(Input.class);
        edit.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Edit item" + ln + "Edit failed" + ln));
        assertThat(tracker.findAll().get(0).getName(), is("Edit item"));
    }
}
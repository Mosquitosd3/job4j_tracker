package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.Output;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {
    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("findName item");
        tracker.add(item);
        FindByNameAction findName = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("findName item");
        findName.execute(input, tracker);
        String ln = System.lineSeparator();
        String expected = "Find by name" + ln + "[" +  item + "]" + ln;
        assertThat(out.toString(), is(expected));
    }
}
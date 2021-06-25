package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;

public class CreateItemAction implements UserAction {
    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        String name = input.askStr("Enter name item");
        tracker.add(new Item(name));
        return true;
    }
}

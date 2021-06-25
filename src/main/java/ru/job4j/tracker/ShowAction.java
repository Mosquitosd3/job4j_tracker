package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "Show all item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        return true;
    }
}

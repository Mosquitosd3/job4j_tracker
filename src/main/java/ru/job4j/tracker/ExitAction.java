package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        return false;
    }
}

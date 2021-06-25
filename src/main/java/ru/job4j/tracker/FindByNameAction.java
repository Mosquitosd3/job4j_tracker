package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        String name = input.askStr("Enter name");
        System.out.println(tracker.findByName(name));
        return true;
    }
}

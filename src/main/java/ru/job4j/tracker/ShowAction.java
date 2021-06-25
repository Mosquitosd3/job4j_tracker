package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.Output;
import ru.job4j.tracker.interfaces.UserAction;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println(name());
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        return true;
    }
}

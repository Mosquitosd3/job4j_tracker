package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id");
        System.out.println(tracker.findById(id));
        return true;
    }
}

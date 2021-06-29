package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.Output;
import ru.job4j.tracker.interfaces.Store;
import ru.job4j.tracker.interfaces.UserAction;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id");
        out.println(tracker.findById(id));
        return true;
    }
}

package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.Output;
import ru.job4j.tracker.interfaces.Store;
import ru.job4j.tracker.interfaces.UserAction;

public class CreateItemAction implements UserAction {
    private final Output out;

    public CreateItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println(name());
        String name = input.askStr("Enter name item");
        tracker.add(new Item(name));
        return true;
    }
}

package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.Output;
import ru.job4j.tracker.interfaces.Store;
import ru.job4j.tracker.interfaces.UserAction;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println(name());
        int id = input.askInt("Enter id item");
        String name = input.askStr("Enter new name");
        if (tracker.replace(id, new Item(name))) {
            out.println("Edit successfully");
        } else {
            out.println("Edit failed");
        }
        return true;
    }
}

package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        int id = input.askInt("Enter id item");
        String name = input.askStr("Enter new name");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Edit successfully");
        } else {
            System.out.println("Edit failed");
        }
        return true;
    }
}

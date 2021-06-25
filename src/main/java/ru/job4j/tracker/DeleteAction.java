package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.UserAction;

public class DeleteAction implements UserAction  {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        int id = input.askInt("Enter id");
        if (tracker.delete(id)) {
            System.out.println("delete successfully");
        } else {
            System.out.println("Delete failed");
        }
        return true;
    }
}

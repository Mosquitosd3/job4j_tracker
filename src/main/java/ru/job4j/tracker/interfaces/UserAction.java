package ru.job4j.tracker.interfaces;

import ru.job4j.tracker.Tracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}

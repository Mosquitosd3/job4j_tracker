package ru.job4j.tracker.interfaces;

import ru.job4j.tracker.interfaces.Store;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}

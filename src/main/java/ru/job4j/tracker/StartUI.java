package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.interfaces.Output;
import ru.job4j.tracker.interfaces.Store;
import ru.job4j.tracker.interfaces.UserAction;

import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .." + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    public void showMenu() {
        List<String> menu = List.of(
                "0. Add new Item",
                "1. Show all items",
                "2. Edit item",
                "3. Delete item",
                "4. Find item by Id",
                "5. Find items by name",
                "6. Exit Program"
        );
        for (String str : menu) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateItemAction(output),
                    new ShowAction(output),
                    new EditAction(output),
                    new DeleteAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new ExitAction(output)
            };
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

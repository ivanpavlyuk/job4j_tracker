package ru.job4j.tracker;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(new ConsoleOutput()),
                new ShowAction(new ConsoleOutput()),
                new EditAction(new ConsoleOutput()),
                new DeleteAction(new ConsoleOutput()),
                new FindByIdAction(new ConsoleOutput()),
                new FindByNameAction(new ConsoleOutput()),
                new ExitAction()
        };
        new StartUI(new ConsoleOutput()).init(input, tracker, actions);
    }
}
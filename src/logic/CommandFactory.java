package logic;

import storage.User;
import userinterface.UserInterface;

public class CommandFactory {
    User user;
    UserInterface userInterface;
    Command command;

    public CommandFactory(UserInterface userInterface, Command command) {
        this.userInterface = userInterface;
        this.command = command;
    }

    public Command createCommand(int type) {
        Command command;
        switch(type) {
            case 0 -> command = new ViewBudgetCommand(user, userInterface);
            case 1 -> command = new ChangeBudgetCommand(user, userInterface);
            case 2 -> command = new ViewExpensesCommand(user, userInterface);
            //TODO: complete implementing Commands classes and complete the switch statement
            default -> throw new RuntimeException("No such command!");
        }
        return command;
    }
}

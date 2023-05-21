package logic;

import storage.User;
import userinterface.UserInterface;

import java.util.Map;

public class ViewExpensesCommand implements Command{
    private User user;
    private UserInterface userInterface;

    public ViewExpensesCommand(User user, UserInterface userInterface) {
        this.user = user;
        this.userInterface = userInterface;
    }

    @Override
    public void execute() {
        userInterface.showInfo("Your planned incomes: ");
        Map<String, Integer> expenses = user.getExpends();
        expenses.forEach(
                (key, value)
                        -> userInterface.showInfo("\tAmount: " + value + ", comment: " + key + "."));
    }
}

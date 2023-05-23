package logic;

import storage.User;
import userinterface.UserInterface;

import java.util.Map;

public class ViewIncomesCommand implements Command{
    private final User user;
    private final UserInterface userInterface;
    public ViewIncomesCommand(User user, UserInterface userInterface) {
        this.user = user;
        this.userInterface = userInterface;
    }
    @Override
    public void execute() {
        userInterface.showInfo("Your planned incomes: ");
        Map<String, Integer> incomes = user.getIncomes();
        incomes.forEach(
                (key, value)
                -> userInterface.showInfo("\tAmount: " + value + ", comment: " + key + "."));
    }
}

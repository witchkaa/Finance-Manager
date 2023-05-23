package logic;

import storage.IntHolder;
import storage.User;
import userinterface.UserInterface;

public class ChangeBudgetCommand implements Command{
    private final User user;
    private final UserInterface userInterface;
    public ChangeBudgetCommand(User user, UserInterface userInterface) {
        this.user = user;
        this.userInterface = userInterface;
    }
    @Override
    public void execute() {
        userInterface.showInfo("Enter the immediate changes you want to do with your budget. " +
                "Enter an integer number, like '50' to add 50 or '-300' to subtract 300.");
        int choice = (int) userInterface.askInfo("int");
        int newBudget = user.getBudget().getValue() + choice;
        user.setBudget(new IntHolder(newBudget));
    }
}

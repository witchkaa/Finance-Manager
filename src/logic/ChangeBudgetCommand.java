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
        int currentBudget = user.getBudget().getValue();
        if(currentBudget + choice >= 0) {
            int newBudget = user.getBudget().getValue() + choice;
            user.setBudget(new IntHolder(newBudget));
            userInterface.showInfo("Budget updated successfully.");
        } else {
            userInterface.showInfo("Your budget will be negative if you change it right now. Are you sure?" +
                    "\nPress '0' to continue, press any other number to go back");
            int choiceQuit = (int) userInterface.askInfo("int");
            if (choiceQuit == 0) {
                int newBudget = user.getBudget().getValue() + choice;
                user.setBudget(new IntHolder(newBudget));
                userInterface.showInfo("Budget updated successfully.");
            } else {
                userInterface.showInfo("Budget was not updated.");
            }

        }
    }
}

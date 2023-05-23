package logic;

import storage.IntHolder;
import storage.User;
import userinterface.UserInterface;

public class MarkExpenseDoneCommand implements Command{
    private final User user;
    private final UserInterface userInterface;
    public MarkExpenseDoneCommand (User user, UserInterface userInterface) {
        this.user = user;
        this.userInterface = userInterface;
    }
    @Override
    public void execute() {
        userInterface.showInfo("Type in the comment to the expense you want to mark as done. " +
                "Make sure you do it correctly!");
        String choice = (String)userInterface.askInfo("string");
        if(user.getExpends().containsKey(choice)) {
            int value = user.getExpends().get(choice);
            int oldBudget = user.getBudget().getValue();
            IntHolder newBudget = new IntHolder(oldBudget - value);
            user.setBudget(newBudget);
            user.getHistory().add(value * (-1));
            user.getExpends().remove(choice);
            userInterface.showInfo("Marked as done successfully!");

        } else {
            userInterface.showInfo("Wrong comment!");
        }

    }
}

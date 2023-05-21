package logic;

import storage.IntHolder;
import storage.User;
import userinterface.UserInterface;

public class MarkIncomeDoneCommand implements Command{
    private UserInterface userInterface;
    private User user;

    public MarkIncomeDoneCommand(User user, UserInterface userInterface) {
        this.userInterface = userInterface;
        this.user = user;
    }

    @Override
    public void execute() {
        userInterface.showInfo("Type in the comment to the income you want to mark as done. " +
                "Make sure you do it correctly!");
        String choice = (String)userInterface.askInfo("string");
        if(user.getIncomes().containsKey(choice)) {
            int value = user.getExpends().get(choice);
            int oldBudget = user.getBudget().getValue();
            IntHolder newBudget = new IntHolder(oldBudget + value);
            user.setBudget(newBudget);
            user.getIncomes().remove(choice);
            userInterface.showInfo("Marked as done successfully!");
        } else {
            userInterface.showInfo("Wrong comment!");
        }
    }
}

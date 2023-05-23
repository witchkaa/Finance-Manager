package logic;

import storage.User;
import userinterface.UserInterface;

public class AddIncomeCommand implements Command{
    private final User user;
    private final UserInterface userInterface;
    public AddIncomeCommand(User user, UserInterface userInterface) {
        this.user = user;
        this.userInterface = userInterface;
    }
    @Override
    public void execute() {
        userInterface.showInfo("Enter comment: ");
        String comment = (String) userInterface.askInfo("string");
        userInterface.showInfo("Enter amount: ");
        int amount = (int) userInterface.askInfo("int");
        user.getExpends().put(comment, amount);
        userInterface.showInfo("Put successfully!");
    }
}

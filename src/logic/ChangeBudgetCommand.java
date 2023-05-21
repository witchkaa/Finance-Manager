package logic;

import storage.User;
import userinterface.UserInterface;

public class ChangeBudgetCommand implements Command{
    private User user;
    private UserInterface userInterface;

    public ChangeBudgetCommand(User user, UserInterface userInterface) {
        this.user = user;
        this.userInterface = userInterface;
    }
    @Override
    public void execute() {

    }
}

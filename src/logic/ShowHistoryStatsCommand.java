package logic;

import storage.User;
import userinterface.UserInterface;

import java.util.List;

public class ShowHistoryStatsCommand implements Command{
    private final User user;
    private final UserInterface userInterface;
    public ShowHistoryStatsCommand(User user, UserInterface userInterface) {
        this.user = user;
        this.userInterface = userInterface;
    }
    @Override
    public void execute() {
        List<Integer> history = user.getHistory();
        int sum = 0;
        for(Integer value: history) {
            sum += value;
        }
        userInterface.showInfo("History of transactions stats: incomes-expenses = " + sum);
    }
}

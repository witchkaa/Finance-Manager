package logic;

import storage.User;
import userinterface.UserInterface;
import java.util.Map;

public class ComparePlansCommand implements Command{
    private final User user;
    private final UserInterface userInterface;
    public ComparePlansCommand(User user, UserInterface userInterface) {
        this.user = user;
        this.userInterface = userInterface;
    }
    @Override
    public void execute() {
        Map<String, Integer> expends = user.getExpends();
        Map<String, Integer> incomes = user.getIncomes();
        int incomesSum = 0;
        int expendsSum = 0;
        for(Map.Entry<String, Integer> entry : expends.entrySet()) {
            expendsSum += entry.getValue();
        }
        for(Map.Entry<String, Integer> entry : incomes.entrySet()) {
            incomesSum += entry.getValue();
        }
        int comparison = incomesSum - expendsSum;
        if (comparison > 0) {
            userInterface.showInfo("Your planned incomes are more than your planned expends by " + comparison +
                    "! That is good!"
            );
        } else if (comparison == 0) {
            userInterface.showInfo("Wow!!! Your planned incomes and expends are equal! Balance here.");
        } else {
            userInterface.showInfo("Your planned expends are more than you planned incomes by " + (comparison*(-1)) +
                    ". Consider re-watching your budget.");
        }
    }
}

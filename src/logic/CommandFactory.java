package logic;

import storage.User;
import userinterface.UserInterface;

import java.util.Scanner;

public class CommandFactory {
    User user;
    UserInterface userInterface;
    Command command;

    public CommandFactory(UserInterface userInterface, Command command) {
        this.userInterface = userInterface;
        this.command = command;
    }

    public Command createCommand(int type) {
        Command command;
        switch(type) {
            case 0 -> command = new ViewBudgetCommand(user, userInterface);
            case 1 -> command = new ChangeBudgetCommand(user, userInterface);
            case 2 -> command = new ViewExpensesCommand(user, userInterface);
            case 3 -> command = new ViewIncomesCommand(user, userInterface);
            case 4 -> command = new AddExpenseCommand(user, userInterface);
            case 5 -> command = new AddIncomeCommand(user, userInterface);
            case 6 -> command = new MarkExpenseDoneCommand(user, userInterface);
            case 7 -> command = new MarkIncomeDoneCommand(user, userInterface);
            case 8 -> command = new RemoveExpenseCommand(user, userInterface);
            case 9 -> command = new RemoveIncomeCommand(user, userInterface);
            default -> {
                command = null;
                System.out.println("No such command! Type a number 0-10: ");
                Scanner scan = new Scanner(System.in);
                int type2 = scan.nextInt();
                scan.close();
                createCommand(type2);
            }
        }
        return command;
    }
}

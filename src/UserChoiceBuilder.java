public class UserChoiceBuilder {
    UserChoice userChoice;
    public UserChoice doUsersChoice(int choice) {
        switch (choice) {
            case 1: return new ExpensesViewer();
            case 2: return new IncomesViewer();
            case 3: return new BudgetViewer();
        }
    }
}

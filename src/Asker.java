import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Asker {
    private static final User user = new User();
    public static int askUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                Choose what would you like to do:
                \tview planned expenses - press '1'
                \tview planned incomes - press '2'
                \tview current budget - press '3'
                \tadd expense - press '4'
                \tadd income - press '5'
                \tremove expense = press '6'
                \tremove income - press '7'
                \tmark expense as done - press '8'
                \tmark income as done - press '9'
                \tview income/expense ratio - press '10'
                """);
        int choice = scan.nextInt();
        int MAX_CHOICE = 10;
        int MIN_CHOICE = 1;
        if (choice < MIN_CHOICE || choice > MAX_CHOICE) {
            System.out.println("There's no such choice, try again!");
            askUser();
        }
        return choice;
    }
    public static void performAction(){
        int choice = askUser();
        switch (choice) {
            case 1 -> viewExpenses(user.getExpenses());
            case 2 -> viewIncomes(user.getIncomes());
            case 3 -> viewBudget(user.getBudget());
            case 4 ->  user.setExpenses(addExpense(user.getExpenses()));
            case 5 -> user.setIncomes(addIncome((user.getIncomes())));
            case 10 -> viewRatio(user.getExpenses(), user.getIncomes());

            //TODO: complete switching between choices of action
        }
    }
    public static HashMap<String,Double> readExpenses() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("expenseAmount.txt"));
        ArrayList<Double> expenseAmounts = (ArrayList<Double>) ois.readObject();
        ois = new ObjectInputStream(new FileInputStream("expenseComment.txt"));
        ArrayList<String> expenseComments = (ArrayList<String>) ois.readObject();
        ois.close();
        HashMap<String,Double> expenses = new HashMap<>();
        for(int i = 0; i < expenseAmounts.size(); i++) {
            expenses.put(expenseComments.get(i), expenseAmounts.get(i));
        }
        return expenses;
    }
    public static HashMap<String,Double> readIncomes() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("incomesAmount.txt"));
        ArrayList<Double> incomesAmount = (ArrayList<Double>) ois.readObject();
        ois = new ObjectInputStream(new FileInputStream("incomesComment.txt"));
        ArrayList<String> incomesComments = (ArrayList<String>) ois.readObject();
        ois.close();
        HashMap<String,Double> incomes = new HashMap<>();
        for(int i = 0; i < incomesAmount.size(); i++) {
            incomes.put(incomesComments.get(i), incomesAmount.get(i));
        }
        ois.close();
        return incomes;
    }

    public static void writeExpenses(HashMap<String,Double> expenses) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("expenseComment.txt"));
        Set<String> expensesCommentsSet = expenses.keySet();
        ArrayList<String> expensesComments = new ArrayList<>(expensesCommentsSet);
        oos.writeObject(expensesComments);
        oos.flush();
        oos = new ObjectOutputStream(new FileOutputStream("expenseAmount.txt"));
        Set<Double> expensesAmountsSet = (Set<Double>) expenses.values();
        ArrayList<Double> expensesAmounts = new ArrayList<>(expensesAmountsSet);
        oos.writeObject(expensesAmounts);
        oos.flush();
        oos.close();
    }
    public static void writeIncomes(HashMap<String,Double> incomes) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("incomesComment.txt"));
        Set<String> incomesCommentsSet = incomes.keySet();
        ArrayList<String> incomesComments = new ArrayList<>(incomesCommentsSet);
        oos.writeObject(incomesComments);
        oos.flush();
        oos = new ObjectOutputStream(new FileOutputStream("incomesAmount.txt"));
        Set<Double> incomesAmountsSet = (Set<Double>) incomes.values();
        ArrayList<Double> incomesAmounts = new ArrayList<>(incomesAmountsSet);
        oos.writeObject(incomesAmounts);
        oos.flush();
        oos.close();
    }

    private static void viewRatio(HashMap<String, Double> expenses, HashMap<String, Double> incomes) {
        Double[] expenseValues = expenses.values().toArray(new Double[0]);
        Double[] incomeValues = incomes.values().toArray(new Double[0]);
        double expenseSum = 0;
        double incomeSum = 0;
        for(Double value: expenseValues) {
            expenseSum += value;
        }
        for(Double value: incomeValues) {
            incomeSum += value;
        }
        double ratio = incomeSum - expenseSum;
        if (ratio>0) {
            System.out.println("Your planned incomes are more than your expenses by " + ratio);
        } else if (ratio < 0) {
            System.out.println("Your planned incomes are less than your expenses by " + (ratio*(-1)));
        } else {
            System.out.println("Incomes and expenses are equal! What a balance!");
        }
    }

    public static void viewExpenses(HashMap<String, Double> expenses) {
        System.out.println(expenses.toString());
    }
    public static void viewBudget(double budget) {
        System.out.println("Your budget is " + budget);
    }
    public static void viewIncomes(HashMap<String, Double> incomes) {
        System.out.println(incomes.toString());
    }
    public static double readBudget() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("budget.txt"));
        double budget =  (double) ois.readObject();
        return budget;
    }
    public static void writeBudget(double budget) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("budget"));
        oos.writeObject(budget);
        oos.flush();
        oos.close();
    }
    public static HashMap<String, Double> addExpense(HashMap<String, Double> expenses) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount of a new expense: ");
        double amount = scan.nextFloat();
        scan.nextLine();
        System.out.println("Enter the comment on the expense: ");
        String comment = scan.nextLine();
        System.out.println("Expense added: amount = " + amount +", comment: " + comment);
        expenses.put(comment, amount);
        return expenses;
    }
    public static HashMap<String, Double> addIncome(HashMap<String, Double> incomes) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount of a new income: ");
        double amount = scan.nextFloat();
        scan.nextLine();
        System.out.println("Enter the comment on the income: ");
        String comment = scan.nextLine();
        System.out.println("Income added: amount = " + amount +", comment: " + comment);
        incomes.put(comment, amount);
        return incomes;
    }
}

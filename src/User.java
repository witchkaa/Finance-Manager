import java.util.HashMap;


public class User {
    private static HashMap<String, Double> incomes;
    private static HashMap<String, Double> expenses;
    private static double budget;

    public HashMap<String, Double> getIncomes() {
        return incomes;
    }

    public void setIncomes(HashMap<String, Double> incomes) {
        this.incomes = incomes;
    }

    public HashMap<String, Double> getExpenses() {
        return expenses;
    }

    public void setExpenses(HashMap<String, Double> expenses) {
        this.expenses = expenses;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}

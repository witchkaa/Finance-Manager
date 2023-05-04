import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class User {
    HashMap<String, Double> incomes;
    HashMap<String, Double> expenses;
    public void writeIncomes() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("incomesComment"));
        Set<String> incomesCommentsSet = incomes.keySet();
        ArrayList<String> incomesComments = new ArrayList<>(incomesCommentsSet);
        oos.writeObject(incomesComments);
        oos.flush();
        oos = new ObjectOutputStream(new FileOutputStream("incomesAmount"));
        Set<Double> incomesAmountsSet = (Set<Double>) incomes.values();
        ArrayList<Double> incomesAmounts = new ArrayList<>(incomesAmountsSet);
        oos.writeObject(incomesAmounts);
        oos.flush();
        oos.close();
    }
    public void writeExpenses() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("expensesComment"));
        Set<String> expensesCommentsSet = expenses.keySet();
        ArrayList<String> expensesComments = new ArrayList<>(expensesCommentsSet);
        oos.writeObject(expensesComments);
        oos.flush();
        oos = new ObjectOutputStream(new FileOutputStream("expensesAmount"));
        Set<Double> expensesAmountsSet = (Set<Double>) expenses.values();
        ArrayList<Double> expensesAmounts = new ArrayList<>(expensesAmountsSet);
        oos.writeObject(expensesAmounts);
        oos.flush();
        oos.close();
    }
    public void readExpenses() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("expensesAmount"));
        ArrayList<Double> expenseAmounts = (ArrayList<Double>) ois.readObject();
        ois = new ObjectInputStream(new FileInputStream("expensesComment"));
        ArrayList<String> expenseComments = (ArrayList<String>) ois.readObject();
        ois.close();
        HashMap<String,Double> expenses = new HashMap<>();
        for(int i = 0; i < expenseAmounts.size(); i++) {
            expenses.put(expenseComments.get(i), expenseAmounts.get(i));
        }
        this.expenses = expenses;
    }
    public void readIncomes() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("incomesAmount"));
        ArrayList<Double> incomesAmount = (ArrayList<Double>) ois.readObject();
        ois = new ObjectInputStream(new FileInputStream("incomesComment"));
        ArrayList<String> incomesComments = (ArrayList<String>) ois.readObject();
        ois.close();
        HashMap<String,Double> incomes = new HashMap<>();
        for(int i = 0; i < incomesAmount.size(); i++) {
            incomes.put(incomesComments.get(i), incomesAmount.get(i));
        }
        ois.close();
        this.incomes = incomes;
    }
}

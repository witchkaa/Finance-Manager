import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Welcome to Finance Manager!");
        Asker.readIncomes();
        Asker.readExpenses();
        Asker.readBudget();
        Asker.performAction();
    }

}

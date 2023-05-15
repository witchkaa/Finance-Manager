public class Expense implements Transaction{
    double amount;
    String comment;
    public Expense(double amount, String comment) {
        this.amount = amount;
        this.comment = comment;
    }
    @Override
    public void view() {

    }

}

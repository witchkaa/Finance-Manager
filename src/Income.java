public class Income implements Transaction{
    double amount;
    String comment;

    public Income(double amount, String comment) {
        this.amount = amount;
        this.comment = comment;
    }

    @Override
    public void view() {

    }
}

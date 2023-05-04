public class TransactionBuilder {
    public Transaction createTransaction(int input) {
        Transaction transaction = null;
        if(input == 1){
            transaction = new Expense();
        } else if (input == 2){
            transaction = new Income();
        } else {
            System.out.println("Wrong input!");
        }
        return transaction;
    }
}

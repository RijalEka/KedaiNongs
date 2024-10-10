import java.util.ArrayList;

public class TransactionHistory {
    private ArrayList<String> history = new ArrayList<>();

    public void addTransaction(String transaction) {
        history.add(transaction);
    }

    public void displayHistory() {
        System.out.println("History Transaksi:");
        for (String transaction : history) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        TransactionHistory th = new TransactionHistory();
        th.addTransaction("Pesanan: Nasi Goreng, Total: 15000");
        th.addTransaction("Pesanan: Teh Manis, Total: 5000");
        th.displayHistory();
        
    }
}

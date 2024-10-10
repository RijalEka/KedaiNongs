import java.util.Scanner;

public class PaymentSystem {
    public void calculateChange(double total, double payment) {
        if (payment >= total) {
            double change = payment - total;
            System.out.println("Kembalian: " + change);
        } else {
            System.out.println("Pembayaran kurang!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan total harga:");
        double total = sc.nextDouble();

        System.out.println("Masukkan pembayaran:");
        double payment = sc.nextDouble();

        PaymentSystem ps = new PaymentSystem();
        ps.calculateChange(total, payment);
    }
}

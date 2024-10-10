import java.util.ArrayList;
import java.util.Scanner;

public class OrderManagement {
    private ArrayList<String> orders = new ArrayList<>();

    public void addOrder(String order) {
        orders.add(order);
        System.out.println(order + " ditambahkan.");
    }

    public void removeOrder(String order) {
        if (orders.contains(order)) {
            orders.remove(order);
            System.out.println(order + " dihapus.");
        } else {
            System.out.println(order + " tidak ditemukan.");
        }
    }

    public void displayOrders() {
        System.out.println("Daftar Pesanan:");
        for (String order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        OrderManagement om = new OrderManagement();
        Scanner sc = new Scanner(System.in);
        
        om.addOrder("Nasi Goreng");
        om.addOrder("Teh Manis");
        om.displayOrders();
        om.removeOrder("Nasi Goreng");
        om.displayOrders();
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class UserAuth {
    private HashMap<String, String> users = new HashMap<>();
    
    public void register(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            System.out.println("Registrasi berhasil.");
        } else {
            System.out.println("Username sudah ada.");
        }
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login berhasil.");
            return true;
        } else {
            System.out.println("Login gagal.");
            return false;
        }
    }

    public static void main(String[] args) {
        UserAuth auth = new UserAuth();
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan username untuk registrasi:");
        String username = sc.nextLine();
        System.out.println("Masukkan password:");
        String password = sc.nextLine();
        auth.register(username, password);

        System.out.println("Login:");
        System.out.println("Username:");
        username = sc.nextLine();
        System.out.println("Password:");
        password = sc.nextLine();
        auth.login(username, password);
        
    }
}

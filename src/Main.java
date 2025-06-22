/**
 * Main class untuk mendemonstrasikan sistem perpustakaan
 * dengan konsep Inheritance dan Polymorphism
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 1. Setup sistem: Buat BookManager dan Scanner
        BookManager bookManager = new BookManager(10); // Kapasitas 10 buku
        Scanner scanner = new Scanner(System.in);

        // 2. Buat beberapa pengguna
        User admin = new Admin("A001", "John Doe", "john@library.com", "Senior");
        User member = new Member("U001", "Alice Johnson", "alice@email.com", "MEM001");

        // 3. Admin menambahkan beberapa buku awal
        System.out.println("--- Admin Setup Awal ---");
        bookManager.addBook(new Book("Java Programming", "Herbert Schildt", "Tersedia"));
        bookManager.addBook(new Book("Python Basics", "Eric Matthes", "Tersedia"));
        bookManager.addBook(new Book("Web Development", "Jon Duckett", "Tersedia"));
        System.out.println("------------------------");

        // 4. Demonstrasi Polymorphism secara Interaktif
        while (true) {
            System.out.println("\n=== SELAMAT DATANG DI PERPUSTAKAAN ===");
            System.out.println("Pilih pengguna untuk berinteraksi:");
            System.out.println("1. Admin: " + admin.getName());
            System.out.println("2. Member: " + member.getName());
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            User currentUser;
            if (userChoice == 1) {
                currentUser = admin;
            } else if (userChoice == 2) {
                currentUser = member;
            } else if (userChoice == 3) {
                System.out.println("Terima kasih.");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
                continue;
            }

            // ini polymorphism: memanggil metode 'performAction'
            currentUser.performAction(bookManager, scanner);
        }
        
        scanner.close();
    }
}

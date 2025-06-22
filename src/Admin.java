/**
 * Class Admin yang mewarisi dari User
 * Menunjukkan implementasi Inheritance
 */

import java.util.Scanner;

public class Admin extends User {
    private String adminLevel;

    // Constructor - memanggil constructor parent class
    public Admin(String userId, String name, String email, String adminLevel) {
        super(userId, name, email); // Inheritance - memanggil constructor parent
        this.adminLevel = adminLevel;
    }

    // Getter untuk adminLevel
    public String getAdminLevel() {
        return adminLevel;
    }


@Override
public void interact() {
    System.out.println("\n--- Login sebagai Admin: " + name + " ---");
}

@Override
public void performAction(BookManager bookManager, Scanner scanner) {
    interact();
    System.out.println("PILIH AKSI:\n1. Tambah Buku\n2. Hapus Buku\n3. Lihat Buku Tersedia");
    System.out.print("Pilihan Anda: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); 

    if (choice == 1) {
        System.out.print("Masukkan judul buku baru: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan nama pengarang: ");
        String author = scanner.nextLine();
        bookManager.addBook(new Book(title, author, "Tersedia"));
    } else if (choice == 2) {
        System.out.print("Masukkan judul buku yang akan dihapus: ");
        String title = scanner.nextLine();
        bookManager.removeBook(title);
    } else if (choice == 3) {
        bookManager.displayAvailableBooks();
    } else {
        System.out.println("Pilihan tidak valid.");
    }
}

// Override displayInfo untuk menampilkan info spesifik Admin
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil method parent
        System.out.println("Role: Admin");
        System.out.println("Admin Level: " + adminLevel);
    }
}

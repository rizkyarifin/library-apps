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
        if (canAddBook()) {
            System.out.print("Masukkan judul buku baru: ");
            String title = scanner.nextLine();
            System.out.print("Masukkan nama pengarang: ");
            String author = scanner.nextLine();
            bookManager.addBook(new Book(title, author, "Tersedia"));
        } else {
            System.out.println("Anda tidak memiliki izin untuk menambah buku.");
        }
    } else if (choice == 2) {
        if (canRemoveBook()) {
            System.out.print("Masukkan judul buku yang akan dihapus: ");
            String title = scanner.nextLine();
            bookManager.removeBook(title);
        } else {
            System.out.println("Anda tidak memiliki izin untuk menghapus buku.");
        }
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
    
    // Implementasi permission system untuk Admin (Anggota 4)
    @Override
    public boolean canAddBook() {
        return true; // Admin bisa menambah buku
    }
    
    @Override
    public boolean canRemoveBook() {
        return true; // Admin bisa menghapus buku
    }
    
    @Override
    public boolean canBorrowBook() {
        return false; // Admin tidak perlu meminjam buku
    }
}

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
    
    // Method signatures untuk Anggota 2 (Array Operations)
    public void addBook(Object[] books, Object newBook, int[] bookCount) {
        System.out.println("Admin " + name + " menambahkan buku");
        // Implementation akan dilengkapi oleh Anggota 2
    }
    
    public void removeBook(Object[] books, String title, int[] bookCount) {
        System.out.println("Admin " + name + " menghapus buku: " + title);
        // Implementation akan dilengkapi oleh Anggota 2
    }
    
    public Object[] searchBook(Object[] books, String title, int bookCount) {
        System.out.println("Admin " + name + " mencari buku: " + title);
        // Implementation akan dilengkapi oleh Anggota 2
        return null;
    }
    
    // Method signatures untuk Anggota 3 (Book Management)
    public void displayAllBooks(Object[] books, int bookCount) {
        System.out.println("Admin " + name + " melihat semua buku");
        // Implementation akan dilengkapi oleh Anggota 3
    }
    
    public void manageLibrary() {
        System.out.println("Admin " + name + " sedang mengelola perpustakaan");
    }
    
    // Override method interact() - Polymorphism (untuk Anggota 4)
    @Override
    public void interact() {
        System.out.println("=== Admin Interface ===");
        System.out.println("Admin " + name + " dapat:");
        System.out.println("1. Menambah buku");
        System.out.println("2. Menghapus buku");
        System.out.println("3. Mencari buku");
        System.out.println("4. Melihat semua buku");
        System.out.println("5. Mengelola perpustakaan");
    }
    
    // Override performAction untuk Anggota 4 (Polymorphism)
    @Override
    public void performAction(Object[] books, int[] bookCount, Scanner scanner) {
        System.out.println("=== Menu Aksi Member: "  + name + " ===");
        System.out.println("1. Pinjam Buku");
        System.out.println("2. Kembalikan Buku");
        System.out.print("Pilih aksi (1-2): ");

        int choice = scanner.nextInt();
        scanner.nextLine()

        if (choice == 1) {
            System.out.print("Masukkan judul buku baru: ");
            String title = scanner.nextLine();
            // MEmenaggil metode untuk menambah buku
            addBook(books, title, bookCount);
        } else if (choice == 2) {
            System.out.print("Masukkan judul buku yang akan dihapus: ");
            String title = scanner.nextLine();
            // Memanggil metode untuk menghapus buku
            removeBook(books, tittle, bookCount);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        // Specific admin actions - akan diimplementasi oleh Anggota 4
    }
    
    // Permission methods untuk Anggota 4 (Polymorphism)
    @Override
    public boolean canAddBook() {
        return true; // Admin dapat menambah buku
    }
    
    @Override
    public boolean canRemoveBook() {
        return true; // Admin dapat menghapus buku
    }
    
    @Override
    public boolean canBorrowBook() {
        return false; // Admin tidak perlu meminjam buku
    }
    
    // Override displayInfo untuk menampilkan info spesifik Admin
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil method parent
        System.out.println("Role: Admin");
        System.out.println("Admin Level: " + adminLevel);
    }
}

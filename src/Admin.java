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
    public void addBook(Book[] books, Book newBook, int[] bookCount) {
        if (bookCount[0] < books.length) {
            books[bookCount[0]] = newBook;
            bookCount[0]++;
            System.out.println("Admin " + name + " berhasil menambahkan buku: " + newBook.getTitle());
        } else {
            System.out.println("Perpustakaan penuh! Tidak dapat menambahkan buku baru.");
        }
    }
    
    public void removeBook(Book[] books, String title, int[] bookCount) {
        boolean found = false;
        for (int i = 0; i < bookCount[0]; i++) {
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title)) {
                // Geser array ke kiri
                for (int j = i; j < bookCount[0] - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[bookCount[0] - 1] = null;
                bookCount[0]--;
                found = true;
                System.out.println("Admin " + name + " berhasil menghapus buku: " + title);
                break;
            }
        }
        if (!found) {
            System.out.println("Buku dengan judul '" + title + "' tidak ditemukan.");
        }
    }

    public Book[] searchBook(Book[] books, String title, int bookCount) {
        Book[] result = new Book[bookCount];
        int resultCount = 0;

        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                result[resultCount++] = books[i];
            }
        }

        System.out.println("Admin " + name + " mencari buku dengan kata kunci: \"" + title + "\"");
        if (resultCount == 0) {
            System.out.println("Tidak ada buku yang ditemukan.");
        } else {
            System.out.println("Ditemukan " + resultCount + " buku:");
            for (int i = 0; i < resultCount; i++) {
                System.out.println((i + 1) + ". " + result[i].getTitle() + " by " + result[i].getAuthor() + " - " + result[i].getStatus());
            }
        }

        // Return hasil pencarian yang sesuai
        Book[] trimmedResult = new Book[resultCount];
        System.arraycopy(result, 0, trimmedResult, 0, resultCount);
        return trimmedResult;
    }
    
    // Method signatures untuk Anggota 3 (Book Management)
    public void displayAllBooks(Book[] books, int bookCount) {
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
    public void performAction(Book[] books, int[] bookCount, Scanner scanner) {
        System.out.println("=== Menu Aksi Admin: "  + name + " ===");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.print("Pilih aksi (1-2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Fix missing semicolon

        if (choice == 1) {
            System.out.print("Masukkan judul buku baru: ");
            String title = scanner.nextLine();
            System.out.print("Masukkan nama pengarang: ");
            String author = scanner.nextLine();
            // Memanggil metode untuk menambah buku
            addBook(books, new Book(title, author, "Tersedia"), bookCount);
        } else if (choice == 2) {
            System.out.print("Masukkan judul buku yang akan dihapus: ");
            String title = scanner.nextLine();
            // Memanggil metode untuk menghapus buku
            removeBook(books, title, bookCount); // Fix typo
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

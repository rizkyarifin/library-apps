/**
 * Class Member yang mewarisi dari User
 * Menunjukkan implementasi Inheritance
 */

import java.util.Scanner;

public class Member extends User {
    private String memberId;
    private int borrowedBooks;
    private final int MAX_BORROW = 3; // Maksimal buku yang bisa dipinjam

    // Constructor - memanggil constructor parent class
    public Member(String userId, String name, String email, String memberId) {
        super(userId, name, email); // Inheritance - memanggil constructor parent
        this.memberId = memberId;
        this.borrowedBooks = 0;
    }

    // Getter methods
    public String getMemberId() {
        return memberId;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getMaxBorrow() {
        return MAX_BORROW;
    }

    // Metode internal baru untuk logika spesifik Member
    public void processBorrow(Book book) {
        if (borrowedBooks >= MAX_BORROW) {
            System.out.println("-> Gagal: Anda telah mencapai batas maksimal peminjaman (" + MAX_BORROW + " buku).");
            return;
        }
        borrowedBooks++;
        book.setStatus("Dipinjam");
        System.out.println("-> Berhasil meminjam '" + book.getTitle() + "'. Total buku dipinjam: " + borrowedBooks);
    }

    public void processReturn(Book book) {
        borrowedBooks--;
        book.setStatus("tersedia");
        System.out.println("-> Berhasil mengembalikan '" + book.getTitle() + "'. Total buku dipinjam: " + borrowedBooks);
    }
    
   
    // Override method interact() - Polymorphism (untuk Anggota 4)
    @Override
    public void interact() {
        System.out.println("\n--- Login sebagai Member: " + name + " ---");
    }

    // Override performAction untuk Anggota 4 (Polymorphism)
    @Override
    public void performAction(Book[] books, int[] bookCount, Scanner scanner) {
        System.out.println("=== Menu aksi Member: " + name + " ===");
        System.out.println("1. Pinjam Buku");
        System.out.println("2. Kembalikan Buku");
        System.out.print("Pilih aksi (1-2): ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Masukkan judul buku yang akan dipinjam: ");
            String title = scanner.nextLine();
            // Memanggil metode untuk meminjam buku
            borrowBook(books, title, bookCount[0]); // Fix typo
        } else if (choice == 2) {
            System.out.print("Masukkan judul buku yang akan dikembalikan: ");
            String title = scanner.nextLine(); // Fix syntax error
            // Memanggil metode untuk mengembalikan buku
            returnBook(books, title, bookCount[0]);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
       
    }

    // Override displayInfo untuk menampilkan info spesifik Member
    @Override
    public void displayInfo() {
        super.displayInfo(); // Memanggil method parent
        System.out.println("Role: Member");
        System.out.println("Member ID: " + memberId);
        System.out.println("Books Borrowed: " + borrowedBooks + "/" + MAX_BORROW);
    }
}

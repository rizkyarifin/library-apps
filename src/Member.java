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
        book.setStatus("Tersedia");
        System.out.println("-> Berhasil mengembalikan '" + book.getTitle() + "'. Total buku dipinjam: " + borrowedBooks);
    }
    
   
    // Override method interact() - Polymorphism (untuk Anggota 4)
    @Override
    public void interact() {
        System.out.println("\n--- Login sebagai Member: " + name + " ---");
    }

    // Override performAction untuk Anggota 4 (Polymorphism)
    @override
    public void performAction(BookManager bookManager, Scanner scanner) {
        interact();
        System.out.println("PILIH AKSI:\n1. Pinjam Buku\n2. Kembalikan Buku\n3. Lihat Buku Tersedia");
        System.out.print("Pilihan Anda: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Masukkan judul buku yang akan dipinjam: ");
            String title = scanner.nextLine();
            bookManager.borrowBook(title this);
        } else if (choice == 2) {
            System.out.print("Masukkan judul buku yang akan dikembalikan: ");
            String title = scanner.nextLine();
            bookManager.returnBook(title, this);
        } else if (choice == 3) {
            bookManager.displayAvailableBooks();
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

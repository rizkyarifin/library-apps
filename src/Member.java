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

    // Method signatures untuk Anggota 3 (Book Management)
    public boolean borrowBook(Book[] books, String bookTitle, int bookCount) {
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                if (!book.getStatus().equalsIgnoreCase("Tersedia")) {
                    System.out.println("Buku " + bookTitle + " sedang tidak tersedia untuk dipinjam.");
                    return false;
                }

                if (borrowedBooks >= MAX_BORROW) {
                    System.out.println("Member " + name + " sudah mencapai batas maksimal peminjaman!");
                    return false;
                }

                borrowedBooks++;
                book.setStatus("Dipinjam");
                System.out.println("Member " + name + " meminjam buku: " + bookTitle);
                System.out.println("Total buku dipinjam: " + borrowedBooks);
                return true;
            }
        }

        System.out.println("Buku dengan judul " + bookTitle + " tidak ditemukan.");
        return false;
    }

    public boolean returnBook(Book[] books, String bookTitle, int bookCount) {
        if (borrowedBooks == 0) {
            System.out.println("Member " + name + " tidak memiliki buku yang dipinjam!");
            return false;
        }

        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                if (!book.getStatus().equalsIgnoreCase("Dipinjam")) {
                    System.out.println("Buku " + bookTitle + " tidak sedang dipinjam!");
                    return false;
                }

                borrowedBooks--;
                book.setStatus("Tersedia");
                System.out.println("Member " + name + " mengembalikan buku: " + bookTitle);
                System.out.println("Total buku dipinjam: " + borrowedBooks);
                return true;
            }
        }

        System.out.println("Buku dengan judul " + bookTitle + " tidak ditemukan.");
        return false;
    }

    // Method untuk melihat buku tersedia (untuk Anggota 3)
    public void viewAvailableBooks(Book[] books, int bookCount) {
        System.out.println("Member " + name + " melihat daftar buku tersedia");
        int count = 0;
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];

            if (book == null) {
                continue;
            }

            if (book.getStatus().equalsIgnoreCase("Tersedia")) {
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() + " - " + book.getStatus());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Tidak ada buku yang tersedia saat ini.");
        }
    }

    // Method untuk mencari buku (dari Anggota 2)
    public Book[] searchBook(Book[] books, String title, int bookCount) {
        Book[] result = new Book[bookCount];
        int resultCount = 0;

        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                result[resultCount++] = books[i];
            }
        }

        System.out.println("Member " + name + " mencari buku dengan kata kunci: \"" + title + "\"");
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

    // Override method interact() - Polymorphism (untuk Anggota 4)
    @Override
    public void interact() {
        System.out.println("=== Member Interface ===");
        System.out.println("Member " + name + " dapat:");
        System.out.println("1. Meminjam buku");
        System.out.println("2. Mengembalikan buku");
        System.out.println("3. Melihat buku tersedia");
        System.out.println("4. Mencari buku");
        System.out.println("5. Melihat riwayat peminjaman");
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
        // Specific member actions - akan diimplementasi oleh Anggota 4
    }

    // Permission methods untuk Anggota 4 (Polymorphism)
    @Override
    public boolean canAddBook() {
        return false; // Member tidak dapat menambah buku
    }

    @Override
    public boolean canRemoveBook() {
        return false; // Member tidak dapat menghapus buku
    }

    @Override
    public boolean canBorrowBook() {
        return borrowedBooks < MAX_BORROW; // Member dapat meminjam jika belum mencapai limit
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

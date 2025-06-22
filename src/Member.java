/**
 * Class Member yang mewarisi dari User
 * Menunjukkan implementasi Inheritance
 */
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
        if (borrowedBooks < MAX_BORROW) {
            borrowedBooks++;
            System.out.println("Member " + name + " meminjam buku: " + bookTitle);
            System.out.println("Total buku dipinjam: " + borrowedBooks);
            // Implementation akan dilengkapi oleh Anggota 3
            return true;
        } else {
            System.out.println("Member " + name + " sudah mencapai batas maksimal peminjaman!");
            return false;
        }
    }
    
    public boolean returnBook(Book[] books, String bookTitle, int bookCount) {
        if (borrowedBooks > 0) {
            borrowedBooks--;
            System.out.println("Member " + name + " mengembalikan buku: " + bookTitle);
            System.out.println("Total buku dipinjam: " + borrowedBooks);
            // Implementation akan dilengkapi oleh Anggota 3
            return true;
        } else {
            System.out.println("Member " + name + " tidak memiliki buku yang dipinjam!");
            return false;
        }
    }
    
    // Method untuk melihat buku tersedia (untuk Anggota 3)
    public void viewAvailableBooks(Book[] books, int bookCount) {
        System.out.println("Member " + name + " melihat daftar buku tersedia");
        // Implementation akan dilengkapi oleh Anggota 3
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
    public void performAction(Book[] books, int[] bookCount) {
        System.out.println("Member performing member actions...");
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
/**
 * Main class untuk mendemonstrasikan sistem perpustakaan
 * dengan konsep Inheritance dan Polymorphism
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM PERPUSTAKAAN ===\n");
        
        // Membuat objek Admin
        Admin admin1 = new Admin("A001", "John Doe", "john@library.com", "Senior");
        Admin admin2 = new Admin("A002", "Jane Smith", "jane@library.com", "Junior");
        
        // Membuat objek Member
        Member member1 = new Member("U001", "Alice Johnson", "alice@email.com", "MEM001");
        Member member2 = new Member("U002", "Bob Wilson", "bob@email.com", "MEM002");
        
        // Demonstrasi Inheritance dan method overriding
        System.out.println("--- Informasi Admin ---");
        admin1.displayInfo();
        System.out.println();
        
        System.out.println("--- Informasi Member ---");
        member1.displayInfo();
        System.out.println();
        
        // Demonstrasi Polymorphism
        System.out.println("--- Demonstrasi Polymorphism ---");
        User[] users = {admin1, member1, admin2, member2};
        
        for (User user : users) {
            System.out.println("\nUser: " + user.getName());
            user.interact();
            System.out.println("Can add book: " + user.canAddBook());
            System.out.println("Can remove book: " + user.canRemoveBook());
            System.out.println("Can borrow book: " + user.canBorrowBook());
        }
        
        // Demonstrasi method specific untuk Admin
        System.out.println("\n--- Admin Operations ---");
        Book[] books = new Book[10]; // Array untuk menyimpan buku
        int[] bookCount = {0}; // Counter untuk jumlah buku
        
        // Menambahkan beberapa buku
        admin1.addBook(books, new Book("Java Programming", "Herbert Schildt", "Tersedia"), bookCount);
        admin1.addBook(books, new Book("Python Basics", "Eric Matthes", "Tersedia"), bookCount);
        admin1.addBook(books, new Book("Web Development", "Jon Duckett", "Tersedia"), bookCount);
        admin1.addBook(books, new Book("Database Design", "Adrienne Watt", "Tersedia"), bookCount);
        
        // Menampilkan semua buku
        admin1.displayAllBooks(books, bookCount[0]);
        
        // Mencari buku
        admin1.searchBook(books, "Java", bookCount[0]);
        
        // Menghapus buku
        admin1.removeBook(books, "Web Development", bookCount);
        admin1.manageLibrary();
        
        // Demonstrasi method specific untuk Member
        System.out.println("\n--- Member Operations ---");
        member1.borrowBook(books, "Java Programming", bookCount[0]);
        member1.borrowBook(books, "Python Basics", bookCount[0]);
        member1.borrowBook(books, "Database Design", bookCount[0]);
        member1.borrowBook(books, "Web Development", bookCount[0]); // Akan ditolak karena limit
        
        // Melihat buku yang tersedia
        member1.viewAvailableBooks(books, bookCount[0]);
        
        // Mengembalikan buku
        member1.returnBook(books, "Java Programming", bookCount[0]);
        
        // Member mencari buku
        member2.searchBook(books, "Python", bookCount[0]);
        
        // Demonstrasi polymorphic behavior dengan performAction
        System.out.println("\n--- Polymorphic Actions ---");
        for (User user : users) {
            System.out.println("\n" + user.getName() + ":");
            user.performAction(books, bookCount);
        }
    }
}
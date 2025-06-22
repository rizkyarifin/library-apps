/**
 * Main class untuk mendemonstrasikan sistem perpustakaan
 * dengan konsep Inheritance dan Polymorphism
 */
import java.util.Scanner;
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
        Object[] books = new Object[10]; // Placeholder untuk array buku
        int[] bookCount = {0}; // Counter untuk jumlah buku
        
        admin1.addBook(books, "New Book", bookCount);
        admin1.removeBook(books, "Old Book", bookCount);
        admin1.searchBook(books, "Java Programming", 5);
        admin1.manageLibrary();
        
        // Demonstrasi method specific untuk Member
        System.out.println("\n--- Member Operations ---");
        member1.borrowBook(books, "Java Programming", 5);
        member1.borrowBook(books, "Python Basics", 5);
        member1.borrowBook(books, "Web Development", 5);
        member1.borrowBook(books, "Database Design", 5); // Akan ditolak karena limit
        
        member1.returnBook(books, "Java Programming", 5);
        member1.viewAvailableBooks(books, 5);

        Scanner scanner = new Scanner(System.in);
        
        // Demonstrasi polymorphic behavior dengan performAction
        System.out.println("\n--- Polymorphic Actions ---");
        for (User user : users) {
            System.out.println("\n--- Interaksi dengan "  + user.getName() + " ---");
            user.performAction(books, bookCount, scanner);
        }
    }
}

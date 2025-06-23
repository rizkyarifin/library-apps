/**
 * Class User sebagai parent class untuk semua pengguna sistem perpustakaan
 * Menerapkan konsep Inheritance dan Polymorphism
 */
import java.util.Scanner;
public abstract class User {
    // Atribut protected agar bisa diakses oleh child class
    protected String userId;
    protected String name;
    protected String email;
    
    // Constructor
    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
    
    // Getter methods
    public String getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Abstract methods untuk polymorphism (akan diimplementasi oleh Anggota 4)
    public abstract void interact();
    
    // Abstract method untuk operasi berbeda Admin vs Member (Soal 4)
    public abstract void performAction(BookManager bookManager, Scanner scanner);
    
    // Abstract methods untuk permission system (Anggota 4)
    public abstract boolean canAddBook();
    public abstract boolean canRemoveBook();
    public abstract boolean canBorrowBook();
    
    
    // Method umum untuk menampilkan informasi user
    public void displayInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

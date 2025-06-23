// File: LibrarySystem.java
package library;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books;
    private List<User> users;

    public LibrarySystem() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public boolean lendBook(String title, Member member) {
        Book book = searchBook(title);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            member.borrowBook(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String title, Member member) {
        Book book = searchBook(title);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            member.returnBook(book);
            return true;
        }
        return false;
    }
}

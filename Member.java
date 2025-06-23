// File: Member.java
package library;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    private List<Book> borrowedBooks;

    public Member(String name) {
        super(name);
        borrowedBooks = new ArrayList<>();
    }

    @Override
    public void interact() {
        System.out.println("[Member] " + name + " bisa meminjam dan mengembalikan buku.");
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

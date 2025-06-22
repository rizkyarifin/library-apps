
public class BookManager {
    private Book[] books;
    private int bookCount;

    public BookManager(int capacity) {
        this.books = new Book[capacity];
        this.bookCount = 0;
    }

    //METODE UNTUK ADMIN
    public void addBook(Book newBook) {
        if (bookCount < books.length) {
            books[bookCount] = newBook;
            bookCount++;
            System.out.println("-> Buku '" + newBook.getTitle() + "' berhasil ditambahkan.");
        } else {
            System.out.println("-> Perpustakaan penuh! Tidak dapat menambahkan buku baru.");
        }
    }

    public void removeBook(String title) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[bookCount - 1] = null;
                bookCount--;
                found = true;
                System.out.println("-> Buku '" + title + "' berhasil dihapus.");
                break;
            }
        }
        if (!found) {
            System.out.println("-> Buku dengan judul '" + title + "' tidak ditemukan.");
        }
    }

    //METODE UNTUK MEMBER
    public void borrowBook(String bookTitle, Member member) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(bookTitle)) {
                if (!books[i].getStatus().equalsIgnoreCase("Tersedia")) {
                    System.out.println("-> Buku '" + bookTitle + "' sedang tidak tersedia.");
                    return;
                }
                member.processBorrow(books[i]);
                return;
            }
        }
        System.out.println("-> Buku dengan judul '" + bookTitle + "' tidak ditemukan.");
    }

    public void returnBook(String bookTitle, Member member) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(bookTitle)) {
                if (!books[i].getStatus().equalsIgnoreCase("Dipinjam")) {
                    System.out.println("-> Buku '" + bookTitle + "' tidak sedang dalam status dipinjam.");
                    return;
                }
                member.processReturn(books[i]);
                return;
            }
        }
        System.out.println("-> Buku dengan judul '" + bookTitle + "' tidak ditemukan.");
    }
    
    //METODE UNTUK SEMUA
    public void displayAvailableBooks() {
        System.out.println("\n--- Daftar Buku yang Tersedia ---");
        int availableCount = 0;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getStatus().equalsIgnoreCase("Tersedia")) {
                System.out.println("- " + books[i].getTitle() + " oleh " + books[i].getAuthor());
                availableCount++;
            }
        }
        if (availableCount == 0) {
            System.out.println("Saat ini tidak ada buku yang tersedia.");
        }
    }
}

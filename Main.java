// File: Main.java
package library;

public class Main {
    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();

        // Tambah beberapa buku
        system.addBook(new Book("Laskar Pelangi", "Andrea Hirata"));
        system.addBook(new Book("Bumi", "Tere Liye"));
        system.addBook(new Book("Negeri 5 Menara", "Ahmad Fuadi"));

        // Tambah pengguna
        Admin admin = new Admin("Admin1");
        Member member = new Member("Member1");

        system.addUser(admin);
        system.addUser(member);

        // Tampilkan buku yang tersedia
        System.out.println("\nBuku yang tersedia:");
        system.displayAvailableBooks();

        // Member meminjam buku
        System.out.println("\nMember meminjam buku 'Bumi'");
        if (system.lendBook("Bumi", member)) {
            System.out.println("Peminjaman berhasil.");
        } else {
            System.out.println("Peminjaman gagal.");
        }

        // Tampilkan buku yang tersedia setelah dipinjam
        System.out.println("\nBuku yang tersedia setelah peminjaman:");
        system.displayAvailableBooks();

        // Member mengembalikan buku
        System.out.println("\nMember mengembalikan buku 'Bumi'");
        if (system.returnBook("Bumi", member)) {
            System.out.println("Pengembalian berhasil.");
        } else {
            System.out.println("Pengembalian gagal.");
        }

        // Tampilkan akhir
        System.out.println("\nBuku yang tersedia setelah pengembalian:");
        system.displayAvailableBooks();
    }
}

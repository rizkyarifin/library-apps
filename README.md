# Sistem Manajemen Perpustakaan - Implementasi Inheritance dan Polymorphism

## Overview
Proyek ini adalah sistem manajemen perpustakaan yang kami kembangkan untuk memahami dan menerapkan konsep Inheritance dan Polymorphism dalam pemrograman berorientasi objek. Sistem ini dirancang untuk menangani operasi-operasi dasar perpustakaan seperti pengelolaan buku oleh admin dan aktivitas peminjaman oleh anggota.

## Class Diagram

![Class Diagram](docs/Soal%20No%20-%201%20Class%20Diagram/ClassDiagramImage.png)

## Penerapan Inheritance (Pewarisan)

### Struktur Hierarki
```
         User (Abstract Parent Class)
         /                \
        /                  \
    Admin                Member
(Child Class)        (Child Class)
```

### 1. Parent Class: User (Abstract)
```java
public abstract class User {
    // Protected attributes - dapat diakses oleh child classes
    protected String userId;
    protected String name;
    protected String email;
    
    // Constructor
    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
    
    // Abstract methods - harus diimplementasi oleh child classes
    public abstract void interact();
    public abstract boolean canAddBook();
    public abstract boolean canRemoveBook();
    public abstract boolean canBorrowBook();
}
```

**Penjelasan:**
- Kelas User bersifat abstrak sehingga tidak bisa dibuat objeknya secara langsung
- Atribut menggunakan protected agar bisa diakses oleh kelas turunan
- Method abstrak wajib diimplementasikan oleh kelas anak

### 2. Child Class: Admin
```java
public class Admin extends User {
    private String adminLevel;
    
    public Admin(String userId, String name, String email, String adminLevel) {
        super(userId, name, email); // Memanggil constructor parent
        this.adminLevel = adminLevel;
    }
    
    // Implementation of abstract methods
    @Override
    public boolean canAddBook() { return true; }
    
    @Override
    public boolean canRemoveBook() { return true; }
    
    @Override
    public boolean canBorrowBook() { return false; }
}
```

**Keuntungan yang didapat:**
- Kelas Admin otomatis memiliki semua atribut dari User (userId, name, email)
- Constructor menggunakan super() untuk memanggil constructor induk
- Bisa menambahkan atribut khusus seperti adminLevel

### 3. Child Class: Member
```java
public class Member extends User {
    private String memberId;
    private int borrowedBooks;
    private final int MAX_BORROW = 3;
    
    public Member(String userId, String name, String email, String memberId) {
        super(userId, name, email);
        this.memberId = memberId;
        this.borrowedBooks = 0;
    }
    
    @Override
    public boolean canBorrowBook() { 
        return borrowedBooks < MAX_BORROW; 
    }
}
```

## Penerapan Polymorphism (Polimorfisme)

### 1. Method Overriding
Dalam implementasi ini, setiap kelas turunan memberikan implementasi yang berbeda untuk method abstrak dari kelas induk:

#### Admin Implementation:
```java
@Override
public void interact() {
    System.out.println("=== Admin Interface ===");
    System.out.println("Admin " + name + " dapat:");
    System.out.println("1. Menambah buku");
    System.out.println("2. Menghapus buku");
    System.out.println("3. Mencari buku");
    System.out.println("4. Melihat semua buku");
    System.out.println("5. Mengelola perpustakaan");
}
```

#### Member Implementation:
```java
@Override
public void interact() {
    System.out.println("=== Member Interface ===");
    System.out.println("Member " + name + " dapat:");
    System.out.println("1. Meminjam buku");
    System.out.println("2. Mengembalikan buku");
    System.out.println("3. Melihat buku tersedia");
    System.out.println("4. Mencari buku");
}
```

### 2. Polymorphic Behavior Demo
```java
// Array polymorphic - satu tipe, multiple implementations
User[] users = {
    new Admin("A001", "John Doe", "john@library.com", "Senior"),
    new Member("U001", "Alice Johnson", "alice@email.com", "MEM001")
};

// Satu loop, behavior berbeda
for (User user : users) {
    user.interact();              // Output berbeda untuk Admin vs Member
    System.out.println("Can add book: " + user.canAddBook());
    System.out.println("Can borrow book: " + user.canBorrowBook());
}
```

**Hasil yang didapat:**
- **Admin**: Menampilkan menu khusus admin dengan hak akses untuk menambah/hapus buku tapi tidak bisa meminjam
- **Member**: Menampilkan menu khusus member dengan hak akses untuk meminjam buku tapi tidak bisa menambah/hapus

### 3. Permission System (Polymorphic Methods)
```java
// Method yang sama, logic berbeda berdasarkan class
public abstract boolean canAddBook();
public abstract boolean canRemoveBook();
public abstract boolean canBorrowBook();
```

| Method | Admin | Member |
|--------|-------|--------|
| `canAddBook()` | ✅ `true` | ❌ `false` |
| `canRemoveBook()` | ✅ `true` | ❌ `false` |
| `canBorrowBook()` | ❌ `false` | ✅ `true` (jika < limit) |

## Keuntungan Inheritance & Polymorphism

### Keuntungan Inheritance:
1. **Menghindari duplikasi kode** - Atribut umum cukup ditulis sekali di kelas induk
2. **Mudah maintenance** - Kalau ada perubahan di kelas induk, otomatis berlaku untuk semua kelas anak
3. **Struktur yang logis** - Hierarki kelas mencerminkan hubungan dunia nyata
4. **Konsistensi** - Semua kelas anak punya interface yang sama

### Keuntungan Polymorphism:
1. **Fleksibilitas tinggi** - Satu method bisa punya implementasi yang berbeda-beda
2. **Mudah dikembangkan** - Kalau mau tambah tipe user baru, tinggal buat kelas baru
3. **Behavior dinamis** - Program bisa menentukan behavior saat runtime
4. **Kode lebih bersih** - Tidak perlu banyak if-else untuk cek tipe objek

**Kesimpulan**: Implementasi inheritance dan polymorphism dalam sistem perpustakaan ini berhasil membuat struktur kode yang mudah dipelihara, mudah dikembangkan, dan solid. Sistem permission yang dibuat juga elegant dan mencerminkan hubungan nyata antara Admin dan Member di perpustakaan.

# 📚 Library Management System - Java OOP Project

## Deskripsi

Proyek ini adalah sistem manajemen perpustakaan sederhana yang dikembangkan menggunakan bahasa Java. Sistem ini mengimplementasikan konsep Object-Oriented Programming (OOP) serta penggunaan struktur data array dan List. Proyek dikerjakan oleh satu tim yang terdiri dari 5 anggota, dengan pembagian tugas tertentu. File ini dibuat oleh **Anggota 5** yang bertugas melakukan integrasi dan testing seluruh komponen.

## Fitur Utama
- Tambah, hapus, dan cari buku berdasarkan judul
- Tampilkan buku yang tersedia
- Peminjaman dan pengembalian buku oleh anggota
- Perbedaan hak akses antara Admin dan Member (Polymorphism)

## Struktur Kelas (Class)

- `User` *(Super Class)*
  - `Admin` *(Subclass)*: Bisa menambah dan menghapus buku
  - `Member` *(Subclass)*: Bisa meminjam dan mengembalikan buku
- `Book`: Menyimpan data buku (judul, penulis, status ketersediaan)
- `LibrarySystem`: Main controller untuk integrasi semua komponen
- `Main`: Program utama untuk menjalankan dan menguji sistem

## Cara Menjalankan Program

1. Clone repositori:
```bash
git clone https://github.com/rizkyarifin/library-apps
cd library-apps
```

2. Compile seluruh file:
```bash
javac -d . *.java
```

3. Jalankan program:
```bash
java library.Main
```

## Contoh Output
<lihat di Main.java>

## Testing

Testing dilakukan secara manual melalui class `Main.java`.

| Test Case                       | Input              | Expected Output          | Status |
|-------------------------------|--------------------|--------------------------|--------|
| Tambah buku                   | Judul + Penulis    | Buku tampil di daftar    | ✅ PASS |
| Peminjaman buku tersedia      | "Bumi"             | Peminjaman berhasil      | ✅ PASS |
| Pengembalian buku             | "Bumi"             | Pengembalian berhasil    | ✅ PASS |
| Cari buku tidak ada           | "Unknown"          | Null / Tidak ditemukan   | ✅ PASS |

## Kontributor
- Anggota 1: Data Model (`Book`, dll)
- Anggota 2: User Hierarchy (`User`, `Admin`, `Member`)
- Anggota 3: Fungsi Array Buku
- Anggota 4: Polymorphism dan Method Interaksi
- **Anggota 5: Integrasi, Testing, Dokumentasi (README)**

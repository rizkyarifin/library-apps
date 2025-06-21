# PEMBAGIAN TUGAS KELOMPOK - SISTEM PERPUSTAKAAN

## 📋 Overview Project
Sistem Manajemen Perpustakaan dengan konsep OOP (Inheritance & Polymorphism) dan Array Operations

## 👥 PEMBAGIAN TUGAS (5 ANGGOTA)

### **ANGGOTA 1: OOP Foundation & Class Diagram (30%)**
**Tugas:**
1. ✅ Implementasi class User (Parent Class)
2. ✅ Implementasi class Admin (Child Class) 
3. ✅ Implementasi class Member (Child Class)
4. Membuat Class Diagram lengkap
5. Dokumentasi konsep Inheritance & Polymorphism

**Deliverables:**
- User.java ✅
- Admin.java ✅
- Member.java ✅
- Class Diagram (draw.io/plantuml)
- Penjelasan konsep OOP (markdown/docx)

**Status:** Struktur dasar sudah selesai, tinggal class diagram & dokumentasi

---

### **ANGGOTA 2: Array Operations & Search (30%)**
**Tugas:**
1. Implementasi class Book dengan atribut (title, author, isAvailable)
2. Implementasi operasi array di Admin:
   - addBook() - Menambah buku ke array
   - removeBook() - Menghapus buku dari array
   - searchBook() - Mencari buku berdasarkan judul
3. Implementasi searchBook() di Member
4. Analisis kompleksitas algoritma (Big O)

**Deliverables:**
- Book.java
- Implementasi method di Admin.java & Member.java
- Dokumentasi kompleksitas algoritma

**Dependencies:** Butuh struktur dari Anggota 1

---

### **ANGGOTA 3: Book Management System (30%)**
**Tugas:**
1. Implementasi array untuk menyimpan data buku
2. Implementasi di Admin:
   - displayAllBooks() - Menampilkan semua buku
3. Implementasi di Member:
   - borrowBook() - Meminjam buku
   - returnBook() - Mengembalikan buku
   - viewAvailableBooks() - Melihat buku tersedia
4. Validasi status ketersediaan buku

**Deliverables:**
- Implementasi method di Admin.java & Member.java
- Logic pengelolaan status buku
- Testing scenarios

**Dependencies:** Butuh Book.java dari Anggota 2

---

### **ANGGOTA 4: Polymorphism & User Interaction (10%)**
**Tugas:**
1. Implementasi method polymorphic:
   - interact() - Menu berbeda untuk Admin vs Member
   - performAction() - Aksi berbeda berdasarkan role
2. Implementasi permission system (canAddBook, canBorrowBook, dll)
3. Membuat interactive menu system
4. Demonstrasi polymorphism dengan array User[]

**Deliverables:**
- Implementasi lengkap polymorphic methods
- Interactive menu system
- Demo polymorphism

**Dependencies:** Butuh semua implementasi dari Anggota 1, 2, 3

---

### **ANGGOTA 5: Integration & Testing**
**Tugas:**
1. Membuat class LibrarySystem sebagai main controller
2. Integrasi semua komponen
3. Implementasi Main.java dengan test scenarios
4. Testing semua functionality
5. Setup Git repository
6. Dokumentasi README.md

**Deliverables:**
- LibrarySystem.java
- Main.java (complete version)
- Test cases & results
- README.md
- Git repository

**Dependencies:** Butuh semua komponen dari Anggota 1-4

---

## 📅 TIMELINE PENGERJAAN

### **Fase 1 (Hari 1-2)**
- Anggota 1: Selesaikan OOP structure & class diagram
- Anggota 2: Mulai Book.java & array operations design

### **Fase 2 (Hari 3-4)**
- Anggota 2: Implementasi array operations
- Anggota 3: Implementasi book management
- Anggota 4: Design polymorphic methods

### **Fase 3 (Hari 5-6)**
- Anggota 3: Finalisasi book management
- Anggota 4: Implementasi user interaction
- Anggota 5: Mulai integration

### **Fase 4 (Hari 7)**
- Anggota 5: Testing & finalisasi
- Semua: Review & dokumentasi

---

## 🔧 TECHNICAL SETUP

### **Project Structure:**
```
Perpustakaan/
├── src/
│   ├── User.java          (Anggota 1) ✅
│   ├── Admin.java         (Anggota 1) ✅
│   ├── Member.java        (Anggota 1) ✅
│   ├── Book.java          (Anggota 2)
│   ├── LibrarySystem.java (Anggota 5)
│   └── Main.java          (Anggota 5)
├── docs/
│   ├── ClassDiagram.png   (Anggota 1)
│   ├── OOP_Concepts.md    (Anggota 1)
│   └── Complexity.md      (Anggota 2)
├── tests/
│   └── TestCases.md       (Anggota 5)
└── README.md              (Anggota 5)
```

### **Git Workflow:**
1. Anggota 5 setup repository
2. Setiap anggota buat branch: `feature/anggota-X`
3. Regular commit dengan pesan jelas
4. Pull request untuk review
5. Merge ke main setelah testing

---

## 📝 KOMUNIKASI TIM

### **Daily Standup (via WhatsApp/Discord):**
- Progress update
- Blocker/issues
- Need help?

### **Code Review Sessions:**
- Hari 4: Review Anggota 1 & 2
- Hari 6: Review Anggota 3 & 4
- Hari 7: Final review

### **Shared Resources:**
- Google Drive untuk dokumentasi
- Git repository untuk code
- Discord/WhatsApp untuk komunikasi

---

## ✅ CHECKLIST DELIVERABLES

- [ ] Class User, Admin, Member (Anggota 1)
- [ ] Class Diagram (Anggota 1)
- [ ] Dokumentasi OOP (Anggota 1)
- [ ] Class Book (Anggota 2)
- [ ] Array operations implementation (Anggota 2)
- [ ] Algorithm complexity analysis (Anggota 2)
- [ ] Book management implementation (Anggota 3)
- [ ] Polymorphic methods implementation (Anggota 4)
- [ ] Interactive menu system (Anggota 4)
- [ ] LibrarySystem integration (Anggota 5)
- [ ] Complete testing (Anggota 5)
- [ ] README documentation (Anggota 5)
- [ ] Git repository setup (Anggota 5)

---

## 💡 TIPS SUKSES

1. **Komunikasi adalah kunci** - Update progress setiap hari
2. **Ikuti struktur yang sudah ada** - Jangan ubah method signatures
3. **Test early, test often** - Jangan tunggu akhir untuk testing
4. **Document as you go** - Jangan tunda dokumentasi
5. **Help each other** - Bantu anggota yang kesulitan

## 🚀 GOOD LUCK TEAM!
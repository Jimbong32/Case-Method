# 📝 Sistem Pendaftaran Magang Mahasiswa

Program ini merupakan aplikasi console berbasis Java untuk mengelola data pendaftaran magang mahasiswa. Program menyediakan fitur untuk menambah data, menampilkan seluruh pendaftar, mencari berdasarkan program studi, dan menghitung jumlah pendaftar berdasarkan status magang.

---

## 🚀 Fitur Utama

### 1. Tambah Data Magang
- Input: Nama, NIM, Program Studi, Perusahaan, Semester, Status.
- Validasi:
  - Semester hanya **6 atau 7**
  - Status hanya **Diterima / Menunggu / Ditolak**

### 2. Tampilkan Semua Pendaftar
- Menampilkan seluruh data dalam bentuk tabel.
- Kolom: Nama, NIM, Prodi, Perusahaan, Semester, Status.

### 3. Cari Pendaftar Berdasarkan Program Studi
- Pengguna dapat mencari berdasarkan nama prodi.
- Hasil ditampilkan dalam format tabel.

### 4. Hitung Jumlah Pendaftar Berdasarkan Status
- Menghitung jumlah pendaftar:
  - Diterima
  - Menunggu
  - Ditolak
- Menampilkan total keseluruhan pendaftar.

---

## 📂 Struktur Program

InnerMagang.java → Program utama berisi menu dan seluruh fitur

---

## ▶️ Cara Menjalankan Program

1. Pastikan Java sudah terinstall di perangkat.
2. Compile program:
   ```bash
   javac InnerMagang.java
   java InnerMagang
   ```
   
## 🧩 Teknologi yang Digunakan

Java
Scanner (input user)
Array sebagai penyimpanan data

## 📌 Catatan

Maksimal kapasitas penyimpanan data adalah 100 pendaftar.
Program berbasis console sehingga cocok untuk latihan pemrograman dasar Java.

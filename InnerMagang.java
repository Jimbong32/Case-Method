import java.util.Scanner;

class Magang {
    String nama;
    String nim;
    String prodi;
    String perusahaan;
    int semester;
    String status;
}

public class InnerMagang {
    static Scanner input = new Scanner(System.in);
    static Magang[] data = new Magang[100];
    static int jumlahData = 0;

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("\n=== SISTEM PENDAFTARAN MAGANG MAHASISWA ===");
            System.out.println("1. Tambah Data Magang");
            System.out.println("2. Tampilkan Semua Pendaftar");
            System.out.println("3. Cari Pendaftar Berdasarkan Prodi");
            System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> tambahData();
                case 2 -> tampilData();
                case 3 -> cariProdi();
                case 4 -> hitungStatus();
                case 5 -> System.out.println("Program selesai.");
                default -> System.out.println("Menu tidak valid!");
            }

        } while (pilih != 5);
    }

    // ====================================================================
    // 1. Tambah Data Magang + Validasi
    // ====================================================================
    static void tambahData() {
        Magang m = new Magang();

        System.out.print("Nama Mahasiswa: ");
        m.nama = input.nextLine();

        System.out.print("NIM: ");
        m.nim = input.nextLine();

        System.out.print("Program Studi: ");
        m.prodi = input.nextLine();

        System.out.print("Perusahaan Tujuan Magang: ");
        m.perusahaan = input.nextLine();

        // Validasi Semester (6 atau 7)
        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            m.semester = input.nextInt();
            input.nextLine();

            if (m.semester == 6 || m.semester == 7) break;

            System.out.println(" Semester hanya boleh 6 atau 7!");
        }

        // Validasi Status
        while (true) {
            System.out.print("Status magang (Diterima / Menunggu / Ditolak): ");
            m.status = input.nextLine();

            if (isStatusValid(m.status)) break;

            System.out.println("Status tidak valid! Pilih: Diterima / Menunggu / Ditolak");
        }

        data[jumlahData++] = m;

        System.out.println(" Data pendaftaran berhasil ditambahkan. Total pendaftar: " + jumlahData);
    }

    // Fungsi cek validitas status
    static boolean isStatusValid(String s) {
        return s.equalsIgnoreCase("Diterima")
                || s.equalsIgnoreCase("Menunggu")
                || s.equalsIgnoreCase("Ditolak");
    }

    // ====================================================================
    // 2. Tampilkan Semua Data dalam Bentuk Tabel
    // ====================================================================
    static void tampilData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data pendaftar!");
            return;
        }

        System.out.println("\n==========================================================================================");
        System.out.printf("| %-15s | %-10s | %-20s | %-15s | %-8s | %-10s |\n",
                "Nama", "NIM", "Program Studi", "Perusahaan", "Semester", "Status");
        System.out.println("==========================================================================================");

        for (int i = 0; i < jumlahData; i++) {
            Magang m = data[i];
            System.out.printf("| %-15s | %-10s | %-20s | %-15s | %-8d | %-10s |\n",
                    m.nama, m.nim, m.prodi, m.perusahaan, m.semester, m.status);
        }

        System.out.println("==========================================================================================");
    }

    // ====================================================================
    // 3. Cari Data Berdasarkan Program Studi
    // ====================================================================
    static void cariProdi() {
        System.out.print("Masukkan Program Studi: ");
        String cari = input.nextLine();

        boolean ditemukan = false;

        System.out.println("\n=== Hasil Pencarian ===");
        for (int i = 0; i < jumlahData; i++) {
            if (data[i].prodi.equalsIgnoreCase(cari)) {
                Magang m = data[i];
                System.out.printf("| %-15s | %-10s | %-20s | %-15s | %-8s | %-10s |\n",
                "Nama", "NIM", "Program Studi", "Perusahaan", "Semester", "Status");
                System.out.printf("| %-15s | %-10s | %-20s | %-15s | %-8d | %-10s |\n",
                        m.nama, m.nim, m.prodi, m.perusahaan, m.semester, m.status);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada data mahasiswa dengan prodi tersebut.");
        }
    }

    // ====================================================================
    // 4. Hitung Jumlah Pendaftar Berdasarkan Status
    // ====================================================================
    static void hitungStatus() {
        int diterima = 0, menunggu = 0, ditolak = 0;

        for (int i = 0; i < jumlahData; i++) {
            String s = data[i].status.toLowerCase();
            switch (s) {
                case "diterima" -> diterima++;
                case "menunggu" -> menunggu++;
                case "ditolak" -> ditolak++;
            }
        }

        System.out.println("\n=== Jumlah Pendaftar Berdasarkan Status ===");
        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak  : " + ditolak);
        System.out.println("Total pendaftar: " + jumlahData);
    }
}

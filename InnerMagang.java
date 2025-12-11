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
            System.out.println("\n=== MENU SISTEM DATA MAGANG ===");
            System.out.println("1. Tambah Data Pendaftar");
            System.out.println("2. Tampilkan Semua Data");
            System.out.println("3. Cari Berdasarkan Prodi");
            System.out.println("4. Hitung Jumlah Berdasarkan Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
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

    // ----------------------------------------------------------
    // 1. Tambah Data + VALIDASI
    // ----------------------------------------------------------
    static void tambahData() {
        Magang m = new Magang();

        System.out.print("Nama mahasiswa : ");
        m.nama = input.nextLine();
        System.out.print("NIM            : ");
        m.nim = input.nextLine();

        System.out.print("Program Studi  : ");
        m.prodi = input.nextLine();

        System.out.print("Perusahaan     : ");
        m.perusahaan = input.nextLine();

        // Validasi semester hanya 6 atau 7
        do {
            System.out.print("Semester (6/7) : ");
            m.semester = input.nextInt();
            if (m.semester != 6 && m.semester != 7) {
                System.out.println("Semester harus 6 atau 7!");
            }
        } while (m.semester != 6 && m.semester != 7);
        input.nextLine();

        // Validasi status magang
        do {
            System.out.print("Status (Diterima/Menunggu/Ditolak) : ");
            m.status = input.nextLine();
            if (!m.status.equalsIgnoreCase("Diterima") &&
                !m.status.equalsIgnoreCase("Menunggu") &&
                !m.status.equalsIgnoreCase("Ditolak")) {
                System.out.println("Status tidak valid!");
            }
        } while (!m.status.equalsIgnoreCase("Diterima") &&
                 !m.status.equalsIgnoreCase("Menunggu") &&
                 !m.status.equalsIgnoreCase("Ditolak"));

        data[jumlahData] = m;
        jumlahData++;

        System.out.println("Data berhasil ditambahkan!");
    }

    // ----------------------------------------------------------
    // 2. Tampilkan Semua Data (Format TABEL)
    // ----------------------------------------------------------
    static void tampilData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data pendaftar!");
            return;
        }

        System.out.println("\n==========================================================================================");
        System.out.printf("| %-15s | %-10s | %-10s | %-15s | %-8s | %-10s |\n",
                "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");
        System.out.println("==========================================================================================");
for (int i = 0; i < jumlahData; i++) {
            Magang m = data[i];
            System.out.printf("| %-15s | %-10s | %-10s | %-15s | %-8d | %-10s |\n",
                    m.nama, m.nim, m.prodi, m.perusahaan, m.semester, m.status);
        }
        System.out.println("==========================================================================================");
    }

   
    static void cariProdi() {
        System.out.print("Masukkan Program Studi yang dicari: ");
        String cari = input.nextLine();

        boolean ditemukan = false;
        System.out.println("\nHasil Pencarian:");
        for (int i = 0; i < jumlahData; i++) {
            if (data[i].prodi.equalsIgnoreCase(cari)) {
                Magang m = data[i];
                System.out.printf("- %s (%s) | Perusahaan: %s | Semester: %d | Status: %s\n",
                        m.nama, m.nim, m.perusahaan, m.semester, m.status);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada data mahasiswa dengan prodi tersebut.");
        }
    }


    static void hitungStatus() {
        int diterima = 0, menunggu = 0, ditolak = 0;

        for (int i = 0; i < jumlahData; i++) {
            String s = data[i].status.toLowerCase();
            if (s.equals("diterima")) diterima++;
            else if (s.equals("menunggu")) menunggu++;
            else if (s.equals("ditolak")) ditolak++;
        }

        System.out.println("\nJumlah Pendaftar Berdasarkan Status:");
        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak  : " + ditolak);
    }
}

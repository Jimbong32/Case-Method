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

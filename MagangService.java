import java.util.ArrayList;
import java.util.Scanner;

public class MagangService {
    private ArrayList<Magang> data = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void tambahData() {
        System.out.println("\n=== Tambah Data Pendaftar Magang ===");

        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("NIM: ");
        String nim = input.nextLine();

        System.out.print("Program Studi: ");
        String prodi = input.nextLine();

        System.out.print("Perusahaan Tujuan: ");
        String perusahaan = input.nextLine();

        int semester = inputSemester();
        String status = inputStatus();

        data.add(new Magang(nama, nim, prodi, perusahaan, semester, status));
        System.out.println("Data berhasil ditambahkan!\n");
    }

    private int inputSemester() {
        while (true) {
            System.out.print("Semester (6 atau 7): ");
            int sem = Integer.parseInt(input.nextLine());

            if (sem == 6 || sem == 7) {
                return sem;
            }
            System.out.println("Semester tidak valid! Harus 6 atau 7.");
        }
    }

    private String inputStatus() {
        while (true) {
            System.out.print("Status (Diterima / Menunggu / Ditolak): ");
            String status = input.nextLine();

            if (status.equalsIgnoreCase("Diterima") ||
                status.equalsIgnoreCase("Menunggu") ||
                status.equalsIgnoreCase("Ditolak")) {
                return status;
            }
            System.out.println("Status tidak valid!");
        }
    }

    public void tampilkanSemua() {
        if (data.isEmpty()) {
            System.out.println("\nBelum ada data!\n");
            return;
        }

        System.out.println("\n================ DATA PENDAFTAR MAGANG ================");
        printHeader();
        for (Magang m : data) {
            m.printAsRow();
        }
        System.out.println("========================================================\n");
    }

    private void printHeader() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-12s | %-12s | %-10s | %-8s | %-10s |\n",
                "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");
        System.out.println("--------------------------------------------------------------------------");
    }

    public void cariByProdi() {
        System.out.print("\nMasukkan nama Program Studi yang dicari: ");
        String target = input.nextLine();

        boolean ditemukan = false;

        printHeader();
        for (Magang m : data) {
            if (m.getProdi().equalsIgnoreCase(target)) {
                m.printAsRow();
                ditemukan = true;
            }
        }
        System.out.println("--------------------------------------------------------------------------");

        if (!ditemukan) {
            System.out.println("Tidak ada data dengan prodi tersebut.\n");
        }
    }

    public void hitungStatus() {
        int diterima = 0, menunggu = 0, ditolak = 0;

        for (Magang m : data) {
            switch (m.getStatus().toLowerCase()) {
                case "diterima" -> diterima++;
                case "menunggu" -> menunggu++;
                case "ditolak" -> ditolak++;
            }
        }

        System.out.println("\n=== REKAP STATUS MAGANG ===");
        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak  : " + ditolak);
        System.out.println("\nTotal pendaftar magang saat ini: " + data.size() + "\n");

    }
}

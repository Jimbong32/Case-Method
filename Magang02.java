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

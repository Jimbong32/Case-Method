public class Magang {
    private String nama;
    private String nim;
    private String prodi;
    private String perusahaan;
    private int semester;
    private String status;

    public Magang(String nama, String nim, String prodi, String perusahaan, int semester, String status) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.perusahaan = perusahaan;
        this.semester = semester;
        this.status = status;
    }

    public String getProdi() {
        return prodi;
    }

    public String getStatus() {
        return status;
    }

    public void printAsRow() {
        System.out.printf("| %-15s | %-12s | %-12s | %-10s | %-8d | %-10s |\n",
                nama, nim, prodi, perusahaan, semester, status);
    }
}

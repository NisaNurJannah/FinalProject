import java.util.Scanner;
import java.util.Stack;

class Transaksi {
    private String jenis;
    private double jumlah;

    public Transaksi(String jenis, double jumlah) {
        this.jenis = jenis;
        this.jumlah = jumlah;
    }

    public String getJenis() {
        return jenis;
    }

    public double getJumlah() {
        return jumlah;
    }
}

class ATM {
    private Stack<Transaksi> riwayatTransaksi;

    public ATM() {
        riwayatTransaksi = new Stack<>();
    }

    public void lakukanTransaksi(String jenis, double jumlah) {
        Transaksi transaksi = new Transaksi(jenis, jumlah);
        riwayatTransaksi.push(transaksi);
        System.out.println("Transaksi: " + jenis + ", Jumlah: " + jumlah);
    }

    public void tampilkanRiwayatTransaksi() {
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Riwayat transaksi kosong.");
        } else {
            System.out.println("Riwayat Transaksi:");
            for (Transaksi transaksi : riwayatTransaksi) {
                System.out.println("Jenis: " + transaksi.getJenis() + ", Jumlah: " + transaksi.getJumlah());
            }
        }
    }

    public void batalkanTransaksiTerakhir() {
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi yang dapat dibatalkan.");
        } else {
            Transaksi transaksiTerakhir = riwayatTransaksi.pop();
            System.out.println("Membatalkan Transaksi Terakhir: Jenis: " + transaksiTerakhir.getJenis() +
                    ", Jumlah: " + transaksiTerakhir.getJumlah());
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        int pilihan = 0;
        while (pilihan != 4) {
            System.out.println("Menu ATM:");
            System.out.println("1. Lakukan Transaksi");
            System.out.println("2. Tampilkan Riwayat Transaksi");
            System.out.println("3. Batalkan Transaksi Terakhir");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan jenis transaksi (Deposit/Tarik): ");
                    String jenis = scanner.next();
                    System.out.print("Masukkan jumlah transaksi: ");
                    double jumlah = scanner.nextDouble();
                    atm.lakukanTransaksi(jenis, jumlah);
                }
                case 2 -> atm.tampilkanRiwayatTransaksi();
                case 3 -> atm.batalkanTransaksiTerakhir();
                case 4 -> System.out.println("Keluar dari sistem ATM.");
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            System.out.println();
        }
    }
}
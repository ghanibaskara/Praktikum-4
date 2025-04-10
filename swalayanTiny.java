import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swalayanTiny {
    //deklarasi variabel static agar selalu ada di memori (bisa digunakan langsung pada semua class dan method di dalam file)
    static Scanner input = new Scanner(System.in);
    static listPelanggan list = new listPelanggan();
    static int choice;

    public static void main(String[] args) {

        //deklarasi objek pelanggan yang akan disimpan pada list pelanggkan
        Pelanggan silver = new Pelanggan("3812345678", "Budi Santoso", 500000, "1234");
        Pelanggan gold = new Pelanggan("5623456789", "Siti Rahma", 1000000, "2345");
        Pelanggan platinum = new Pelanggan("7434567890", "Joko Widodo", 2000000, "3456");

        list.tambahkanPelanggan("3812345678", silver);
        list.tambahkanPelanggan("5623456789", gold);
        list.tambahkanPelanggan("7434567890", platinum);

        menu();

    }

    //method menu untuk menampilkan menu awal masuk program
    public static void menu() {
        //menggunakan while agar selalu kembali ke menu awal
        while (true) {
            System.out.println("\n===== SELAMAT DATANG DI SWALAYAN TINY =====");
            System.out.println("1. Login Pelanggan");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu (1-2):");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                // memanggil metohd login
                    login();
                    break;
                case 2:
                    System.out.println("Terima kasih telah menggunakan layanan Swalayan Tiny!");
                    //system exit untuk mengakhiri program
                    System.exit(0);
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        }
    }

    public static void login() {
        System.out.print("\nMasukkan nomor pelanggan (10 digit): ");
        String Input = input.nextLine();

        //if condition agar hanya menerima input yang panjangnya 10 digit
        if (Input.length() == 10) {
            //deklarasi variabel prefix untuk mengambil 2 huruf pertama dari input
            String prefix = Input.substring(0, 2);
            //if condition kedua untuk memfilter hanya input 10 digit degan prefix yang sesuai agar bisa masuk ke program
            if (prefix.equals("38") || prefix.equals("56") || prefix.equals("74")) {
                //disini format input sudah sesuai dengan nomor pelanggan, kemudian if condition untuk mengetahui apakah input merupakan akun pelanggan yang terdaftar
                if (list.nomorPelanggan.contains(Input)) {
                    //deklarasi variabel int index untuk mengetahui index dari akun pelanggan yang ada di dalam class listpelanggan menggunakan indexOf
                    int index = list.nomorPelanggan.indexOf(Input);
                    //for loop menggunakan nilai variabel dalam objek pelanggan yang diambil dari list pelanggan
                    for (list.Pelanggan.get(index).getPercobaanLogin(); list.Pelanggan.get(index)
                            .getPercobaanLogin() <= 3; list.Pelanggan.get(index).tambahkanPercobaanLogin()) {
                                //if condition apabila entitas telah diblokir maka akan keluar dari method
                        if (list.Pelanggan.get(index).isBlocked() == true) {
                            System.out.println("Akun Anda telah diblokir karena 3 kali gagal autentikasi.");
                            return;
                        }
                        System.out.println("Masukkan pin anda : ");
                        Input = input.nextLine();
                        //if condition untuk konfirmasi pin yang sesuai dengan objek
                        if (list.Pelanggan.get(index).getPin().equals(Input)) {
                            System.out.println("Berhasil Login.");
                            //masu ke methood menu pelanggan dengan parameter objek pelanggan pada index yang sesuai
                            menuPelanggan(list.Pelanggan.get(index));
                            break;

                        } else {
                            System.out.println("PIN salah! Kesempatan tersisa: "
                                    + (2 - list.Pelanggan.get(index).getPercobaanLogin()));
                        }
                    }

                } else {
                    System.out.println("Pelanggan dengan nomor " + Input + " tidak ditemukan.");
                }
            } else {
                System.out.println("Prefix tidak valid. Harus diawali dengan 38, 56, atau 74.");
            }
        } else {
            System.out.println("Nomor pelanggan tidak valid. Harus 10 digit.");
        }
    }

    public static void menuPelanggan(Pelanggan pelanggan) {
       //menggunakan while agar selalu kembali ke menu awal
        while (true) {
            System.out.println("\n===== MENU PELANGGAN =====");
            System.out.println(
                    "Selamat datang, " + pelanggan.getNamaPelanggan() + " (Pelanggan " + pelanggan.getTipeAkun() + ")");
            System.out.println("Saldo Anda: Rp " + pelanggan.getSaldo());
            System.out.println("1. Pembelian");
            System.out.println("2. Top Up Saldo");
            System.out.println("3. Lihat Info Akun");
            System.out.println("4. Logout");
            System.out.print("Pilih menu (1-4): ");

            choice = input.nextInt();
            input.nextLine();

            //switch case untuk masuk ke method yang sesuai
            switch (choice) {
                case 1:
                    purchase(pelanggan);
                    break;
                case 2:
                    topup(pelanggan);
                    break;
                case 3:
                    infoAkun(pelanggan);
                    break;
                case 4:
                    System.out.println("Logout berhasil!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void purchase(Pelanggan pelanggan) {
        System.out.print("Masukkan jumlah pembelian (Rp): ");
        double amount = input.nextDouble();
        input.nextLine();

        //apabila input amount yang dimasukkan negatif akan keluar dari method
        if (amount <= 0) {
            System.out.println("Jumlah pembelian harus lebih dari 0.");
            return;
        }

        //for loop untuk pengisian pin dengan batas 3x percobaan gagal
        for (pelanggan.getPercobaanLogin(); pelanggan.getPercobaanLogin() <= 3; pelanggan.tambahkanPercobaanLogin()) {

            //apabila kondisi akun telah terblokir akan keluar dari method
            if (pelanggan.isBlocked()) {
                System.out.println("Akun Anda telah diblokir karena 3 kali gagal autentikasi.");
                return;
            }
            System.out.println("Masukkan PIN untuk konfirmasi: ");
            String pin = input.nextLine();

            //if condition untuk mengonfirmasi pin yang sesuai
            if (pelanggan.getPin().equals(pin)) {
                //if condition untuk memenuhi syarat saldo setelah transaksi harus diatas 10k
                if (pelanggan.getSaldo() - amount >= 10000) {
                    System.out.println("Pembelian sebesar Rp " + amount + " berhasil.");
                    pelanggan.purchase(amount);
                    System.out.println("Saldo baru: Rp " + pelanggan.getSaldo());
                    return;
                } else {
                    System.out.println(
                            "Pembelian gagal. Pastikan saldo Anda mencukupi (min. Rp 10.000 setelah transaksi).");
                    return;
                }
            } else {
                System.out.println("PIN salah! Kesempatan tersisa: " + (2 - pelanggan.getPercobaanLogin()));
            }
        }
    }

    public static void infoAkun(Pelanggan pelanggan) {
        System.out.println("\n===== INFORMASI AKUN =====");
        System.out.println("Nomor Pelanggan: " + pelanggan.getNomorPelanggan());
        System.out.println("Nama: " + pelanggan.getNamaPelanggan());
        System.out.println("Jenis Pelanggan: " + pelanggan.getTipeAkun());
        System.out.println("Saldo: Rp " + pelanggan.getSaldo());

        switch (pelanggan.getTipeAkun()) {
            case "Silver":
                System.out.println("Cashback: 5% untuk pembelian di atas Rp 1.000.000");
                break;
            case "Gold":
                System.out.println("Cashback: 7% untuk pembelian di atas Rp 1.000.000, 2% untuk pembelian lainnya");
                break;
            case "Platinum":
                System.out.println("Cashback: 10% untuk pembelian di atas Rp 1.000.000, 5% untuk pembelian lainnya");
                break;
            default:
                break;
        }
        //ternary operation untuk mengembalikan nilai diblokir apabila variabel blocked bernilai false dan mengembalikan nilai aktif apabila variabel blocked bernilai trua
        System.out.println("Status Akun: " + (pelanggan.isBlocked() ? "Diblokir" : "Aktif"));
    }

    public static void topup(Pelanggan pelanggan) {
        System.out.print("Masukkan jumlah top up (Rp): ");
        double amount = input.nextDouble();
        input.nextLine();

         //apabila input amount yang dimasukkan negatif akan keluar dari method
        if (amount <= 0) {
            System.out.println("Jumlah top up harus lebih dari 0.");
            return;
        }

        //for loop untuk pengisian pin dengan batas 3x percobaan gagal
        for (pelanggan.getPercobaanLogin(); pelanggan.getPercobaanLogin() <= 3; pelanggan.tambahkanPercobaanLogin()) {

              //apabila kondisi akun telah terblokir akan keluar dari method
            if (pelanggan.isBlocked()) {
                System.out.println("Akun Anda telah diblokir karena 3 kali gagal autentikasi.");
                return;
            }

             //if condition untuk mengonfirmasi pin yang sesuai
            System.out.println("Masukkan PIN untuk konfirmasi: ");
            String pin = input.nextLine();
            if (pelanggan.getPin().equals(pin)) {
                pelanggan.topup(amount);
                return;
            } else {
                System.out.println("PIN salah! Kesempatan tersisa: " + (2 - pelanggan.getPercobaanLogin()));
            }
        }
    }
}



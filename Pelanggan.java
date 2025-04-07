//class untuk entitas pelanggan
public class Pelanggan {
    // deklarasi variabel dengan enkapsulasi private agar tidak bisa diakses secara
    // langsung, yang berarti harus menggunakan method untuk mengakses variabel tsb
    private double saldo;
    private String nomorPelanggan;
    private String namaPelanggan;
    private String pin;
    private int percobaanLogin = 0;
    private boolean blocked = false;
    private String tipeAkun;

    // constructor objek pelanggan dengan parameter nomor pelanggan, nama, saldo,
    // dan pin
    Pelanggan(String nomorPelanggan, String namaPelanggan, double saldo, String pin) {
        this.nomorPelanggan = nomorPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.saldo = saldo;
        this.pin = pin;
        // di akhir konstruktor memanggil method set tipe akun untuk menandai tipe akun
        // dari pelanggan ini (ex silver, gold, platinum)
        setTipeAkun();
    }

    // getter method
    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public int getPercobaanLogin() {
        return percobaanLogin;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipeAkun() {
        return tipeAkun;
    }

    public boolean isBlocked() {
        return blocked;
    }

    //method tambahkan percobaan login untuk menaikkan nilai dari variabel percobaan login

    public void tambahkanPercobaanLogin() {
        percobaanLogin++;
        //di akhir akan memanggil method terblokir untuk mengevaluasi apabila variabel percobban login bernilai 3, variabel blocked akan bernilai true
        teblokir();
    }

    public void teblokir() {
        if (percobaanLogin == 3) {
            blocked = true;
        }
    }

    public void topup(double amount) {
        saldo += amount;
    }

    public void purchase(double amount) {
        //if condition untuk mengevaluasi apabila pembelian bejumlah lebih dari 1 jt maka akan menerapkan cashback
        if (amount > 1000000) {
            //menerapkan cashback sesuai dengan tipe akun yang sesuai menggunakan switch case
            switch (getTipeAkun()) {
                case "Silver":
                    saldo -= amount * 0.95;
                    break;
                case "Gold":
                    saldo -= amount * 0.93;
                    break;
                case "Platinum":
                    saldo -= amount * 0.9;
                    break;
                default:
                    break;
            }
        } else {
            //menerapkan cashback sesuai dengan tipe akun yang sesuai menggunakan switch case untuk pembelian yang berjumlah kurang dari 1jt
            switch (getTipeAkun()) {
                case "Silver":
                    saldo -= amount;
                    break;
                case "Gold":
                    saldo -= amount * 0.98;
                    break;
                case "Platinum":
                    saldo -= amount * 0.95;
                    break;
            }
        }

    }

    public void setTipeAkun() {
        //menggunakan substring dari string nomor pelanggan dengan awal 0 dan akhir 2 untuk mengambil prefix 2 huruf pertama pada string nomorpelanggan yang kemudian dievaluasi pada switch case untuk menerapkan nilai tipe akun yang sesuai perintah
        switch (nomorPelanggan.substring(0, 2)) {
            case "38":
                tipeAkun = "Silver";
                break;
            case "56":
                tipeAkun = "Gold";
                break;
            case "74":
                tipeAkun = "Platinum";
                break;
            default:
                break;
        }
    }

}

import java.util.ArrayList;

//class listPelanggan untuk menyimpan data pelanggan yang terdaftar menggunnakan array list
public class listPelanggan {
    // menyimpan id pelanggan
    public ArrayList<String> nomorPelanggan = new ArrayList<String>();

    // menyimpan class pelanggan
    public ArrayList<Pelanggan> Pelanggan = new ArrayList<Pelanggan>();

    listPelanggan() {
    }

    // method tambahkan pelanggan dengan constructor nomor pelanggan dan objek
    // pelanggan yang akan disimpan dalam array list
    public void tambahkanPelanggan(String nomorPelanggan, Pelanggan Pelanggan) {
        this.nomorPelanggan.add(nomorPelanggan);
        this.Pelanggan.add(Pelanggan);
    }

}
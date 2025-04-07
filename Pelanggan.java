public class Pelanggan {
   
        private double saldo;
        private String nomorPelanggan;
        private String namaPelanggan;
        private String pin;
        private int percobaanLogin = 0;
        private boolean blocked = false;
        private String tipeAkun;
    
        Pelanggan(String nomorPelanggan, String namaPelanggan, double saldo, String pin) {
            this.nomorPelanggan = nomorPelanggan;
            this.namaPelanggan = namaPelanggan;
            this.saldo = saldo;
            this.pin = pin;
            setTipeAkun();
        }
    
        public String getNomorPelanggan() {
            return nomorPelanggan;
        }
    
        public String getNamaPelanggan() {
            return namaPelanggan;
        }
    
        public int getPercobaanLogin() {
            return percobaanLogin;
        }
    
        public void tambahkanPercobaanLogin() {
            percobaanLogin++;
            teblokir();
        }
    
        public void teblokir() {
            if (percobaanLogin == 3) {
                blocked = true;
            }
        }
    
        public boolean isBlocked() {
            return blocked;
        }
    
        public String getPin() {
            return pin;
        }
    
        public double getSaldo() {
            return saldo;
        }
    
        public void topup(double amount) {
            saldo += amount;
        }
    
        public void purchase(double amount) {
            if (amount > 1000000) {
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
    
        public String getTipeAkun() {
            return tipeAkun;
        }
    
    }
    


import java.util.Date;

public class LibraryMember {

    private ProfilAnggota profil;
    private String kodeAnggota;
    private Date tanggalGabung;
    private boolean statusAktif;
    private TingkatKeanggotaan tingkatKeanggotaan;
    private int jumlahBukuDipinjam;
    private int jumlahTerlambat;
    private int jumlahDenda;
    private int poinLoyalitas;
    private String kodeReferal;
    private boolean langgananBuletin;

   
    // sebelum refactoring
    public LibraryMember(String namaLengkap, String alamat, String nomorTelepon, String email, String jenisKelamin,
    String kodeAnggota, Date tanggalGabung, boolean statusAktif,
    String tingkatKeanggotaan, int jumlahBukuDipinjam, int jumlahTerlambat, int jumlahDenda,
    int poinLoyalitas, String kodeReferal, boolean langgananBuletin) {
    //
}
    // sesudah refactoring 
    public LibraryMember(ProfilAnggota profil, String kodeAnggota, Date tanggalGabung,
                         boolean statusAktif, TingkatKeanggotaan tingkatKeanggotaan,
                         int jumlahBukuDipinjam, int jumlahTerlambat, int jumlahDenda,
                         int poinLoyalitas, String kodeReferal, boolean langgananBuletin) {
        this.profil = profil;
        this.kodeAnggota = kodeAnggota;
        this.tanggalGabung = tanggalGabung;
        this.statusAktif = statusAktif;
        this.tingkatKeanggotaan = tingkatKeanggotaan;
        this.jumlahBukuDipinjam = jumlahBukuDipinjam;
        this.jumlahTerlambat = jumlahTerlambat;
        this.jumlahDenda = jumlahDenda;
        this.poinLoyalitas = poinLoyalitas;
        this.kodeReferal = kodeReferal;
        this.langgananBuletin = langgananBuletin;
    }

    public void cetakProfilLengkap() {
        System.out.println("===== PROFIL ANGGOTA =====");
        System.out.println("Nama         : " + profil.getNamaLengkap());
        System.out.println("Jenis Kelamin: " + profil.getJenisKelamin());
        System.out.println("Alamat       : " + profil.getAlamat());
        System.out.println("Telepon      : " + profil.getNomorTelepon());
        System.out.println("Email        : " + profil.getEmail());
        System.out.println("Kode Anggota : " + kodeAnggota);
        System.out.println("Tanggal Gabung: " + tanggalGabung);
        System.out.println("Status Aktif : " + statusAktif);
        System.out.println("Tingkat      : " + tingkatKeanggotaan);
        System.out.println("Buku Dipinjam: " + jumlahBukuDipinjam);
        System.out.println("Terlambat    : " + jumlahTerlambat);
        System.out.println("Denda        : Rp " + jumlahDenda);
        System.out.println("Poin         : " + poinLoyalitas);
        System.out.println("Kode Referal : " + kodeReferal);
        System.out.println("Langganan Buletin: " + langgananBuletin);
        System.out.println("Skor Risiko  : " + hitungSkorRisiko());
        System.out.println("Layak Upgrade?: " + periksaKelayakanUpgrade());
        System.out.println("===========================");
    }

    public boolean periksaKelayakanUpgrade() {
        return tingkatKeanggotaan == TingkatKeanggotaan.DASAR && poinLoyalitas > 100;
    }

    public double hitungSkorRisiko() {
        double skor = 0;
        skor += jumlahTerlambat * 1.5;
        skor += jumlahDenda * 0.1;
        if (!statusAktif) skor += 5;
        if (tingkatKeanggotaan == TingkatKeanggotaan.DASAR) skor += 2;
        if (jumlahBukuDipinjam > 50) skor -= 1.5;
        return skor;
    }
}
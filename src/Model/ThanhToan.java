package Model;

public class ThanhToan {
    //maptp, tenkh,cmnd,sdt,email,tinhtrrang
    private  int MaPhieu;
    private  String TenKH;
    private  String CMND;
    private  String SDT;
    private  String Email;
    private  String TinhTrang;
    private  String LoaiPhieu;


    ThanhToan(){}
    public ThanhToan(int maphieu, String tenkh, String cmnd, String sdt, String email,String loaiphieu, String tinhtrang){
        MaPhieu = maphieu;
        TenKH = tenkh;
        CMND = cmnd;
        SDT = sdt;
        Email = email;
        LoaiPhieu = loaiphieu;
        TinhTrang = tinhtrang;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public int getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        MaPhieu = maPhieu;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setLoaiPhieu(String loaiPhieu) {
        LoaiPhieu = loaiPhieu;
    }

    public String getLoaiPhieu() {
        return LoaiPhieu;
    }
}

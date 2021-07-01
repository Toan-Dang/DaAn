package Model;

import java.util.Date;

public class KhachHang {
    private int MaKH;
    private String MaLKH;
    private String UserName;
    private Date NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String SDT;
    private String CMND;
    private String Email;
    private String DoanhSo;
    private String TenKH;

    public  KhachHang(){}
    public KhachHang(int makh, String username, String tenkh, String lkh, String sdt, String cmnd){
        MaKH = makh;
        MaLKH = lkh;
        UserName = username;
        TenKH = tenkh;
        SDT = sdt;
        CMND = cmnd;
    }
    public KhachHang(  int MaKH,
             String MaLKH,
             String UserName,
             Date NgaySinh,
             String GioiTinh,
             String DiaChi,
             String SDT,
             String CMND,
             String Email,
             String DoanhSo,
             String TenKH)
    {
        this.MaKH= MaKH;
        this.MaLKH = MaLKH;
        this.UserName = UserName;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CMND = CMND;
        this.Email = Email;
        this.DoanhSo = DoanhSo;
        this.TenKH = TenKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCMND() {
        return CMND;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setDoanhSo(String doanhSo) {
        DoanhSo = doanhSo;
    }

    public String getDoanhSo() {
        return DoanhSo;
    }

    public void setMaLKH(String maLKH) {
        MaLKH = maLKH;
    }

    public String getMaLKH() {
        return MaLKH;
    }

}

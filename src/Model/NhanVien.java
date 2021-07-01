package Model;

import java.util.Date;

public class NhanVien {
    private int MaNV;
    private int NguoiQuanLy;
    private String UserName;
    private String TenNV;
    private Date NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String SDT;
    private String CMND;
    private String Email;
    private String ChucVu;
    private Date NgayVaoLam;

    NhanVien(){}

   public NhanVien(int manv, String tennv, String username,String chucvu, String SDT, String CMND){
        MaNV = manv;
        TenNV = tennv;
        UserName = username;
        ChucVu = chucvu;
        this.SDT =SDT;
        this.CMND = CMND;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getCMND() {
        return CMND;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSDT() {
        return SDT;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        NgayVaoLam = ngayVaoLam;
    }

    public Date getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNguoiQuanLy(int nguoiQuanLy) {
        NguoiQuanLy = nguoiQuanLy;
    }

    public int getNguoiQuanLy() {
        return NguoiQuanLy;
    }

}

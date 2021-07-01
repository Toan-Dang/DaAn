package Model;

import java.util.Date;

public class ChiTietPhieuThuePhong {
    private int MaPTP;
    private int Maphong;
    private  String LoaiPhong;
    private Date NgayNhanPhong;
    private Date NgayTraPhong;
    private  double Tien;
    private  double Gia;

    ChiTietPhieuThuePhong(){}
    public ChiTietPhieuThuePhong(int maphong, String lp, Date nnp, Date ntp, double tien, double gia){
        Maphong = maphong;
        LoaiPhong = lp;
        NgayNhanPhong = nnp;
        NgayTraPhong = ntp;
        Tien = tien;
        Gia = gia;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }

    public Date getNgayTraPhong() {
        return NgayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        NgayTraPhong = ngayTraPhong;
    }

    public Date getNgayNhanPhong() {
        return NgayNhanPhong;
    }

    public void setNgayNhanPhong(Date ngayNhanPhong) {
        NgayNhanPhong = ngayNhanPhong;
    }

    public int getMaPTP() {
        return MaPTP;
    }

    public void setMaPTP(int maPTP) {
        MaPTP = maPTP;
    }

    public int getMaphong() {
        return Maphong;
    }

    public void setMaphong(int maphong) {
        Maphong = maphong;
    }

    public double getTien() {
        return Tien;
    }

    public void setLoaiPhong(String loaiPhong) {
        LoaiPhong = loaiPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setTien(double tien) {
        Tien = tien;
    }
}

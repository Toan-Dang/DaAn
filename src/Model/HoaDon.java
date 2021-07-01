package Model;

import java.util.Date;

public class HoaDon {
    private int MaKH;
    private int       MaNV;
    private int MaBILL;
    private int        MaPTP;
    private int  MaHDDT;
    private int       MaPT;
    private int  MaKM;
    private int       MaPDV;
    private double  TongTien;
    private Date NgayThanhToan;
    private Date  NgayKhachVaoO;
    private Date      NgayKhachDi;

    HoaDon (){}
    public HoaDon(int mahd, int makh, int manv, int maptp, int mahddt, int mapdv, int mapt, int makm,
                         double tien, Date ntt, Date nv, Date nd){
        MaKH = makh;
        MaNV = manv;
        MaBILL = mahd;
        MaPTP = maptp;
        MaHDDT = mahddt;
        MaPT = mapt;
        MaKM = makm;
        MaPDV = mapdv;
        TongTien = tien;
        NgayThanhToan = ntt;
        NgayKhachVaoO = nv;
        NgayKhachDi = nd;
    }
    public HoaDon(int mahd, int makh, int manv, int maptp, int mapdv, int mapt, int makm,
                  double tien, Date ntt, Date nv, Date nd){
        MaKH = makh;
        MaNV = manv;
        MaBILL = mahd;
        MaPTP = maptp;
        MaPT = mapt;
        MaKM = makm;
        MaPDV = mapdv;
        TongTien = tien;
        NgayThanhToan = ntt;
        NgayKhachVaoO = nv;
        NgayKhachDi = nd;
    }
    public HoaDon(int mahd, int makh, int manv, int maptp, int mapdv, int mapt, int makm,
                  double tien, Date ntt){
        MaKH = makh;
        MaNV = manv;
        MaBILL = mahd;
        MaPTP = maptp;
        MaPT = mapt;
        MaKM = makm;
        MaPDV = mapdv;
        TongTien = tien;
        NgayThanhToan = ntt;
    }

    public void setMaPTP(int maPTP) {
        MaPTP = maPTP;
    }

    public int getMaPTP() {
        return MaPTP;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        NgayThanhToan = ngayThanhToan;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public int getMaBILL() {
        return MaBILL;
    }

    public void setMaBILL(int maBILL) {
        MaBILL = maBILL;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setMaHDDT(int maHDDT) {
        MaHDDT = maHDDT;
    }

    public int getMaHDDT() {
        return MaHDDT;
    }

    public void setMaKM(int maKM) {
        MaKM = maKM;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setMaPDV(int maPDV) {
        MaPDV = maPDV;
    }

    public int getMaKM() {
        return MaKM;
    }

    public void setMaPT(int maPT) {
        MaPT = maPT;
    }

    public Date getNgayKhachDi() {
        return NgayKhachDi;
    }

    public void setNgayKhachDi(Date ngayKhachDi) {
        NgayKhachDi = ngayKhachDi;
    }

    public int getMaPDV() {
        return MaPDV;
    }

    public void setNgayKhachVaoO(Date ngayKhachVaoO) {
        NgayKhachVaoO = ngayKhachVaoO;
    }

    public Date getNgayKhachVaoO() {
        return NgayKhachVaoO;
    }

    public void setTongTien(double tongTien) {
        TongTien = tongTien;
    }

    public int getMaPT() {
        return MaPT;
    }

}

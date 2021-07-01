package Model;


public class ChiTietThietHai {
    private String TenDv;
    private double Gia;
    private int SoLuong;
    private double Tien;

    ChiTietThietHai(){}
    public ChiTietThietHai(String ten, double gia, int sl, double tien){
        TenDv = ten;
        Gia = gia;
        SoLuong = sl;
        Tien = tien;
    }

    public void setTien(double tien) {
        Tien = tien;
    }

    public double getTien() {
        return Tien;
    }

    public void setGia(double gia) {
        Gia = gia;
    }

    public double getGia() {
        return Gia;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setTenDv(String tenDv) {
        TenDv = tenDv;
    }

    public String getTenDv() {
        return TenDv;
    }
}

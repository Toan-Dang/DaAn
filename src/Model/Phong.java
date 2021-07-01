package Model;

import java.util.List;

public class Phong {
    private int MaPhong;
    private String MaLoaiPhong;
    private String TinhTrang;
    private String GhiChu;
    private int SoLuongNguoiHienTai;
    private  double Gia;

    List<LoaiPhong> loaiPhongs;
    public Phong(){

    }
    public Phong(int maphong, String maloaiphong, int soluong, String tinhtrang){
        this.MaPhong = maphong;
        this.MaLoaiPhong = maloaiphong;
        this.TinhTrang = tinhtrang;
        this.SoLuongNguoiHienTai = soluong;

    }

    public Phong(int maphong, String maloaiphong, int soluong, String tinhtrang,double gia){
        this.MaPhong = maphong;
        this.MaLoaiPhong = maloaiphong;
        this.TinhTrang = tinhtrang;
        this.SoLuongNguoiHienTai = soluong;
        this.Gia = gia;
    }

    public Phong(int MaPhong, String MaLoaiPhong, double gia, int soluongtoida, String ghiChu) {
        this.MaPhong = MaPhong;
        this.MaLoaiPhong = MaLoaiPhong;
        this.Gia = gia;
        this.SoLuongNguoiHienTai = soluongtoida;
        this.GhiChu = ghiChu;
    }
    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        MaLoaiPhong = maLoaiPhong;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int maPhong) {
        MaPhong = maPhong;
    }

    public int getSoLuongNguoiHienTai() {
        return SoLuongNguoiHienTai;
    }

    public void setSoLuongNguoiHienTai(int soLuongNguoiHienTai) {
        SoLuongNguoiHienTai = soLuongNguoiHienTai;
    }
}

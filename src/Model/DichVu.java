package Model;

public class DichVu {
    private String TenDV;
    private String GhiChu;
    private double Gia;
    private int MaDv;


    public DichVu() {
    }

    public DichVu(int madv, String tendv, String ghichu, double gia) {
        MaDv = madv;
        TenDV = tendv;
        GhiChu = ghichu;
        Gia = gia;
    }

    public DichVu(String tendv, String ghichu, double gia) {
        TenDV = tendv;
        GhiChu = ghichu;
        Gia = gia;
    }

    public Double getGia() {
        return Gia;
    }

    public void setGia(Double gia) {
        Gia = gia;
    }

    public int getMaDv() {
        return MaDv;
    }

    public void setMaDv(int maDv) {
        MaDv = maDv;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String tenDV) {
        TenDV = tenDV;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }


}

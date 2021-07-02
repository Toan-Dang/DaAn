package Model;

import java.sql.Date;

public class DichVu2 {
    private String tenDichVu;
    private String chiTiet;
    private double gia;
    private int SL;
    private double thanhTien;
    private Date NgayYeuCau;

    public DichVu2(String tenDichVu, double gia, String chiTiet,int sL,double thanhTien)  {
        super();
        this.tenDichVu = tenDichVu;
        this.chiTiet = chiTiet;
        this.gia = gia;
        SL = sL;
        this.thanhTien = thanhTien;
    }
    public DichVu2(String tenDichVu, double gia, String chiTiet,int sL,Date ngayYeuCau,double thanhTien)  {
        super();
        this.tenDichVu = tenDichVu;
        this.chiTiet = chiTiet;
        this.gia = gia;
        SL = sL;
        this.thanhTien = thanhTien;
        NgayYeuCau = ngayYeuCau;
    }
    /**
     * @return the ngayYeuCau
     */
    public Date getNgayYeuCau() {
        return NgayYeuCau;
    }
    /**
     * @param ngayYeuCau the ngayYeuCau to set
     */
    public void setNgayYeuCau(Date ngayYeuCau) {
        NgayYeuCau = ngayYeuCau;
    }
    /**
     * @return the tenDichVu
     */
    public String getTenDichVu() {
        return tenDichVu;
    }
    /**
     * @param tenDichVu the tenDichVu to set
     */
    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }
    /**
     * @return the chiTiet
     */
    public String getChiTiet() {
        return chiTiet;
    }
    /**
     * @param chiTiet the chiTiet to set
     */
    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }
    /**
     * @return the gia
     */
    public double getGia() {
        return gia;
    }
    /**
     * @param gia the gia to set
     */
    public void setGia(double gia) {
        this.gia = gia;
    }
    /**
     * @return the sL
     */
    public int getSL() {
        return SL;
    }
    /**
     * @param sL the sL to set
     */
    public void setSL(int sL) {
        SL = sL;
    }
    /**
     * @return the thanhTien
     */
    public double getThanhTien() {
        return thanhTien;
    }
    /**
     * @param thanhTien the thanhTien to set
     */
    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
package Model;

import java.util.Date;

public class DSNguoiTrongPhong {
	private String tenKH;
	private String gioiTinh;
	private String SDT;
	private Date ngaySinh;
	private String QuocTich;
	private String CMND;
	private String diaChi;
	private String email;
	private int MaPhong;
	private Date NgayDen;


	public DSNguoiTrongPhong(String tenKH, String gioiTinh, String sdt, Date ngaySinh, String quocTich, String cmnd,
							 String diaChi, String email, int maPhong, Date ngayDen) {
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.SDT = sdt;
		this.ngaySinh = ngaySinh;
		this.QuocTich = quocTich;
		this.CMND = cmnd;
		this.diaChi = diaChi;
		this.email = email;
		this.MaPhong = maPhong;
		this.NgayDen = ngayDen;
	}

    public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getQuocTich() {
		return QuocTich;
	}
	public void setQuocTich(String quocTich) {
		this.QuocTich = quocTich;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setMaPhong(int maPhong) {
		MaPhong = maPhong;
	}

	public int getMaPhong() {
		return MaPhong;
	}

	public void setNgayDen(Date ngayDen) {
		NgayDen = ngayDen;
	}

	public Date getNgayDen() {
		return NgayDen;
	}
}

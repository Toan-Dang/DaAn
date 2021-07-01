package Model;

import java.util.Date;

public class DangKiTruoc {
	private int maPhong;
	private int maKH;
	private Date ngayDK;
	private Date ngayNhanPhong;
	private Date ngayTraPhong;
	
	public DangKiTruoc(int maKH, Date ngayDK, Date ngayNhanPhong, Date ngayTraPhong) {
		super();
		this.maKH = maKH;
		this.ngayDK = ngayDK;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
	}
	
	public DangKiTruoc() {}
	
	
	public DangKiTruoc(int maPhong, int maKH, Date ngayDK, Date ngayNhanPhong, Date ngayTraPhong) {
		super();
		this.maPhong = maPhong;
		this.maKH = maKH;
		this.ngayDK = ngayDK;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
	}

	public int getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public Date getNgayDK() {
		return ngayDK;
	}
	public void setNgayDK(Date ngayDK) {
		this.ngayDK = ngayDK;
	}
	public Date getNgayNhanPhong() {
		return ngayNhanPhong;
	}
	public void setNgayNhanPhong(Date ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}
	public Date getNgayTraPhong() {
		return ngayTraPhong;
	}
	public void setNgayTraPhong(Date ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}

	
	
}

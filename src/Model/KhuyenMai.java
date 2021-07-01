package Model;

import java.util.Date;

public class KhuyenMai {
	private  int MaKM;
	private String tenKM;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	

	public KhuyenMai(int maKM, String tenKM, Date ngayBatDau, Date ngayKetThuc) {
		this.MaKM = maKM;
		this.tenKM = tenKM;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}


	public int getMaKM() {
		return MaKM;
	}

	public void setMaKM(int maKM) {
		MaKM = maKM;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}
}

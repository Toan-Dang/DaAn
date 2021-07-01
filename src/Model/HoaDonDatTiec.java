package Model;

public class HoaDonDatTiec {
	private int maNV;
	private int maKH;
	private String ngayLapHDDT;
	private String tongTienDT;
	private String ghiChu;
	private String ngayThanhToan;
	private String tinhTrangThanhToan;
	
	public HoaDonDatTiec(int maNV, int maKH, String ngayLapHDDT, String tongTienDT, String ghiChu,
			String ngayThanhToan, String tinhTrangThanhToan) {
		super();
		this.maNV = maNV;
		this.maKH = maKH;
		this.ngayLapHDDT = ngayLapHDDT;
		this.tongTienDT = tongTienDT;
		this.ghiChu = ghiChu;
		this.ngayThanhToan = ngayThanhToan;
		this.tinhTrangThanhToan = tinhTrangThanhToan;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getNgayLapHDDT() {
		return ngayLapHDDT;
	}

	public void setNgayLapHDDT(String ngayLapHDDT) {
		this.ngayLapHDDT = ngayLapHDDT;
	}

	public String getTongTienDT() {
		return tongTienDT;
	}

	public void setTongTienDT(String tongTienDT) {
		this.tongTienDT = tongTienDT;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public String getTinhTrangThanhToan() {
		return tinhTrangThanhToan;
	}

	public void setTinhTrangThanhToan(String tinhTrangThanhToan) {
		this.tinhTrangThanhToan = tinhTrangThanhToan;
	}
	
	

}

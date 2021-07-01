package Model;

public class PhieuDichVu {
	private int maPDV;
	private int maPTP;
	private String ngayLapPDV;
	private String tongTienDV;
	private String ghiChu;
	private int maPhong;
	public PhieuDichVu(int maPDV, int maPTP, String ngayLapPDV, String tongTienDV, String ghiChu, int maPhong) {
		super();
		this.maPDV = maPDV;
		this.maPTP = maPTP;
		this.ngayLapPDV = ngayLapPDV;
		this.tongTienDV = tongTienDV;
		this.ghiChu = ghiChu;
		this.maPhong = maPhong;
	}
	public int getMaPDV() {
		return maPDV;
	}
	public void setMaPDV(int maPDV) {
		this.maPDV = maPDV;
	}
	public int getMaPTP() {
		return maPTP;
	}
	public void setMaPTP(int maPTP) {
		this.maPTP = maPTP;
	}
	public String getNgayLapPDV() {
		return ngayLapPDV;
	}
	public void setNgayLapPDV(String ngayLapPDV) {
		this.ngayLapPDV = ngayLapPDV;
	}
	public String getTongTienDV() {
		return tongTienDV;
	}
	public void setTongTienDV(String tongTienDV) {
		this.tongTienDV = tongTienDV;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}
	
	

}

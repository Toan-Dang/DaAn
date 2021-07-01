package Model;

public class ChiTietKhuyenMai {
	private String maLKH;
	private String maKM;
	private int soLuong;
	public ChiTietKhuyenMai(String maLKH, String maKM, int soLuong) {
		super();
		this.maLKH = maLKH;
		this.maKM = maKM;
		this.soLuong = soLuong;
	}
	public String getMaLKH() {
		return maLKH;
	}
	public void setMaLKH(String maLKH) {
		this.maLKH = maLKH;
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
}

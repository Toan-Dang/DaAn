package Model;

public class ThietHai {
	private int maPT;
	private int maThietHai;
	private int soLuong;
	private String ghiChu;
	public ThietHai(int maPT, int maThietHai, int soLuong, String ghiChu) {
		super();
		this.maPT = maPT;
		this.maThietHai = maThietHai;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
	}
	public int getMaPT() {
		return maPT;
	}
	public void setMaPT(int maPT) {
		this.maPT = maPT;
	}
	public int getMaThietHai() {
		return maThietHai;
	}
	public void setMaThietHai(int maThietHai) {
		this.maThietHai = maThietHai;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}

package Model;

public class DSDatTiec {
	private int maHDDT;
	private int maMonAn;
	private int soLuong;
	private String ghiChu;
	private String tienThem;
	public DSDatTiec(int maHDDT, int maMonAn, int soLuong, String ghiChu, String tienThem) {
		super();
		this.maHDDT = maHDDT;
		this.maMonAn = maMonAn;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
		this.tienThem = tienThem;
	}
	public int getMaHDDT() {
		return maHDDT;
	}
	public void setMaHDDT(int maHDDT) {
		this.maHDDT = maHDDT;
	}
	public int getMaMonAn() {
		return maMonAn;
	}
	public void setMaMonAn(int maMonAn) {
		this.maMonAn = maMonAn;
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
	public String getTienThem() {
		return tienThem;
	}
	public void setTienThem(String tienThem) {
		this.tienThem = tienThem;
	}
	
	
}

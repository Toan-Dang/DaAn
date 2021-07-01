package Model;

public class MonAnDatTiec {
	private String tenSP;
	private String chiTiet;
	private int gia;
	public MonAnDatTiec(String tenSP, String chiTiet, int gia) {
		super();
		this.tenSP = tenSP;
		this.chiTiet = chiTiet;
		this.gia = gia;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getChiTiet() {
		return chiTiet;
	}
	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	
	
}

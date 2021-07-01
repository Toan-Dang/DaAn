package Model;

public class QuyDinh {
	private int maQD;
	private String tenQD;
	private String ghiChu;
	public QuyDinh(int maQD, String tenQD, String ghiChu) {
		super();
		this.maQD = maQD;
		this.tenQD = tenQD;
		this.ghiChu = ghiChu;
	}
	public int getMaQD() {
		return maQD;
	}
	public void setMaQD(int maQD) {
		this.maQD = maQD;
	}
	public String getTenQD() {
		return tenQD;
	}
	public void setTenQD(String tenQD) {
		this.tenQD = tenQD;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	} 
	
	
}

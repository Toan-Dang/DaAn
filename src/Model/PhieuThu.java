package Model;

public class PhieuThu {
	private int maPTP;
	private String ngayLapPT;
	private int tongTienPT;
	public PhieuThu(int maPTP, String ngayLapPT, int tongTienPT) {
		super();
		this.maPTP = maPTP;
		this.ngayLapPT = ngayLapPT;
		this.tongTienPT = tongTienPT;
	}
	public int getMaPTP() {
		return maPTP;
	}
	public void setMaPTP(int maPTP) {
		this.maPTP = maPTP;
	}
	public String getNgayLapPT() {
		return ngayLapPT;
	}
	public void setNgayLapPT(String ngayLapPT) {
		this.ngayLapPT = ngayLapPT;
	}
	public int getTongTienPT() {
		return tongTienPT;
	}
	public void setTongTienPT(int tongTienPT) {
		this.tongTienPT = tongTienPT;
	}
	
	

}

package Model;

public class LoaiPhong {
	private int maLoaiPhong;
	private String tenLoaiPhong;
	private double gia;
	private int soLuongToiDa;
	
	
	public LoaiPhong(int maLoaiPhong, String tenLoaiPhong, double giaPhong, int soLuongToiDa) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.gia = giaPhong;
		this.soLuongToiDa = soLuongToiDa;
	}
	
	public LoaiPhong() {}
	public int getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(int maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public double getGiaPhong() {
		return gia;
	}
	public void setGiaPhong(double giaPhong) {
		this.gia = giaPhong;
	}
	public int getSoLuongToiDa() {
		return soLuongToiDa;
	}
	public void setSoLuongToiDa(int soLuongToiDa) {
		this.soLuongToiDa = soLuongToiDa;
	}
}

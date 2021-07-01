package Model;

public class XuatDanhSachPhong_ {
	 private int maPhong;
	 private  String loaiPhong;
	 private  String tinhTrang;
	 private  double gia;
	 private  int soLuongToiDa;
	 
	 public XuatDanhSachPhong_() {}
	 public XuatDanhSachPhong_(int maPhong, String loaiPhong, String tinhTrang, double gia, int soLuongToiDa) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.tinhTrang = tinhTrang;
		this.gia = gia;
		this.soLuongToiDa = soLuongToiDa;
	}
	public int getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getSoLuongToiDa() {
		return soLuongToiDa;
	}
	public void setSoLuongToiDa(int soLuongToiDa) {
		this.soLuongToiDa = soLuongToiDa;
	}
	 
	 
}

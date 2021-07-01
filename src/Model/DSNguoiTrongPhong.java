package Model;

public class DSNguoiTrongPhong {
	private String tenKH;
	private String gioiTinh;
	private String SDT;
	private String ngaySinh;
	private String loaiKhachHang;
	private String CMND;
	private String diaChi;
	private String email;
	public DSNguoiTrongPhong(String tenKH, String gioiTinh, String sDT, String ngaySinh, String loaiKhachHang,
			String cMND, String diaChi, String email) {
		super();
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		SDT = sDT;
		this.ngaySinh = ngaySinh;
		this.loaiKhachHang = loaiKhachHang;
		CMND = cMND;
		this.diaChi = diaChi;
		this.email = email;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getLoaiKhachHang() {
		return loaiKhachHang;
	}
	public void setLoaiKhachHang(String loaiKhachHang) {
		this.loaiKhachHang = loaiKhachHang;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

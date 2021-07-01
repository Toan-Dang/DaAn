package Data;

import java.awt.GraphicsConfiguration;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import View.TongQuan.TongQuan_ThongTinPhong_DatPhong;
import View.TongQuan.TongQuan_ThongTinPhong_ThemDichVu;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Model.DangKiTruoc;
import Model.DichVu;
import Model.KhachHang;
import Model.LoaiPhong;
import Model.NguoiDung;
import Model.Phong;
import Model.XuatDanhSachPhong_;
import Model.*;


public class CoSoDuLieu {
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "123");
		return con;
	}

	public CoSoDuLieu() {
	}

	public static int checkTK(String a, String b) throws ClassNotFoundException, SQLException {
		Connection con = CoSoDuLieu.getConnect();
		CallableStatement stmt = con.prepareCall("{?= call Check_DangNhap(?,?)}");

		stmt.setString(2, a);
		stmt.setString(3, b);

		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.execute();

		return stmt.getInt(1);
	}

	public static List<DangKiTruoc> getDanhSachLichHen() throws ClassNotFoundException, SQLException {
		try {
			List<DangKiTruoc> list = new ArrayList<DangKiTruoc>();
			Connection con = CoSoDuLieu.getConnect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DangKiTruoc");
			while (rs.next()) {
				DangKiTruoc dkt;
				dkt = new DangKiTruoc();
				dkt.setMaKH(rs.getInt("MaKH"));
				dkt.setMaPhong(rs.getInt("MaPhong"));
				dkt.setNgayDK(rs.getDate("NgayDK"));
				dkt.setNgayNhanPhong(rs.getDate("NgayNhanPhong"));
				dkt.setNgayTraPhong(rs.getDate("NgayTraPhong"));
				list.add(dkt);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static List<LoaiPhong> getDanhSachLoaiPhong() throws ClassNotFoundException, SQLException {
		try {
			List<LoaiPhong> list = new ArrayList<LoaiPhong>();
			Connection con = CoSoDuLieu.getConnect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LoaiPhong");
			while (rs.next()) {
				LoaiPhong dkt;
				dkt = new LoaiPhong();
				dkt.setMaLoaiPhong(rs.getInt("MaLoaiPhong"));
				dkt.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
				dkt.setSoLuongToiDa(rs.getInt("SoLuongToiDa"));
				dkt.setGiaPhong(rs.getDouble("Gia"));
				list.add(dkt);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static List<XuatDanhSachPhong_> getDanhSachPhong() throws ClassNotFoundException, SQLException {
		try {
			List<XuatDanhSachPhong_> list = new ArrayList<XuatDanhSachPhong_>();
			Connection con = CoSoDuLieu.getConnect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Phong.MaPhong, LoaiPhong.TENLOAIPHONG, Phong.TinhTrang, Gia, LoaiPhong.SoLuongToiDa \r\n"
					+ "FROM Phong INNER JOIN LoaiPhong on Phong.MaloaiPhong = LoaiPhong.MaLoaiPhong ");
			while (rs.next()) {
				XuatDanhSachPhong_ dkt;
				dkt = new XuatDanhSachPhong_();
				dkt.setMaPhong(rs.getInt("MaPhong"));
				dkt.setLoaiPhong(rs.getString("tenLoaiPhong"));
				if (rs.getInt("TinhTrang") == 0)
					dkt.setTinhTrang("Trống");
				else if (rs.getInt("TinhTrang") == 1)
					dkt.setTinhTrang("Đang ở");
				else if (rs.getInt("TinhTrang") == 2)
					dkt.setTinhTrang("Đang chờ");
				dkt.setGia(rs.getDouble("Gia"));
				dkt.setSoLuongToiDa(rs.getInt("Soluongtoida"));
				list.add(dkt);
			}
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}


	public static boolean ThemNguoiDung(NguoiDung u) throws ClassNotFoundException, SQLException {
		if (u != null) {
			String SQLinssert = "INSERT INTO NguoiDung (USERNAME,PASSWORD) " + "VALUES (?,?)";
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pstm = con.prepareStatement(SQLinssert);
			pstm.setString(1, u.getUserName());
			pstm.setString(2, u.getPassword());
			pstm.execute();
			con.close();
			return true;
		} else {
			return false;
		}
	}


	public static ArrayList<Phong> listphong() throws ClassNotFoundException, SQLException {
		ArrayList<Phong> listphong = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "SELECT MAPHONG,TENLOAIPHONG,SOLUONGNGUOI_HIENTAI,TINHTRANG FROM PHONG P inner join LOAIPHONG L on P.MALOAIPHONG = L.MALOAIPHONG ORDER BY MAPHONG";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int maphong = rs.getInt(1);
				String maloaiphong = rs.getString(2);
				int soluong = rs.getInt(3);
				String tinh_trang = rs.getString(4);

				if (tinh_trang != null) {
					if (tinh_trang.equals("0")) tinh_trang = "trống";
					if (tinh_trang.equals("1")) tinh_trang = "đã có người";
					if (tinh_trang.equals("2")) tinh_trang = "đã được đặt";
				} else tinh_trang = "trống";
				listphong.add(new Phong(maphong, maloaiphong, soluong, tinh_trang));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listphong;
	}

	public static ArrayList<Phong> listphongfull() throws ClassNotFoundException, SQLException {
		ArrayList<Phong> listphongfull = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "SELECT MAPHONG,TENLOAIPHONG,SOLUONGNGUOI_HIENTAI,TINHTRANG, GIA FROM PHONG P inner join LOAIPHONG L on P.MALOAIPHONG = L.MALOAIPHONG ORDER BY MAPHONG";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int maphong = rs.getInt(1);
				String maloaiphong = rs.getString(2);
				int soluong = rs.getInt(3);
				String tinh_trang = rs.getString(4);
				double gia = rs.getDouble(5);
				if (tinh_trang != null) {
					if (tinh_trang.equals("0")) tinh_trang = "trống";
					if (tinh_trang.equals("1")) tinh_trang = "đã có người";
					if (tinh_trang.equals("2")) tinh_trang = "đã được đặt";
				} else tinh_trang = "trống";
				listphongfull.add(new Phong(maphong, maloaiphong, soluong, tinh_trang, gia));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listphongfull;
	}

	public static ArrayList<KhuyenMai> listkhuyenmai() throws ClassNotFoundException, SQLException {
		ArrayList<KhuyenMai> listkhuyenmai = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "select makm, tenkm, ngaybatdau, NGAYKETTHUC from khuyenmai";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int makm = rs.getInt(1);
				String tenkm = rs.getString(2);
				Date nbd = rs.getDate(3);
				Date nkt = rs.getDate(4);
				listkhuyenmai.add(new KhuyenMai(makm,tenkm,nbd,nkt));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listkhuyenmai;
	}


	public static ArrayList<LoaiPhong> listloaiphong() throws ClassNotFoundException, SQLException {
		ArrayList<LoaiPhong> listloaiphong = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "SELECT MALOAIPHONG,TENLOAIPHONG,GIA, SOLUONGTOIDA FROM LOAIPHONG";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int malp = rs.getInt(1);
				String tenlp = rs.getString(2);
				double gia = rs.getDouble(3);
				int sl = rs.getInt(4);

				listloaiphong.add(new LoaiPhong(malp, tenlp, gia, sl));

			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listloaiphong;
	}

	public static ArrayList<DangKiTruoc> listdattruoc(int ID) throws ClassNotFoundException, SQLException {
		ArrayList<DangKiTruoc> list = new ArrayList<>();
		String querry = "SELECT MAPHONG, MAKH, NGAYDK, NGAYNHANPHONG, NGAYTRAPHONG from DANGKITRUOC WHERE MAPHONG = " + ID;
		Connection con = CoSoDuLieu.getConnect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(querry);
			while (rs.next()) {
				int maphong = rs.getInt(1);
				int makh = rs.getInt(2);
				java.util.Date ngdk = rs.getDate(3);
				java.util.Date nnp = rs.getDate(4);
				Date ntp = rs.getDate(5);

				list.add(new DangKiTruoc(maphong, makh, ngdk, nnp, ntp));
			}
			con.close();
		} catch (SQLException throwables) {

			throwables.printStackTrace();
		}


		return list;
	}

	public static boolean isDatPhong(int ID) throws ClassNotFoundException, SQLException {
		Connection connection = CoSoDuLieu.getConnect();
		String query = "SELECT TINHTRANG FROM PHONG WHERE MAPHONG = " + ID;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int tinhtrang = rs.getInt(1);
				if (tinhtrang != 0) {
					connection.close();
					return true;
				}
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return false;
	}

	public static void XoaPhong(int r) throws ClassNotFoundException {
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "DELETE FROM PHONG WHERE MAPHONG = " + r;
			PreparedStatement pt = con.prepareStatement(query);
			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Delete Success!!");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			JOptionPane.showMessageDialog(null, "Delete NOT Success!!");

		}
	}
	public static void XoaKhuyenMai(int r) throws ClassNotFoundException {
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "DELETE FROM KHUYENMAI WHERE MAKM = " + r;
			PreparedStatement pt = con.prepareStatement(query);
			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Delete Success!!");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			JOptionPane.showMessageDialog(null, "Delete NOT Success!!");

		}
	}

	public static void getLoaiPhonglist(JComboBox<String> list) throws ClassNotFoundException {
		String query = "SELECT TENLOAIPHONG FROM LOAIPHONG";
		try {

			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("TENLOAIPHONG");

				list.addItem(name);

			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static void getlistQuanLy(JComboBox<String> list) throws ClassNotFoundException {
		String query = "select hotennv from nhanvien where manv in (select Nguoiquanly from nhanvien )";
		try {

			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("hotennv");

				list.addItem(name);

			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static void getDichVuList(JComboBox<String> list) throws ClassNotFoundException {
		String query = "SELECT TENDICHVU FROM DICHVU";
		try {

			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("TENDICHVU");

				list.addItem(name);

			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static int getMaPhongID(int id) throws ClassNotFoundException {
		int maphong = 0;
		String query = "SELECT MAPHONG FROM PHONG WHERE MAPHONG = " + id;
		try {

			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				maphong = rs.getInt("MAPHONG");
			}
			con.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return maphong;
	}

	public static int getMaPhongrow(int r) throws ClassNotFoundException {
		int maphong = 0;
		String query = "SELECT MAPHONG FROM PHONG WHERE ROWNUM <=" + r + " MINUS SELECT MAPHONG FROM PHONG WHERE ROWNUM <" + r;
		try {

			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				maphong = rs.getInt("MAPHONG");
			}
			con.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return maphong;
	}

	public static int getMaKhuyenMairow(int r) throws ClassNotFoundException {
		int maphong = 0;
		String query = "SELECT MAKM FROM KHUYENMAI WHERE ROWNUM <=" + r + " MINUS SELECT MAKM FROM KHUYENMAI WHERE ROWNUM <" + r;
		try {

			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				maphong = rs.getInt("MAKM");
			}
			con.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return maphong;
	}


	public static void InsertPhong(String ghichu, JComboBox<String> list) throws ClassNotFoundException {
		try {
			String query = "INSERT INTO PHONG(MALOAIPHONG,GHICHU) VALUES(?,?)";

			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);
			int MaLoaiPhong = 0;
			String loaiphong = Objects.requireNonNull(list.getSelectedItem()).toString();
			if (loaiphong.equals("PHONG TONG THONG ")) MaLoaiPhong = 1;
			if (loaiphong.equals("PHONG DAC BIET")) MaLoaiPhong = 2;
			if (loaiphong.equals("PHONG LOAI 1")) MaLoaiPhong = 3;
			if (loaiphong.equals("PHONG LOAI 2")) MaLoaiPhong = 4;
			if (loaiphong.equals("PHONG LOAI 3")) MaLoaiPhong = 5;
			if (loaiphong.equals("PHONG CACH LI")) MaLoaiPhong = 6;

			pt.setInt(1, MaLoaiPhong);
			pt.setString(2, ghichu);
			pt.execute();

			con.close();
			JOptionPane.showMessageDialog(null, "Success Insert");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static void UpdatePhong(int maphong, String ghichu, JComboBox<String> list) throws ClassNotFoundException {
		String query = "BEGIN UPDATE_ROOM ( ? , ? , ? );END;";
		try {
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);
			int MaLoaiPhong = 0;
			String loaiphong = Objects.requireNonNull(list.getSelectedItem()).toString();
			if (loaiphong.equals("PHONG TONG THONG ")) MaLoaiPhong = 1;
			if (loaiphong.equals("PHONG DAC BIET")) MaLoaiPhong = 2;
			if (loaiphong.equals("PHONG LOAI 1")) MaLoaiPhong = 3;
			if (loaiphong.equals("PHONG LOAI 2")) MaLoaiPhong = 4;
			if (loaiphong.equals("PHONG LOAI 3")) MaLoaiPhong = 5;
			if (loaiphong.equals("PHONG CACH LI")) MaLoaiPhong = 6;

			pt.setInt(1, maphong);
			pt.setInt(2, MaLoaiPhong);
			pt.setString(3, ghichu);

			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Success UPDATE");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}


	public static ArrayList<DangKiTruoc> getlistdattruoc(int ID) throws ClassNotFoundException, SQLException {
		ArrayList<DangKiTruoc> list = new ArrayList<>();
		String querry = "SELECT MAPHONG, MAKH, NGAYDK, NGAYNHANPHONG, NGAYTRAPHONG from DANGKITRUOC WHERE MAPHONG = " + ID;
		Connection con = CoSoDuLieu.getConnect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(querry);
			while (rs.next()) {
				int maphong = rs.getInt(1);
				int makh = rs.getInt(2);
				java.util.Date ngdk = rs.getDate(3);
				java.util.Date nnp = rs.getDate(4);
				Date ntp = rs.getDate(5);

				list.add(new DangKiTruoc(maphong, makh, ngdk, nnp, ntp));
			}
			con.close();
		} catch (SQLException throwables) {

			throwables.printStackTrace();
		}


		return list;
	}


	public static ArrayList<DichVu> listdv() throws ClassNotFoundException, SQLException {
		ArrayList<DichVu> listdv = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "SELECT MADV,TENDICHVU, CHITIET ,GIA FROM DICHVU order by madv";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int madv = rs.getInt(1);
				String tendv = rs.getString(2);
				String chitiet = rs.getString(3);
				double gia = rs.getDouble(4);

				listdv.add(new DichVu(madv, tendv, chitiet, gia));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listdv;
	}

	public static void InsertDichVu(String tendv, String chitiet, String giaz) throws ClassNotFoundException {
		String query = "INSERT INTO DICHVU(TENDICHVU, CHITIET, GIA) VALUES ( ? , ? , ? )";
		try {
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);

			pt.setString(1, tendv);
			pt.setString(2, chitiet);
			int gia = Integer.parseInt(giaz);
			pt.setInt(3, gia);

			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Success Insert");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static void XoaDichVu(int r) throws ClassNotFoundException {
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "DELETE FROM DICHVU WHERE MADV = (SELECT MADV FROM DICHVU WHERE ROWNUM <=" + r + " MINUS SELECT MADV FROM DICHVU WHERE ROWNUM <" + r + " )";
			PreparedStatement pt = con.prepareStatement(query);
			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Delete Success!!");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			JOptionPane.showMessageDialog(null, "Delete NOT Success!!");

		}
	}

	public static void UpdateDichVu(int ID, String tendv, String ghichu, String giaz) throws ClassNotFoundException {
		String query = "BEGIN UPDATE_SERVICES ( ? , ? , ? , ? );END;";
		try {
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);
			pt.setInt(1, ID);
			pt.setString(2, tendv);
			pt.setString(3, ghichu);
			double gia = Double.parseDouble(giaz);
			pt.setDouble(4, gia);

			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Success UPDATE");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static int searchDichVu(int r) throws ClassNotFoundException {
		int getdv = 0;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT MADV FROM DICHVU WHERE rownum <=" + r + " MINUS SELECT MADV FROM DICHVU WHERE rownum <" + r;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				getdv = rs.getInt("MADV");
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return getdv;
	}

	public static String getTenDichVuID(int ID) throws ClassNotFoundException {
		String madv = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT TENDICHVU FROM DICHVU WHERE MADV = " + ID;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				madv = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return madv;
	}

	public static double getGiaDichVuID(int ID) throws ClassNotFoundException {
		double madv = 0;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT GIA FROM DICHVU WHERE MADV = " + ID;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				madv = rs.getDouble(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return madv;
	}

	public static String getChiTietDichVuID(int ID) throws ClassNotFoundException {
		String madv = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT CHITIET FROM DICHVU WHERE MADV = " + ID;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				madv = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return madv;
	}

	public static int Check(String cmnd) throws ClassNotFoundException {
		String query = "SELECT CHECK_CMND_EXIST( '" + cmnd + "' ) AS RES FROM DUAL";
		int makh = -1;
		try {
			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				makh = rs.getInt(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return makh;
	}

	public static String GetTenKH(int makh) throws ClassNotFoundException {
		String tenkh = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT TENKH FROM KHACHHANG WHERE MAKH = " + makh;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tenkh = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return tenkh;
	}

	public static Date GetNgaySinh(int makh) throws ClassNotFoundException {
		Date ngSinh = null;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT NGAYSINH FROM KHACHHANG WHERE MAKH = " + makh;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ngSinh = rs.getDate(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return ngSinh;
	}

	public static void SetNgaySinh(int makh, UtilDateModel model, Properties p) throws ClassNotFoundException {
		var dt = GetNgaySinh(makh);
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model.setValue(dt);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl pick = new JDatePickerImpl(datePanel, new TongQuan_ThongTinPhong_DatPhong.DateLabelFormatter());

	}

	public static String GetGioiTinh(int makh) throws ClassNotFoundException {
		String gt = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT GIOITINH FROM KHACHHANG WHERE MAKH = " + makh;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				gt = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return gt;
	}

	public static void SetGioiTinh(JRadioButton nam, JRadioButton nu, int makh) throws ClassNotFoundException {
		String gender = GetGioiTinh(makh);
		if (gender.equals("NAM")) {
			nam.setSelected(true);
			nu.setSelected(false);
		} else {
			nu.setSelected(true);
			nam.setSelected(false);
		}
	}

	public static String GetSDT(int makh) throws ClassNotFoundException {
		String sdt = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT SDT FROM KHACHHANG WHERE MAKH = " + makh;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				sdt = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return sdt;
	}

	public static String GetDiaChi(int makh) throws ClassNotFoundException {
		String diachi = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT DIACHI FROM KHACHHANG WHERE MAKH = " + makh;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				diachi = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return diachi;
	}

	public static void GetInfoKH_Makh(int makh, JTextField ten, JTextField diachi, JTextField sdt, JRadioButton nam, JRadioButton nu,
									  UtilDateModel model, Properties p) throws ClassNotFoundException {
		ten.setText(CoSoDuLieu.GetTenKH(makh));
		diachi.setText(CoSoDuLieu.GetDiaChi(makh));
		sdt.setText(CoSoDuLieu.GetSDT(makh));
		CoSoDuLieu.SetGioiTinh(nam, nu, makh);
		CoSoDuLieu.SetNgaySinh(makh, model, p);
	}

	public static void CreateWithAvailabeKH(int maphong, JDatePickerImpl ngaynhanphong, JDatePickerImpl ngaytraphong,
											int makh, int manv) throws ClassNotFoundException {
		String query = "BEGIN INSERT_INTO_PTP_CTPTP( ? , ? , ? , ? , ? ) ; END;";

		java.util.Date datengaynp = (java.util.Date) ngaynhanphong.getModel().getValue();
		java.sql.Date sqldatengaynp = new java.sql.Date(datengaynp.getTime());

		java.util.Date datengaytp = (java.util.Date) ngaytraphong.getModel().getValue();
		java.sql.Date sqldatengaytp = new java.sql.Date(datengaytp.getTime());

		try {
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);

			pt.setInt(1, maphong);
			pt.setDate(2, sqldatengaynp);
			pt.setDate(3, sqldatengaytp);
			pt.setInt(4, makh);
			pt.setInt(5, manv);

			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Success UPDATE");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static void CreateWithNewKH(int maphong, JDatePickerImpl ngaynhanphong, JDatePickerImpl ngaytraphong,
									   int manv, JTextField tenkh, String gioitinh, JDatePickerImpl NGSinh,
									   JTextField SDT, JTextField DiaChi, JTextField CMND) throws ClassNotFoundException {

		java.util.Date datengaysinh = (java.util.Date) NGSinh.getModel().getValue();
		java.sql.Date sqldatengaysinh = new java.sql.Date(datengaysinh.getTime());

		java.util.Date datengaynp = (java.util.Date) ngaynhanphong.getModel().getValue();
		java.sql.Date sqldatengaynp = new java.sql.Date(datengaynp.getTime());

		java.util.Date datengaytp = (java.util.Date) ngaytraphong.getModel().getValue();
		java.sql.Date sqldatengaytp = new java.sql.Date(datengaytp.getTime());


		String query = "BEGIN INSERT_INTO_KH_PTP_CTPTP( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ; END;";
		try {
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);

			pt.setInt(1, maphong);
			pt.setDate(2, sqldatengaynp);
			pt.setDate(3, sqldatengaytp);
			pt.setInt(4, manv);
			pt.setString(5, tenkh.getText());
			pt.setString(6, gioitinh);
			pt.setDate(7, sqldatengaysinh);
			pt.setString(8, SDT.getText());
			pt.setString(9, DiaChi.getText());
			pt.setString(10, CMND.getText());

			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Success UPDATE");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static void InsertChiTietDV(int mapdv, int madv, int maphong, String text) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO CHITIETDV(MAPDV, MADV, NGAYYEUCAU,SOLUONG, MAPHONG) VALUES ( ? , ? , ?, ?,? )";
		try {
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);
			long millis = System.currentTimeMillis();
			Date date = new java.util.Date(millis);
			java.sql.Date dates = new java.sql.Date(date.getTime());

			System.out.println(1);

			pt.setInt(1, mapdv);
			pt.setInt(2, madv);
			pt.setDate(3, dates);
			int sl = Integer.parseInt(text);
			pt.setInt(4, sl);
			pt.setInt(5, maphong);

			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Success Insert");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static int getMaDichVu(String comboBox) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int maDV = -1;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT MaDV FROM DICHVU WHERE DICHVU.TENDICHVU = '" + comboBox + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				maDV = rs.getInt(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return maDV;
	}

	public static String getTenNhanVien(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String ten;
		if (id == -1)
			ten = "Chưa xác định";
		else ten = " cc";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT HOTENNV FROM NHANVIEN WHERE NHANVIEN.MANV = " + id;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ten = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}


		return ten;
	}

	public static int getID(String text) throws ClassNotFoundException {
		// TODO Auto-generated method stub


		int id = -1;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT Manv FROM NHANVIEN WHERE NHANVIEN.username = '" + text + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				id = rs.getInt(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}


		return id;
	}

	public static ArrayList<ThanhToan> listphieu() throws ClassNotFoundException, SQLException {
		ArrayList<ThanhToan> listphieu = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "SELECT MAPTP, TENKH, CMND, SDT,EMAIL ,tinhtrangthanhtoan  FROM KHACHHANG A JOIN PHIEU_THUE_PHONG B ON A.MAKH = B.MAKH WHERE B.TINHTRANGTHANHTOAN = 0 order by MAPTP";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			String tinhtrang = "";
			String LoaiPhieu = "Phiếu thuê phòng";
			while (rs.next()) {
				int maphieu = rs.getInt(1);
				String tenkh = rs.getString(2);
				String cmnd = rs.getString(3);
				String sdt = rs.getString(4);
				String email = rs.getString(5);
				int tt = rs.getInt(6);
				if (tt == 0) tinhtrang = "Chưa thanh toán";
				listphieu.add(new ThanhToan(maphieu, tenkh, cmnd, sdt, email, LoaiPhieu, tinhtrang));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listphieu;
	}

	public static Date getNgayLapPhieu(int mahd) throws ClassNotFoundException {
		Date nlp = null;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "select ngaylapptp  from phieu_thue_phong where maptp = " + mahd;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				nlp = rs.getDate(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return nlp;
	}

	public static String getTienPhong(int mahd) throws ClassNotFoundException {
		String tien = "";
		double ngayo = 0.0;
		double ngaydi = 0.0;
		Date sys = null;
		Date ntp = null;
		int tienphong = 0;
		int ngay = 0;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "select tongtienthanhtoan  from phieu_thue_phong where maptp = " + mahd;
			String query2 = "select sysdate - ngaynhanphong, ngaytraphong - ngaynhanphong, sysdate, ngaytraphong from chitiet_phieuthuephong where maptp = " + mahd;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tien = rs.getString(1);
			}
			Statement st2 = con.createStatement();
			ResultSet rs2 = st2.executeQuery(query2);
			while (rs2.next()) {
				ngayo = rs2.getDouble(1);
				ngaydi = rs2.getDouble(2);
				sys = rs2.getDate(3);
				ntp = rs2.getDate(4);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		assert sys != null;
		if (sys.compareTo(ntp) > 0) {
			ngay = Math.toIntExact(Math.round(ngaydi));
		} else {
			ngay = Math.toIntExact(Math.round(ngayo));
		}
		++ngay;
		tienphong = Integer.parseInt(tien);
		//  ngay = Math.toIntExact(Math.round(ngayo));
		tien = String.valueOf((tienphong * ngay));
		return tien;
	}

	public static String getTienDichVu(int mahd) throws ClassNotFoundException {
		String tien = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "select sum(TONGTIENDV)  from PHIEUDICHVU where maptp = " + mahd;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tien = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return tien;
	}

	public static String getTienPhieuThu(int mahd) throws ClassNotFoundException {
		String tien = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "select sum(TONGTIENPT)  from PhieuThu where maptp = " + mahd;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tien = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return tien;
	}

	public static int getTongTien(int mahd) throws NumberFormatException, ClassNotFoundException {
		int tien = 0;

		getTienPhong(mahd);
		tien += Integer.parseInt(getTienPhong(mahd));
		if (getTienDichVu(mahd) != null) tien += Integer.parseInt(getTienDichVu(mahd));
		if (getTienPhieuThu(mahd) != null) tien += Integer.parseInt(getTienPhieuThu(mahd));
		return tien;
	}

	public static int getMaKM(String tenkm) throws ClassNotFoundException {
		int makm = 0;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "select makm from khuyenmai \n" +
					"where tenkm = '" + tenkm + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				makm = rs.getInt(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return makm;
	}

	public static long getTongTien_KM(long tienz, String makm) throws ClassNotFoundException {
		long tienkm = 0;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "select tienduocgiam from khuyenmai \n" +
					"where tenkm = '" + makm + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tienkm = rs.getInt(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return tienz - (tienkm * tienz) / 100;
	}

	public static ArrayList<ChiTietPhieuThuePhong> listctptp(int mahd) throws ClassNotFoundException, SQLException {
		ArrayList<ChiTietPhieuThuePhong> listctptp = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = " select c.maphong, d.tenloaiphong , b.ngaynhanphong,b.ngaytraphong,d.gia, sysdate - b.ngaynhanphong from phieu_thue_phong a, CHITIET_PHIEUTHUEPHONG b, Phong c, LoaiPhong d \n" +
				" where a.maptp = " + mahd + " and b.maptp =a.maptp and c.maphong = b.maphong and c.maloaiphong = d.maloaiphong";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int maphong = rs.getInt(1);
				String tenlp = rs.getString(2);
				Date nnp = rs.getDate(3);
				Date ntp = rs.getDate(4);
				double gia = rs.getDouble(5);
				int sys = rs.getInt(6);
				++sys;
				double tien = sys * gia;
				listctptp.add(new ChiTietPhieuThuePhong(maphong, tenlp, nnp, ntp, tien, gia));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listctptp;
	}

	public static ArrayList<ChiTietDichVu> listctdv(int mahd) throws ClassNotFoundException, SQLException {
		ArrayList<ChiTietDichVu> listctdv = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "select tendichvu, gia, soluong, gia*soluong from PHIEUDICHVU a, DICHVU b, CHITIETDV c where a.maptp = " +
				mahd + " and c.MAPDV = a.MAPDV and c.MADV = b.MADV";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String tendv = rs.getString(1);
				double gia = rs.getDouble(2);
				int sl = rs.getInt(3);
				double tien = rs.getDouble(4);
				listctdv.add(new ChiTietDichVu(tendv, gia, sl, tien));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listctdv;
	}

	public static ArrayList<ChiTietThietHai> listctth(int mahd) throws ClassNotFoundException, SQLException {
		ArrayList<ChiTietThietHai> listctth = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "select TENTHIETBI, gia, soluong, gia*soluong from PHIEUTHU a, THIETHAI b, CHITIET_THIETHAI c where a.maptp = " + mahd + " and c.MAPT = a.MAPT and c.MATHIETHAI = b.MATHIETHAI";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String tendv = rs.getString(1);
				double gia = rs.getDouble(2);
				int sl = rs.getInt(3);
				double tien = rs.getDouble(4);
				listctth.add(new ChiTietThietHai(tendv, gia, sl, tien));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listctth;
	}

	public static void getKhuyenMailist(JComboBox<String> list, int makh) throws ClassNotFoundException {
		String query = "select TENKM from khachhang a, LOAIKH b, CHI_TIET_KHUYENMAI c, KHUYENMAI d \n" +
				"where A.MALKH = B.MALKH \n" +
				"and B.MALKH = C.MALKH\n" +
				"and C.MAKM = D.MAKM\n" +
				"and a.makh = " + makh;
		try {

			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			list.addItem("");
			while (rs.next()) {
				String name = rs.getString("TENKM");
				list.addItem(name);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static void ThanhToan(long tien, int makh, int manv, int mahd, int makm) throws ClassNotFoundException {
		String query = "begin ThanhToan_update( ? , ? , ? , ? , ? );end;";
		try {
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);

			pt.setInt(1, mahd);
			pt.setInt(2, makh);
			pt.setInt(3, manv);
			pt.setLong(4, tien);
			pt.setInt(5, makm);

			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Success ThanhToan");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static ArrayList<NhanVien> listNhanVien() throws ClassNotFoundException, SQLException {
		ArrayList<NhanVien> listNhanVien = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "SELECT MANV,USERNAME, HOTENNV,ChucVu,SDT,CMND FROM NHANVIEN ORDER BY MANV";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int manv = rs.getInt(1);
				String username = rs.getString(2);
				String tenkh = rs.getString(3);
				String lkh = rs.getString(4);
				String sdt = rs.getString(5);
				String cmnd = rs.getString(6);
				try {
					username = (username.trim());
				} catch (NullPointerException ignored) {

				}
				listNhanVien.add(new NhanVien(manv, username, tenkh, lkh, sdt, cmnd));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listNhanVien;
	}

	public static int getMANVrow(int r) throws ClassNotFoundException {
		int maphong = 0;
		String query = "SELECT MANV FROM NHANVIEN WHERE ROWNUM <=" + r + " MINUS SELECT MANV FROM NHANVIEN WHERE ROWNUM <" + r;
		try {
			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				maphong = rs.getInt("MANV");
			}
			con.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return maphong;
	}

	public static void XoaNhanVien(int manv) throws ClassNotFoundException {
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "DELETE FROM NHANVIEN WHERE MANV = " + manv;
			PreparedStatement pt = con.prepareStatement(query);
			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Delete Success!!");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			JOptionPane.showMessageDialog(null, "Delete NOT Success!!");

		}
	}

	public static String GetTenNV(int manv) throws ClassNotFoundException {
		String tenkh = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT HOTENNV FROM NHANVIEN WHERE MANV = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tenkh = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return tenkh;
	}

	public static String GetEmailNV(int manv) throws ClassNotFoundException {
		String tenkh = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT EMAIL FROM NHANVIEN WHERE MANV = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tenkh = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return tenkh;
	}

	public static String GetCMNDNV(int manv) throws ClassNotFoundException {
		String tenkh = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT CMND FROM NHANVIEN WHERE MANV = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tenkh = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return tenkh;
	}

	public static String GetNGQLYNV(int manv) throws ClassNotFoundException {
		String tenkh = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT NGUOIQUANLY FROM NHANVIEN WHERE MANV = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tenkh = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return tenkh;
	}

	public static Date GetNGVLNV(int manv) throws ClassNotFoundException {
		Date tenkh = null;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT NGAYVAOLAM FROM NHANVIEN WHERE MANV = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tenkh = rs.getDate(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return tenkh;
	}

	public static Date GetNgaySinhNV(int manv) throws ClassNotFoundException {
		Date ngSinh = null;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT NGAYSINH FROM NHANVIEN WHERE MANV = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ngSinh = rs.getDate(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return ngSinh;
	}

	public static void SetNgaySinhNV(int manv, UtilDateModel model, Properties p) throws ClassNotFoundException {
		var dt = GetNgaySinhNV(manv);
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model.setValue(dt);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl pick = new JDatePickerImpl(datePanel, new TongQuan_ThongTinPhong_DatPhong.DateLabelFormatter());

	}

	public static void SetNgayVaoLamNV(int manv, UtilDateModel model, Properties p) throws ClassNotFoundException {
		var dt = GetNGVLNV(manv);
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		model.setValue(dt);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl pick = new JDatePickerImpl(datePanel, new TongQuan_ThongTinPhong_DatPhong.DateLabelFormatter());

	}

	public static String GetGioiTinhNV(int manv) throws ClassNotFoundException {
		String gt = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT GIOITINH FROM NHANVIEN WHERE MANV = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				gt = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return gt;
	}

	public static void SetGioiTinhNV(JRadioButton nam, JRadioButton nu, int manv) throws ClassNotFoundException {
		String gender = GetGioiTinhNV(manv);
		if (gender.equals("NAM")) {
			nam.setSelected(true);
			nu.setSelected(false);
		} else {
			nu.setSelected(true);
			nam.setSelected(false);
		}
	}

	public static String GetSDTNV(int manv) throws ClassNotFoundException {
		String sdt = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT SDT FROM NHANVIEN WHERE MANV = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				sdt = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return sdt;
	}

	public static String GetDiaChiNV(int manv) throws ClassNotFoundException {
		String diachi = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT DIACHI FROM NHANVIEN WHERE MANV = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				diachi = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return diachi;
	}

	public static String GetUsernameNV(int manv) throws ClassNotFoundException {
		String diachi = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "select b.username from nhanvien a, nguoidung b where a.username = b.username and a.manv = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				diachi = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return diachi;
	}

	public static String GetPassNV(int manv) throws ClassNotFoundException {
		String diachi = "";
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "select password from nhanvien a, nguoidung b where a.username = b.username and a.manv = " + manv;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				diachi = rs.getString(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return diachi;
	}

	public static void GetInfoNV(int manv, JTextField ten, JTextField diachi, JTextField sdt, JRadioButton nam, JRadioButton nu,
								 UtilDateModel model, Properties p, JTextField ngql, JTextField cmnd,
								 JTextField email, UtilDateModel modelvl, Properties pvl) throws ClassNotFoundException {
		ten.setText(CoSoDuLieu.GetTenNV(manv));
		diachi.setText(CoSoDuLieu.GetDiaChiNV(manv));
		sdt.setText(CoSoDuLieu.GetSDTNV(manv));
		ngql.setText(CoSoDuLieu.GetNGQLYNV(manv));
		cmnd.setText(CoSoDuLieu.GetCMNDNV(manv));
		email.setText(CoSoDuLieu.GetEmailNV(manv));
		CoSoDuLieu.SetGioiTinhNV(nam, nu, manv);
		CoSoDuLieu.SetNgaySinhNV(manv, model, p);
		CoSoDuLieu.SetNgayVaoLamNV(manv, modelvl, pvl);
	}

	public static void UpdateNhanVien(int manv, JTextField ngql, JTextField email,
									  JTextField tennv, String gioitinh, JDatePickerImpl NGSinh, JDatePickerImpl NgVL
			, JTextField SDT, JTextField DiaChi, JTextField CMND) throws ClassNotFoundException {

		java.util.Date datengaysinh = (java.util.Date) NGSinh.getModel().getValue();
		java.sql.Date sqldatengaysinh = new java.sql.Date(datengaysinh.getTime());

		java.util.Date datengayvl = (java.util.Date) NgVL.getModel().getValue();
		java.sql.Date sqldatengayvl = new java.sql.Date(datengayvl.getTime());

		String query = "insert into nhanvien(manv,hotennv,ngaysinh,gioitinh,diachi,sdt,cmnd,email,nguoiquanly,ngayvaolam) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		try {
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);
			pt.setInt(1, manv);
			pt.setString(2, tennv.getText());
			pt.setDate(3, sqldatengaysinh);
			pt.setString(4, gioitinh);
			pt.setString(5, DiaChi.getText());
			pt.setString(6, SDT.getText());
			pt.setString(7, CMND.getText());
			pt.setString(8, email.getText());
			pt.setString(9, ngql.getText());
			pt.setDate(10, sqldatengayvl);

			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Success UPDATE");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static int getNguoiQuanLy(JComboBox<String> list) throws ClassNotFoundException {
		int manv = 0;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String ngql = Objects.requireNonNull(list.getSelectedItem()).toString();
			String query = "select manv from nhanvien where hotennv = '" + ngql + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				manv = rs.getInt(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return manv;
	}

	public static int CreateMaNV() throws ClassNotFoundException {
		int manv = 0;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = " SELECT MANV  FROM ( SELECT MANV FROM NHANVIEN ORDER BY MANV DESC ) WHERE ROWNUM = 1";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				manv = rs.getInt(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return ++manv;
	}

	public static ArrayList<KhachHang> listKhachHang() throws ClassNotFoundException, SQLException {
		ArrayList<KhachHang> listkh = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "SELECT  MAKH,USERNAME, TENKH,TENLKH,SDT,CMND FROM KHACHHANG A JOIN LOAIKH B ON A.MALKH = B.MALKH ORDER BY MAKH";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int makh = rs.getInt(1);
				String username = rs.getString(2);
				String tenkh = rs.getString(3);
				String lkh = rs.getString(4);
				String sdt = rs.getString(5);
				String cmnd = rs.getString(6);

				try {
					username = (username.trim());
				} catch (NullPointerException ignored) {

				}


				listkh.add(new KhachHang(makh, username, tenkh, lkh, sdt, cmnd));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listkh;
	}

	public static int getMaKHrow(int r) throws ClassNotFoundException {
		int maphong = 0;
		String query = "SELECT MAKH FROM KHACHHANG WHERE ROWNUM <=" + r + " MINUS SELECT MAKH FROM KHACHHANG WHERE ROWNUM <" + r;
		try {
			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				maphong = rs.getInt("MAKH");
			}
			con.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return maphong;
	}

	public static int getMaKh(int maptp) {
		int makh = 0;
		String query = "SELECT MAKH FROM PHIEU_THUE_PHONG WHERE MAPTP = " + maptp;
		try {
			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				makh = rs.getInt("MAKH");
			}
			con.close();

		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();
		}
		return makh;
	}

	public static ArrayList<HoaDon> listHoaDon() throws ClassNotFoundException, SQLException {
		ArrayList<HoaDon> listHoaDon = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		String query = "select MATHANHTOAN, MAKH, MANV, MAPTP, MAPDV, MAPT,MAKM,TONGTIEN, NGAYTHANHTOAN from THANHTOAN ORDER BY MATHANHTOAN";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int maphieu = rs.getInt(1);
				int makh = rs.getInt(2);
				int manv = rs.getInt(3);
				int maptp = rs.getInt(4);
				int mapdv = rs.getInt(5);
				int mapt = rs.getInt(6);
				int makm = rs.getInt(7);
				double tien = rs.getDouble(8);
				Date ngaytt = rs.getDate(9);

				listHoaDon.add(new HoaDon(maphieu, makh, manv, maptp, mapdv, mapt, makm, tien, ngaytt));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listHoaDon;
	}

	public static int getMaPhieuDichVu(int maphong) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int maPDV = -1;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT MaPDV FROM PHIEUDICHVU, PHIEU_THUE_PHONG, CHITIET_PHIEUTHUEPHONG "
					+ " WHERE PHIEUDICHVU.MAPTP = PHIEU_THUE_PHONG.MAPTP"
					+ " AND CHITIET_PHIEUTHUEPHONG.MAPHONG = " + maphong
					+ " AND PHIEU_THUE_PHONG.MAPTP = CHITIET_PHIEUTHUEPHONG.MAPTP"
					+ " AND PHIEU_THUE_PHONG.TINHTRANGTHANHTOAN = 0";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				maPDV = rs.getInt(1);
			}
			con.close();
			if (maPDV == -1) {
				System.out.print("1");
				con = CoSoDuLieu.getConnect();
				long millis = System.currentTimeMillis();
				Date date = new java.util.Date(millis);
				java.sql.Date dates = new java.sql.Date(date.getTime());
				String q = "SELECT MAPDV"
						+ " FROM PHIEUDICHVU"
						+ " WHERE ROWNUM =1"
						+ " ORDER BY MAPDV DESC";
				st = con.createStatement();
				rs = st.executeQuery(q);

				while (rs.next()) {
					maPDV = rs.getInt(1) + 1;
				}
				con.close();

				con = CoSoDuLieu.getConnect();
				String query2 = "insert into PhieuDichVu (MaPTP,NgayLapPDV,GhiChu, MaPDV) values (?,?,?,?)";
				PreparedStatement pt2 = con.prepareStatement(query2);
				pt2.setInt(1, getMaPTP(maphong));
				pt2.setDate(2, (java.sql.Date) dates);
				pt2.setString(3, "");
				pt2.setInt(4, maPDV);
				pt2.execute();
				System.out.print(maPDV);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return maPDV;
	}

	public static int getMaPTP(int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int maPTP = -1;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT CHITIET_PHIEUTHUEPHONG.MaPTP FROM CHITIET_PHIEUTHUEPHONG, PHIEU_THUE_PHONG"
					+ " WHERE CHITIET_PHIEUTHUEPHONG.MAPTP = PHIEU_THUE_PHONG.MAPTP"
					+ " AND CHITIET_PHIEUTHUEPHONG.MAPHONG = " + id
					+ " AND PHIEU_THUE_PHONG.TINHTRANGTHANHTOAN = 0";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				maPTP = rs.getInt(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return maPTP;
	}

	public static void getthiethaiList(JComboBox<String> comboBox) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String query = "SELECT tenthietbi FROM thiethai";
		try {

			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("tenthietbi");

				comboBox.addItem(name);

			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static int getMaPhieuThu(int maPTP) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int maPDV = -1;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT MaPt FROM  PHIEU_THUE_PHONG, PHIEUTHU "
					+ " WHERE PHIEUtHU.MAPTP = " + maPTP
					+ " AND PHIEU_THUE_PHONG.TINHTRANGTHANHTOAN = 0";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				maPDV = rs.getInt(1);
			}
			con.close();

			if (maPDV == -1) {

				//System.out.print("1");
				con = CoSoDuLieu.getConnect();
				long millis = System.currentTimeMillis();
				Date date = new java.util.Date(millis);
				java.sql.Date dates = new java.sql.Date(date.getTime());
				String q = "SELECT MAPT"
						+ " FROM PHIEUTHU"
						+ " WHERE ROWNUM =1"
						+ " ORDER BY MAPT DESC";
				st = con.createStatement();
				rs = st.executeQuery(q);

				while (rs.next()) {
					maPDV = rs.getInt(1);
				}
				maPDV++;
				con.close();

				con = CoSoDuLieu.getConnect();
				String query2 = "insert into PhieuTHU (MaPTP,NGAYLAPPT, MaPT) values (?,?,?)";
				PreparedStatement pt2 = con.prepareStatement(query2);
				pt2.setInt(1, maPTP);
				pt2.setDate(2, dates);
				pt2.setInt(3, maPDV);
				pt2.execute();
				System.out.print(maPDV);

				con.close();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return maPDV;
	}


	public static int getMaThietHai(String string) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		int mapt = -1;
		try {
			Connection con = CoSoDuLieu.getConnect();
			String query = "SELECT MaTHIETHAI FROM THIETHAI WHERE THIETHAI.TENTHIETBI = '" + string + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				mapt = rs.getInt(1);
			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return mapt;
	}

	public static void InsertChiTietThietHai(int maPhieuThu, int maThietHai, String maphong, String soluong) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO CHITIET_thiethai(MAPT, MATHIETHAI, SOLUONG, MAPHONG) VALUES ( ? , ? , ?, ? )";
		try {
			Connection con = CoSoDuLieu.getConnect();
			PreparedStatement pt = con.prepareStatement(query);
			long millis = System.currentTimeMillis();
			Date date = new java.util.Date(millis);
			java.sql.Date dates = new java.sql.Date(date.getTime());

			pt.setInt(1, maPhieuThu);
			pt.setInt(2, maThietHai);
			int mp = Integer.parseInt(maphong);
			pt.setInt(4, mp);
			int sl = Integer.parseInt(soluong);
			pt.setInt(3, sl);

			pt.execute();
			con.close();
			JOptionPane.showMessageDialog(null, "Success Insert");

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static void getListPhong_PTP(JComboBox comboBoxphong, int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String query = "SELECT MaPhong FROM ChiTiet_PhieuThuePhong where ChiTiet_PhieuThuePhong.mapTp = " + id;
		try {

			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("mapHOng");

				comboBoxphong.addItem(name);

			}
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public static void CreateWithAvailabeKH_multi(List<Integer> maphong, JDatePickerImpl ngaynhanphong, JDatePickerImpl ngaytraphong,
												  int makh, int manv) throws ClassNotFoundException {
		String query = "BEGIN INSERT_INTO_PTP_CTPTP( ? , ? , ? , ? , ? ) ; END;";

		java.util.Date datengaynp = (java.util.Date) ngaynhanphong.getModel().getValue();
		java.sql.Date sqldatengaynp = new java.sql.Date(datengaynp.getTime());

		java.util.Date datengaytp = (java.util.Date) ngaytraphong.getModel().getValue();
		java.sql.Date sqldatengaytp = new java.sql.Date(datengaytp.getTime());


		for (Integer it : maphong) {
			try {
				Connection con = CoSoDuLieu.getConnect();
				PreparedStatement pt = con.prepareStatement(query);
				pt.setInt(1, it);
				pt.setDate(2, sqldatengaynp);
				pt.setDate(3, sqldatengaytp);
				pt.setInt(4, makh);
				pt.setInt(5, manv);
				pt.execute();
				con.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

		JOptionPane.showMessageDialog(null, "Success UPDATE");


	}

	public static int getMaKh_cmnd(JTextField cmnd) {
		int makh = 0;
		String query = "select makh from khachhang where cmnd = " + cmnd.getText();
		try {
			Connection con = CoSoDuLieu.getConnect();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				makh = rs.getInt("MAKH");
			}
			con.close();

		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();
		}
		return makh;
	}

	public static void CreateWithNewKH_multi(List<Integer> maphong, JDatePickerImpl ngaynhanphong, JDatePickerImpl ngaytraphong,
											 int manv, JTextField tenkh, String gioitinh, JDatePickerImpl NGSinh,
											 JTextField SDT, JTextField DiaChi, JTextField CMND) throws ClassNotFoundException {
		///this = CreateWithNewKH + CreateWithAvailabeKH_multi;
		boolean isNewKH = true;
		for (int i = 0; i < maphong.size(); i++) {
			if (isNewKH) {
				CoSoDuLieu.CreateWithNewKH(maphong.get(0), ngaynhanphong, ngaytraphong, manv, tenkh, gioitinh, NGSinh, SDT, DiaChi, CMND);
				maphong.remove(0);
				isNewKH = false;
			} else {
				int makh = CoSoDuLieu.getMaKh_cmnd(CMND);
				CoSoDuLieu.CreateWithAvailabeKH_multi(maphong, ngaynhanphong, ngaytraphong, makh, manv);
			}
		}

		JOptionPane.showMessageDialog(null, "Success UPDATE");
	}

	public static ArrayList<Phong> getDanhSachPhongKhaDung(JDatePickerImpl a, JDatePickerImpl b) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<Phong> listdv = new ArrayList<>();
		Connection connection = CoSoDuLieu.getConnect();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String aa = formatter.format(a.getModel().getValue());
		String bb = formatter.format(b.getModel().getValue());
		String query = "(select phong.maphong, loaiphong.tenloaiphong, loaiphong.gia, loaiphong.soluongtoida, phong.ghichu"
				+ " from phong, loaiphong"
				+ " where phong.MALOAIPHONG = loaiphong.MALOAIPHONG"
				+ " MINUS"
				+ " select phong.maphong, loaiphong.tenloaiphong, loaiphong.gia, loaiphong.soluongtoida, phong.ghichu"
				+ " from phong, loaiphong, DANGKITRUOC"
				+ " where phong.MALOAIPHONG = loaiphong.MALOAIPHONG"
				+ " and DANGKITRUOC.MAPHONG= phong.MAPHONG"
				+ " and ((DANGKITRUOC.NGAYTRAPHONG is null and DANGKITRUOC.NGAYNHANPHONG < TO_DATE('" + aa + "','dd/MM/yyyy'))"
				+ " or (DANGKITRUOC.NGAYNHANPHONG > TO_DATE('" + aa + "','dd/MM/yyyy')  and TO_DATE('" + bb + "','dd/MM/yyyy') > DANGKITRUOC.NGAYNHANPHONG)"
				+ " or (DANGKITRUOC.NGAYNHANPHONG < TO_DATE('" + aa + "','dd/MM/yyyy') and TO_DATE('" + aa + "','dd/MM/yyyy') < DANGKITRUOC.NGAYTRAPHONG)))"
				+ " MINUS "
				+ " (select phong.maphong, loaiphong.tenloaiphong, loaiphong.gia, loaiphong.soluongtoida, phong.ghichu"
				+ " from phong, loaiphong, ChiTiet_PhIEUThuePhong"
				+ " where phong.MALOAIPHONG = loaiphong.MALOAIPHONG"
				+ " and ChiTiet_PhIEUThuePhong.MAPHONG= phong.MAPHONG"
				+ " and ((ChiTiet_PhIEUThuePhong.NGAYTRAPHONG is null and ChiTiet_PhIEUThuePhong.NGAYNHANPHONG < TO_DATE('" + aa + "','dd/MM/yyyy'))"
				+ " or (ChiTiet_PhIEUThuePhong.NGAYNHANPHONG > TO_DATE('" + aa + "','dd/MM/yyyy') and TO_DATE('" + bb + "','dd/MM/yyyy') > ChiTiet_PhIEUThuePhong.NGAYNHANPHONG)"
				+ " or (ChiTiet_PhIEUThuePhong.NGAYNHANPHONG < TO_DATE('" + aa + "','dd/MM/yyyy') and TO_DATE('" + aa + "','dd/MM/yyyy') < ChiTiet_PhIEUThuePhong.NGAYTRAPHONG)))";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int maphong = rs.getInt(1);
				String tenLoaiPhong = rs.getString(2);
				double gia = rs.getDouble(3);
				int SLTD = rs.getInt(4);
				String ghiChu = rs.getString(5);
				listdv.add(new Phong(maphong, tenLoaiPhong, gia, SLTD, ghiChu));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listdv;
	}


	public static  TreeMap<Date, Long> getNgay_DoanhThu() throws ClassNotFoundException, SQLException {
		TreeMap<Date, Long> map = new TreeMap<>();
		try {
			Connection con = CoSoDuLieu.getConnect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select TRUNC(ngaythanhtoan),  sum(tongtien) from thanhtoan group by TRUNC(ngaythanhtoan)");
			while (rs.next()) {
				Date ntt = rs.getDate(1);
				long tt = rs.getLong(2);
				map.put(ntt, tt);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
}





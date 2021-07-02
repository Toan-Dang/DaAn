package View.TongQuan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Data.CoSoDuLieu;
import Model.DangKiTruoc;
import Model.DichVu;
import Model.DichVu2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TongQuan_ThongTinPhong_ThemDichVu extends JFrame implements ActionListener {
	int id;
	int maptp;
	private JPanel contentPane;
	private JTextField textSoLuong;
	private String[] columnNames = {
			"Tên dịch vụ",
			"Gía",
			"Chi tiết",
			"Số lượng",
			"Ngày yêu cầu",
			"Thành tiền"};
	private Object data = new Object [][] {};
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TongQuan_ThongTinPhong_ThemDichVu frame = new TongQuan_ThongTinPhong_ThemDichVu(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TongQuan_ThongTinPhong_ThemDichVu(int id) throws ClassNotFoundException, SQLException {
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(10, 10, 760, 51);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u00EAm d\u1ECBch v\u1EE5");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(288, 10, 138, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(178, 34, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

		JLabel lblNewLabel_1 = new JLabel("M\u00E3 ph\u00F2ng:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 72, 64, 51);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel(String.valueOf(id));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(84, 71, 64, 51);
		contentPane.add(lblNewLabel_1_1);

		JComboBox<String> comboBox = new JComboBox<>();
		CoSoDuLieu.getDichVuList(comboBox);
		comboBox.setBounds(84, 125, 222, 36);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1_2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(406, 117, 64, 51);
		contentPane.add(lblNewLabel_1_2);

		textSoLuong = new JTextField();
		textSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textSoLuong.setBounds(482, 124, 83, 36);
		contentPane.add(textSoLuong);
		textSoLuong.setColumns(10);

		JLabel lblNewLabel_1_3 = new JLabel("D\u1ECBch v\u1EE5:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 117, 64, 51);
		contentPane.add(lblNewLabel_1_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 760, 238);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel( (Object[][]) data, columnNames));

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnThem.setBounds(630, 124, 88, 36);
		contentPane.add(btnThem);

		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.addActionListener(e-> this.dispose());

		btnQuayLai.setBackground(new Color(220, 20, 60));
		btnQuayLai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnQuayLai.setBounds(608, 455, 137, 49);
		contentPane.add(btnQuayLai);

		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSua.setBackground(new Color(0, 191, 255));
		btnSua.setBounds(328, 455, 88, 36);
		btnSua.addActionListener(e->{
			this.dispose();
			try {
				new TongQuan_ThongTinPhong_ThemDichVu_SuaDichVu(id, CoSoDuLieu.getMaDichVu((String) table.getValueAt(table.getSelectedRow(), 0)),(int) table.getValueAt(table.getSelectedRow(), 3));
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(464, 455, 88, 36);
		btnXoa.addActionListener(e->{
			try {
				CoSoDuLieu.XoaChitietDichVu(CoSoDuLieu.getMaPhieuDichVu(id), CoSoDuLieu.getMaDichVu((String)table.getValueAt(table.getSelectedRow(), 0)), id);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
			try {
				new TongQuan_ThongTinPhong_ThemDichVu(id);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		contentPane.add(btnXoa);
		showListDichVuDaDat(listdv(id));

		btnThem.addActionListener(e -> {
			//System.out.print(comboBox.getSelectedItem().toString());
			try {
				try {
					CoSoDuLieu.InsertChiTietDV(CoSoDuLieu.getMaPhieuDichVu(id),CoSoDuLieu.getMaDichVu(comboBox.getSelectedItem().toString()),id, textSoLuong.getText());
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
			try {
				new TongQuan_ThongTinPhong_ThemDichVu(id);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		this.setVisible(true);
	}

	public void showListDichVuDaDat(List<DichVu2> list)
	{
		int size = list.size();
		Object [][] LichHen = new Object[size][6];
		for (int i = 0; i < size; i++)
		{
			LichHen[i][0] = list.get(i).getTenDichVu();
			LichHen[i][1] = list.get(i).getGia();
			LichHen[i][2] = list.get(i).getChiTiet();
			LichHen[i][3] = list.get(i).getSL();
			LichHen[i][5] = list.get(i).getThanhTien();
		}
		table.setModel(new DefaultTableModel(LichHen, columnNames));
	}

	public List<DichVu2> listdv(int ID) throws ClassNotFoundException, SQLException {
		List<DichVu2> listdv = new ArrayList<>();
		Connection connection =CoSoDuLieu.getConnect();
		String query = "SELECT DICHVU.TENDICHVU,DICHVU.GIA,CHITIETDV.SOLUONG, DICHVU.ChiTiet, PHIEUDICHVU.MAPDV "
				+ " FROM DICHVU, CHITIETDV, PHIEU_THUE_PHONG, PHIEUDICHVU "
				+ " WHERE DICHVU.MADV = CHITIETDV.MADV"
				+ " AND CHITIETDV.MAPHONG = "+ ID
				+ " AND PHIEU_THUE_PHONG.TINHTRANGTHANHTOAN = 0"
				+" AND PHIEUDICHVU.MAPDV = CHITIETDV.MAPDV"
				+" AND PHIEUDICHVU.MAPTP = PHIEU_THUE_PHONG.MAPTP";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String tendv = rs.getString(1);
				double gia = rs.getDouble(2);
				int sl = rs.getInt(3);
				String chitiet = rs.getString(4);
				double thanhtien = gia* sl;
				listdv.add(new DichVu2(tendv, gia,chitiet,sl,thanhtien));
			}
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return listdv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

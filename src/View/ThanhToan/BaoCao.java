package View.ThanhToan;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

import Data.CoSoDuLieu;
import Model.HoaDon;
import REPORT.Xchart;
import View.CaiDat.QLPhong.CaiDat;
import View.KhachHang.KhachHangV;
import View.NhanVien.NhanVienV;
import View.TongQuan.TongQuan;

import java.util.Date;
import java.util.List;

public class BaoCao extends JFrame  {
	int id = 1;
	private JPanel contentPane;
	private JButton btnKhachHang;
	private JButton btnCaiDat;
	private JTextField textField;
	JTable table;
	TableRowSorter<TableModel> rowSorter;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new BaoCao(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public BaoCao(int id) throws ClassNotFoundException, SQLException {
		this.id =id;
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1240, 730);
		this.setLocationRelativeTo(null);
		this.setTitle("Báo cáo");

		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1206, 47);
		panel.setBackground(new Color(178, 34, 34));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("HOWARD HOTEL");
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 0, 300, 47);
		lblNewLabel.setForeground(Color.white);
		panel.add(lblNewLabel);

		JLabel lblTenNhanVien = new JLabel(CoSoDuLieu.getTenNhanVien(id));
		lblTenNhanVien.setForeground(new Color(255, 255, 255));
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTenNhanVien.setBounds(974, 10, 194, 27);
		panel.add(lblTenNhanVien);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 58, 170, 595);
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnTongQuan = new JButton("T\u1ED5ng quan");
		btnTongQuan.addActionListener(e->{this.dispose();
			try {
				new TongQuan(id);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});
		btnTongQuan.setBackground(Color.LIGHT_GRAY);
		btnTongQuan.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnTongQuan.setBounds(0, 10, 170, 44);
		panel_1.add(btnTongQuan);

		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.addActionListener(e -> {
			this.dispose();
			try {
				new NhanVienV(id);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		btnNhanVien.setBackground(new Color(192, 192, 192));
		btnNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNhanVien.setBounds(0, 54, 170, 44);
		panel_1.add(btnNhanVien);

		btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnKhachHang.setBackground(Color.LIGHT_GRAY);
		btnKhachHang.setBounds(0, 141, 170, 44);
		panel_1.add(btnKhachHang);
		btnKhachHang.addActionListener(e -> {
			try {
				new KhachHangV(id);
			} catch (ClassNotFoundException classNotFoundException) {
				classNotFoundException.printStackTrace();
			}
		});

		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.addActionListener(e->{this.dispose();
			try {
				new ThanhToanV(id);
				this.dispose();
			} catch (ClassNotFoundException | SQLException classNotFoundException) {
				classNotFoundException.printStackTrace();
			}
		});
		btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnThanhToan.setBackground(new Color(192, 192, 192));
		btnThanhToan.setBounds(0, 97, 170, 44);
		panel_1.add(btnThanhToan);
		btnThanhToan.addActionListener(e -> {
			try {
				new ThanhToanV(id);
			} catch (ClassNotFoundException | SQLException classNotFoundException) {
				classNotFoundException.printStackTrace();
			}
			this.dispose();});

		JButton btnBaoCao = new JButton("Báo cáo");
		btnBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnBaoCao.setBackground(Color.WHITE);
		btnBaoCao.setBounds(0, 184, 170, 44);
		panel_1.add(btnBaoCao);
		btnBaoCao.addActionListener(e -> {
			try {
				new BaoCao(id);
				this.dispose();
			} catch (ClassNotFoundException | SQLException classNotFoundException) {
				classNotFoundException.printStackTrace();
			}
		});
		btnCaiDat = new JButton("Cài đặt");
		btnCaiDat.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnCaiDat.setBackground(Color.LIGHT_GRAY);
		btnCaiDat.setBounds(0, 228, 170, 44);
		panel_1.add(btnCaiDat);
		btnCaiDat.addActionListener(e -> {
			try {
				new CaiDat(id);
				this.dispose();
			} catch (ClassNotFoundException classNotFoundException) {
				classNotFoundException.printStackTrace();
			}
		});
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(178, 34, 34));
		panel_2.setBounds(190, 67, 1009, 36);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("B\u00E1o C\u00E1o");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(39, 0, 134, 36);
		panel_2.add(lblNewLabel_2);

		JButton btnHan = new JButton("H\u00F3a \u0111\u01A1n");
		btnHan.setForeground(Color.BLACK);
		btnHan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHan.setBackground(Color.WHITE);
		btnHan.setBounds(200, 113, 179, 36);
		contentPane.add(btnHan);

		JButton btnBiuKinh = new JButton("Bi\u1EC3u \u0111\u1ED3 kinh t\u1EBF");
		btnBiuKinh.setForeground(Color.BLACK);
		btnBiuKinh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBiuKinh.setBackground(Color.LIGHT_GRAY);
		btnBiuKinh.setBounds(378, 113, 179, 36);
		contentPane.add(btnBiuKinh);
		btnBiuKinh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Xchart();
				} catch (SQLException | ClassNotFoundException throwables) {
					throwables.printStackTrace();
				}
			}
		});
		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(198, 175, 62, 19);
		contentPane.add(lblNewLabel_5);

		JTextField searchfield = new JTextField();
		searchfield.setBounds(315, 172, 291, 27);
		contentPane.add(searchfield);
		searchfield.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = searchfield.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = searchfield.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(178, 34, 34));
		panel_4.setBounds(488, 595, 736, 3);
		contentPane.add(panel_4);

		JLabel lblNewLabel_4 = new JLabel("Khách hàng là thượng đế!");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_4.setBounds(1019, 598, 243, 25);
		contentPane.add(lblNewLabel_4);
		new Table();
	}

	public class Table {
		public Table() {
			EventQueue.invokeLater(() -> {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				ArrayList<HoaDon> list = new ArrayList<>();
				try {
					list = CoSoDuLieu.listHoaDon();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				TableModel model = new TableModel();

				int[] rowint = new int[7];
				double tien ;
				Date rowdate ;
				for (HoaDon tt : list) {
					rowint[0] = tt.getMaBILL();
					rowint[1] = tt.getMaKH();
					rowint[2] = tt.getMaNV();
					rowint[3] = tt.getMaPTP();
					rowint[4] = tt.getMaPDV();
					rowint[5] = tt.getMaPT();
					rowint[6] = tt.getMaKM();
					tien = tt.getTongTien();
					rowdate = tt.getNgayThanhToan();

					model.add(new HoaDon(rowint[0],rowint[1],rowint[2],rowint[3],rowint[4],rowint[5],rowint[6],
							tien,rowdate ));
				}
				table = new JTable(model);
				table.setFillsViewportHeight(true);

				table.setShowGrid(false);
				table.setPreferredScrollableViewportSize(new Dimension(500, 70));
				rowSorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(rowSorter);
				table.setOpaque(true);

				table.setBackground(new Color(255, 255, 255));
				table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setBackground(new Color(178, 34, 34));
				table.getTableHeader().setForeground(new Color(255, 255, 255));
				table.setSurrendersFocusOnKeystroke(true);

				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

				DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
				rightRenderer.setHorizontalAlignment(JLabel.CENTER);

				JTableHeader header = table.getTableHeader();
				header.setDefaultRenderer(new HeaderRenderer(table));

				for (int columnIndex = 0; columnIndex < table.getColumnCount() -2 ; columnIndex++)
				{
					table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
				}

				JScrollPane scrollpane = new JScrollPane(table);
				scrollpane.setViewportView(table);
				scrollpane.setBounds(190, 200, 1000, 300);

				contentPane.add(scrollpane);
			});
		}
		private class HeaderRenderer implements TableCellRenderer {

			DefaultTableCellRenderer renderer;

			public HeaderRenderer(JTable table) {
				renderer = (DefaultTableCellRenderer)
						table.getTableHeader().getDefaultRenderer();
				renderer.setHorizontalAlignment(JLabel.CENTER);
			}

			@Override
			public Component getTableCellRendererComponent(
					JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int col) {
				return renderer.getTableCellRendererComponent(
						table, value, isSelected, hasFocus, row, col);
			}
		}
		public class TableModel extends AbstractTableModel {

			private final List<HoaDon> data;

			public TableModel() {
				data = new ArrayList<>();
			}
			@Override
			public String getColumnName(int column) {
				return switch (column) {
					case 0 -> "Mã HÓA ĐƠN";
					case 1 -> "MÃ KHÁCH HÀNG";
					case 2 -> "MÃ NHÂN VIÊN";
					case 3 -> "PHIẾU THUÊ PHÒNG";
					case 4 -> "PHIẾU DV";
					case 5 -> "PHIẾU THU";
					case 6 -> "MÃ KM";
					case 7 -> "TIỀN";
					case 8 -> "NGÀY THANH TOÁN";
					//case 9 -> "NGÀY VÀO";
					//case 10 -> "NGÀY ĐI";
					default -> null;
				};
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return switch (columnIndex) {
					case 0,1,2,3,4,5,6 -> Integer.class;
					case 7 -> Double.class;
					case 8,9,10 -> Date.class;
					default -> Object.class;
				};
			}

			@Override
			public int getRowCount() {
				return data.size();
			}

			@Override
			public int getColumnCount() {
				//return 11;
				return 9;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				HoaDon obj = data.get(rowIndex);
				return switch (columnIndex) {
					case 0 -> obj.getMaBILL();
					case 1 -> obj.getMaKH();
					case 2 -> obj.getMaNV();
					case 3 -> obj.getMaPTP();
					case 4 -> obj.getMaPDV();
					case 5 -> obj.getMaPT();
					case 6 -> obj.getMaKM();
					case 7 -> obj.getTongTien();
					case 8 -> obj.getNgayThanhToan();
				//	case 9 -> obj.getNgayKhachVaoO();
				//	case 10 -> obj.getNgayKhachDi();
					default -> null;
				};
			}


			public void add(HoaDon value) {
				int startIndex = getRowCount();
				data.add(value);
				fireTableRowsInserted(startIndex, getRowCount() - 1);
			}

		}

	}
}

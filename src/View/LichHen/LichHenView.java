package View.LichHen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.CoSoDuLieu;
import Model.DangKiTruoc;

import java.util.List;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class LichHenView extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnTongQuan;
	private JButton btnLichHen;
	private JButton btnHoaDon;
	private JButton btnKhachHang;
	private JButton btnBaoCao;
	private JButton btnCaiDat;
	private JButton btnQuanLiDichVu;
	private JButton btnQuanLiPhong;
	private JButton btnQuanLiNhanVien;
	private JTextField textFieldTimKiem;
	private JTable table;
	private JTable tableLichHen;
	private JButton btnThemLichHen;
	private String[] columnNames = {
			 "Mã phòng",
			 "Mã khách hàng",
			 "Ngày đăng ký",
			 "Ngày nhận phòng",
			 "Ngày trả phòng"};
	private Object data = new Object [][] {};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LichHenView frame = new LichHenView();
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
	public LichHenView() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(10, 78, 167, 605);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnTongQuan = new JButton("T\u1ED5ng Quan");
		btnTongQuan.setBackground(SystemColor.scrollbar);
		btnTongQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTongQuan.setBounds(0, 83, 167, 36);
		panel.add(btnTongQuan);
		
		btnLichHen = new JButton("L\u1ECBch h\u1EB9n");
		btnLichHen.setBackground(SystemColor.text);
		btnLichHen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLichHen.setBounds(0, 129, 167, 36);
		panel.add(btnLichHen);
		
		btnHoaDon = new JButton("Hoa \u0110\u01A1n");
		btnHoaDon.setBackground(SystemColor.scrollbar);
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHoaDon.setBounds(0, 175, 167, 36);
		panel.add(btnHoaDon);
		
		btnKhachHang = new JButton("Kh\u00E1ch h\u00E0ng ");
		btnKhachHang.setBackground(SystemColor.scrollbar);
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKhachHang.setBounds(0, 221, 167, 36);
		panel.add(btnKhachHang);
		
		btnBaoCao = new JButton("B\u00E1o C\u00E1o");
		btnBaoCao.setBackground(SystemColor.scrollbar);
		btnBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBaoCao.setBounds(0, 267, 167, 36);
		panel.add(btnBaoCao);
		
		btnCaiDat = new JButton("C\u00E0i \u0111\u1EB7t");
		btnCaiDat.setBackground(SystemColor.scrollbar);
		btnCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCaiDat.setBounds(0, 313, 167, 36);
		panel.add(btnCaiDat);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 10, 51, 52);
		panel.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(61, 10, 96, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ho\u1EA1t \u0111\u1ED9ng");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_2.setForeground(new Color(50, 205, 50));
		lblNewLabel_2.setBounds(61, 37, 59, 13);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 10, 167, 68);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("4T Hotel");
		lblNewLabel.setForeground(SystemColor.info);
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 147, 48);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(176, 10, 810, 673);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(224, 255, 255));
		panel_4.setBounds(0, 0, 822, 57);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("T\u00ECm ki\u1EBFm:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(22, 67, 93, 37);
		panel_2.add(lblNewLabel_3);
		
		textFieldTimKiem = new JTextField();
		textFieldTimKiem.setBounds(99, 73, 385, 27);
		panel_2.add(textFieldTimKiem);
		textFieldTimKiem.setColumns(10);
		
		btnThemLichHen = new JButton("Th\u00EAm");
		btnThemLichHen.setBackground(new Color(60, 179, 113));
		btnThemLichHen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThemLichHen.setBounds(615, 67, 127, 37);
		panel_2.add(btnThemLichHen);
		
		JScrollPane scrollPaneLichHenTable = new JScrollPane();
		scrollPaneLichHenTable.setBounds(22, 145, 778, 298);
		panel_2.add(scrollPaneLichHenTable);
		
		tableLichHen = new JTable();
		tableLichHen.setModel(new DefaultTableModel( (Object[][]) data, columnNames));
		scrollPaneLichHenTable.setViewportView(tableLichHen);
		showListLichHen(CoSoDuLieu.getDanhSachLichHen());
		
		this.btnThemLichHen.addActionListener(this);
		
	}
	
	public void showListLichHen(List<DangKiTruoc> list)
	{
		int size = list.size();
		Object [][] LichHen = new Object[size][5];
		for (int i = 0; i < size; i++)
		{
			LichHen[i][0] = list.get(i).getMaPhong();
			LichHen[i][1] = list.get(i).getMaKH();
			LichHen[i][2] = list.get(i).getNgayDK();
			LichHen[i][3] = list.get(i).getNgayNhanPhong();
			LichHen[i][4] = list.get(i).getNgayTraPhong();
		}
		this.tableLichHen.setModel(new DefaultTableModel(LichHen, columnNames));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnThemLichHen)
		{
			ThemLichHenView lh = new ThemLichHenView();
		}
	}
	
	
}

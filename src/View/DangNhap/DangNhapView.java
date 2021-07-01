package View.DangNhap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data.CoSoDuLieu;
import View.KhachHang.KhachHangHomeView;
import View.TongQuan.TongQuan;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DangNhapView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	JButton btnDangNhap;
	JButton btnDangKy;
	public static void main(String[] args) {

	         new DangNhapView(); 	
	}
	
	public DangNhapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(300, 300, 300, 300));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(300, 150, 559, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDangNhap.setBounds(165, 10, 242, 52);
		panel.add(lblDangNhap);
		
		JLabel lblTenDangNhap = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp:");
		lblTenDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTenDangNhap.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenDangNhap.setBounds(85, 81, 148, 20);
		panel.add(lblTenDangNhap);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(192, 72, 232, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMauKhau = new JLabel("M\u1EADu kh\u1EA9u:");
		lblMauKhau.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMauKhau.setBounds(85, 170, 148, 20);
		panel.add(lblMauKhau);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(194, 161, 232, 39);
		panel.add(passwordField);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nh\u1EDB t\u00E0i kho\u1EA3n");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(194, 217, 138, 21);
		panel.add(rdbtnNewRadioButton);
		
		btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBackground(new Color(0, 128, 128));
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDangNhap.setBounds(85, 276, 163, 52);
		panel.add(btnDangNhap);
		
		btnDangKy = new JButton("\u0110\u0103ng K\u00FD");
		btnDangKy.setForeground(new Color(255, 255, 255));
		btnDangKy.setBackground(new Color(139, 69, 19));
		btnDangKy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDangKy.setBounds(335, 276, 163, 52);
		panel.add(btnDangKy);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(178, 34, 34));
		panel_2.setBounds(10, 10, 800, 46);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("HOWARD HOTEL");
		lblNewLabel.setBounds(247, 0, 300, 46);
		panel_2.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(178, 34, 34));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 36));
		
		this.btnDangKy.addActionListener(this);
		this.btnDangNhap.addActionListener(this);
		
		this.setVisible(true);
		
	
	}
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

	
	private boolean kiemTraMatKhau () {
        String name =String.copyValueOf(this.passwordField.getPassword()) ;
        if (name == null || "".equals(name.trim())) {
        	passwordField.requestFocus();
            showMessage("MatKhau khong dc de trong.");
            return false;
        }
        return true;
    }
	private boolean kiemTraTK () {
        String name = this.textField.getText();
        if (name == null || "".equals(name.trim())) {
        	textField.requestFocus();
            showMessage("ten tai khoan khong dc de trong.");
            return false;
        }
        return true;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnDangKy)
		{
			this.dispose();
			DangKiView dk = new DangKiView();
		}
		if (e.getSource() == btnDangNhap)
		{
			if(this.kiemTraMatKhau()||this.kiemTraTK()) {
				try {
					if(CoSoDuLieu.checkTK(this.textField.getText(), String.copyValueOf(this.passwordField.getPassword())) == 1)
					{
						this.dispose();
						KhachHangHomeView kh = new KhachHangHomeView();
					}
					else if(CoSoDuLieu.checkTK(this.textField.getText(), String.copyValueOf(this.passwordField.getPassword())) == 2)
					{
						this.dispose();
						TongQuan tongquan = new TongQuan(CoSoDuLieu.getID(this.textField.getText()));
					}
					else
					{
						showMessage("Tài khoản hoặc mật khẩu sai!");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					showMessage(e1.getMessage());
				}
			}
			else
			{
				
			}
		}
	}


}

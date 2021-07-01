package View.DangNhap;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Data.CoSoDuLieu;
import Model.NguoiDung;
import View.CapNhatThongTinView;


public class DangKiView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JTextField textTenTK;
	private JPasswordField password;
	private JPasswordField passwordRe;
	private JButton btnDangKy;
	private JButton btnQuayLai;
	public DangKiView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(25, 24, 458, 389);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng k\u00FD");
		lblNewLabel.setBounds(160, 10, 124, 57);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		lblNewLabel_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(116, 61, 133, 28);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(116, 137, 133, 28);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(116, 206, 133, 28);
		panel.add(lblNewLabel_5);
		
		textTenTK = new JTextField();
		textTenTK.setBackground(Color.LIGHT_GRAY);
		textTenTK.setBounds(116, 99, 205, 28);
		panel.add(textTenTK);
		textTenTK.setColumns(10);

		ButtonGroup btg = new ButtonGroup();
		btnDangKy = new JButton("\u0110\u0103ng k\u00FD");
		btnDangKy.setBackground(Color.CYAN);
		btnDangKy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnDangKy.setBounds(65, 326, 124, 38);
		panel.add(btnDangKy);
		
		btnQuayLai = new JButton("Quay l\u1EA1i");
		btnQuayLai.setBackground(new Color(250, 128, 114));
		btnQuayLai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnQuayLai.setBounds(265, 326, 108, 38);
		panel.add(btnQuayLai);
		
		password = new JPasswordField();
		password.setBackground(Color.LIGHT_GRAY);
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(116, 175, 205, 32);
		panel.add(password);
		
		passwordRe = new JPasswordField();
		passwordRe.setBackground(Color.LIGHT_GRAY);
		passwordRe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordRe.setBounds(116, 244, 205, 32);
		panel.add(passwordRe);
		this.setVisible(true);
		
		this.btnDangKy.addActionListener(this);
		this.btnQuayLai.addActionListener(this);
	}
	
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

	private boolean kiemTraMatKhau () {
        String name = this.password.getPassword().toString();
        if (name == null || "".equals(name.trim())) {
        	password.requestFocus();
            showMessage("MatKhau khong dc de trong.");
            return false;
        }
        return true;
    }
	private boolean kiemTraNhapLaiMatKhau() {
        String name = String.copyValueOf( this.passwordRe.getPassword());
        if (name == null || "".equals(name.trim())) {
        	this.passwordRe.requestFocus();
            showMessage("MatKhau khong duoc de trong.");
            return false;
        }
        else if
        	(name.equals(String.copyValueOf(this.password.getPassword())) == false)
        {
        	System.out.print(name);
        	this.passwordRe.requestFocus();
            showMessage("Mat khau nhap lai khong dung.");
            return false;
        }
        	
        return true;
    }

	private boolean kiemTraTenTK () {
        String name = this.textTenTK.getText();
        if (name == null || "".equals(name.trim())) {
        	this.textTenTK.requestFocus();
            showMessage("tenTK khong dc de trong.");
            return false;
        }
        return true;
    }

	public  NguoiDung layThongTin() {
		if(!this.kiemTraMatKhau()|| !this.kiemTraNhapLaiMatKhau() ||!this.kiemTraTenTK())
		{
			return null;
		}
		try
		{
			NguoiDung u = new NguoiDung();	
			u.setPassword(String.copyValueOf(this.password.getPassword()));
			u.setUserName(this.textTenTK.getText());
			
			return u;
		}
		catch(Exception e)
		{
			 showMessage(e.getMessage());
		}
		return null;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.btnDangKy) {
			try {
				if (CoSoDuLieu.ThemNguoiDung(layThongTin())) {
					showMessage("Dang ky thanh cong!");
					CapNhatThongTinView cntt = new CapNhatThongTinView(this.textTenTK.getText());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				showMessage(e1.getMessage());
			}
		} else if (e.getSource()==this.btnQuayLai) {
			this.dispose();
			DangNhapView dn = new DangNhapView();
		}
	}

}

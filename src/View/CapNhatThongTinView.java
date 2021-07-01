package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Data.CoSoDuLieu;
import Model.KhachHang;


public class CapNhatThongTinView extends JFrame implements ActionListener {

	private String username;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField textEmail;
	private JTextField textHoTen;
	private JTextField textNgaySinh;
	private JTextField textSDT;
	private JTextField textDiaChi;
	private JButton btnCapNhat;
	private JButton btnNhapLai;
	private JRadioButton rdbtnNam;
	private JRadioButton btnNu;
	private JTextField textCmnd;
	
	 public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            try {
	              new CapNhatThongTinView("NV06");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }
	public CapNhatThongTinView(String usersname) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(82, 48, 592, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u1EADp nh\u1EADt th\u00F4ng tin");
		lblNewLabel.setBounds(184, 10, 240, 57);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(27, 67, 133, 28);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("H\u1ECD t\u00EAn:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(309, 67, 115, 28);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_6 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(309, 133, 133, 28);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("SDT:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(27, 133, 115, 28);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(309, 209, 102, 45);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(27, 286, 77, 46);
		panel.add(lblNewLabel_9);
		
		textEmail = new JTextField();
		textEmail.setBackground(Color.LIGHT_GRAY);
		textEmail.setBounds(27, 91, 205, 32);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		textHoTen = new JTextField();
		textHoTen.setBackground(Color.LIGHT_GRAY);
		textHoTen.setBounds(309, 92, 205, 32);
		panel.add(textHoTen);
		textHoTen.setColumns(10);
		
		textNgaySinh = new JTextField();
		textNgaySinh.setBackground(Color.LIGHT_GRAY);
		textNgaySinh.setBounds(309, 167, 205, 32);
		panel.add(textNgaySinh);
		textNgaySinh.setColumns(10);
		
		textSDT = new JTextField();
		textSDT.setBackground(Color.LIGHT_GRAY);
		textSDT.setBounds(27, 164, 205, 32);
		panel.add(textSDT);
		textSDT.setColumns(10);
		
		textDiaChi = new JTextField();
		textDiaChi.setBackground(Color.LIGHT_GRAY);
		textDiaChi.setBounds(27, 324, 520, 32);
		panel.add(textDiaChi);
		textDiaChi.setColumns(10);
		
		rdbtnNam = new JRadioButton("Nam",true);
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNam.setBounds(384, 221, 103, 21);
		panel.add(rdbtnNam);
		
		
		
		btnNu = new JRadioButton("N\u1EEF");
		btnNu.setBackground(Color.WHITE);
		btnNu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNu.setBounds(495, 221, 103, 21);
		panel.add(btnNu);

		ButtonGroup btg = new ButtonGroup();
		btg.add(btnNu);
		btg.add(rdbtnNam);
		btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.setBackground(Color.CYAN);
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnCapNhat.setBounds(106, 378, 124, 38);
		panel.add(btnCapNhat);
		
		btnNhapLai = new JButton("Nh\u1EADp l\u1EA1i");
		btnNhapLai.setBackground(new Color(250, 128, 114));
		btnNhapLai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNhapLai.setBounds(309, 378, 108, 38);
		panel.add(btnNhapLai);
		
		JLabel lblNewLabel_10 = new JLabel("CMND:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(27, 215, 58, 32);
		panel.add(lblNewLabel_10);
		
		textCmnd = new JTextField();
		textCmnd.setBackground(Color.LIGHT_GRAY);
		textCmnd.setBounds(27, 257, 205, 28);
		panel.add(textCmnd);
		textCmnd.setColumns(10);
		this.setVisible(true);
		this.username = usersname;
		this.btnCapNhat.addActionListener(this);
		this.btnNhapLai.addActionListener(this);
	}
	
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
	
	private boolean kiemTraTen() {
        String name = this.textHoTen.getText();
        if (name == null || "".equals(name.trim())) {
        	textHoTen.requestFocus();
            showMessage("HoTen khong duoc de trong.");
            return false;
        }
        return true;
    }
	
	private boolean kiemTraDiaChi() {
        String DC = this.textDiaChi.getText();
        if (DC == null || "".equals(DC.trim())) {
        	this.textDiaChi.requestFocus();
            showMessage("Diachi khong duoc de trong.");
            return false;
        }
        return true;
	}
        	
	private boolean kiemTraSDT () {
        String name = this.textSDT.getText();
        if (name == null || "".equals(name.trim())) {
        	textSDT.requestFocus();
            showMessage("SDT khong dc de trong.");
            return false;
        }
        return true;
    }
	
	private boolean kiemTraEMAIL () {
        String name = this.textEmail.getText();
        if (name == null || "".equals(name.trim())) {
        	this.textEmail.requestFocus();
            showMessage("Email khong dc de trong.");
            return false;
        }
        return true;
    }
	private boolean kiemTraNgaySinh () {
        String name = this.textNgaySinh.getText();
        if (name == null || "".equals(name.trim())) {
        	this.textNgaySinh.requestFocus();
            showMessage("NgaySinh khong dc de trong.");
            return false;
        }
        return true;
    }
	private boolean kiemTraCMND () {
        String name = this.textCmnd.getText();
        if (name == null || "".equals(name.trim())) {
        	this.textCmnd.requestFocus();
            showMessage("CMND khong dc de trong.");
            return false;
        }
        return true;
    }

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}

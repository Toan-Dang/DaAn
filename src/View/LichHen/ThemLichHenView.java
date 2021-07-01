package View.LichHen;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class ThemLichHenView extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnHuy;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemLichHenView frame = new ThemLichHenView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemLichHenView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(94, 82, 169, 45);
		contentPane.add(lblNewLabel);
		
		btnHuy = new JButton("H\u1EE7y");
		btnHuy.setBackground(new Color(255, 0, 0));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHuy.setBounds(385, 376, 161, 53);
		contentPane.add(btnHuy);
		
		lblNewLabel_1 = new JLabel("Th\u00EAm l\u1ECBch h\u1EB9n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel_1.setBounds(208, 10, 294, 53);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(94, 127, 193, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 Ph\u00F2ng");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(407, 82, 169, 45);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(395, 127, 193, 45);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Ng\u00E0y nh\u1EADn ph\u00F2ng:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(94, 210, 161, 45);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 267, 193, 45);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Ng\u00E0y tr\u1EA3 ph\u00F2ng:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(407, 210, 169, 45);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(407, 267, 193, 45);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.setBackground(new Color(60, 179, 113));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(142, 376, 169, 53);
		contentPane.add(btnNewButton);
		this.setVisible(true);
		this.btnHuy.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnHuy)
		{
			this.dispose();
		}
	}
}

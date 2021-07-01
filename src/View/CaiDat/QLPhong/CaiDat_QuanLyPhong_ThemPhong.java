package View.CaiDat.QLPhong;



import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data.CoSoDuLieu;

import java.awt.Color;
import java.awt.Font;

public class CaiDat_QuanLyPhong_ThemPhong extends JFrame {
	int id;
    private JPanel contentPane;
    private JTextField textGhiChu;
    private final JComboBox<String> list;

    public CaiDat_QuanLyPhong_ThemPhong(int id) throws ClassNotFoundException {
    	this.id = id;
        this.setVisible(true);
        this.setBounds(100, 100, 577, 404);
        this.setLocationRelativeTo(null);
        this.setTitle("Thêm phòng");

        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(248, 248, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(178, 34, 34));
        panel.setBounds(10, 10, 491, 53);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Th\u00EAm ph\u00F2ng");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblNewLabel.setBounds(93, 10, 285, 33);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Lo\u1EA1i ph\u00F2ng:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1.setBounds(51, 113, 87, 53);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Ghi ch\u00FA:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_1.setBounds(51, 208, 87, 53);
        contentPane.add(lblNewLabel_1_1);

        ////////
        list = new JComboBox<>();
        CoSoDuLieu.getLoaiPhonglist(list);
        list.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        list.setOpaque(false);
        list.setBounds(148, 117, 194, 45);
        contentPane.add(list);

        textGhiChu = new JTextField();
        textGhiChu.setBounds(148, 224, 281, 37);
        contentPane.add(textGhiChu);
        textGhiChu.setColumns(10);

        JButton btnThem = new JButton("Thêm");
        btnThem.setForeground(new Color(255, 255, 255));
        btnThem.setBackground(new Color(0, 128, 128));
        btnThem.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnThem.setBounds(319, 284, 134, 37);
        contentPane.add(btnThem);

        JButton btnQuayLai = new JButton("Quay lại");
        btnQuayLai.setForeground(Color.WHITE);
        btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnQuayLai.setBackground(new Color(220, 20, 60));
        btnQuayLai.setBounds(84, 284, 134, 37);
        contentPane.add(btnQuayLai);

        btnQuayLai.addActionListener(e -> {
        	this.dispose();
        	try {
				new CaiDat(id);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
       btnThem.addActionListener(e -> {
        	try {
				CoSoDuLieu.InsertPhong(textGhiChu.getText(),list);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            this.dispose();
            try {
				new CaiDat(id);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
    }
}
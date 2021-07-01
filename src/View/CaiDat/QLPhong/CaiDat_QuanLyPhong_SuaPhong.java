package View.CaiDat.QLPhong;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.CoSoDuLieu;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CaiDat_QuanLyPhong_SuaPhong extends JFrame implements ActionListener {
	int id;
    private JPanel contentPane;
    private JTextField textGhiChu;
    private final JComboBox<String> list;
    private JButton btnQuayLai;

    public CaiDat_QuanLyPhong_SuaPhong(int ID) throws ClassNotFoundException {
    	this.id = id;
    	this.setVisible(true);
        this.setBounds(100, 100, 524, 482);
        this.setLocationRelativeTo(null);
        this.setTitle("sửa phòng");

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

        JLabel lblNewLabel = new JLabel("S\u1EEDa ph\u00F2ng");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblNewLabel.setBounds(93, 10, 285, 33);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Lo\u1EA1i ph\u00F2ng:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1.setBounds(72, 171, 87, 53);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Ghi ch\u00FA:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_1.setBounds(70, 243, 87, 53);
        contentPane.add(lblNewLabel_1_1);

        ////////

        list = new JComboBox<>();
        CoSoDuLieu.getLoaiPhonglist(list);
        list.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        list.setOpaque(false);
        list.setBounds(169, 175, 194, 45);
        contentPane.add(list);

        textGhiChu = new JTextField();
        textGhiChu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        textGhiChu.setBounds(167, 251, 281, 37);
        contentPane.add(textGhiChu);
        textGhiChu.setColumns(10);

        JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
        btnCapNhat.setForeground(new Color(255, 255, 255));
        btnCapNhat.setBackground(new Color(0, 128, 128));
        btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnCapNhat.setBounds(338, 361, 134, 37);
        contentPane.add(btnCapNhat);

        btnQuayLai = new JButton("Quay lại");
        btnQuayLai.setForeground(Color.WHITE);
        btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnQuayLai.setBackground(new Color(220, 20, 60));
        btnQuayLai.setBounds(82, 361, 134, 37);
        contentPane.add(btnQuayLai);
        btnQuayLai.addActionListener(e -> {
			try {
				new CaiDat(id);
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});

        JLabel lblNewLabel_1_1_1 = new JLabel("M\u00E3 ph\u00F2ng:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_1_1_1.setBounds(72, 99, 87, 53);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblMaPhong = new JLabel();
        lblMaPhong.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblMaPhong.setBounds(169, 109, 134, 37);
        contentPane.add(lblMaPhong);
        lblMaPhong.setText(String.valueOf(CoSoDuLieu.getMaPhongID(ID)));

        btnQuayLai.addActionListener(this);

        btnCapNhat.addActionListener(e -> {
            try {
				CoSoDuLieu.UpdatePhong(ID,textGhiChu.getText(),list);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnQuayLai)
		{
			this.dispose();
		}
	}
}
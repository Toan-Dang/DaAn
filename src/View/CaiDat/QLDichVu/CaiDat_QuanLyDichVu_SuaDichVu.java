package View.CaiDat.QLDichVu;



import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data.CoSoDuLieu;

import java.awt.*;

public class CaiDat_QuanLyDichVu_SuaDichVu extends  JFrame{
	int id;
    private JPanel contentPane;
    private JTextField textTenDichVu;
    private JTextField textGia;
    private JTextField textChiTiet;

    public CaiDat_QuanLyDichVu_SuaDichVu(int ID, int id) throws ClassNotFoundException {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 577, 404);
        this.setLocationRelativeTo(null);
        this.setTitle("Thêm Dịch vụ");

        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(248, 248, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(178, 34, 34));
        panel.setBounds(10, 10, 543, 53);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Sửa dịch vụ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblNewLabel.setBounds(125, 10, 290, 33);
        panel.add(lblNewLabel);

        JLabel tendv = new JLabel("T\u00EAn d\u1ECBch v\u1EE5:");
        tendv.setFont(new Font("Times New Roman", Font.BOLD, 17));
        tendv.setBounds(42, 103, 112, 53);
        contentPane.add(tendv);

        textTenDichVu = new JTextField();
        textTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        textTenDichVu.setBounds(157, 111, 216, 42);
        contentPane.add(textTenDichVu);
        textTenDichVu.setColumns(10);

        JLabel gia = new JLabel("Gi\u00E1");
        gia.setFont(new Font("Times New Roman", Font.BOLD, 17));
        gia.setBounds(42, 166, 112, 53);
        contentPane.add(gia);

        textGia = new JTextField();
        textGia.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        textGia.setColumns(10);
        textGia.setBounds(157, 174, 216, 42);
        contentPane.add(textGia);

        JLabel ghichu = new JLabel("Chi ti\u1EBFt");
        ghichu.setFont(new Font("Times New Roman", Font.BOLD, 17));
        ghichu.setBounds(42, 229, 112, 53);
        contentPane.add(ghichu);

        textChiTiet = new JTextField();
        textChiTiet.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        textChiTiet.setColumns(10);
        textChiTiet.setBounds(157, 237, 216, 42);
        contentPane.add(textChiTiet);


        ///////////////////////////

        JButton btnThem = new JButton("Cập nhật");
        btnThem.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnThem.setForeground(new Color(255, 255, 255));
        btnThem.setBackground(new Color(0, 128, 128));
        btnThem.setBounds(329, 306, 126, 42);
        contentPane.add(btnThem);

        JButton btnQuayLai = new JButton("Quay l\u1EA1i");
        btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnQuayLai.setBackground(new Color(220, 20, 60));
        btnQuayLai.setBounds(119, 306, 126, 42);
        contentPane.add(btnQuayLai);

        textChiTiet.setText(CoSoDuLieu.getChiTietDichVuID(ID));
        textGia.setText(String.valueOf(CoSoDuLieu.getGiaDichVuID(ID)));
        textTenDichVu.setText(String.valueOf(CoSoDuLieu.getTenDichVuID(ID)));

        btnQuayLai.addActionListener(e -> {
            this.dispose();
           new CaiDat_QuanLyDichVu(id);
        });
        btnThem.addActionListener(e -> {
            try {
				CoSoDuLieu.UpdateDichVu(ID, textTenDichVu.getText(),textChiTiet.getText(),textGia.getText());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            new CaiDat_QuanLyDichVu(id);
            this.dispose();
        });
       

    }
}

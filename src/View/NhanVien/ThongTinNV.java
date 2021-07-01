package View.NhanVien;

import Data.CoSoDuLieu;
import View.DangNhap.DangNhapView;
import View.TongQuan.TongQuan_ThongTinPhong_DatPhong;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Properties;


import java.awt.EventQueue;

import java.awt.Color;
        import java.awt.Font;

public class ThongTinNV extends JFrame {
    int id;
    private JPanel contentPane;
    private JTextField textHoTen;
    private JTextField textNgaySinh;
    private JTextField textDiaChi;
    private JTextField textEmail;
    private JTextField textSDT;
    private JTextField textCMND;
    private JTextField textNgayVaoLam;
    private JTextField textNguoiQuanLy;
    private JTextField textUserName;
    private JPasswordField textMatKhau;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThongTinNV frame = new ThongTinNV(1, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @throws ClassNotFoundException
     */
    public ThongTinNV(int manv, int id) throws ClassNotFoundException {
        this.id = id;
        this.setVisible(true);
        setBounds(100, 100, 864, 688);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 830, 68);
        panel.setBackground(new Color(178, 34, 34));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblTenNhanVien = new JLabel("Th\u00F4ng tin nh\u00E2n vi\u00EAn");
        lblTenNhanVien.setForeground(new Color(255, 255, 255));
        lblTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblTenNhanVien.setBounds(156, 10, 470, 48);
        panel.add(lblTenNhanVien);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(211, 211, 211));
        panel_1.setBounds(10, 79, 830, 562);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
        lblNewLabel_1.setBounds(10, 10, 98, 44);
        panel_1.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblMaNhanVien = new JLabel();
        lblMaNhanVien.setBounds(102, 10, 49, 44);
        panel_1.add(lblMaNhanVien);
        lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblMaNhanVien.setText(String.valueOf(manv));

        JLabel lblNewLabel_1_1 = new JLabel("H\u1ECD t\u00EAn:");
        lblNewLabel_1_1.setBounds(91, 55, 67, 44);
        panel_1.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        textHoTen = new JTextField();
        textHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textHoTen.setBounds(181, 59, 217, 32);
        panel_1.add(textHoTen);
        textHoTen.setColumns(10);


        UtilDateModel modelngaysinh = new UtilDateModel();
        Properties pNgSinh = new Properties();
        pNgSinh.put("text.today", "Today");
        pNgSinh.put("text.month", "Month");
        pNgSinh.put("text.year", "Year");
        modelngaysinh.setSelected(true);
        JDatePanelImpl datePanelNgSinh = new JDatePanelImpl(modelngaysinh, pNgSinh);
        JDatePickerImpl pickNGSinh = new JDatePickerImpl(datePanelNgSinh, new TongQuan_ThongTinPhong_DatPhong.DateLabelFormatter());
        pickNGSinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pickNGSinh.setBounds(546, 55, 217, 32);
        panel_1.add(pickNGSinh);

        JLabel lblNewLabel_1_1_1 = new JLabel("Ng\u00E0y sinh");
        lblNewLabel_1_1_1.setBounds(456, 53, 98, 44);
        panel_1.add(lblNewLabel_1_1_1);
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_2 = new JLabel("Gi\u1EDBi t\u00EDnh");
        lblNewLabel_1_1_2.setBounds(91, 107, 98, 44);
        panel_1.add(lblNewLabel_1_1_2);
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_3 = new JLabel("SDT");
        lblNewLabel_1_1_3.setBounds(456, 107, 98, 44);
        panel_1.add(lblNewLabel_1_1_3);
        lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_4 = new JLabel("EMAIL");
        lblNewLabel_1_1_4.setBounds(91, 163, 98, 44);
        panel_1.add(lblNewLabel_1_1_4);
        lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_5 = new JLabel("CMND");
        lblNewLabel_1_1_5.setBounds(456, 161, 98, 44);
        panel_1.add(lblNewLabel_1_1_5);
        lblNewLabel_1_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_7 = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
        lblNewLabel_1_1_7.setBounds(456, 215, 98, 44);
        panel_1.add(lblNewLabel_1_1_7);
        lblNewLabel_1_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_8 = new JLabel("Ng\u01B0\u1EDDi qu\u1EA3n l\u00FD");
        lblNewLabel_1_1_8.setBounds(91, 215, 98, 44);
        panel_1.add(lblNewLabel_1_1_8);
        lblNewLabel_1_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        textDiaChi = new JTextField();
        textDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textDiaChi.setBounds(181, 269, 582, 32);
        panel_1.add(textDiaChi);
        textDiaChi.setColumns(10);


        JLabel lblNewLabel_1_1_10 = new JLabel("\u0110\u1ECBa ch\u1EC9");
        lblNewLabel_1_1_10.setBounds(91, 261, 98, 44);
        panel_1.add(lblNewLabel_1_1_10);
        lblNewLabel_1_1_10.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(192, 192, 192));
        separator.setBounds(20, 76, 410, -37);
        panel_1.add(separator);

        JRadioButton rbdtnam = new JRadioButton("Nam");
        rbdtnam.setBackground(new Color(192, 192, 192));
        rbdtnam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        rbdtnam.setBounds(181, 119, 103, 21);
        panel_1.add(rbdtnam);

        JRadioButton rbdtnu = new JRadioButton("N\u1EEF");
        rbdtnu.setBackground(new Color(192, 192, 192));
        rbdtnu.setBounds(295, 120, 103, 21);
        panel_1.add(rbdtnu);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbdtnam);
        bg.add(rbdtnu);
        final String[] gt = new String[1];
        rbdtnam.addItemListener(e -> gt[0] = "NAM");
        rbdtnu.addItemListener(e -> gt[0] = "NU");

        textEmail = new JTextField();
        textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textEmail.setColumns(10);
        textEmail.setBounds(181, 163, 217, 32);
        panel_1.add(textEmail);


        textSDT = new JTextField();
        textSDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textSDT.setColumns(10);
        textSDT.setBounds(546, 107, 217, 32);
        panel_1.add(textSDT);


        textCMND = new JTextField();
        textCMND.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textCMND.setColumns(10);
        textCMND.setBounds(546, 161, 217, 32);
        panel_1.add(textCMND);

        UtilDateModel modelngayvl = new UtilDateModel();
        Properties pNgVL = new Properties();
        pNgVL.put("text.today", "Today");
        pNgVL.put("text.month", "Month");
        pNgVL.put("text.year", "Year");
        modelngayvl.setSelected(true);
        JDatePanelImpl datePanelNgVL = new JDatePanelImpl(modelngayvl, pNgVL);
        JDatePickerImpl pickNGVL = new JDatePickerImpl(datePanelNgVL, new TongQuan_ThongTinPhong_DatPhong.DateLabelFormatter());
        pickNGVL.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pickNGVL.setBounds(546, 215, 217, 32);
        panel_1.add(pickNGVL);


        textNguoiQuanLy = new JTextField();
        textNguoiQuanLy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textNguoiQuanLy.setColumns(10);
        textNguoiQuanLy.setBounds(181, 217, 217, 32);
        panel_1.add(textNguoiQuanLy);

        JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
        btnCapNhat.setForeground(new Color(255, 255, 255));
        btnCapNhat.setBackground(new Color(0, 128, 128));
        btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnCapNhat.setBounds(647, 491, 114, 44);
        panel_1.add(btnCapNhat);

        JButton btnLogout = new JButton("Đăng suất");
        btnLogout.setForeground(new Color(255, 255, 255));
        btnLogout.setBackground(new Color(0, 128, 128));
        btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnLogout.setBounds(347, 491, 114, 44);
        panel_1.add(btnLogout);
        btnLogout.addActionListener(e -> {
            new DangNhapView();ThongTinNV.this.dispose();
        });

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(35, 336, 762, 32);
        panel_1.add(separator_1);

        JLabel lblNewLabel = new JLabel("Th\u00F4ng tin t\u00E0i kho\u1EA3n");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setBounds(35, 336, 168, 32);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1_1_6 = new JLabel("T\u00E0i kho\u1EA3n");
        lblNewLabel_1_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_6.setBounds(91, 396, 67, 44);
        panel_1.add(lblNewLabel_1_1_6);

        textUserName = new JTextField();
        textUserName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textUserName.setColumns(10);
        textUserName.setBounds(181, 400, 217, 32);
        panel_1.add(textUserName);
        textUserName.setText(CoSoDuLieu.GetUsernameNV(manv));
        textUserName.setEditable(false);

        JLabel lblNewLabel_1_1_9 = new JLabel("M\u1EADt kh\u1EA9u");
        lblNewLabel_1_1_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_9.setBounds(456, 396, 67, 44);
        panel_1.add(lblNewLabel_1_1_9);

        textMatKhau = new JPasswordField();
        textMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 15));
        textMatKhau.setColumns(10);
        textMatKhau.setBounds(546, 400, 217, 32);
        panel_1.add(textMatKhau);
        textMatKhau.setText(CoSoDuLieu.GetPassNV(manv));

        JButton btnQuayLai = new JButton("Quay l\u1EA1i");
        btnQuayLai.addActionListener(e -> {
            this.dispose();
            try {
                new NhanVienV(id);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        btnQuayLai.setForeground(Color.WHITE);
        btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuayLai.setBackground(new Color(220, 20, 60));
        btnQuayLai.setBounds(498, 491, 114, 44);
        panel_1.add(btnQuayLai);

        CoSoDuLieu.GetInfoNV(manv,textHoTen,textDiaChi,textSDT,rbdtnam,rbdtnu,modelngaysinh,pNgSinh,
                textNguoiQuanLy,textCMND,textEmail,modelngayvl,pNgVL  );

        btnQuayLai.addActionListener(e -> {ThongTinNV.this.dispose(); try {
            new NhanVienV(id);
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }});

        btnCapNhat.addActionListener(e -> {
            try {
                CoSoDuLieu.UpdateNhanVien(manv,textNguoiQuanLy,textEmail,textHoTen,gt[0],pickNGSinh,
                        pickNGVL,textSDT,textDiaChi,textCMND);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            ThongTinNV.this.dispose();
            try {
                new NhanVienV(id);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
    }
}


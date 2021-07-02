package View.TongQuan;


import Data.CoSoDuLieu;
import Model.Phong;
import View.ThanhToan.BaoCao;
import View.CaiDat.QLPhong.CaiDat;
import View.ThanhToan.ThanhToanV;
import View.KhachHang.KhachHangV;
import View.NhanVien.NhanVienV;
import View.NhanVien.ThongTinNV;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TongQuan extends JFrame{
    int id = 0;
    JPanel soDoPhong;
    JButton btnDP;
    List<Integer> selectionList = new ArrayList();
    private JPanel contentPane;
    private JButton btnKhachHang;
    private JButton btnCaiDat;
    private boolean isKeydown = false;

    /**
     * Create the frame.
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public TongQuan(int id) throws ClassNotFoundException, SQLException {
        this.id = id;
        //this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1240, 730);
        this.setFocusable(true);
        this.setTitle("DS Phòng");
        this.setVisible(true);
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
        lblTenNhanVien.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    new ThongTinNV(id, id);
                } catch (NumberFormatException | ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });


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
        btnTongQuan.setBackground(Color.WHITE);
        btnTongQuan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan.setBounds(0, 10, 170, 44);
        panel_1.add(btnTongQuan);
        btnTongQuan.addActionListener(e->{
            this.dispose();
            try {
                new TongQuan(id);
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        JButton btnNhanVien = new JButton("Nhân viên");
        btnNhanVien.addActionListener(e -> {
            this.dispose();
            try {
                new NhanVienV(id);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
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
            TongQuan.this.dispose();
            try {
                new KhachHangV(id);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        JButton btnThanhToan = new JButton("Thanh toán");
        btnThanhToan.addActionListener(e -> {
            this.dispose();
            try {
                new ThanhToanV(id);
            } catch (ClassNotFoundException | SQLException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnThanhToan.setBackground(new Color(192, 192, 192));
        btnThanhToan.setBounds(0, 97, 170, 44);
        panel_1.add(btnThanhToan);

        JButton btnBaoCao = new JButton("Báo cáo");
        btnBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnBaoCao.setBackground(Color.LIGHT_GRAY);
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
        btnCaiDat.addActionListener(e -> {
            TongQuan.this.dispose();
            try {
                new CaiDat(id);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        btnCaiDat.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnCaiDat.setBackground(Color.LIGHT_GRAY);
        btnCaiDat.setBounds(0, 228, 170, 44);
        panel_1.add(btnCaiDat);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(178, 34, 34));
        panel_2.setBounds(190, 67, 1009, 36);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("T\u1ED5ng quan");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(39, 0, 134, 36);
        panel_2.add(lblNewLabel_2);

        JLabel lblChuThich = new JLabel("Ch\u00FA th\u00EDch: ");
        lblChuThich.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblChuThich.setBounds(189, 113, 83, 30);
        contentPane.add(lblChuThich);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(60, 179, 113));
        panel_3.setBounds(266, 113, 38, 30);
        panel_3.setLayout(null);
        contentPane.add(panel_3);

        JLabel lblNewLabel_4 = new JLabel("Tr\u1ED1ng");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4.setBounds(314, 118, 83, 20);
        contentPane.add(lblNewLabel_4);

        JPanel panel_3_1 = new JPanel();
        panel_3_1.setBackground(new Color(255, 0, 0));
        panel_3_1.setBounds(371, 113, 38, 30);
        contentPane.add(panel_3_1);

        JLabel lblNewLabel_4_1 = new JLabel("\u0110ang \u1EDF");
        lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_1.setBounds(419, 118, 83, 20);
        contentPane.add(lblNewLabel_4_1);

        JPanel panel_3_2 = new JPanel();
        panel_3_2.setBackground(new Color(148, 0, 211));
        panel_3_2.setBounds(479, 113, 38, 30);
        contentPane.add(panel_3_2);

        JLabel lblNewLabel_4_2 = new JLabel("\u0110\u00E3 \u0111\u1EB7t tr\u01B0\u1EDBc");
        lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_2.setBounds(527, 118, 83, 20);
        contentPane.add(lblNewLabel_4_2);

        JPanel panel_3_2_1 = new JPanel();
        panel_3_2_1.setBackground(new Color(192, 192, 192));
        panel_3_2_1.setBounds(614, 113, 38, 30);
        contentPane.add(panel_3_2_1);
/*
        JLabel lblNewLabel_5 = new JLabel("1");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_3_2_1.add(lblNewLabel_5);

        JLabel lblNewLabel_4_2_1 = new JLabel("Ph\u00F2ng \u0111\u01A1n");
        lblNewLabel_4_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_2_1.setBounds(662, 118, 83, 20);
        contentPane.add(lblNewLabel_4_2_1);

        JPanel panel_3_2_2 = new JPanel();
        panel_3_2_2.setBackground(new Color(192, 192, 192));
        panel_3_2_2.setBounds(736, 113, 38, 30);
        contentPane.add(panel_3_2_2);

        JLabel lblNewLabel_6 = new JLabel("2");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_3_2_2.add(lblNewLabel_6);

        JLabel lblNewLabel_4_2_2 = new JLabel("Ph\u00F2ng \u0111\u00F4i");
        lblNewLabel_4_2_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_2_2.setBounds(784, 118, 83, 20);
        contentPane.add(lblNewLabel_4_2_2);

        JPanel panel_3_2_3 = new JPanel();
        panel_3_2_3.setBackground(new Color(192, 192, 192));
        panel_3_2_3.setBounds(855, 113, 38, 30);
        contentPane.add(panel_3_2_3);

        JLabel lblNewLabel_7 = new JLabel("n");
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_3_2_3.add(lblNewLabel_7);

        JLabel lblNewLabel_4_2_3 = new JLabel("Ph\u00F2ng \u0111o\u00E0n");
        lblNewLabel_4_2_3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_2_3.setBounds(903, 118, 83, 20);
        contentPane.add(lblNewLabel_4_2_3);
*/
        JButton btnDSDichVu = new JButton("DS dịch vụ");
        btnDSDichVu.addActionListener(e -> {

            try {
                new TongQuan_DsDichVu();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        });
        btnDSDichVu.setBackground(new Color(0, 206, 209));
        btnDSDichVu.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnDSDichVu.setBounds(1050, 185, 166, 47);
        contentPane.add(btnDSDichVu);

        btnDP = new JButton("Đặt Phòng");
        btnDP.setBackground(new Color(0, 206, 209));
        btnDP.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnDP.setBounds(1050, 350, 166, 47);
        btnDP.setVisible(false);
        contentPane.add(btnDP);
        btnDP.addActionListener(e -> new DatNhieuPhong(selectionList));

        JButton btnDSCheckin = new JButton("DS checkin");
        btnDSCheckin.setBackground(new Color(0, 206, 209));
        btnDSCheckin.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnDSCheckin.setBounds(1050, 255, 166, 47);
        contentPane.add(btnDSCheckin);

        JButton btnNewButton = new JButton("Reset");

        btnNewButton.setBackground(new Color(119, 136, 153));
        btnNewButton.addActionListener(e->{
            this.dispose();
            try {
                new TongQuan(id);
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        btnNewButton.setBounds(1127, 106, 72, 47);
        contentPane.add(btnNewButton);

        soDoPhong = new JPanel();
        soDoPhong.setBounds(190, 153, 832, 500);
        contentPane.add(soDoPhong);

        new DanhSachPhong();
        KeyStroke keyStroke;
        InputMap inputMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_CONTROL, InputEvent.CTRL_DOWN_MASK, false);
        inputMap.put(keyStroke, "pressedControl");
        contentPane.getActionMap().put("pressedControl", new DanhSachPhong("pressed"));

        keyStroke = KeyStroke.getKeyStroke("released CONTROL");
        inputMap.put(keyStroke, "releasedControl");
        contentPane.getActionMap().put("releasedControl", new DanhSachPhong("released"));


    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new TongQuan(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public class DanhSachPhong extends AbstractAction {

        private final JPanel controls = new JPanel() {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(832, 500);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(832, 500);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(832, 500);
            }
        };


        private String keyState;


        public DanhSachPhong(String state) {
            this.keyState = state;
        }

        DanhSachPhong() throws ClassNotFoundException, SQLException {
            initUI();
        }

        public final void initUI() throws ClassNotFoundException, SQLException {

            soDoPhong.add(controls);
            controls.setBackground(new Color(185, 243, 243));
            controls.setBorder(new TitledBorder("Danh sách phòng"));
            soDoPhong.add(getCheckBoxPanel());

        }

        private void addLabel(String maphong, String tinhtrang, String loaiphong) {
            Color color = new Color(60, 179, 113);
            if (tinhtrang.equals("đã có người")) color = new Color(255, 0, 0);
            if (tinhtrang.equals("đã được đặt")) color = new Color(148, 0, 211);
            JPanel controls1 = new JPanel();
            controls1.setBackground(color);
            controls1.setBorder(new EmptyBorder(0, 0, 0, 0));
            controls1.setLayout(new BorderLayout());

            JLabel txtmaphong = new JLabel();
            txtmaphong.setText(maphong);
            txtmaphong.setHorizontalAlignment(SwingConstants.CENTER);
            txtmaphong.setFont(new Font("Times New Roman", Font.BOLD, 20));
            controls1.add(txtmaphong, BorderLayout.CENTER);

            JLabel txtloaiphong = new JLabel();
            txtloaiphong.setText(loaiphong);
            txtloaiphong.setForeground(Color.blue);
            txtloaiphong.setBackground(Color.gray);
            txtloaiphong.setHorizontalAlignment(SwingConstants.RIGHT);
            txtloaiphong.setFont(new Font("Times New Roman", Font.PLAIN, 10));
            controls1.add(txtloaiphong, BorderLayout.NORTH);

            controls1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    {
                        super.mousePressed(e);
                        JPanel p = (JPanel) e.getSource();
                        JLabel label = (JLabel) p.getComponent(0);
                        int mp = Integer.parseInt(label.getText());
                        if (mp != 0) {
                            if (isKeydown) {
                                if (selectionList.contains(mp)) {
                                    selectionList.remove(Integer.valueOf(mp));
                                    deleteSelection(controls1);
                                } else {
                                    selectionList.add(mp);
                                    updateSelection(controls1);
                                }
                            } else {
                               // selectionList.clear();
                                // selectionList.add(mp);
                                if (selectionList.size() > 1) {
                                    TongQuan.this.dispose();

                                    try {
                                        new TongQuan(id);
                                        new ThongTinPhong(Integer.parseInt(label.getText()));
                                    } catch (ClassNotFoundException | SQLException classNotFoundException) {
                                        classNotFoundException.printStackTrace();
                                    }
                                } else {
                                    try {
                                        new ThongTinPhong(Integer.parseInt(label.getText()));
                                    } catch (ClassNotFoundException classNotFoundException) {
                                        classNotFoundException.printStackTrace();
                                    }
                                }

                            }
                        }
                        btnDP.setVisible(selectionList.size() > 1);
                    }
                }
            });

            controls.add(controls1);
        }

        private void updateSelection(JPanel panel) {
            panel.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        }

        private void deleteSelection(JPanel panel) {
            panel.setBorder(null);
        }

        private JPanel getCheckBoxPanel() throws ClassNotFoundException, SQLException {

            ArrayList<Phong> listphong = CoSoDuLieu.listphong();
            int cnt = listphong.size();
            int row = (cnt/10)+1;

            for (Phong p : listphong) {
                if (controls.getComponentCount() < 1) {
                    controls.setLayout(new BorderLayout());
                    addLabel(String.valueOf(p.getMaPhong()), p.getTinhTrang(), p.getMaLoaiPhong());
                    makeChange();
                } else if (controls.getComponentCount() == 1) {
                    controls.setLayout(new GridLayout(0, 2, 10, 10));
                    addLabel(String.valueOf(p.getMaPhong()), p.getTinhTrang(), p.getMaLoaiPhong());
                    makeChange();
                } else {
                    controls.setLayout(new GridLayout(4, 0, 5, 5));
                    addLabel(String.valueOf(p.getMaPhong()), p.getTinhTrang(), p.getMaLoaiPhong());
                    makeChange();
                }

            }
            return new JPanel();
        }

        private void makeChange() {
            soDoPhong.revalidate();
            soDoPhong.repaint();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (keyState.equals("pressed"))
                isKeydown = true;
            if (keyState.equals("released"))
                isKeydown = false;
        }
    }
}

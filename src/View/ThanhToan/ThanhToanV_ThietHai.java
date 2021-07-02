package View.ThanhToan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Data.CoSoDuLieu;
import Model.DangKiTruoc;
import Model.DichVu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThanhToanV_ThietHai extends JFrame implements ActionListener {
    int id;
    int maptp;
    private JPanel contentPane;
    private JTextField textSoLuong;
    private String[] columnNames = {
            "Tên thiết bị",
            "Chi tiết",
            "Giá",
            "Mã phòng",
            "Số lượng",
            "Thành tiền"};
    private Object data = new Object [][] {};
    private JTable table;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThanhToanV_ThietHai frame = new ThanhToanV_ThietHai(1);
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
    public ThanhToanV_ThietHai(int id) throws ClassNotFoundException, SQLException {
        this.id = id;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 794, 455);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(178, 34, 34));
        panel.setBounds(10, 10, 760, 51);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Thiệt hại");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(288, 10, 138, 29);
        panel.add(lblNewLabel);
        lblNewLabel.setBackground(new Color(178, 34, 34));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

        JLabel lbl = new JLabel("Mã Phiếu:");
        lbl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lbl.setBounds(10, 72, 64, 51);
        contentPane.add(lbl);

        JLabel lblNewLabel_1_1 = new JLabel(String.valueOf(id));
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(84, 71, 64, 51);
        contentPane.add(lblNewLabel_1_1);

        JComboBox<String> comboBox = new JComboBox<>();
        CoSoDuLieu.getthiethaiList(comboBox);
        comboBox.setBounds(84, 125, 162, 36);
        contentPane.add(comboBox);

        JLabel lblNewLabel_1_2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(272, 118, 64, 51);
        contentPane.add(lblNewLabel_1_2);

        textSoLuong = new JTextField();
        textSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textSoLuong.setBounds(348, 125, 53, 36);
        contentPane.add(textSoLuong);
        textSoLuong.setColumns(10);

        JLabel lblNewLabel_1_3 = new JLabel("Thiết bị:");
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(10, 117, 64, 51);
        contentPane.add(lblNewLabel_1_3);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 171, 760, 166);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel( (Object[][]) data, columnNames));

        JButton btnThem = new JButton("Th\u00EAm");
        btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnThem.setBounds(630, 124, 88, 36);
        contentPane.add(btnThem);

        JButton btnQuayLai = new JButton("Quay lại");
        btnQuayLai.addActionListener(e-> {
            this.dispose();
        });

        btnQuayLai.setBackground(new Color(220, 20, 60));
        btnQuayLai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnQuayLai.setBounds(616, 347, 137, 49);
        contentPane.add(btnQuayLai);

        JLabel lblNewLabel_1_2_1 = new JLabel("Mã phòng:");
        lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_2_1.setBounds(430, 118, 64, 51);
        contentPane.add(lblNewLabel_1_2_1);

        JComboBox comboBoxphong = new JComboBox();
        comboBoxphong.setBounds(504, 125, 88, 36);
        contentPane.add(comboBoxphong);
        CoSoDuLieu.getListPhong_PTP(comboBoxphong, id);

        JButton btnSua = new JButton("Sửa");
        btnSua.addActionListener(e->{
            this.dispose();
            try {
                new ThanhToanV_ThietHai_Sua(id,CoSoDuLieu.getMaThietHai( (String)table.getValueAt(table.getSelectedRow(), 0)), (int)table.getValueAt(table.getSelectedRow(), 3),(int)table.getValueAt(table.getSelectedRow(), 4));
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        btnSua.setBackground(new Color(0, 191, 255));
        btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnSua.setBounds(348, 347, 88, 36);
        contentPane.add(btnSua);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBackground(Color.RED);
        btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnXoa.setBounds(484, 347, 88, 36);
        contentPane.add(btnXoa);
        btnXoa.addActionListener(e-> {
            try {
                CoSoDuLieu.XoaChitietThietHai(CoSoDuLieu.getMaPhieuThu(id),CoSoDuLieu.getMaThietHai( (String)table.getValueAt(table.getSelectedRow(), 0)), (int)table.getValueAt(table.getSelectedRow(), 3));
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            this.dispose();
            try {
                new ThanhToanV_ThietHai(id);
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        showListThietHai(listtb(id));

        btnThem.addActionListener(e -> {
            //System.out.print(comboBox.getSelectedItem().toString());
            try {
                try {
                    CoSoDuLieu.InsertChiTietThietHai(CoSoDuLieu.getMaPhieuThu(id),CoSoDuLieu.getMaThietHai(comboBox.getSelectedItem().toString()),comboBoxphong.getSelectedItem().toString(), textSoLuong.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            this.dispose();
            try {
                new ThanhToanV_ThietHai(id);
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        this.setVisible(true);
    }

    public void showListThietHai(List<ThietBi> list)
    {
        int size = list.size();
        Object [][] LichHen = new Object[size][6];
        for (int i = 0; i < size; i++)
        {
            LichHen[i][0] = list.get(i).getTenThietBi();
            LichHen[i][2] = list.get(i).getGia();
            LichHen[i][1] = list.get(i).getChiTiet();
            LichHen[i][4] = list.get(i).getSL();
            LichHen[i][3] = list.get(i).getMaPhong();
            LichHen[i][5] = list.get(i).getThanhTien();
        }
        table.setModel(new DefaultTableModel(LichHen, columnNames));
    }

    public List<ThietBi> listtb(int ID) throws ClassNotFoundException, SQLException {
        List<ThietBi> listdv = new ArrayList<>();
        Connection connection =CoSoDuLieu.getConnect();
        String query = "SELECT THIETHAI.TENTHIETBI,THIETHAI.GIA,CHITIET_THIETHAI.SOLUONG, THIETHAI.GHICHU, CHITIET_THIETHAI.MAPHONG "
                + " FROM THIETHAI, CHITIET_THIETHAI, PHIEU_THUE_PHONG, PHIEUTHU "
                + " WHERE ThietHai.mathiethai = CHITIET_THIETHAI.MaThietHai"
                + " AND PHIEU_THUE_PHONG.MAPTP = "+ ID
                + " AND PHIEU_THUE_PHONG.TINHTRANGTHANHTOAN = 0"
                +" AND PHIEUTHU.MAPT = CHITIET_THIETHAI.MAPT"
                +" AND PHIEUTHU.MAPTp = PHIEU_THUE_PHONG.MAPTP";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String tenThietBi = rs.getString(1);
                double gia = rs.getDouble(2);
                int sl = rs.getInt(3);
                String chitiet = rs.getString(4);
                int maphong = rs.getInt(5);
                double thanhtien = gia* sl;
                listdv.add(new ThietBi(tenThietBi, chitiet,gia,sl,maphong,thanhtien));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listdv;
    }

    public class ThietBi {
        private String tenThietBi;
        private String chiTiet;
        private double gia;
        private int SL;
        private int maPhong;
        private double thanhTien;
        /**
         * @return the tenThietBi
         */
        public String getTenThietBi() {
            return tenThietBi;
        }
        /**
         * @param tenThietBi the tenThietBi to set
         */
        public void setTenThietBi(String tenThietBi) {
            this.tenThietBi = tenThietBi;
        }
        /**
         * @return the chiTiet
         */
        public String getChiTiet() {
            return chiTiet;
        }
        /**
         * @param chiTiet the chiTiet to set
         */
        public void setChiTiet(String chiTiet) {
            this.chiTiet = chiTiet;
        }
        /**
         * @return the gia
         */
        public double getGia() {
            return gia;
        }
        /**
         * @param gia the gia to set
         */
        public void setGia(double gia) {
            this.gia = gia;
        }
        /**
         * @return the sL
         */
        public int getSL() {
            return SL;
        }
        /**
         * @param sL the sL to set
         */
        public void setSL(int sL) {
            SL = sL;
        }
        /**
         * @return the thanhTien
         */
        public double getThanhTien() {
            return thanhTien;
        }
        /**
         * @param thanhTien the thanhTien to set
         */
        public void setThanhTien(double thanhTien) {
            this.thanhTien = thanhTien;
        }


        /**
         * @return the maPhong
         */
        public int getMaPhong() {
            return maPhong;
        }
        /**
         * @param maPhong the maPhong to set
         */
        public void setMaPhong(int maPhong) {
            this.maPhong = maPhong;
        }


        public ThietBi(String tenThietBi, String chiTiet, double gia, int sL, int maPhong, double thanhTien) {
            super();
            this.tenThietBi = tenThietBi;
            this.chiTiet = chiTiet;
            this.gia = gia;
            SL = sL;
            this.maPhong = maPhong;
            this.thanhTien = thanhTien;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

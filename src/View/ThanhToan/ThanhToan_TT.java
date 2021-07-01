package View.ThanhToan;


/*
Procedure thanh toán
        {
        Cập nhật lại tình trạng phòng.
        Cập nhật tình trạng phiếu thuê.
        Cập nhật doanh số.
        Điền thông tin vào bảng hóa đơn.
        }
*/

//////////////////////////

import Data.CoSoDuLieu;
import Model.ChiTietDichVu;
import Model.ChiTietPhieuThuePhong;
import Model.ChiTietThietHai;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThanhToan_TT extends JFrame {

    private final JComboBox<String> list;
    long TienThanhToan;
    int MaKhuyenMai;
    private JPanel contentPane;
    private JTable tablePhong;
    private JTable tableDichVu;
    private JTable tableThietHai;
    private JTextField textTraTruoc;
    private JTextField textGiamTru;
    private JTextField textPhuThu;


    public ThanhToan_TT(int makh, int mahd, int manv) throws ClassNotFoundException {
        this.setVisible(true);
        setBounds(200, 0, 787, 826);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(178, 34, 34));
        panel_1.setBounds(10, 0, 750, 53);
        contentPane.add(panel_1);

        JLabel lblPhng = new JLabel("Thanh to\u00E1n");
        lblPhng.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhng.setForeground(Color.WHITE);
        lblPhng.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblPhng.setBounds(251, 0, 223, 51);
        panel_1.add(lblPhng);

        JLabel lblNewLabel = new JLabel("Kh\u00E1ch h\u00E0ng:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setBounds(122, 65, 81, 38);
        contentPane.add(lblNewLabel);

        JLabel lblTenKhachHang = new JLabel();
        lblTenKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblTenKhachHang.setBounds(213, 65, 200, 38);
        contentPane.add(lblTenKhachHang);
        lblTenKhachHang.setText(CoSoDuLieu.GetTenKH(makh));

        JLabel lblMH = new JLabel("M\u00E3 H\u0110:");
        lblMH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblMH.setBounds(475, 65, 81, 38);
        contentPane.add(lblMH);

        JLabel lblMaHD = new JLabel();
        lblMaHD.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblMaHD.setBounds(547, 65, 165, 38);
        lblMaHD.setText(String.valueOf(mahd));
        contentPane.add(lblMaHD);

        JLabel lblVoLc = new JLabel("Ng\u00E0y l\u1EADp phi\u1EBFu:");
        lblVoLc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblVoLc.setBounds(105, 113, 98, 38);
        contentPane.add(lblVoLc);

        JLabel lblNgayLapPhieu = new JLabel(" 11:30 03/08/2021");
        lblNgayLapPhieu.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNgayLapPhieu.setBounds(213, 113, 165, 38);
        contentPane.add(lblNgayLapPhieu);
        lblNgayLapPhieu.setText(String.valueOf(CoSoDuLieu.getNgayLapPhieu(mahd)));

        JLabel lblTrLc = new JLabel("Ng\u00E0y thanh to\u00E1n:");
        lblTrLc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblTrLc.setBounds(429, 113, 125, 38);
        contentPane.add(lblTrLc);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        JLabel lblNgayThanhToan = new JLabel();
        lblNgayThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNgayThanhToan.setBounds(547, 113, 125, 38);
        contentPane.add(lblNgayThanhToan);
        lblNgayThanhToan.setText(dtf.format(now));

        JSeparator separator = new JSeparator();
        separator.setBounds(39, 161, 694, 2);
        contentPane.add(separator);

        JLabel lblNewLabel_1 = new JLabel("Ti\u1EC1n Ph\u00F2ng: ");
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNewLabel_1.setBounds(39, 161, 154, 38);
        contentPane.add(lblNewLabel_1);

        JLabel lblTienPhong = new JLabel();
        lblTienPhong.setFont(new Font("Dialog", Font.BOLD, 18));
        lblTienPhong.setBounds(173, 161, 134, 38);
        contentPane.add(lblTienPhong);
        lblTienPhong.setText(CoSoDuLieu.getTienPhong(mahd));

        JLabel lblNewLabel_3 = new JLabel("T\u00EDnh theo ng\u00E0y");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(577, 161, 154, 25);
        contentPane.add(lblNewLabel_3);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(39, 294, 694, 2);
        contentPane.add(separator_1);

        JLabel lblNewLabel_1_1 = new JLabel("Ti\u1EC1n d\u1ECBch v\u1EE5:");
        lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNewLabel_1_1.setBounds(44, 294, 154, 38);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblTienDichVu = new JLabel();
        lblTienDichVu.setFont(new Font("Dialog", Font.BOLD, 18));
        lblTienDichVu.setBounds(173, 294, 134, 38);
        contentPane.add(lblTienDichVu);
        lblTienDichVu.setText(CoSoDuLieu.getTienDichVu(mahd));

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(39, 427, 694, 2);
        contentPane.add(separator_2);

        JLabel lblNewLabel_1_2 = new JLabel("Thi\u1EC7t h\u1EA1i:");
        lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNewLabel_1_2.setBounds(44, 427, 154, 38);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblTienThietHai = new JLabel();
        lblTienThietHai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblTienThietHai.setBounds(153, 427, 134, 38);
        contentPane.add(lblTienThietHai);
        lblTienThietHai.setText(CoSoDuLieu.getTienPhieuThu(mahd));

        JSeparator separator_2_1 = new JSeparator();
        separator_2_1.setBounds(39, 560, 694, 2);
        contentPane.add(separator_2_1);

        JLabel lblPhThu = new JLabel("Ph\u1EE5 thu:");
        lblPhThu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblPhThu.setBounds(44, 570, 81, 38);
        contentPane.add(lblPhThu);

        JLabel lblGimTr = new JLabel("Gi\u1EA3m tr\u1EEB:");
        lblGimTr.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblGimTr.setBounds(264, 570, 81, 38);
        contentPane.add(lblGimTr);

        JLabel lblTrTrc = new JLabel("Tr\u1EA3 tr\u01B0\u1EDBc:");
        lblTrTrc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblTrTrc.setBounds(487, 572, 81, 38);
        contentPane.add(lblTrTrc);

        JLabel lblNewLabel_1_2_1 = new JLabel("Thanh To\u00E1n:");
        lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNewLabel_1_2_1.setBounds(39, 607, 154, 38);
        contentPane.add(lblNewLabel_1_2_1);

        JLabel lblTienThanhToan = new JLabel();
        lblTienThanhToan.setFont(new Font("Dialog", Font.BOLD, 18));
        lblTienThanhToan.setBounds(158, 610, 171, 35);
        contentPane.add(lblTienThanhToan);
        lblTienThanhToan.setText(String.valueOf(CoSoDuLieu.getTongTien(mahd)));

        JLabel lblTrngThi = new JLabel("Tr\u1EA1ng th\u00E1i");
        lblTrngThi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblTrngThi.setBounds(44, 643, 81, 38);
        contentPane.add(lblTrngThi);

        JLabel lblangCheckin = new JLabel("\u0110ang checkin");
        lblangCheckin.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblangCheckin.setBounds(140, 643, 134, 38);
        contentPane.add(lblangCheckin);

        JLabel lblHnhThc = new JLabel("H\u00ECnh Th\u1EE9c");
        lblHnhThc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblHnhThc.setBounds(487, 643, 81, 38);
        contentPane.add(lblHnhThc);

        JLabel lblTinMt = new JLabel("Ti\u1EC1n m\u1EB7t");
        lblTinMt.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblTinMt.setBounds(591, 643, 81, 38);
        contentPane.add(lblTinMt);

        JButton btnNewButton = new JButton("Thanh to\u00E1n");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 128, 128));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnNewButton.setBounds(547, 680, 145, 38);
        contentPane.add(btnNewButton);

        textTraTruoc = new JTextField();
        textTraTruoc.setBounds(564, 572, 128, 35);
        contentPane.add(textTraTruoc);
        textTraTruoc.setColumns(10);

        list = new JComboBox<>();
        CoSoDuLieu.getKhuyenMailist(list, makh);
        list.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        list.setOpaque(false);
        list.setBounds(333, 570, 128, 35);
        contentPane.add(list);
        list.addActionListener(e -> {
            String khuyenmai = Objects.requireNonNull(list.getSelectedItem()).toString();
            long tien = 0;
            try {
                tien = CoSoDuLieu.getTongTien(mahd);
                MaKhuyenMai = CoSoDuLieu.getMaKM(khuyenmai);
                TienThanhToan = CoSoDuLieu.getTongTien_KM(tien, khuyenmai);
            } catch (NumberFormatException | ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            lblTienThanhToan.setText(String.valueOf(TienThanhToan));
        });

        textPhuThu = new JTextField();
        textPhuThu.setColumns(10);
        textPhuThu.setBounds(105, 572, 128, 35);
        contentPane.add(textPhuThu);

        btnNewButton.addActionListener(e -> {

            try {

                CoSoDuLieu.ThanhToan(Long.parseLong(lblTienThanhToan.getText()), makh, manv, mahd, MaKhuyenMai);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            ThanhToan_TT.this.dispose();
    });

      new TablePhong(mahd);
      new TableDichVu(mahd);
      new TableThietHai(mahd);

}

public class TablePhong {
    public TablePhong(int mahd) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            ArrayList<ChiTietPhieuThuePhong> list = new ArrayList<>();
            try {
                list = CoSoDuLieu.listctptp(mahd);
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            TableModel model = new TableModel();
            int maphieu;
            String rowstr;
            Date[] rowdate = new Date[2];
            double[] rowdb = new double[2];
            for (ChiTietPhieuThuePhong tt : list) {
                maphieu = tt.getMaphong();
                rowstr = tt.getLoaiPhong();
                rowdate[0] = tt.getNgayNhanPhong();
                rowdate[1] = tt.getNgayTraPhong();
                rowdb[0] = tt.getTien();
                rowdb[1] = tt.getGia();
                model.add(new ChiTietPhieuThuePhong(maphieu, rowstr, rowdate[0], rowdate[1], rowdb[0], rowdb[1]));
            }
            tablePhong = new JTable(model);
            tablePhong.setFillsViewportHeight(true);

            tablePhong.setShowGrid(false);
            tablePhong.setPreferredScrollableViewportSize(new Dimension(500, 70));
            tablePhong.setOpaque(true);

            tablePhong.setBackground(new Color(255, 255, 255));
            tablePhong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            tablePhong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
            tablePhong.getTableHeader().setOpaque(false);
            tablePhong.getTableHeader().setBackground(new Color(178, 34, 34));
            tablePhong.getTableHeader().setForeground(new Color(255, 255, 255));
            tablePhong.setSurrendersFocusOnKeystroke(true);

            JScrollPane scrollpane = new JScrollPane(tablePhong);
            scrollpane.setViewportView(tablePhong);
            scrollpane.setBounds(39, 209, 699, 75);

            contentPane.add(scrollpane);
        });
    }

    public class TableModel extends AbstractTableModel {

        private final List<ChiTietPhieuThuePhong> data;

        public TableModel() {
            data = new ArrayList<>();
        }

        @Override
        public String getColumnName(int column) {
            return switch (column) {
                case 0 -> "Mã Phòng";
                case 1 -> "Loại Phòng";
                case 2 -> "Ngày Nhận phòng";
                case 3 -> "Ngày trả phòng";
                case 4 -> "Thành tiền";
                case 5 -> "Giá";
                default -> null;
            };
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 0 -> Integer.class;
                case 2, 3 -> Date.class;
                case 1 -> String.class;
                case 4, 5 -> Double.class;
                default -> Object.class;
            };
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ChiTietPhieuThuePhong obj = data.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> obj.getMaphong();
                case 1 -> obj.getLoaiPhong();
                case 2 -> obj.getNgayNhanPhong();
                case 3 -> obj.getNgayTraPhong();
                case 4 -> obj.getTien();
                case 5 -> obj.getGia();
                default -> null;
            };
        }

        public void add(ChiTietPhieuThuePhong value) {
            int startIndex = getRowCount();
            data.add(value);
            fireTableRowsInserted(startIndex, getRowCount() - 1);
        }

    }

}

public class TableDichVu {
    public TableDichVu(int mahd) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            ArrayList<ChiTietDichVu> list = new ArrayList<>();
            try {
                list = CoSoDuLieu.listctdv(mahd);
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            TableModelDV model = new TableModelDV();
            String ten;
            double[] row = new double[2];
            int sl;

            for (ChiTietDichVu tt : list) {
                ten = tt.getTenDv();
                row[0] = tt.getGia();
                sl = tt.getSoLuong();
                row[1] = tt.getTien();
                model.add(new ChiTietDichVu(ten, row[0], sl, row[1]));
            }
            tableDichVu = new JTable(model);
            tableDichVu.setFillsViewportHeight(true);

            tableDichVu.setShowGrid(false);
            tableDichVu.setPreferredScrollableViewportSize(new Dimension(500, 70));
            tableDichVu.setOpaque(true);

            tableDichVu.setBackground(new Color(255, 255, 255));
            tableDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            tableDichVu.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
            tableDichVu.getTableHeader().setOpaque(false);
            tableDichVu.getTableHeader().setBackground(new Color(178, 34, 34));
            tableDichVu.getTableHeader().setForeground(new Color(255, 255, 255));
            tableDichVu.setSurrendersFocusOnKeystroke(true);

            JScrollPane scrollpane = new JScrollPane(tableDichVu);
            scrollpane.setViewportView(tableDichVu);
            scrollpane.setBounds(39, 342, 699, 75);

            contentPane.add(scrollpane);
        });
    }

    public class TableModelDV extends AbstractTableModel {

        private final List<ChiTietDichVu> data;

        public TableModelDV() {
            data = new ArrayList<>();
        }

        @Override
        public String getColumnName(int column) {
            return switch (column) {
                case 0 -> "Tên dịch vụ";
                case 1 -> "Giá";
                case 2 -> "Số lượng";
                case 3 -> "Thành tiền";
                default -> null;
            };
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 2 -> Integer.class;
                case 0 -> String.class;
                case 1, 3 -> Double.class;
                default -> Object.class;
            };
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ChiTietDichVu obj = data.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> obj.getTenDv();
                case 1 -> obj.getGia();
                case 2 -> obj.getSoLuong();
                case 3 -> obj.getTien();
                default -> null;
            };
        }

        public void add(ChiTietDichVu value) {
            int startIndex = getRowCount();
            data.add(value);
            fireTableRowsInserted(startIndex, getRowCount() - 1);
        }

    }

}

public class TableThietHai {
    public TableThietHai(int mahd) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            ArrayList<ChiTietThietHai> list = new ArrayList<>();
            try {
                list = CoSoDuLieu.listctth(mahd);
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            TableModelDV model = new TableModelDV();
            String ten;
            double[] row = new double[2];
            int sl;

            for (ChiTietThietHai tt : list) {
                ten = tt.getTenDv();
                row[0] = tt.getGia();
                sl = tt.getSoLuong();
                row[1] = tt.getTien();
                model.add(new ChiTietThietHai(ten, row[0], sl, row[1]));
            }
            tableThietHai = new JTable(model);
            tableThietHai.setFillsViewportHeight(true);

            tableThietHai.setShowGrid(false);
            tableThietHai.setPreferredScrollableViewportSize(new Dimension(500, 70));
            tableThietHai.setOpaque(true);

            tableThietHai.setBackground(new Color(255, 255, 255));
            tableThietHai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            tableThietHai.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
            tableThietHai.getTableHeader().setOpaque(false);
            tableThietHai.getTableHeader().setBackground(new Color(178, 34, 34));
            tableThietHai.getTableHeader().setForeground(new Color(255, 255, 255));
            tableThietHai.setSurrendersFocusOnKeystroke(true);

            JScrollPane scrollpane = new JScrollPane(tableThietHai);
            scrollpane.setViewportView(tableThietHai);
            scrollpane.setBounds(39, 475, 699, 75);

            contentPane.add(scrollpane);
        });
    }

    public class TableModelDV extends AbstractTableModel {

        private final List<ChiTietThietHai> data;

        public TableModelDV() {
            data = new ArrayList<>();
        }

        @Override
        public String getColumnName(int column) {
            return switch (column) {
                case 0 -> "Tên dịch vụ";
                case 1 -> "Giá";
                case 2 -> "Số lượng";
                case 3 -> "Thành tiền";
                default -> null;
            };
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 2 -> Integer.class;
                case 0 -> String.class;
                case 1, 3 -> Double.class;
                default -> Object.class;
            };
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ChiTietThietHai obj = data.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> obj.getTenDv();
                case 1 -> obj.getGia();
                case 2 -> obj.getSoLuong();
                case 3 -> obj.getTien();
                default -> null;
            };
        }

        public void add(ChiTietThietHai value) {
            int startIndex = getRowCount();
            data.add(value);
            fireTableRowsInserted(startIndex, getRowCount() - 1);
        }

    }

}
}


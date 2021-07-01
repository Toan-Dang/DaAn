package View.LichHen;


import Data.CoSoDuLieu;
import Model.Phong;
import View.CaiDat.QLPhong.CaiDat;
import View.ThanhToan.ThanhToanV;
import View.KhachHang.KhachHangV;
import View.TongQuan.TongQuan;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class LichHen_Them extends JFrame {
    int id;
    TableRowSorter<TableModel> rowSorter;
    JTable table;
    int[] getSelectedRow;
    private List<Integer> listLH = new ArrayList<>();
    private JPanel contentPane;
    private JTextField textFieldTimKiem;

    /**
     * Create the frame.
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public LichHen_Them(int id) throws ClassNotFoundException {
        this.id = id;
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1240, 700);
        this.setLocationRelativeTo(null);
        this.setTitle("Tong Quan");

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

        JLabel lblNewLabel = new JLabel("4T HOTEL");
        lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 17));
        lblNewLabel.setBounds(10, 0, 194, 47);
        panel.add(lblNewLabel);

        JLabel lblTenNhanVien = new JLabel(CoSoDuLieu.getTenNhanVien(id));
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
        btnTongQuan.addActionListener(e -> {
            this.dispose();
            try {
                new TongQuan(id);
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        btnTongQuan.setBackground(new Color(192, 192, 192));
        btnTongQuan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan.setBounds(0, 10, 170, 44);
        panel_1.add(btnTongQuan);

        JButton btnNhanVien = new JButton("Nhân viên");
        btnNhanVien.setBackground(new Color(192, 192, 192));
        btnNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnNhanVien.setBounds(0, 54, 170, 44);
        panel_1.add(btnNhanVien);

        JButton btnPhieuThuePhong_1 = new JButton("Khách hàng");
        btnPhieuThuePhong_1.addActionListener(e -> {
            this.dispose();
            try {
                new KhachHangV(id);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        btnPhieuThuePhong_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnPhieuThuePhong_1.setBackground(new Color(192, 192, 192));
        btnPhieuThuePhong_1.setBounds(0, 141, 170, 44);
        panel_1.add(btnPhieuThuePhong_1);

        JButton btnTongQuan_1 = new JButton("Thanh toán");
        btnTongQuan_1.addActionListener(e -> {
            this.dispose();
            try {
                new ThanhToanV(id);
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        btnTongQuan_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan_1.setBackground(new Color(192, 192, 192));
        btnTongQuan_1.setBounds(0, 97, 170, 44);
        panel_1.add(btnTongQuan_1);

        JButton btnTongQuan_1_1 = new JButton("Báo cáo");
        btnTongQuan_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan_1_1.setBackground(Color.LIGHT_GRAY);
        btnTongQuan_1_1.setBounds(0, 184, 170, 44);
        panel_1.add(btnTongQuan_1_1);

        JButton btnPhieuThuePhong_1_1 = new JButton("Cài đặt");
        btnPhieuThuePhong_1_1.addActionListener(e -> {
            this.dispose();
            try {
                new CaiDat(id);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        btnPhieuThuePhong_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnPhieuThuePhong_1_1.setBackground(Color.LIGHT_GRAY);
        btnPhieuThuePhong_1_1.setBounds(0, 228, 170, 44);
        panel_1.add(btnPhieuThuePhong_1_1);

        JButton btnPhieuThuePhong_1_1_1 = new JButton("L\u1ECBch H\u1EB9n");
        btnPhieuThuePhong_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnPhieuThuePhong_1_1_1.setBackground(Color.WHITE);
        btnPhieuThuePhong_1_1_1.setBounds(0, 271, 170, 44);
        panel_1.add(btnPhieuThuePhong_1_1_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(190, 67, 1009, 36);
        panel_2.setBackground(new Color(178, 34, 34));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Lịch hẹn");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(10, 0, 134, 36);
        panel_2.add(lblNewLabel_2);

        JButton btnDanhSach = new JButton("Danh sách");
        btnDanhSach.setForeground(Color.BLACK);
        btnDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnDanhSach.setBackground(Color.LIGHT_GRAY);
        btnDanhSach.setBounds(200, 102, 179, 36);
        contentPane.add(btnDanhSach);

        JButton btnThem = new JButton("Thêm");
        btnThem.setForeground(Color.BLACK);
        btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnThem.setBackground(Color.WHITE);
        btnThem.setBounds(378, 102, 179, 36);
        contentPane.add(btnThem);


        JLabel lblNgyNhnPhng = new JLabel("Ng\u00E0y nh\u1EADn ph\u00F2ng:");
        lblNgyNhnPhng.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblNgyNhnPhng.setBounds(212, 167, 128, 27);
        contentPane.add(lblNgyNhnPhng);

        lblNgyNhnPhng.setHorizontalAlignment(SwingConstants.CENTER);
        UtilDateModel modelngaynp = new UtilDateModel();
        Properties pNgNP = new Properties();
        pNgNP.put("text.today", "Today");
        pNgNP.put("text.month", "Month");
        pNgNP.put("text.year", "Year");
        modelngaynp.setSelected(true);
        JDatePanelImpl datePanelNgNP = new JDatePanelImpl(modelngaynp, pNgNP);
        JDatePickerImpl pickNGNP = new JDatePickerImpl(datePanelNgNP, new DateLabelFormatter());
        pickNGNP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pickNGNP.setBounds(350, 167, 179, 27);
        contentPane.add(pickNGNP);

        JLabel lblNgyTrPhng = new JLabel("Ng\u00E0y tr\u1EA3 ph\u00F2ng:");
        lblNgyTrPhng.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblNgyTrPhng.setBounds(634, 167, 128, 27);
        contentPane.add(lblNgyTrPhng);

        lblNgyTrPhng.setHorizontalAlignment(SwingConstants.CENTER);
        UtilDateModel modelngaytp = new UtilDateModel();
        Properties pNgtP = new Properties();
        pNgtP.put("text.today", "Today");
        pNgtP.put("text.month", "Month");
        pNgtP.put("text.year", "Year");
        modelngaytp.setSelected(true);
        JDatePanelImpl datePanelNgtP = new JDatePanelImpl(modelngaytp, pNgtP);
        JDatePickerImpl pickNGtP = new JDatePickerImpl(datePanelNgtP, new DateLabelFormatter());
        pickNGtP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pickNGtP.setBounds(758, 167, 179, 27);
        contentPane.add(pickNGtP);

        JLabel lblDanhSchPhng = new JLabel("Danh sách phòng khả dụng");
        lblDanhSchPhng.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblDanhSchPhng.setBounds(226, 220, 211, 27);
        contentPane.add(lblDanhSchPhng);

        JButton btnTim = new JButton("Tìm");
        btnTim.setFont(new Font("Times New Roman", Font.BOLD, 15));

        btnTim.setBounds(988, 162, 85, 36);
        contentPane.add(btnTim);

        JButton btnXuat = new JButton("xuất");
        btnXuat.addActionListener(e -> {
            getSelectedRow = table.getSelectedRows();
            for (int j : getSelectedRow) {
                System.out.println(table.getValueAt(j, 0).toString());
            }
        });
        btnXuat.setBounds(867, 583, 170, 52);
        contentPane.add(btnXuat);

        btnTim.addActionListener(e -> {
            new TableLichHen(pickNGNP, pickNGtP);

        });

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new LichHen_Them(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public class TableLichHen {

        public TableLichHen(JDatePickerImpl a, JDatePickerImpl b) {
            EventQueue.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                ArrayList<Phong> list = new ArrayList<>();
                try {
                    list = CoSoDuLieu.getDanhSachPhongKhaDung(a, b);
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                MyTableModel model = new MyTableModel();
                int[] row = new int[2];
                String[] row1 = new String[2];
                double gia;
                for (Phong phong : list) {
                    row[0] = phong.getMaPhong();
                    row1[0] = phong.getMaLoaiPhong();
                    gia = phong.getGia();
                    row[1] = phong.getSoLuongNguoiHienTai();
                    row1[1] = phong.getGhiChu();
                    model.add(new Phong(row[0], row1[0], gia, row[1], row1[1]));
                }
                table = new JTable(model);
                table.setFillsViewportHeight(true);
                table.setShowGrid(false);
                table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                rowSorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(rowSorter);
                table.setOpaque(true);

                table.setBackground(new Color(255, 255, 255));
                table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(178, 34, 34));
                table.getTableHeader().setForeground(new Color(255, 255, 255));
                table.setSurrendersFocusOnKeystroke(true);
                table.setRowSelectionAllowed(true);
                table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment(JLabel.CENTER);

                for (int columnIndex = 0; columnIndex < table.getColumnCount() - 2; columnIndex++) {
                    table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
                }

                JScrollPane scrollpane = new JScrollPane(table);
                scrollpane.setViewportView(table);
                scrollpane.setBounds(199, 257, 907, 316);

                contentPane.add(scrollpane);
            });
        }

        public class MyTableModel extends AbstractTableModel {

            private final List<Phong> data;

            public MyTableModel() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "MÃ PHÒNG";
                    case 1 -> "LOẠI PHÒNG";
                    case 2 -> "GIÁ PHÒNG";
                    case 3 -> "SỐ LƯỢNG NGƯỜI TRONG PHÒNG";
                    case 4 -> "GHI CHÚ";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0, 3 -> Integer.class;
                    case 1, 4 -> String.class;
                    case 2 -> Double.class;
                    default -> Object.class;
                };
            }

            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Phong obj = data.get(rowIndex);
                Object value = null;
                switch (columnIndex) {
                    case 0:
                        value = obj.getMaPhong();
                        break;
                    case 1:
                        value = obj.getMaLoaiPhong();
                        break;
                    case 2:
                        value = obj.getGia();
                        break;
                    case 3:
                        value = obj.getSoLuongNguoiHienTai();
                        break;
                    case 4:
                        value = obj.getGhiChu();
                        break;
                }
                return value;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                if (columnIndex == 5) {

                    Phong value = data.get(rowIndex);
                    fireTableCellUpdated(rowIndex, columnIndex);
                    //  remove(value);

                }
            }

            public void add(Phong value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 5;
            }

        }

    }

    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private final String datePattern = "dd--MM--yyyy";
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }

}

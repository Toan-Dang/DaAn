package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Data.CoSoDuLieu;
import Model.DangKiTruoc;
import Model.DichVu;
import View.TongQuan_DanhSachCheckIn.CheckIn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TongQuan_DanhSachCheckIn extends JFrame implements ActionListener {
    public static final String CheckIn = null;
    private JPanel contentPane;
    private JTable tableDichVu;

    private String[] columnNames = {
            "Tên khách hàng",
            "CMND",
            "SDT",
            "Loại khách hàng",
            "Ghi chú",
            "Mã phòng"
    };
    private Object data = new Object [][] {};
    private JTextField textField;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TongQuan_DanhSachCheckIn frame = new TongQuan_DanhSachCheckIn();
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
    public TongQuan_DanhSachCheckIn() throws ClassNotFoundException, SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 873, 493);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(178, 34, 34));
        panel.setBounds(10, 0, 839, 54);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Danh s\u00E1ch check in");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblNewLabel.setBounds(247, 10, 326, 34);
        panel.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 130, 839, 223);
        contentPane.add(scrollPane);

        tableDichVu = new JTable();
        tableDichVu.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "T\u00EAn kh\u00E1ch h\u00E0ng", "CMND", "SDT", "Lo\u1EA1i kh\u00E1ch h\u00E0ng", "Ghi ch\u00FA", "M\u00E3 ph\u00F2ng"
                }
        ));
        tableDichVu.getColumnModel().getColumn(0).setPreferredWidth(108);

        tableDichVu.setModel(new DefaultTableModel( (Object[][]) data, columnNames));
        showListCheckIn(listcheckin());

        scrollPane.setViewportView(tableDichVu);

        tableDichVu.setBackground(new Color(255, 255, 255));
        tableDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tableDichVu.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
        tableDichVu.getTableHeader().setOpaque(false);
        tableDichVu.getTableHeader().setBackground(new Color(178, 34, 34));
        tableDichVu.getTableHeader().setForeground(new Color(255, 255, 255));
        tableDichVu.setSurrendersFocusOnKeystroke(true);

        JButton btnNewButton = new JButton("Quay lại");
        btnNewButton.addActionListener(e-> this.dispose());
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(178, 34, 34));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setBounds(711, 378, 138, 48);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Tìm kiếm:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(78, 84, 100, 36);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(161, 89, 269, 29);
        contentPane.add(textField);
        textField.setColumns(10);
/*
        JTextField searchfield = new JTextField();
        searchfield.setBounds(161, 89, 269, 29);
        contentPane.add(searchfield);
        searchfield.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchfield.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchfield.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });


 */
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);


        for (int columnIndex = 0; columnIndex < tableDichVu.getColumnCount() - 2 ; columnIndex++)
        {
            tableDichVu.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        this.setVisible(true);
        tableDichVu.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try {
                    getMaPhong();
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    public void showListCheckIn(List<CheckIn> list) throws ClassNotFoundException
    {
        int size = list.size();
        Object [][] checkIn = new Object[size][5];
        for (int i = 0; i < size; i++)
        {
            checkIn[i][0] = list.get(i).getTenKhachHang();
            checkIn[i][1] = list.get(i).getCMND();
            checkIn[i][2] = list.get(i).getSDT();
            checkIn[i][3] = list.get(i).getLoaiKhachHang();
            checkIn[i][4] = list.get(i).getGhiChu();
        }
        this.tableDichVu.setModel(new DefaultTableModel(checkIn, columnNames));
    }

    public void getMaPhong() throws ClassNotFoundException
    {
        JComboBox addMaPhong = new JComboBox();
        CoSoDuLieu.getMaPhong(addMaPhong,tableDichVu.getValueAt(tableDichVu.getSelectedRow(), 1));

        DefaultCellEditor maPhong = new DefaultCellEditor(addMaPhong);
        this.tableDichVu.getColumnModel().getColumn(5).setCellEditor(maPhong);
    }

    public ArrayList<CheckIn> listcheckin() throws ClassNotFoundException, SQLException {
        ArrayList<CheckIn> listci = new ArrayList<>();
        Connection connection =CoSoDuLieu.getConnect();
        String query = "SELECT khachhang.TenKh,khachhang.CMND, khachhang.SDT ,loaikh.TENLKH"
                + " FROM khachhang, loaikh, phieu_thue_phong "
                + " where phieu_thue_phong.makh = khachhang.makh"
                + " and phieu_thue_phong.tinhtrangthanhtoan = 0"
                + " and khachhang.malkh = loaikh.malkh";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String tenKhachHang = rs.getString(1);
                String cmnd = rs.getString(2);
                String sdt = rs.getString(3);
                String loailkh = rs.getString(4);
                listci.add(new CheckIn(tenKhachHang, cmnd, sdt, loailkh," "));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listci;
    }

    public class CheckIn
    {
        private String tenKhachHang;
        private String CMND;
        private String SDT;
        private String loaiKhachHang;
        private String GhiChu;
        /**
         * @return the tenKhachHang
         */


        public String getTenKhachHang() {
            return tenKhachHang;
        }
        public CheckIn(String tenKhachHang, String cMND, String sDT, String loaiKhachHang, String ghiChu) {
            super();
            this.tenKhachHang = tenKhachHang;
            CMND = cMND;
            SDT = sDT;
            this.loaiKhachHang = loaiKhachHang;
            GhiChu = ghiChu;
        }
        /**
         * @param tenKhachHang the tenKhachHang to set
         */
        public void setTenKhachHang(String tenKhachHang) {
            this.tenKhachHang = tenKhachHang;
        }
        /**
         * @return the cMND
         */
        public String getCMND() {
            return CMND;
        }
        /**
         * @param cMND the cMND to set
         */
        public void setCMND(String cMND) {
            CMND = cMND;
        }
        /**
         * @return the sDT
         */
        public String getSDT() {
            return SDT;
        }
        /**
         * @param sDT the sDT to set
         */
        public void setSDT(String sDT) {
            SDT = sDT;
        }
        /**
         * @return the loaiKhachHang
         */
        public String getLoaiKhachHang() {
            return loaiKhachHang;
        }
        /**
         * @param loaiKhachHang the loaiKhachHang to set
         */
        public void setLoaiKhachHang(String loaiKhachHang) {
            this.loaiKhachHang = loaiKhachHang;
        }
        /**
         * @return the ghiChu
         */
        public String getGhiChu() {
            return GhiChu;
        }
        /**
         * @param ghiChu the ghiChu to set
         */
        public void setGhiChu(String ghiChu) {
            GhiChu = ghiChu;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

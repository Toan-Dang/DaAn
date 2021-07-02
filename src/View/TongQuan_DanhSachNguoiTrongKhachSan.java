package View;
import java.awt.BorderLayout;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Data.CoSoDuLieu;
import Model.DSNguoiTrongPhong;
import Model.DangKiTruoc;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class TongQuan_DanhSachNguoiTrongKhachSan extends JFrame implements ActionListener{
    int check = 1 ;
    private JPanel contentPane;
    private JTextField textFieldTenKhachHang;
    private JTextField textCMND;
    private JTextField textQuocTich;
    private JTextField textSDT;
    private JTextField textEmail;
    private JTextField textDiaChi;
    private JTable table;

    String [] columnName = {"Tên khách hàng",
            "Mã phòng",
            "Giới tính",
            "SDT",
            "Ngày sinh",
            "Quốc tịch",
            "CMND",
            "Địa chỉ",
            "Email",
            "Ngày đến"
    };

    private Object data = new Object [][] {};


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TongQuan_DanhSachNguoiTrongKhachSan frame = new TongQuan_DanhSachNguoiTrongKhachSan();
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
    @SuppressWarnings("deprecation")
    public TongQuan_DanhSachNguoiTrongKhachSan() throws ClassNotFoundException, SQLException  {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 10, 1063, 808);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(178, 34, 34));
        panel.setBounds(10, 10, 1029, 66);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Danh s\u00E1ch ng\u01B0\u1EDDi trong kh\u00E1ch s\u1EA1n");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblNewLabel.setBounds(215, 10, 636, 46);
        panel.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 86, 1029, 427);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel( (Object[][]) data, columnName));

        table.setBackground(new Color(255, 255, 255));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(178, 34, 34));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.setSurrendersFocusOnKeystroke(true);



        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(245, 245, 245));
        panel_1.setBounds(10, 533, 1039, 228);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng: ");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 10, 109, 43);
        panel_1.add(lblNewLabel_1);

        textFieldTenKhachHang = new JTextField();
        textFieldTenKhachHang.setBounds(113, 15, 195, 35);
        panel_1.add(textFieldTenKhachHang);
        textFieldTenKhachHang.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("CMND:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(338, 10, 109, 43);
        panel_1.add(lblNewLabel_1_1);

        textCMND = new JTextField();
        textCMND.setColumns(10);
        textCMND.setBounds(441, 15, 195, 35);
        panel_1.add(textCMND);

        JLabel lblNewLabel_1_2 = new JLabel("Ng\u00E0y sinh:");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(666, 10, 109, 43);
        panel_1.add(lblNewLabel_1_2);

        textQuocTich = new JTextField();
        textQuocTich.setColumns(10);
        textQuocTich.setBounds(113, 68, 195, 35);
        panel_1.add(textQuocTich);

        JLabel lblNewLabel_1_3 = new JLabel("Qu\u1ED1c t\u1ECBch");
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(10, 63, 109, 43);
        panel_1.add(lblNewLabel_1_3);

        textSDT = new JTextField();
        textSDT.setColumns(10);
        textSDT.setBounds(441, 65, 195, 35);
        panel_1.add(textSDT);

        JLabel lblNewLabel_1_4 = new JLabel("SDT");
        lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_4.setBounds(338, 60, 109, 43);
        panel_1.add(lblNewLabel_1_4);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(769, 65, 195, 35);
        panel_1.add(textEmail);

        JLabel lblNewLabel_1_5 = new JLabel("Email");
        lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_5.setBounds(666, 60, 109, 43);
        panel_1.add(lblNewLabel_1_5);

        textDiaChi = new JTextField();
        textDiaChi.setColumns(10);
        textDiaChi.setBounds(113, 122, 195, 35);
        panel_1.add(textDiaChi);

        JLabel lblNewLabel_1_6 = new JLabel("\u0110\u1ECBa ch\u1EC9");
        lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_6.setBounds(10, 117, 109, 43);
        panel_1.add(lblNewLabel_1_6);

        JLabel lblNewLabel_1_7 = new JLabel("Gi\u1EDBi t\u00EDnh:");
        lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_7.setBounds(338, 114, 109, 43);
        panel_1.add(lblNewLabel_1_7);

        JLabel lblNewLabel_1_8 = new JLabel("M\u00E3 ph\u00F2ng");
        lblNewLabel_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_8.setBounds(666, 110, 109, 43);
        panel_1.add(lblNewLabel_1_8);

        JButton btnThem = new JButton("Th\u00EAm");
        btnThem.setBackground(new Color(65, 105, 225));
        btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnThem.setBounds(926, 169, 103, 35);
        panel_1.add(btnThem);



        JButton btnXa = new JButton("X\u00F3a");


        btnXa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnXa.setBackground(new Color(220, 20, 60));
        btnXa.setBounds(800, 169, 103, 35);
        panel_1.add(btnXa);
        btnXa.addActionListener(e->{
            try {
                CoSoDuLieu.XoaNguoiTrongPhong((Date)table.getValueAt(table.getSelectedColumn(),9),(String) table.getValueAt(table.getSelectedColumn(),6));
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            this.dispose();
            try {
                new TongQuan_DanhSachNguoiTrongKhachSan();
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        JButton btnSa = new JButton("S\u1EEDa");
        btnSa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnSa.setBackground(new Color(72, 209, 204));
        btnSa.setBounds(672, 169, 103, 35);
        panel_1.add(btnSa);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        comboBox.setBounds(769, 110, 195, 35);
        panel_1.add(comboBox);
        CoSoDuLieu.getMaPhong(comboBox);

        JRadioButton rdbtnNam = new JRadioButton("Nam");
        rdbtnNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        rdbtnNam.setBounds(442, 129, 62, 21);
        panel_1.add(rdbtnNam);

        JRadioButton rdbtnNu = new JRadioButton("N\u1EEF");
        rdbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        rdbtnNu.setBounds(536, 129, 62, 21);
        panel_1.add(rdbtnNu);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnNam);
        bg.add(rdbtnNu);

        UtilDateModel modelngaynp = new UtilDateModel();
        Properties pNgNP = new Properties();
        pNgNP.put("text.today", "Today");
        pNgNP.put("text.month", "Month");
        pNgNP.put("text.year", "Year");
        modelngaynp.setSelected(true);
        JDatePanelImpl datePanelNgNP = new JDatePanelImpl(modelngaynp, pNgNP);
        JDatePickerImpl pickNGS = new JDatePickerImpl(datePanelNgNP, new DateLabelFormatter());
        pickNGS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pickNGS.setBounds(766, 15, 198, 38);
        panel_1.add(pickNGS);
        this.setVisible(true);
        showListNguoiTrongPhong(CoSoDuLieu.getLishNguoiTrongPhong());



        btnThem.addActionListener(e->{
            if(check == 1) {
                String gioiTinh= "";
                if(rdbtnNam.isSelected())
                {
                    gioiTinh = "NAM";
                }
                if(rdbtnNu.isSelected())
                {
                    gioiTinh = "NU";
                }
                String maphong =comboBox.getSelectedItem().toString();
                try {
                    CoSoDuLieu.ThemNguoiTrongPhong(this.textFieldTenKhachHang.getText(), this.textCMND.getText(), this.textDiaChi.getText(), this.textEmail.getText(), this.textQuocTich.getText(), this.textSDT.getText(),gioiTinh,pickNGS, maphong  );
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                this.dispose();
                try {
                    new TongQuan_DanhSachNguoiTrongKhachSan();
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            else
            {
                this.dispose();
                try {
                    new TongQuan_DanhSachNguoiTrongKhachSan();
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                check = 1;
            }
        });

        btnSa.addActionListener(e->{
            if(check == 2)
            {
                try {
                    CoSoDuLieu.XoaNguoiTrongPhong((Date)table.getValueAt(table.getSelectedColumn(),9),(String) table.getValueAt(table.getSelectedColumn(),6));
                } catch (ClassNotFoundException | SQLException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }

                System.out.print(this.textFieldTenKhachHang.getText());
                String gioiTinh = "NAM";
                if(rdbtnNam.isSelected())
                {
                    gioiTinh = "NAM";
                }
                if(rdbtnNu.isSelected())
                {
                    gioiTinh = "NU";
                }
                String maphong =comboBox.getSelectedItem().toString();
                try {
                    CoSoDuLieu.ThemNguoiTrongPhong(this.textFieldTenKhachHang.getText(), this.textCMND.getText(), this.textDiaChi.getText(), this.textEmail.getText(), this.textQuocTich.getText(), this.textSDT.getText(),gioiTinh,pickNGS, maphong  );
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                this.dispose();
                try {
                    new TongQuan_DanhSachNguoiTrongKhachSan();
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        MouseListener tableMouseListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String newEntry = (String )table.getValueAt(table.getSelectedRow(), 6);
                try {
                    CoSoDuLieu.setNguoiTrongPhong(textFieldTenKhachHang,textCMND,textDiaChi,textEmail,textQuocTich,textSDT,rdbtnNam,rdbtnNu,modelngaynp,comboBox,newEntry,pickNGS  );
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                check = 2;

            }
        };
        table.addMouseListener(tableMouseListener);/////////////////
    }

    public void showListNguoiTrongPhong(List<DSNguoiTrongPhong> list)
    {
        int size = list.size();
        Object [][] NguoiTrongPhong = new Object[size][10];
        for (int i = 0; i < size; i++)
        {
            NguoiTrongPhong[i][0] = list.get(i).getTenKH();
            NguoiTrongPhong[i][1] = list.get(i).getMaPhong();
            NguoiTrongPhong[i][2] = list.get(i).getGioiTinh();
            NguoiTrongPhong[i][3] = list.get(i).getSDT();
            NguoiTrongPhong[i][4] = list.get(i).getNgaySinh();
            NguoiTrongPhong[i][5] = list.get(i).getQuocTich();
            NguoiTrongPhong[i][6] = list.get(i).getCMND();
            NguoiTrongPhong[i][7] = list.get(i).getDiaChi();
            NguoiTrongPhong[i][8] = list.get(i).getEmail();
            NguoiTrongPhong[i][9] = list.get(i).getNgayDen();
        }
        this.table.setModel(new DefaultTableModel(NguoiTrongPhong, columnName));
    }
    public static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

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
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

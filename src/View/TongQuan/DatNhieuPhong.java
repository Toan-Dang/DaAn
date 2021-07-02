package View.TongQuan;


import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Data.CoSoDuLieu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class DatNhieuPhong extends JFrame {

    List<Integer> id;

    JPanel contentPane;
    private final JTextField textTen;
    private final JTextField textCMND;
    private final JTextField textDiaChi;
    private final JTextField textSDT;



    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new TongQuan_ThongTinPhong_DatPhong(8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    int makh;
    int manv = 1;
    public DatNhieuPhong(List<Integer> id)  {
        this.id = id;
        this.setVisible(true);
        this.setBounds(100, 100, 910, 501);
        this.setLocationRelativeTo(null);
        this.setTitle("Thông tin phòng số " + id.toString());
        System.out.println(id.size());
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(255, 255, 255));

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(178, 34, 34));
        panel_1.setBounds(10, 10, 876, 53);
        contentPane.add(panel_1);

        JLabel lblPhng = new JLabel("Phòng:");
        lblPhng.setBounds(100, 0, 223, 51);
        panel_1.add(lblPhng);
        lblPhng.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhng.setForeground(new Color(255, 255, 255));
        lblPhng.setFont(new Font("Times New Roman", Font.BOLD, 30));


        JLabel lblMaPhong = new JLabel(String.valueOf(id.toString()));
        lblMaPhong.setBounds(200, 0, 700, 51);
        panel_1.add(lblMaPhong);
        lblMaPhong.setHorizontalAlignment(SwingConstants.CENTER);
        lblMaPhong.setForeground(new Color(255, 255, 255));
        lblMaPhong.setFont(new Font("Times New Roman", Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setBounds(10, 63, 876, 384);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnCheck = new JButton("Check");
        btnCheck.setBounds(423, 29, 92, 30);
        panel.add(btnCheck);

        JLabel lblCmnd = new JLabel("CMND:");
        lblCmnd.setBounds(38, 10, 78, 67);
        panel.add(lblCmnd);
        lblCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCmnd.setFont(new Font("Times New Roman", Font.BOLD, 15));

        textCMND = new JTextField();
        textCMND.setBounds(150, 28, 252, 36);
        panel.add(textCMND);
        textCMND.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textCMND.setColumns(10);

        JLabel lblTn = new JLabel("Tên:");
        lblTn.setBounds(39, 64, 100, 67);
        panel.add(lblTn);
        lblTn.setHorizontalAlignment(SwingConstants.CENTER);
        lblTn.setFont(new Font("Times New Roman", Font.BOLD, 15));

        textTen = new JTextField();
        textTen.setBounds(150, 79, 252, 36);
        panel.add(textTen);
        textTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textTen.setColumns(10);

        JButton btnTao = new JButton("Tạo ");
        btnTao.setBounds(216, 309, 129, 51);
        panel.add(btnTao);
        btnTao.setForeground(new Color(255, 255, 255));
        btnTao.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnTao.setBackground(new Color(0, 128, 128));

        JButton btnQuayLai = new JButton("Quay l\u1EA1i");
        btnQuayLai.setBounds(536, 309, 129, 51);
        panel.add(btnQuayLai);
        btnQuayLai.setForeground(new Color(255, 255, 255));
        btnQuayLai.setBackground(new Color(220, 20, 60));
        btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 15));

        JLabel lblGiiTnh = new JLabel("giới tính:");
        lblGiiTnh.setHorizontalAlignment(SwingConstants.CENTER);
        lblGiiTnh.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblGiiTnh.setBounds(39, 116, 100, 67);
        panel.add(lblGiiTnh);

        JLabel lblaCh = new JLabel("Địa chỉ:");
        lblaCh.setHorizontalAlignment(SwingConstants.CENTER);
        lblaCh.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblaCh.setBounds(39, 170, 100, 67);
        panel.add(lblaCh);

        JLabel lblNgyNp = new JLabel("Ngày NP:");
        lblNgyNp.setHorizontalAlignment(SwingConstants.CENTER);
        lblNgyNp.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNgyNp.setBounds(39, 232, 100, 67);
        panel.add(lblNgyNp);

        JLabel lblSdt = new JLabel("SDT:");
        lblSdt.setHorizontalAlignment(SwingConstants.CENTER);
        lblSdt.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblSdt.setBounds(435, 64, 100, 67);
        panel.add(lblSdt);

        JLabel lblNgyTp = new JLabel("Ngày TP:");
        lblNgyTp.setHorizontalAlignment(SwingConstants.CENTER);
        lblNgyTp.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNgyTp.setBounds(435, 232, 100, 67);
        panel.add(lblNgyTp);

        JLabel lblNgySinh = new JLabel("Ngày sinh:");
        lblNgySinh.setHorizontalAlignment(SwingConstants.CENTER);
        lblNgySinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNgySinh.setBounds(435, 116, 100, 67);
        panel.add(lblNgySinh);

        textDiaChi = new JTextField();
        textDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textDiaChi.setColumns(10);
        textDiaChi.setBounds(150, 182, 252, 36);
        panel.add(textDiaChi);

        UtilDateModel modelngaynp = new UtilDateModel();
        Properties pNgNP = new Properties();
        pNgNP.put("text.today", "Today");
        pNgNP.put("text.month", "Month");
        pNgNP.put("text.year", "Year");
        modelngaynp.setSelected(true);
        JDatePanelImpl datePanelNgNP = new JDatePanelImpl(modelngaynp, pNgNP);
        JDatePickerImpl pickNGNP = new JDatePickerImpl(datePanelNgNP, new DateLabelFormatter());
        pickNGNP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pickNGNP.setBounds(150, 252, 252, 36);
        panel.add(pickNGNP);

        textSDT = new JTextField();
        textSDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textSDT.setColumns(10);
        textSDT.setBounds(563, 79, 252, 36);
        panel.add(textSDT);

        UtilDateModel modelngaysinh = new UtilDateModel();
        Properties pNgSinh = new Properties();
        pNgSinh.put("text.today", "Today");
        pNgSinh.put("text.month", "Month");
        pNgSinh.put("text.year", "Year");
        modelngaysinh.setSelected(true);
        JDatePanelImpl datePanelNgSinh = new JDatePanelImpl(modelngaysinh, pNgSinh);
        JDatePickerImpl pickngaysinh = new JDatePickerImpl(datePanelNgSinh, new DateLabelFormatter());
        pickngaysinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pickngaysinh.setBounds(563, 125, 252, 36);
        panel.add(pickngaysinh);

        UtilDateModel modelngaytraphong = new UtilDateModel();
        Properties pNGTP = new Properties();
        pNGTP.put("text.today", "Today");
        pNGTP.put("text.month", "Month");
        pNGTP.put("text.year", "Year");
        modelngaytraphong.setSelected(true);
        JDatePanelImpl datePanelNGTP = new JDatePanelImpl(modelngaytraphong, pNGTP);
        JDatePickerImpl pickNGTP = new JDatePickerImpl(datePanelNGTP, new TongQuan_ThongTinPhong_DatPhong.DateLabelFormatter());
        pickNGTP.setBounds(563, 252, 252, 36);
        pickNGTP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel.add(pickNGTP);

        JRadioButton rdbtnNam = new JRadioButton("Nam");
        rdbtnNam.setBounds(150, 139, 69, 21);
        panel.add(rdbtnNam);
        rdbtnNam.setBackground(new Color(240,240,240));
        rdbtnNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JRadioButton rdbtnNu = new JRadioButton("Nữ");
        rdbtnNu.setBounds(263, 139, 44, 21);
        panel.add(rdbtnNu);
        rdbtnNu.setBackground(new Color(240,240,240));
        rdbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnNam);
        bg.add(rdbtnNu);
        final String[] gt = new String[1];
        rdbtnNam.addItemListener(e -> gt[0] = "NAM");
        rdbtnNu.addItemListener(e -> gt[0] = "NU");

        btnQuayLai.addActionListener(e -> this.dispose());

        btnCheck.addActionListener(e -> {
            try {
                makh = CoSoDuLieu.Check(textCMND.getText());
            } catch (ClassNotFoundException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            if(makh > 0) {
                try {
                    CoSoDuLieu.GetInfoKH_Makh(makh,textTen,textDiaChi,textSDT,rdbtnNam,rdbtnNu,
                            modelngaysinh, pNgSinh);
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng thành công" );
            }
            else {
                JOptionPane.showMessageDialog(null, "Không có thông tin khách hàng" );
            }
        });
        btnTao.addActionListener(e -> {
            if(makh > 0)
                try {
                    CoSoDuLieu.CreateWithAvailabeKH_multi(id,pickNGNP, pickNGTP,makh,manv);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            else
                try {
                    CoSoDuLieu.CreateWithNewKH_multi(id,pickNGNP, pickNGTP,manv,textTen,gt[0],pickngaysinh,
                            textSDT,textDiaChi,textCMND);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
        });
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
}

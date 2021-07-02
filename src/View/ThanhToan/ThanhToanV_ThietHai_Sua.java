package View.ThanhToan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.CoSoDuLieu;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class ThanhToanV_ThietHai_Sua extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     * @throws ClassNotFoundException
     */
    public ThanhToanV_ThietHai_Sua(int mapt,int madv, int maphong, int soluong) throws ClassNotFoundException {
        this.setVisible(true);
        setTitle("S\u1EEDa d\u1ECBch v\u1EE5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 897, 140);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("T\u00EAn thi\u1EC7t h\u1EA1i:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblNewLabel.setBounds(22, 10, 92, 36);
        contentPane.add(lblNewLabel);

        JComboBox comboBox = new JComboBox();
        CoSoDuLieu.getthiethaiList(comboBox);
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        comboBox.setBounds(140, 10, 145, 36);
        contentPane.add(comboBox);

        JLabel lblMPhng = new JLabel("M\u00E3 ph\u00F2ng:");
        lblMPhng.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblMPhng.setBounds(548, 10, 92, 36);
        contentPane.add(lblMPhng);

        JComboBox comboBox_1 = new JComboBox();
        CoSoDuLieu.getListPhong_PTP(comboBox_1, mapt);
        comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        comboBox_1.setBounds(635, 11, 92, 36);
        contentPane.add(comboBox_1);

        JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
        lblSLng.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        lblSLng.setBounds(342, 10, 74, 36);
        contentPane.add(lblSLng);

        textField = new JTextField(soluong);
        textField.setBounds(426, 10, 69, 36);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("C\u1EADp nh\u1EADt");
        btnNewButton.setBackground(new Color(0, 128, 128));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton.setBounds(735, 51, 107, 42);

        btnNewButton.addActionListener(e->{
            this.dispose();
            try {
                CoSoDuLieu.SuaPhieuThu(CoSoDuLieu.getMaPhieuThu(mapt), madv, soluong, maphong, CoSoDuLieu.getMaThietHai(comboBox.getSelectedItem().toString()), textField.getText(),comboBox_1.getSelectedItem().toString() );
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                new ThanhToanV_ThietHai(mapt);
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        contentPane.add(btnNewButton);
    }
}

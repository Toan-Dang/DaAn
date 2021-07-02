package View.TongQuan;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Data.CoSoDuLieu;
import Model.DangKiTruoc;
import Model.DichVu;
import Model.Phong;
import View.CaiDat.QLPhong.ThongTinPhong;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TongQuan_ThongTinPhong_DoiPhong extends JFrame implements ActionListener {
    int id;
    private JPanel contentPane;
    private JTable tableDichVu;

    private String[] columnNames = {
            "Mã Phòng",
            "Tên Loại Phòng",
            "Số lượng tối đa",
            "Gía"
    };
    private Object data = new Object [][] {};


    /**
     * Launch the application.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        TongQuan_ThongTinPhong_DoiPhong frame = new TongQuan_ThongTinPhong_DoiPhong(1);
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public TongQuan_ThongTinPhong_DoiPhong(int id) throws ClassNotFoundException, SQLException {
        this.id =id;
        setBounds(800, 200, 731, 379);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(178, 34, 34));
        panel.setBounds(10, 0, 697, 54);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Danh s\u00E1ch ph\u00F2ng tr\u1ED1ng");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblNewLabel.setBounds(176, 10, 326, 36);
        panel.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 89, 697, 158);
        contentPane.add(scrollPane);

        tableDichVu = new JTable();
        tableDichVu.setModel(new DefaultTableModel(
                new Object[][] {
                        {},
                },
                new String[] {
                }
        ));

        tableDichVu.setModel(new DefaultTableModel( (Object[][]) data, columnNames));
        showListPhong(CoSoDuLieu.listphongtrong());

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
        btnNewButton.setBounds(545, 285, 126, 35);
        contentPane.add(btnNewButton);

        JButton btnDoi = new JButton("Đổi");
        btnDoi.setForeground(Color.WHITE);
        btnDoi.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDoi.setBackground(new Color(0, 128, 128));
        btnDoi.setBounds(395, 286, 126, 35);
        contentPane.add(btnDoi);
        btnDoi.addActionListener(e -> {
            this.dispose();
            try {
                CoSoDuLieu.DoiPhong((int)tableDichVu.getValueAt(tableDichVu.getSelectedRow(), 0), id);
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                new ThongTinPhong((int)tableDichVu.getValueAt(tableDichVu.getSelectedRow(), 0));
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tableDichVu.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);


        for (int columnIndex = 0; columnIndex < tableDichVu.getColumnCount() - 2 ; columnIndex++)
        {
            tableDichVu.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        this.setVisible(true);
    }

    public void showListPhong(List<Phong> list)
    {
        int size = list.size();
        Object [][] Phong = new Object[size][4];
        for (int i = 0; i < size; i++)
        {
            Phong[i][0] = list.get(i).getMaPhong();
            Phong[i][1] = list.get(i).getMaLoaiPhong();
            Phong[i][2] = list.get(i).getGia();
            Phong[i][3] = list.get(i).getSoLuongNguoiHienTai();
        }
        this.tableDichVu.setModel(new DefaultTableModel(Phong, columnNames));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

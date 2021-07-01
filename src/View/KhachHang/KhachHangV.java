package View.KhachHang;


import Model.KhachHang;
import Data.CoSoDuLieu;
import View.ThanhToan.BaoCao;
import View.CaiDat.QLPhong.CaiDat;
import View.ThanhToan.ThanhToanV;
import View.NhanVien.NhanVienV;
import View.TongQuan.TongQuan;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

public class KhachHangV extends JFrame {
	int id;
    private JPanel contentPane;
    TableRowSorter<TableModel> rowSorter;
    JTable table;
    private JButton btnNhanVien;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new KhachHangV(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public KhachHangV(int id) throws ClassNotFoundException  {
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

        JLabel lblNewLabel = new JLabel("HOWARD HOTEL");
        lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 17));
        lblNewLabel.setBounds(10, 0, 300, 47);
        lblNewLabel.setForeground(Color.white);
        panel.add(lblNewLabel);


        JLabel lblNewLabel_1 = new JLabel(CoSoDuLieu.getTenNhanVien(id));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setBounds(974, 10, 194, 27);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 58, 170, 595);
        panel_1.setBackground(new Color(255, 255, 255));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnTongQuan = new JButton("T\u1ED5ng quan");
        btnTongQuan.addActionListener(e -> {this.dispose();
        try {
			new TongQuan(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
        btnTongQuan.setBackground(new Color(192, 192, 192));
        btnTongQuan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan.setBounds(0, 10, 170, 44);
        panel_1.add(btnTongQuan);

        btnNhanVien = new JButton("Nhân Viên");
        btnNhanVien.addActionListener(e -> {this.dispose();
        try {
			new NhanVienV(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
        btnNhanVien.setBackground(new Color(192, 192, 192));
        btnNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnNhanVien.setBounds(0, 54, 170, 44);
        panel_1.add(btnNhanVien);

        JButton btnPhieuThuePhong_1 = new JButton("Khách hàng");
        btnPhieuThuePhong_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnPhieuThuePhong_1.setBackground(new Color(255, 255, 255));
        btnPhieuThuePhong_1.setBounds(0, 141, 170, 44);
        panel_1.add(btnPhieuThuePhong_1);

        JButton btnTongQuan_1 = new JButton("Thanh toán");
        btnTongQuan_1.addActionListener(e -> {this.dispose();
            try {
                new ThanhToanV(id);
            } catch (ClassNotFoundException | SQLException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        btnTongQuan_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan_1.setBackground(new Color(192, 192, 192));
        btnTongQuan_1.setBounds(0, 97, 170, 44);
        panel_1.add(btnTongQuan_1);

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
        JButton btnPhieuThuePhong_1_1 = new JButton("Cài đặt");
        btnPhieuThuePhong_1_1.addActionListener(e -> {this.dispose();
        try {
			new CaiDat(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
        btnPhieuThuePhong_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnPhieuThuePhong_1_1.setBackground(Color.LIGHT_GRAY);
        btnPhieuThuePhong_1_1.setBounds(0, 228, 170, 44);
        panel_1.add(btnPhieuThuePhong_1_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(190, 67, 1009, 36);
        panel_2.setBackground(new Color(178, 34, 34));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Khách Hàng");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(39, 0, 134, 36);
        panel_2.add(lblNewLabel_2);


        JLabel lblNewLabel_3 = new JLabel("Danh sách khách hàng");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel_3.setBounds(190, 113, 179, 36);
        contentPane.add(lblNewLabel_3);

        JLabel lblTimKiem = new JLabel("Tìm kiếm");
        lblTimKiem.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblTimKiem.setBounds(190, 159, 99, 27);
        contentPane.add(lblTimKiem);

        JTextField searchfield = new JTextField();
        searchfield.setBounds(261, 160, 291, 27);
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

        JButton btnNewButton_7_1 = new JButton("Thêm +");
        btnNewButton_7_1.setForeground(Color.WHITE);
        btnNewButton_7_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton_7_1.setBackground(new Color(0, 139, 139));
        btnNewButton_7_1.setBounds(651, 159, 99, 27);
        contentPane.add(btnNewButton_7_1);


        new TableKhachHang();
    }

    public class TableKhachHang {

        public TableKhachHang() {
            EventQueue.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                ArrayList<KhachHang> list = new ArrayList<>();
				try {
					list = CoSoDuLieu.listKhachHang();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                MyTableModel model = new MyTableModel();
                int makh;
                String[] str = new String[5];
                for (KhachHang kh : list) {
                   // row[0] = kh.getMaPhong();
                    makh = kh.getMaKH();
                    str[0] = kh.getUserName();
                    str[1] = kh.getTenKH();
                    str[2]= kh.getMaLKH();
                    str[3] = kh.getSDT();
                    str[4] = kh.getCMND();
                    model.add(new KhachHang(makh,str[0],str[1],str[2],str[3],str[4]));
                }
                table = new JTable(model);
                AcceptRejectRenderer renderer = new AcceptRejectRenderer();
                table.getColumnModel().getColumn(6).setCellRenderer(renderer);
                table.getColumnModel().getColumn(6).setCellEditor(new AcceptRejectEditor());
                table.setRowHeight(renderer.getTableCellRendererComponent(table, null, true, true, 0, 0).getPreferredSize().height);
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
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment(JLabel.CENTER);

                JTableHeader header = table.getTableHeader();
                header.setDefaultRenderer(new HeaderRenderer(table));

                for (int columnIndex = 0; columnIndex < table.getColumnCount() - 1 ; columnIndex++)
                {
                    table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
                }
                JScrollPane scrollpane = new JScrollPane(table);
                scrollpane.setViewportView(table);
                scrollpane.setBounds(190, 197, 1000, 406);

                contentPane.add(scrollpane);
            });
        }
        private class HeaderRenderer implements TableCellRenderer {

            DefaultTableCellRenderer renderer;

            public HeaderRenderer(JTable table) {
                renderer = (DefaultTableCellRenderer)
                        table.getTableHeader().getDefaultRenderer();
                renderer.setHorizontalAlignment(JLabel.CENTER);
            }

            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int col) {
                return renderer.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, col);
            }
        }

        public class MyTableModel extends AbstractTableModel {

            private final List<KhachHang> data;

            public MyTableModel() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "MaKH";
                    case 1 -> "UserName";
                    case 2 -> "Tên Khách Hàng";
                    case 3 -> "Loại Khách Hàng";
                    case 4 -> "SDT";
                    case 5 -> "CMND/CCCD";
                    case 6 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> Integer.class;
                    case 1, 2,3,4,5-> String.class;
                    default -> Object.class;
                };
            }

            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return 7;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                KhachHang obj = data.get(rowIndex);
                Object value = null;
                switch (columnIndex) {
                    case 0:
                        value = obj.getMaKH();
                        break;
                    case 1:
                        value = obj.getUserName();
                        break;
                    case 2:
                        value = obj.getTenKH();
                        break;
                    case 3:
                        value = obj.getMaLKH();
                        break;
                    case 4:
                        value = obj.getSDT();
                        break;
                    case 5:
                        value = obj.getCMND();
                        break;
                    case 6:
                        break;
                }
                return value;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                if (columnIndex == 6) {

                    System.out.println(aValue);

                    KhachHang value = data.get(rowIndex);
                    if ("accept".equals(aValue)) {
                        System.out.println("Accepted");
                    } else {
                        System.out.println("Rejected");
                    }
                    fireTableCellUpdated(rowIndex, columnIndex);

                }
            }

            public void add(KhachHang value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 6;
            }
        }

        public class AcceptRejectPane extends JPanel {

            private final JButton accept;
            private final JButton reject;
            private int row;
            private String state;


            public AcceptRejectPane() {
                setLayout(new GridBagLayout());
                accept = new JButton("Update");
                accept.setActionCommand("accept");
                reject = new JButton("Detail");
                reject.setActionCommand("reject");
                add(accept);
                add(reject);

                ActionListener listener = e -> {
                    state = e.getActionCommand();
                    System.out.println("State = " + state);
                };

                accept.addActionListener(listener);
                reject.addActionListener(listener);
            }

            public void addActionListener(ActionListener listener) {
                accept.addActionListener(listener);
                reject.addActionListener(listener);
            }

            public String getState() {
                return state;
            }

            public int getRow() {
                return row;
            }

            public void setRow(int row) {
                this.row = row;
            }
        }

        public class AcceptRejectRenderer extends DefaultTableCellRenderer {

            private final AcceptRejectPane acceptRejectPane;


            public AcceptRejectRenderer() {
                acceptRejectPane = new AcceptRejectPane();
            }


            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (isSelected) {
                    acceptRejectPane.setBackground(table.getSelectionBackground());
                } else {
                    acceptRejectPane.setBackground(table.getBackground());
                }
                return acceptRejectPane;
            }
        }

        public class AcceptRejectEditor extends AbstractCellEditor implements TableCellEditor {

            private final AcceptRejectPane acceptRejectPane;

            public AcceptRejectEditor() {
                acceptRejectPane = new AcceptRejectPane();
                acceptRejectPane.addActionListener(e -> SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int reply;
                        int r = acceptRejectPane.getRow();
                        try {
							r = CoSoDuLieu.getMaKHrow(++r);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                            if (acceptRejectPane.getState().equals("reject")) {
                            	KhachHangV.this.dispose();

                            } else {

                            	KhachHangV.this.dispose();

                            }
                    }
                }));
            }

            @Override
            public Object getCellEditorValue() {
                return acceptRejectPane.getState();
            }


            @Override
            public boolean isCellEditable(EventObject e) {
                return true;
            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                if (isSelected) {
                    acceptRejectPane.setBackground(table.getSelectionBackground());
                    acceptRejectPane.setRow(row);
                    return acceptRejectPane;
                }  else{acceptRejectPane.setBackground(table.getBackground());}

                return null;
            }
        }
    }
}

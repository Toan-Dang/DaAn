package View.NhanVien;


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

import Data.CoSoDuLieu;
import Model.NhanVien;
import View.ThanhToan.BaoCao;
import View.CaiDat.QLPhong.CaiDat;
import View.KhachHang.KhachHangV;
import View.ThanhToan.ThanhToanV;
import View.TongQuan.TongQuan;

public class NhanVienV extends JFrame {
	int id;
    private JPanel contentPane;
    private JTextField textFieldTimKiem;
    TableRowSorter<TableModel> rowSorter;
    JTable table;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new NhanVienV(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * Create the frame.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public NhanVienV(int id) throws ClassNotFoundException {
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
        btnTongQuan.addActionListener(e->{
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
        btnPhieuThuePhong_1.addActionListener(e-> {this.dispose();
        try {
			new KhachHangV(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
        btnPhieuThuePhong_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnPhieuThuePhong_1.setBackground(new Color(192, 192, 192));
        btnPhieuThuePhong_1.setBounds(0, 141, 170, 44);
        panel_1.add(btnPhieuThuePhong_1);

        JButton btnTongQuan_1 = new JButton("Thanh toán");
        btnTongQuan_1.addActionListener(e -> {
        	this.dispose();
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

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(190, 67, 1009, 36);
        panel_2.setBackground(new Color(178, 34, 34));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("NhanVien");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(39, 0, 134, 36);
        panel_2.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Danh sách nhân viên");
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

        JButton btnThem = new JButton("Thêm +");
        btnThem.addActionListener(e -> {
        	this.dispose();
        	new NhanVienV_Them(id);
        });
        btnThem.setForeground(Color.WHITE);
        btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnThem.setBackground(new Color(0, 139, 139));
        btnThem.setBounds(659, 159, 99, 27);
        contentPane.add(btnThem);
        this.setVisible(true);
        new TalbeNhanVien();
    }

    public class TalbeNhanVien {

        public TalbeNhanVien() {
            EventQueue.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                ArrayList<NhanVien> list = new ArrayList<>();
				try {
					list = CoSoDuLieu.listNhanVien();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               TableModelNhanVien model = new TableModelNhanVien();
                int makh;
                String[] str = new String[5];
                for (NhanVien nv : list) {
                    makh = nv.getMaNV();
                    str[0] = nv.getUserName();
                    str[1] = nv.getTenNV();
                    str[2]= nv.getChucVu();
                    str[3] = nv.getSDT();
                    str[4] = nv.getCMND();
                    model.add(new NhanVien(makh,str[0],str[1],str[2],str[3],str[4]));
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
        public class TableModelNhanVien extends AbstractTableModel {

            private final List<NhanVien> data;

            public TableModelNhanVien() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "MaNV";
                    case 1 -> "UserName";
                    case 2 -> "Tên Nhân Viên";
                    case 3 -> "Chức vụ";
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
                NhanVien obj = data.get(rowIndex);
                Object value = null;
                switch (columnIndex) {
                    case 0:
                        value = obj.getMaNV();
                        break;
                    case 1:
                        value = obj.getUserName();
                        break;
                    case 2:
                        value = obj.getTenNV();
                        break;
                    case 3:
                        value = obj.getChucVu();
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
                    fireTableCellUpdated(rowIndex, columnIndex);

                }
            }

            public void add(NhanVien value) {
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
                reject = new JButton("Đuổi");
                reject.setActionCommand("reject");
                add(accept);
                add(reject);

                ActionListener listener = e -> {
                    state = e.getActionCommand();
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
							r = CoSoDuLieu.getMANVrow(++r);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        if (acceptRejectPane.getState().equals("reject")) {
                            reply = JOptionPane.showConfirmDialog(null, "are u sure?", "comfirn", JOptionPane.YES_NO_OPTION);
                            if (reply == JOptionPane.YES_OPTION) {
                                try {
									CoSoDuLieu.XoaNhanVien(r);
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                                try {
									new NhanVienV(id);
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                                NhanVienV.this.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Canecled Delete ");
                            }
                        } else {
                            try {
								new NhanVienV_ChinhSua(r, id);
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            NhanVienV.this.dispose();

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

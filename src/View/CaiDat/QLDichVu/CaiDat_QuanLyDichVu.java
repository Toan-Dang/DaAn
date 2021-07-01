package View.CaiDat.QLDichVu;



import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

import Data.CoSoDuLieu;
import Model.DichVu;
import View.CaiDat.QLKhuyenMai.DSKhuyenMai;
import View.CaiDat.QLPhong.CaiDat;
import View.ThanhToan.BaoCao;
import View.KhachHang.KhachHangV;
import View.NhanVien.NhanVienV;
import View.ThanhToan.ThanhToanV;
import View.TongQuan.TongQuan;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class CaiDat_QuanLyDichVu extends JFrame {
	int id;
    private JPanel contentPane;
    private JButton btnTongQuan;

    /**
     * Launch the application.
     */
    JTable table = new JTable();
    TableRowSorter<TableModel> rowSorter;


    public CaiDat_QuanLyDichVu(int id) {
    	this.id = id;
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1240, 730);
        this.setLocationRelativeTo(null);
        this.setTitle("Dịch vụ");

        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
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


        JLabel lblNewLabel_1 = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
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

        btnTongQuan = new JButton("T\u1ED5ng quan");
        btnTongQuan.addActionListener(e -> {
        	this.dispose();
			try {
				new TongQuan(id);
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});

        btnTongQuan.setBackground(new Color(192, 192, 192));
        btnTongQuan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan.setBounds(0, 10, 170, 44);
        panel_1.add(btnTongQuan);

        JButton btnCaiDat = new JButton("Cài đặt");
        btnCaiDat.setBackground(new Color(255, 255, 255));
        btnCaiDat.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnCaiDat.setBounds(0, 225, 170, 44);
        panel_1.add(btnCaiDat);
        
        JButton btnNhanVien = new JButton("Nhân viên");
        btnNhanVien.addActionListener(e-> {this.dispose();
        	try {
				new NhanVienV(id);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        btnNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnNhanVien.setBackground(Color.LIGHT_GRAY);
        btnNhanVien.setBounds(0, 52, 170, 44);
        panel_1.add(btnNhanVien);
        
        JButton btnThanhToan = new JButton("Thanh toán");
 
        btnThanhToan.addActionListener(e-> {
        	this.dispose();
            try {
                new ThanhToanV(id);
            } catch (ClassNotFoundException | SQLException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });

        btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnThanhToan.setBackground(Color.LIGHT_GRAY);
        btnThanhToan.setBounds(0, 95, 170, 44);
        panel_1.add(btnThanhToan);
        
        JButton btnKhachHang = new JButton("Khách hàng");
        btnKhachHang.addActionListener(e-> {this.dispose();
        try {
			new KhachHangV(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
        btnKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnKhachHang.setBackground(Color.LIGHT_GRAY);
        btnKhachHang.setBounds(0, 139, 170, 44);
        panel_1.add(btnKhachHang);
        
        JButton btnBaoCao = new JButton("Báo cáo");
        btnBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnBaoCao.setBackground(Color.LIGHT_GRAY);
        btnBaoCao.setBounds(0, 182, 170, 44);
        panel_1.add(btnBaoCao);
        btnBaoCao.addActionListener(e -> {
            try {
                new BaoCao(id);
                this.dispose();
            } catch (ClassNotFoundException | SQLException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(190, 67, 1009, 36);
        panel_2.setBackground(new Color(178, 34, 34));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Cài Đặt");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(39, 0, 134, 36);
        panel_2.add(lblNewLabel_2);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(189, 101, 537, 36);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        JButton btnNewButton_4 = new JButton("Cài đặt phòng");
        btnNewButton_4.setForeground(new Color(0, 0, 0));
        btnNewButton_4.setBackground(new Color(192, 192, 192));
        btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton_4.setBounds(0, 0, 179, 36);
        panel_3.add(btnNewButton_4);

        JButton btnQuanLyDichVu = new JButton("Quản lý dịch vụ");
        btnQuanLyDichVu.setForeground(new Color(0, 0, 0));
        btnQuanLyDichVu.setBackground(new Color(255, 255, 255));
        btnQuanLyDichVu.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnQuanLyDichVu.setBounds(178, 0, 179, 36);
        panel_3.add(btnQuanLyDichVu);


        JButton btnQuanLyKhuyeMai = new JButton("Quản lý khuyến mãi");
        btnQuanLyKhuyeMai.setForeground(new Color(0, 0, 0));
        btnQuanLyKhuyeMai.setBackground(new Color(192, 192, 192));
        btnQuanLyKhuyeMai.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnQuanLyKhuyeMai.setBounds(356, 0, 179, 36);
        panel_3.add(btnQuanLyKhuyeMai);
        btnQuanLyKhuyeMai.addActionListener(e -> {
            CaiDat_QuanLyDichVu.this.dispose();
            try {
                new DSKhuyenMai(id);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        JLabel lblNewLabel_3 = new JLabel("Danh sách dịch vụ");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_3.setBounds(190, 168, 163, 37);
        contentPane.add(lblNewLabel_3);

        JButton btnNewButton_7_1 = new JButton("Thêm +");
        btnNewButton_7_1.setForeground(Color.WHITE);
        btnNewButton_7_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton_7_1.setBackground(new Color(0, 139, 139));
        btnNewButton_7_1.setBounds(646, 201, 99, 27);
        contentPane.add(btnNewButton_7_1);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(178, 34, 34));
        panel_4.setBounds(480, 625, 736, 3);
        contentPane.add(panel_4);

        JLabel lblNewLabel_4 = new JLabel("Khách hàng là thượng đế!");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        lblNewLabel_4.setBounds(1011, 628, 243, 25);
        contentPane.add(lblNewLabel_4);

        //thanh tìm kiếm
        JTextField searchfield = new JTextField();
        searchfield.setBounds(261, 202, 291, 27);
        contentPane.add(searchfield);
        
        JLabel lblNewLabel_5 = new JLabel("Tìm kiếm:");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_5.setBounds(190, 205, 62, 19);
        contentPane.add(lblNewLabel_5);
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

       new MultiButtonTable();

        btnTongQuan.addActionListener(e -> {
        	this.dispose();
			try {
				new TongQuan(id);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        btnNewButton_4.addActionListener(e -> {
			try {
				new CaiDat(id);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		});
        btnQuanLyDichVu.addActionListener(e -> {
            new CaiDat_QuanLyDichVu(id);
        });

        btnNewButton_7_1.addActionListener(e -> {
            this.dispose();
           new CaiDat_QuanLyDichVu_ThemDichVu(id);
        });
    }

    public class MultiButtonTable {

        public MultiButtonTable() {
            EventQueue.invokeLater(() -> {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                ArrayList<DichVu> list = new ArrayList<>();
				try {
					list = CoSoDuLieu.listdv();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               MyTableModel model = new MyTableModel();
                int rowint;
                String[] rowstr = new String[2];
                double rowdb;
                for (DichVu dv : list) {
                    rowint = dv.getMaDv();
                    rowstr[0] = dv.getTenDV();
                    rowstr[1] = dv.getGhiChu();
                    rowdb = dv.getGia();
                    model.add(new DichVu(rowint, rowstr[0], rowstr[1], rowdb));
                }
                table = new JTable(model);
                AcceptRejectRenderer renderer = new AcceptRejectRenderer();
                table.getColumnModel().getColumn(4).setCellRenderer(renderer);
                table.getColumnModel().getColumn(4).setCellEditor(new AcceptRejectEditor());
                table.setRowHeight(renderer.getTableCellRendererComponent(table, null, true, true, 0, 0).getPreferredSize().height);
                table.setFillsViewportHeight(true);
                table.setOpaque(true);
                table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                rowSorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(rowSorter);

                table.setShowGrid(false);
                table.setSurrendersFocusOnKeystroke(true);
                table.setBackground(new Color(255, 255, 255));
                table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD , 15));
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(178, 34, 34));
                table.getTableHeader().setForeground(new Color(255, 255, 255));
                
               DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment(JLabel.CENTER);

                JTableHeader header = table.getTableHeader();
                header.setDefaultRenderer(new HeaderRenderer(table));

                for (int columnIndex = 0; columnIndex < table.getColumnCount() - 2 ; columnIndex++)
                {
                    table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
                }

                JScrollPane scrollpane = new JScrollPane(table);
                scrollpane.setViewportView(table);
                scrollpane.setBounds(200, 238, 917, 262);
                contentPane.add(scrollpane);
            });
        }
        private  class HeaderRenderer implements TableCellRenderer {

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

            private final List<DichVu> data;

            public MyTableModel() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "Mã dịch vụ";
                    case 1 -> "Tên dịch vụ";
                    case 2 -> "Mô tả";
                    case 3 -> "Giá";
                    case 4 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> Integer.class;
                    case 1, 2 -> String.class;
                    case 3 -> Double.class;
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
                DichVu obj = data.get(rowIndex);
                Object value = null;
                switch (columnIndex) {
                    case 0:
                        value = obj.getMaDv();
                        break;
                    case 1:
                        value = obj.getTenDV();
                        break;
                    case 2:
                        value = obj.getGhiChu();
                        break;
                    case 3:
                        value = obj.getGia();
                        break;
                    case 4:
                        break;
                }
                return value;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                if (columnIndex == 4) {

                    System.out.println(aValue);

                    DichVu value = data.get(rowIndex);
                    if ("accept".equals(aValue)) {
                        System.out.println("Accepted");
                    } else {
                        System.out.println("Rejected");
                    }
                    fireTableCellUpdated(rowIndex, columnIndex);


                }
            }

            public void add(DichVu value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }



            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 4;
            }
        }

        public class AcceptRejectPane extends JPanel {

            private final JButton accept;
            private final JButton reject;
            private int row;
            private String state;


            public AcceptRejectPane() {
                setLayout(new GridBagLayout());
                accept = new JButton("Chỉnh sửa");
                accept.setActionCommand("accept");
                reject = new JButton("Xóa");
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
                        ++r;
                        if (acceptRejectPane.getState().equals("reject")) {
                            reply = JOptionPane.showConfirmDialog(null, "are u sure?", "comfir", JOptionPane.YES_NO_OPTION);
                            if (reply == JOptionPane.YES_OPTION) {
                                 try {
									CoSoDuLieu.XoaDichVu(r);
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                                //////////////////////////////////////////////////////////////////////////
                                new CaiDat_QuanLyDichVu(id);
                            } else {
                                JOptionPane.showMessageDialog(null, "Canecled Delete ");
                            }
                        } else {
                            int getdv = 0;
							try {
								getdv = CoSoDuLieu.searchDichVu(r);
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
                            try {
                            	 CaiDat_QuanLyDichVu.this.dispose();
								new CaiDat_QuanLyDichVu_SuaDichVu(getdv, id);
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
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
                } else {
                    acceptRejectPane.setBackground(table.getBackground());
                }
                acceptRejectPane.setRow(row);
                return acceptRejectPane;
            }
        }
    }
}



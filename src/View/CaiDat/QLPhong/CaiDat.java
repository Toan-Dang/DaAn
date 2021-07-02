package View.CaiDat.QLPhong;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

import Data.CoSoDuLieu;
import Model.Phong;
import View.CaiDat.QLDichVu.CaiDat_QuanLyDichVu;
import View.CaiDat.QLKhuyenMai.DSKhuyenMai;
import View.ThanhToan.BaoCao;
import View.KhachHang.KhachHangV;
import View.NhanVien.NhanVienV;
import View.ThanhToan.ThanhToanV;
import View.TongQuan.TongQuan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;



public class CaiDat extends JFrame implements ActionListener {
	int id;
    JTable table;
    TableRowSorter<TableModel> rowSorter;
    private final JPanel contentPane;
    private JButton btnTongQuan;
    private JButton btnDichVu;
    
    
	public static void main(String[] args) throws ClassNotFoundException {

        new CaiDat(1); 	
	}

    

    public CaiDat(int id) throws ClassNotFoundException {
    	this.id = id;
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1240, 730);
        this.setLocationRelativeTo(null);
        this.setTitle("DS Phòng");

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
        btnKhachHang.setBounds(0, 141, 170, 44);
        panel_1.add(btnKhachHang);
        
        JButton btnThanhToan = new JButton("Thanh toán");
        btnThanhToan.addActionListener(e->{
        	this.dispose();
            try {
                new ThanhToanV(id);
            } catch (ClassNotFoundException | SQLException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnThanhToan.setBackground(Color.LIGHT_GRAY);
        btnThanhToan.setBounds(0, 97, 170, 44);
        panel_1.add(btnThanhToan);
        
        btnDichVu = new JButton("Nhân viên");
        btnDichVu.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnDichVu.setBackground(Color.LIGHT_GRAY);
        btnDichVu.setBounds(0, 54, 170, 44);
        panel_1.add(btnDichVu);
        btnDichVu.addActionListener(this);
        
        btnTongQuan = new JButton("Tổng quan");
        btnTongQuan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan.setBackground(new Color(192, 192, 192));
        btnTongQuan.setBounds(0, 10, 170, 44);
        panel_1.add(btnTongQuan);
        btnTongQuan.addActionListener(this);
        
        JButton btnCaiDat = new JButton("Cài đặt");
        btnCaiDat.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnCaiDat.setBackground(new Color(255, 255, 255));
        btnCaiDat.setBounds(0, 228, 170, 44);
        panel_1.add(btnCaiDat);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(190, 67, 1009, 36);
        panel_2.setBackground(new Color(178, 34, 34));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Nhân viên");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(39, 0, 134, 36);
        panel_2.add(lblNewLabel_2);
        

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(189, 101, 537, 36);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        JButton btnCaiDatPhong = new JButton("Cài đặt phòng");
        btnCaiDatPhong.setForeground(new Color(0, 0, 0));
        btnCaiDatPhong.setBackground(new Color(255, 255, 255));
        btnCaiDatPhong.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCaiDatPhong.setBounds(0, 0, 179, 36);
        panel_3.add(btnCaiDatPhong);

        JButton btnQuanLyDichVu = new JButton("Quản lý dịch vụ");
        btnQuanLyDichVu.setForeground(new Color(0, 0, 0));
        btnQuanLyDichVu.setBackground(new Color(192, 192, 192));
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
            CaiDat.this.dispose();
            try {
                new DSKhuyenMai(id);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        JLabel lblNewLabel_3 = new JLabel("Danh sách phòng");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_3.setBounds(190, 168, 163, 37);
        contentPane.add(lblNewLabel_3);

        JButton btnThem = new JButton("Thêm +");
        btnThem.setForeground(Color.WHITE);
        btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnThem.setBackground(new Color(0, 139, 139));
        btnThem.setBounds(646, 201, 99, 27);
        contentPane.add(btnThem);
        btnThem.addActionListener(e ->{ 
        	try {
			new CaiDat_QuanLyPhong_ThemPhong(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}} );

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
        searchfield.setBounds(307, 202, 291, 27);
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
        JLabel lblNewLabel_5 = new JLabel("Tìm kiếm:");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_5.setBounds(190, 205, 62, 19);
        contentPane.add(lblNewLabel_5);


        new MultiButtonTablePhong();
        btnQuanLyDichVu.addActionListener(e -> {
        	this.dispose();
			new CaiDat_QuanLyDichVu(id);
        });

    }
   

    public class MultiButtonTablePhong {

        public MultiButtonTablePhong() {
            EventQueue.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                ArrayList<Phong> list = new ArrayList<>();
				try {
					list = CoSoDuLieu.listphongfull();
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
                    row[1] = phong.getSoLuongNguoiHienTai();
                    row1[1] = phong.getTinhTrang();
                    gia = phong.getGia();
                    model.add(new Phong(row[0], row1[0], row[1], row1[1], gia));
                }
                table = new JTable(model);
                AcceptRejectRenderer renderer = new AcceptRejectRenderer();
                table.getColumnModel().getColumn(5).setCellRenderer(renderer);
                table.getColumnModel().getColumn(5).setCellEditor(new AcceptRejectEditor());
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
                //table.setDefaultRenderer(String.class, centerRenderer);
                
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
                scrollpane.setBounds(190, 238, 917, 300);

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
        //phong
        public class MyTableModel extends AbstractTableModel {

            private final List<Phong> data;

            public MyTableModel() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "ID";
                    case 1 -> "LOẠI PHÒNG";
                    case 2 -> "SỐ LƯỢNG NGƯỜI TRONG PHÒNG";
                    case 3 -> "TÌNH TRẠNG";
                    case 4 -> "GIÁ PHÒNG";
                    case 5 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0, 2 -> Integer.class;
                    case 1, 3 -> String.class;
                    case 4 -> Double.class;
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
                        value = obj.getSoLuongNguoiHienTai();
                        break;
                    case 3:
                        value = obj.getTinhTrang();
                        break;
                    case 4:
                        value = obj.getGia();
                        break;
                    case 5:
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
							r = CoSoDuLieu.getMaPhongrow(++r);
						} catch (ClassNotFoundException e) {

							e.printStackTrace();
						}
                        try {
							if(!CoSoDuLieu.isDatPhong(r)){
							    if (acceptRejectPane.getState().equals("reject")) {
							        reply = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn?", "comfirn", JOptionPane.YES_NO_OPTION);
							        if (reply == JOptionPane.YES_OPTION) {
							             CoSoDuLieu.XoaPhong(r);
							           
							        } else {
							            JOptionPane.showMessageDialog(null, "Canecled Delete ");
							        }
							    } else {
							    	CaiDat.this.dispose();
							        new CaiDat_QuanLyPhong_SuaPhong(r);	

							    }
							}
							 else {
							    JOptionPane.showMessageDialog(null, "Phòng số " + r + " đã đặt không thể thao tác");
							}
						} catch (HeadlessException | ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnTongQuan)
		{
			this.dispose();
			try {
				new TongQuan(id);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == this.btnDichVu)
		{
			this.dispose();

			try {
				new NhanVienV(id);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
	}
}



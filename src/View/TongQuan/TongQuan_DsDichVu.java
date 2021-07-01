package View.TongQuan;

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
import Model.DichVu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TongQuan_DsDichVu extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTable tableDichVu;
	
	private String[] columnNames = {
			"Mã dịch vụ",
			 "Tên dịch vụ",
			 "Giá",
			 "Chi Tiết",
			 "Trạng thái"
			 };
	private Object data = new Object [][] {};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TongQuan_DsDichVu frame = new TongQuan_DsDichVu();
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
	public TongQuan_DsDichVu() throws ClassNotFoundException, SQLException {
		setBounds(800, 200, 731, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(10, 0, 697, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("D\u1ECBch V\u1EE5");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(176, 10, 326, 47);
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
		showListDichVu(CoSoDuLieu.listdv());
		
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
		btnNewButton.setBounds(545, 273, 138, 48);
		contentPane.add(btnNewButton);

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
	
	public void showListDichVu(List<DichVu> list)
	{
		int size = list.size();
		Object [][] DichVu = new Object[size][5];
		for (int i = 0; i < size; i++)
		{
			DichVu[i][0] = list.get(i).getMaDv();
			DichVu[i][1] = list.get(i).getTenDV();
			DichVu[i][2] = list.get(i).getGia();
			DichVu[i][3] = list.get(i).getGhiChu();
			DichVu[i][4] = "Hoạt động";
		}
		this.tableDichVu.setModel(new DefaultTableModel(DichVu, columnNames));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

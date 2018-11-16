package jdbc_study_coffee.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc_study_coffee.dto.Sale;
import jdbc_study_coffee.service.SalePriceTableUiService;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

public class SalePriceTableUi extends JFrame {

	private JPanel contentPane;
	private boolean isSale;
	private SalePriceTableUiService service;
	private ProductRankPanel pRankList;
	
	/**
	 * Create the frame.
	 */
	public SalePriceTableUi() {
		service = new SalePriceTableUiService();
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 599, 376);
		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		List<Sale> list;
		try {
			list=service.outputOrder(isSale);
			pRankList = new ProductRankPanel();
			pRankList.setList(list);
			pRankList.loadDatas();
			contentPane.add(pRankList, BorderLayout.CENTER);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel(isSale?"판매금액 순위":"마진액 순위");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
	}

	
	
}

package jdbc_study_coffee.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import jdbc_study_coffee.dto.Sale;

public class ProductRankPanel extends JPanel {
	private JTable table;
	private List<Sale> list;
	
	public void setList(List<Sale> list) {
		this.list = list;
	}
	/**
	 * Create the panel.
	 */
	public ProductRankPanel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setAlignWidth();
	}
	private void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER,0,1,2);
		tableCellAlignment(SwingConstants.RIGHT,3,4,5,6,7,8,9);
		tableSetWidth(80,100,200,200,200,300,300,300,200,300);
		
	}
	private void tableSetWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0;i<width.length;i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	private void tableCellAlignment(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0;i<idx.length;i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	public void loadDatas() {
		table.setModel(new DefaultTableModel(
				getDatas(),
				getColumnTitle()
		));
	}
	
	private Object[][] getDatas() {
		Object[][] datas = new Object[list.size()+1][];
			for(int i=0;i<list.size();i++) {
				datas[i] = getProductrow(list.get(i));
			}
			datas[list.size()] = getTotal();
		return datas;
	}

	private Object[] getTotal() {
		int sumSupplyPrice = 0;
		int sumAddtax = 0;
		int sumSalePrice = 0;
		int sumMarginPrice = 0;
		
		for(Sale s : list) {
			sumSupplyPrice += s.getDetail().getSupply();
			sumAddtax += s.getDetail().getAddPrice();
			sumSalePrice += s.getDetail().getSalesPrice();
			sumMarginPrice += s.getDetail().getMarginPrice();
		}
		
		return new Object[]{
				"합계","","","","", String.format("%,d", sumSupplyPrice),String.format("%,d", sumAddtax),
												String.format("%,d", sumSupplyPrice),"",String.format("%,d", sumMarginPrice)
		};
	}
	private Object[] getProductrow(Sale sale) {
		return new Object[] {
				sale.getDetail().getRanking(),
				sale.getProduct().getCode(),
				sale.getProduct().getName(),
				sale.getPrice(),
				sale.getSaleCnt(),
				sale.getDetail().getSupply(),
				sale.getDetail().getAddPrice(),
				sale.getDetail().getSalesPrice(),
				sale.getMarginRate(),
				sale.getDetail().getMarginPrice()
		};
	}

	private String[] getColumnTitle() {
		return new String[] {
				"순위","제품코드","제품명","제품단가","판매수량","공급가액","부가세액","판매금액","마진율","마진액"
		};
	}
	
}

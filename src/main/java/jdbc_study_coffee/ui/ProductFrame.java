package jdbc_study_coffee.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import jdbc_study_coffee.dto.Product;
import jdbc_study_coffee.dto.Sale;
import jdbc_study_coffee.service.ProductFrameService;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ProductFrame extends JFrame implements ActionListener {
	
	
	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfPrice;
	private JTextField tfSaleCnt;
	private JTextField tfMarginRate;
	private JButton btnInput;
	private JLabel lblName;
	
	private ProductFrameService service;
	private JButton btnOutput1;
	private JButton btnOutput2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfName;


	public ProductFrame() { 
		service = new ProductFrameService();
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblCode = new JLabel("제품코드");
		panel.add(lblCode);

		tfCode = new JTextField();

		panel.add(tfCode);
		tfCode.setColumns(10);

		lblName = new JLabel("제품이름");
		panel.add(lblName);
		//번호 입력시 제품이름이 뜸
		tfCode.getDocument().addDocumentListener(new MyDocumentListener() {
			@Override
			public void warning() {
				if(tfCode.getText().length()==4) {
					Product pdt = new Product(tfCode.getText().trim());//입력받은 코드값을 가지고옴
					try {
						Product updatePdt =  service.searchProduct(pdt);
						tfName.setText(updatePdt.getName());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}	
		});
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblPrice = new JLabel("제품단가");
		panel.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		panel.add(tfPrice);
		
		lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);

		JLabel lblSaleCnt = new JLabel("판매수량");
		panel.add(lblSaleCnt);

		tfSaleCnt = new JTextField();
		tfSaleCnt.setColumns(10);
		panel.add(tfSaleCnt);
		
		lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);

		JLabel lblMarginRate = new JLabel("마진율");
		panel.add(lblMarginRate);

		tfMarginRate = new JTextField();
		tfMarginRate.setColumns(10);
		panel.add(tfMarginRate);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));

		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		panel_1.add(btnInput);

		btnOutput1 = new JButton("출력1");
		btnOutput1.addActionListener(this);
		panel_1.add(btnOutput1);

		btnOutput2 = new JButton("출력2");
		btnOutput2.addActionListener(this);
		panel_1.add(btnOutput2);
	}

	// 입력버튼 눌렀을 시
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOutput2) {
			do_btnOutput2_actionPerformed(e);
		}
		if (e.getSource() == btnOutput1) {
			do_btnOutput1_actionPerformed(e);
		}
		if (e.getSource() == btnInput) {
			do_btnInput_actionPerformed(e);  
		}
	}

	protected void do_btnInput_actionPerformed(ActionEvent e) {
		//입력된 데이터를 product로 받기 - 입력한 데이터 저장
		Sale sale = getSale();
		try {
			service.registerSale(sale);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("입력 된 값 추가");
		try {
			service.selectSaleByAll();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private Sale getSale() {
		Product code = new Product(tfCode.getText().trim());
		int price = Integer.parseInt(tfPrice.getText().trim());
		int saleCnt = Integer.parseInt(tfSaleCnt.getText().trim());
		int marginRate = Integer.parseInt(tfMarginRate.getText().trim());
		
		return new Sale(0 ,code , price, saleCnt, marginRate);
	}
	protected void do_btnOutput1_actionPerformed(ActionEvent e) {
		SalePriceTableUi ui = new SalePriceTableUi();
		ui.setVisible(true);
	}
	protected void do_btnOutput2_actionPerformed(ActionEvent e) {
		SalePriceTableUi ui = new SalePriceTableUi();
		ui.setVisible(false);
	}
}














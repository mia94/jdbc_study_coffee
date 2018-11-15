package jdbc_study_coffee.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import jdbc_study_coffee.dto.Product;
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

		JLabel lblShowName = new JLabel("");
		panel.add(lblShowName);
		tfCode.getDocument().addDocumentListener(new MyDocumentListener() {

			@Override
			public void warning() {
				//lblName.setText(tfCode.getText());
				if(tfCode.getText().length()==4) {
					Product pdt = new Product(tfCode.getText().trim());//입력받은 코드값을 가지고옴
					try {
						Product updatePdt =  service.searchProduct(pdt);
						lblShowName.setText(updatePdt.getName());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
		JLabel lblPrice = new JLabel("제품단가");
		panel.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		panel.add(tfPrice);

		JLabel lblSaleCnt = new JLabel("판매수량");
		panel.add(lblSaleCnt);

		tfSaleCnt = new JTextField();
		tfSaleCnt.setColumns(10);
		panel.add(tfSaleCnt);

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

		JButton btnOutput1 = new JButton("출력1");
		panel_1.add(btnOutput1);

		JButton btnOutput2 = new JButton("출력2");
		panel_1.add(btnOutput2);
		btnOutput2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}

	// 입력버튼 눌렀을 시
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) {
			do_btnInput_actionPerformed(e);
		}
	}

	protected void do_btnInput_actionPerformed(ActionEvent e) {
		//입력된 데이터를 product로 받기 - 입력한 데이터 저장
		
	}
}

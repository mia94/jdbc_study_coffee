package java_swing_coffee.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ProductFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfPrice;
	private JTextField tfSaleCnt;
	private JTextField tfMarginRate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductFrame frame = new ProductFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductFrame() {
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
		
		JLabel lblName = new JLabel("제품이름");
		panel.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
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
		
		JButton btnInput = new JButton("입력");
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

}

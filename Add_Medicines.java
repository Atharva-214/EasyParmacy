package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add_Medicines extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JButton btnNewButton_1;
	private JTextField textField_5;
	
	String medName;
	String mfgDate;
	String expiryDate;
	String price;
	String qty;
	String suppName;
	String address;
	int pin;
	int phNo;
	int phNo2 = 0;
	int pres;
	int ref;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Medicines frame = new Add_Medicines();
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
	public Add_Medicines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		lblNewLabel = new JLabel("Medicine Name");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 8, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 20, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 17, SpringLayout.EAST, lblNewLabel);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mfg Date");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 12, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -217, SpringLayout.EAST, panel);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Expiry Date");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 6, SpringLayout.EAST, textField_1);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 6, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textField_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -10, SpringLayout.EAST, panel);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 14, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 20, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, -3, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 27, SpringLayout.EAST, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField_1);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Quantity");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_2);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, -3, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 278, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField_2);
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main().setVisible(true);
				dispose();
			}
		});
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, panel);
		panel.add(btnNewButton_1);
		
		textField_5 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_5, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_5, 0, SpringLayout.EAST, textField);
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		JLabel lblNewLabel_5 = new JLabel("Supplier Name");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_5, -3, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 24, SpringLayout.SOUTH, textField_3);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 12, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_7, 6, SpringLayout.SOUTH, textField_5);
		sl_panel.putConstraint(SpringLayout.WEST, textField_7, 53, SpringLayout.EAST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.EAST, textField_7, 0, SpringLayout.EAST, textField);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile Number");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 3, SpringLayout.NORTH, textField_6);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_6, 6, SpringLayout.SOUTH, textField_7);
		sl_panel.putConstraint(SpringLayout.WEST, textField_6, 0, SpringLayout.WEST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField_6, 0, SpringLayout.EAST, lblNewLabel_4);
		textField_6.setColumns(10);
		panel.add(textField_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Pin Code");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6_1, 12, SpringLayout.SOUTH, textField_7);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6_1, 0, SpringLayout.WEST, textField_2);
		panel.add(lblNewLabel_6_1);
		
		textField_8 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_8, 6, SpringLayout.SOUTH, textField_7);
		sl_panel.putConstraint(SpringLayout.WEST, textField_8, 6, SpringLayout.EAST, lblNewLabel_6_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_8, 6, SpringLayout.EAST, textField);
		textField_8.setColumns(10);
		panel.add(textField_8);
		
		JButton btnNewButton = new JButton("Add to Stock");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 91, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -21, SpringLayout.SOUTH, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medName = textField.getText();
				mfgDate = textField_1.getText();
				expiryDate = textField_2.getText();
				price = textField_3.getText();
				qty = textField_4.getText();
				suppName = textField_5.getText();
				address = textField_7.getText();
				pin = Integer.parseInt(textField_8.getText());
				phNo = Integer.parseInt(textField_6.getText());
				pres = JOptionPane.showConfirmDialog(null, "Does this medicine require prescription?");
				if(pres == 0) {
					pres = 1;
				}
				else {
					pres = 0;
				}
				ref = JOptionPane.showConfirmDialog(null, "Does this medicine require refrigeration?");
				if(ref == 0) {
					ref = 1;
				}
				else {
					ref = 0;
				}
				
				int conf = JOptionPane.showConfirmDialog(null, "Do you want to add another phone number of supplier");
				if(conf == 0) {
					phNo2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter phone number?"));
				}
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AAA_Pharmacy","root","Root@123");
					System.out.println("Successfully Connected!");
					Statement st = con.createStatement();
					st.executeUpdate("Insert into Medicines (med_name, mfg_date, exp_date, price, stock, prescription_reqd, refrigeration_reqd) values('"+medName+"', '"+mfgDate+"', '"+expiryDate+"', "+price+", "+qty+", "+pres+", "+ref+");");
					System.out.println("Inserted into Medicines Table");
					st.executeUpdate("Insert into suppliers (supplier_name, supplier_contact_1, supplier_contact_2, office_address, pincode) values('"+suppName+"', "+phNo+", "+phNo2+", '"+address+"', "+pin+");");
					System.out.println("Inserted into Suppliers Table");
				}
				catch (Exception sqle) {
					System.out.println(sqle.getMessage());
				}
			}
		});
		panel.add(btnNewButton);
		
	}
}

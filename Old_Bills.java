package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Old_Bills extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable table;
	
	String custName;
	int phNo;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Old_Bills frame = new Old_Bills();
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
	public Old_Bills() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Customer Name");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contact Number");
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main().setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnNewButton);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		table = new JTable();
		Object[] columns = {"Sr. No", "Medicine Name", "Quantity", "Price", "Net Price", "Order Date"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		
		table.setModel(model);
		JScrollPane scrollPane1 = new JScrollPane(table);
		panel_2.add(scrollPane1);
		
		btnNewButton_1 = new JButton("Display Bill");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				custName = textField.getText();
				phNo = Integer.parseInt(textField_1.getText());
				
				
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AAA_Pharmacy","root","Root@123");
					System.out.println("Successfully Connected!");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select med_name,qty,price,qty*price as net_price,order_time from medicines,orders, customers where orders.customer_id=customers.customer_id and orders.med_id= medicines.med_id and customer_name='"+custName+"' and customers.phone_num="+phNo);
					int i = 0;
					if(rs.next()) {
						while(rs.next()) {
							Object row[] = {i,rs.getString("med_name"), rs.getString("qty"), rs.getString("price"), rs.getString("net_price"), rs.getString("order_time")};
							model.addRow(row);
							i++;
						}
					}
					else {
						System.out.print("No Record Found");
					}
					
				}
				catch (Exception sqle) {
					System.out.println(sqle.getMessage());
				}
			}
		});
		panel_1.add(btnNewButton_1);
		
		
	}

}

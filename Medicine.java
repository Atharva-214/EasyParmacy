package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Medicine extends JFrame {
	private JTextField textField;
	private JTextField txtSystemdate;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	String custName;
	int age;
	String gen;
	String add;
	int pin;
	int mob;
	
	ArrayList<Integer> medId = new ArrayList<>();
	String medName;
	int qty = 0;
	int i = 1;
	int total;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine frame = new Medicine();
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
	public Medicine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
				
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("Customer Name");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField, 37, SpringLayout.EAST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 169, SpringLayout.EAST, lblNewLabel);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		panel.add(lblNewLabel_1);
		
		txtSystemdate = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, txtSystemdate);
		sl_panel.putConstraint(SpringLayout.NORTH, txtSystemdate, 0, SpringLayout.NORTH, panel);
		txtSystemdate.setText(java.time.LocalDate.now().toString());
		txtSystemdate.setEditable(false);
		sl_panel.putConstraint(SpringLayout.EAST, txtSystemdate, 0, SpringLayout.EAST, panel);
		panel.add(txtSystemdate);
		txtSystemdate.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 13, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -4, SpringLayout.NORTH, textField_2);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, -3, SpringLayout.NORTH, lblNewLabel_2);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_2);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, txtSystemdate, 46, SpringLayout.WEST, textField_3);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 29, SpringLayout.EAST, lblNewLabel_3);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 17, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 76, SpringLayout.EAST, lblNewLabel_4);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pin");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 102, SpringLayout.EAST, textField_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 0, SpringLayout.SOUTH, textField_4);
		panel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_5, -3, SpringLayout.NORTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.WEST, textField_5, 377, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_5, -10, SpringLayout.EAST, panel);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile Number");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 14, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_6, 6, SpringLayout.SOUTH, textField_4);
		sl_panel.putConstraint(SpringLayout.WEST, textField_6, 0, SpringLayout.WEST, textField);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Please enter the name of Medicine");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_7, -195, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 16, SpringLayout.SOUTH, textField_6);
		panel.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, textField_7);
		sl_panel.putConstraint(SpringLayout.WEST, textField_7, 247, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_7, -16, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_7, 36, SpringLayout.SOUTH, textField_5);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, textField_7);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, 73, SpringLayout.SOUTH, textField_7);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 415, SpringLayout.WEST, panel);
		panel.add(scrollPane);
		
		table = new JTable();
		Object[] columns = {"Sr. No", "Medicine Name", "Quantity"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main().setVisible(true);
				dispose();
			}
		});		
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add to List");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total = 0;
				medName = textField_7.getText();
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AAA_Pharmacy","root","Root@123");
					System.out.println("Successfully Connected!");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select med_id, stock from medicines where med_name = '"+medName+"';");
					if(rs.getFetchSize() >= 0) {
						System.out.println("Medicine in stock.");
						qty = Integer.parseInt(JOptionPane.showInputDialog("Please enter the quantity of medicines required?"));
						while(rs.next()) {
							total += rs.getInt("stock");
							medId.add(rs.getInt("med_id"));
						}
						if(qty <= total) {
							System.out.println("Asked Amount present.");
							Object row[] = {i,medName, qty};
							model.addRow(row);
							i++;
						}
						else {
							System.out.println("Sorry! Asked Amount not present.\nGiven the complete stock");
							Object row[] = {i,medName, total};
							model.addRow(row);
							i++;
						}
					}
					else {
						System.out.println("Medicine not found in stock.");
						textField_7.setText("");
					}
				}
				catch (Exception sqle) {
					System.out.println(sqle.getMessage());
				}
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				custName = textField.getText();
				age = Integer.parseInt(textField_2.getText());
				gen = textField_3.getText();
				add = textField_4.getText();
				pin = Integer.parseInt(textField_5.getText());
				mob = Integer.parseInt(textField_6.getText());
						
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AAA_Pharmacy","root","Root@123");
					System.out.println("Successfully Connected!");
					Statement st = con.createStatement();
					st.executeUpdate("Insert into Customers (age, gender, customer_name, address, pincode, phone_num) values("+age+", '"+gen+"', '"+custName+"', '"+add+"', "+pin+", "+mob+");");
					System.out.println("Inserted into Customers Table");
					
					ResultSet rs = st.executeQuery("Select customer_id from customers where customer_name ='"+custName+"' and phone_num ='"+mob+"');");
					int cust_id = rs.getInt("customer_id");
					
					for(int c = 0; c < table.getRowCount(); c++) {
						st.executeUpdate("Insert into Orders (customer_id, med_id, qty, order_time) values("+cust_id+", "+medId.get(0)+", "+table.getValueAt(c, 2)+", '"+txtSystemdate.getText()+"');");
						System.out.println("Inserted into Orders Table");
					}
				}
				catch (Exception sqle) {
					System.out.println(sqle.getMessage());
				}

			  }
		});
		panel_1.add(btnNewButton);
	}
}

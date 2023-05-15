package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

public class Main extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton_4 = new JButton("Exit");
	Add_Medicines addMeds = new Add_Medicines();
	Medicine medicines = new Medicine();
	Old_Bills dispBills = new Old_Bills();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("AAA_Pharmacy");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JButton btnNewButton_3 = new JButton("Add Medicines");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_3, 20, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_3, 151, SpringLayout.WEST, panel);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMeds.setVisible(true);
				dispose();
				
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Order taken from Customer");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 34, SpringLayout.SOUTH, btnNewButton_3);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 127, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -126, SpringLayout.EAST, panel);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicines.setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Old Bills");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 164, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -26, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispBills.setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
				if(c == 0) {
					System.exit(0);
				}
			}
		});
		contentPane.add(btnNewButton_4, BorderLayout.SOUTH);
		
	}
	
	

}

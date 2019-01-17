import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.util.*;
import java.awt.Font;
public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	 User user = new User("","","","5");
	 private JPasswordField passwordField;
	 private List<JComboBox<String>> jcb = new ArrayList<>();
	 private JTextField textField_1;
	 private ImageIcon signImage = new ImageIcon(getClass().getResource("road.jpg"));
	 private JLabel signLabel;

	/**
	 * Launch the application.
	 */
	public static void signUp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		
		lblNewLabel.setBounds(10, 41, 109, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		lblNewLabel_1.setBounds(10, 93, 78, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		lblNewLabel_2.setBounds(10, 136, 57, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
	
		lblNewLabel_3.setBounds(10, 183, 46, 19);
		contentPane.add(lblNewLabel_3);
		
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 102, 51));
		textField.setBounds(129, 40, 220, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setForeground(new Color(102, 0, 153));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(129, 135, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setForeground(new Color(102, 0, 153));
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(240, 135, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		
		
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 102, 51));
		passwordField.setBounds(129, 92, 220, 20);
		contentPane.add(passwordField);
		

		JButton btnNewButton = new JButton("Sign Up!");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(102, 0, 153));
		btnNewButton.setBounds(190, 228, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 102, 51));
		textField_1.setBounds(129, 184, 220, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		signLabel = new JLabel(signImage);
		signLabel.setBounds(-15, 0, 543, 307);
		contentPane.add(signLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String gender;
				String age;
				if( rdbtnNewRadioButton.isSelected())
					gender = "male";
				else
					gender = "female";
			 age = textField_1.getText();
			 if( userName.equals("") || password.equals("") || age.equals("") || !(rdbtnNewRadioButton.isSelected()) && !(rdbtnNewRadioButton_1.isSelected()))
			 {
				 JOptionPane.showMessageDialog(null,"Please fill in all of the blanks"); 
			 }
			 else if(!(isInteger(age)))
			 {
				 JOptionPane.showMessageDialog(null,"Age must be an integer!");
			 }
			 else
			 {
			 user.addUser(userName, password, gender, age);	
			 }
		}});
	}
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void adminLog() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 389);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadminLogin = new JLabel("Admin Login");
		lblAadminLogin.setFont(new Font("Arial", Font.BOLD, 15));
		lblAadminLogin.setForeground(new Color(102, 0, 153));
		lblAadminLogin.setBounds(22, 49, 121, 54);
		contentPane.add(lblAadminLogin);
		
		JLabel lblEnter = new JLabel("Enter code");
		lblEnter.setFont(new Font("Arial", Font.BOLD, 14));
		lblEnter.setBackground(Color.WHITE);
		lblEnter.setBounds(22, 119, 86, 14);
		contentPane.add(lblEnter);
		
		textField = new JTextField();
		textField.setBounds(117, 117, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setForeground(new Color(102, 0, 153));
		btnEnter.setBackground(Color.WHITE);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin admin = new Admin("");
				 String adminCode = textField.getText();
				 if( admin.login(adminCode) == true)

				 {

				 textField.setText( null);

				 setVisible(false);

				 AdminPlanAdd add = new AdminPlanAdd();

				 add.adminPlanAdd();

				 }
				else
				{
					JOptionPane.showMessageDialog( null,"Invalid login","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEnter.setBounds(108, 162, 89, 34);
		contentPane.add(btnEnter);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 0, 521, 39);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Trippin'");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(label);
	}

}

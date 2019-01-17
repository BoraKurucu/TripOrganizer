import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.imageio.*;
 class Log extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private File file =  new File( "User.txt");
	private ImageIcon logImage = new ImageIcon(getClass().getResource("road.jpg"));
	private JLabel logLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log();
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
	String userName;
	public Log() {
		setTitle("Trippin'");
		setBackground(Color.WHITE);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 572, 337);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Trippin'");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(102, 0, 153));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(154, 10, 250, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(22, 83, 114, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(22, 148, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(189, 82, 190, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 147, 190, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(102, 0, 153));
		btnLogin.setBackground(Color.WHITE);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user;
				user = new User("","","","");
				 userName = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				if( !(textField.getText().equals("")) &&  !(password.equals("")))
				{
			
				if( user.login(userName,password) == true)
				{
	            
					MainMenu main = new MainMenu();
					main.newScreen(userName);	
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog( null,"Invalid login","Error",JOptionPane.ERROR_MESSAGE);
				}
				}
				else
				{
					JOptionPane.showMessageDialog( null,"Please fill in all of the blanks","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnLogin.setBounds(178, 183, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(102, 0, 153));
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText( null);
				passwordField.setText(null);
			}
		});
		btnReset.setBounds(303, 183, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(102, 0, 153));
		btnExit.setBackground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(441, 183, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setForeground(new Color(102, 0, 153));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp sign = new SignUp();
				sign.signUp();
			}
		});
		btnNewButton.setBounds(441, 36, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnIAmAdmin = new JButton("I am admin");
		btnIAmAdmin.setForeground(new Color(102, 0, 153));
		btnIAmAdmin.setBackground(Color.WHITE);
		btnIAmAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 setVisible(false);
				AdminLogin adm = new AdminLogin();
				adm.adminLog();
			}
		});
		btnIAmAdmin.setBounds(214, 252, 117, 23);
		contentPane.add(btnIAmAdmin);
		logLabel = new JLabel(logImage);
		logLabel.setForeground(new Color(102, 0, 153));
		logLabel.setBounds(-11, 0, 574, 307);
		contentPane.add(logLabel);
		
	}
}

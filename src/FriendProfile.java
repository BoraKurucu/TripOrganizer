import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
public class FriendProfile extends JFrame
{
	private File file =  new File( "User.txt");
	private static User user = new User("","","","");
	private JFrame frmMyProfile;
	private JPanel panel;
	private JComboBox comboBox;
	private JLabel name;
	private JLabel gender;
	private JLabel age;
	private static String name2;
	public static void newScreen(String userName) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					name2 = userName;
					user = user.getUserByScan(name2);
					FriendProfile my = new FriendProfile();
					my.name.setText( user.getUserName());
					my.gender.setText(user.getGender());
					my.age.setText( user.getAge());			
					my.frmMyProfile.setVisible( true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FriendProfile()
	{
		initialize();
	}
	public void initialize()
	{
		frmMyProfile = new JFrame( "Profile Page");
		frmMyProfile.getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		frmMyProfile.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frmMyProfile.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel profileLbl = new JLabel("Friend's Profile");
		profileLbl.setHorizontalAlignment(SwingConstants.CENTER);
		profileLbl.setBounds(132, 11, 176, 14);
		panel.add(profileLbl);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(50, 60, 46, 14);
		panel.add(lblName);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(50, 85, 46, 14);
		panel.add(lblGender);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(50, 110, 46, 14);
		panel.add(lblAge);
		
		 name = new JLabel("");
		name.setBounds(132, 60, 46, 14);
		panel.add(name);
		 
		  gender = new JLabel("");
		  gender.setBounds(132, 85, 46, 14);
		  panel.add(gender);
		
		 age = new JLabel("");
		age.setBounds(132, 110, 46, 14);
		panel.add(age);
	}
}
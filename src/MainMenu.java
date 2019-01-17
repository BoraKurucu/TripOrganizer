import java.awt.EventQueue;

import javax.swing.*;
import java.util.*;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
public class MainMenu {
	private File file =  new File( "User.txt");
	private JFrame frmMainmenu;
	private JLabel holidayLabel;
	private User user;
	private MyProfile profile;
	private static String name;
	private String text = "";
	private String text2 = "We are working on new plans!";
	private Plan plan = new Plan("","","");
	private City city = new City("city");
	private ArrayList<JButton> buttonList = new ArrayList<JButton>();
	private PlanWindow planWindow = new PlanWindow();
	private JPanel titlePanel;
	private JLabel title;
	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel holidayPanel;
	private JLabel mainLabel;
	private JLabel artLabel;
	private JLabel concertLabel;
	private ImageIcon holidayImage = new ImageIcon(getClass().getResource("newholiday.jpg"));
	private ImageIcon main1Image = new ImageIcon(getClass().getResource("main2.jpg"));
	private ImageIcon artImage = new ImageIcon(getClass().getResource("main3.jpg"));
	private ImageIcon concertImage = new ImageIcon(getClass().getResource("concert.jpg"));
	
	
	private JTextField txtEnterUsersName;
	private Friends friend = new Friends();

	/**
	 * Launch the application.
	 */
	public static void newScreen(String userName) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					name = userName;
					MainMenu window = new MainMenu();
					window.frmMainmenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void initialize() {
		user = new User( "","","","");
		profile = new MyProfile();
		frmMainmenu = new JFrame();
		
		frmMainmenu.getContentPane().setBackground(Color.WHITE);
		frmMainmenu.setBackground(Color.WHITE);
		frmMainmenu.getContentPane().setForeground(Color.WHITE);
		frmMainmenu.getContentPane().setFont(new Font("Adobe Caslon Pro", Font.BOLD, 25));
		frmMainmenu.setTitle("Home Page");
		frmMainmenu.setBounds(100, 100, 880, 548);
		frmMainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainmenu.getContentPane().setLayout(null);
		
		JLabel lblRecommendenCitiesFor = new JLabel("Recommended  cities for you");
		lblRecommendenCitiesFor.setForeground(new Color(102, 0, 153));
		lblRecommendenCitiesFor.setFont(new Font("Arial", Font.BOLD, 14));
		lblRecommendenCitiesFor.setBounds(42, 295, 218, 14);
		frmMainmenu.getContentPane().add(lblRecommendenCitiesFor);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(303, 295, 383, 76);
		frmMainmenu.getContentPane().add(panel);
		ArrayList<Plan> list = plan.getList();
		 for( int i = 0; i < city.getCityList().size();i++)
		  {
		   text = city.getCityList().get(i);
		  planClicked clicked = new planClicked();
		   JButton button3 = new JButton();
		   button3.addActionListener(clicked);
		   button3.setText(text);
		   buttonList.add(button3);
		  panel.add(button3);
		  }
		   
		JButton btnProfile = new JButton("Profile");
		btnProfile.setForeground(new Color(102, 0, 153));
		btnProfile.setBackground(Color.WHITE);
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				{
				profile.newScreen(name);
				frmMainmenu.setVisible(false);
				}
				
			}
		});
		btnProfile.setBounds(739, 458, 89, 23);
		frmMainmenu.getContentPane().add(btnProfile);
		
		JButton btnAddfriend = new JButton("AddFriend");
		btnAddfriend.setForeground(new Color(102, 0, 153));
		btnAddfriend.setBackground(Color.WHITE);

		btnAddfriend.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
		User user = new User("","","","");
		if((txtEnterUsersName.getText().equals("")))
		{
			JOptionPane.showMessageDialog(null,"Please enter the friend name");
		}
		else
		{
			if(user.findUserByName(txtEnterUsersName.getText()))
			{
				
				if(friend.findCombination(name,txtEnterUsersName.getText()))
				{

					JOptionPane.showMessageDialog(null,"You are already friends!");

				}
				else
				{
					friend.addFriend(name, txtEnterUsersName.getText());
					JOptionPane.showMessageDialog(null,"Friend succesfuly added");
				}
			}
			else
			{
				JOptionPane.showMessageDialog( null,"User not found","Friend error",JOptionPane.ERROR_MESSAGE);	
			}
			}
			}

			});

		btnAddfriend.setBounds(395, 458, 120, 23);

		frmMainmenu.getContentPane().add(btnAddfriend);
		
		txtEnterUsersName = new JTextField();
		txtEnterUsersName.setText("EnterUsersName");
		txtEnterUsersName.setBounds(548, 460, 125, 20);
		frmMainmenu.getContentPane().add(txtEnterUsersName);
		txtEnterUsersName.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 0, 153));
		panel_2.setBounds(0, 0, 854, 39);
		frmMainmenu.getContentPane().add(panel_2);
		Panel holPanel = new Panel();
		holPanel.setBounds(0, 35, 854, 100);
		frmMainmenu.getContentPane().add(holPanel);
		holidayLabel = new JLabel(holidayImage);
		holPanel.add(holidayLabel);
		Panel panel_8 = new Panel();
		panel_8.setBounds(32, 141, 161, 144);
		frmMainmenu.getContentPane().add(panel_8);
		mainLabel = new JLabel(main1Image);
		panel_8.add(mainLabel);
		JTextPane txtpnTrippinIsHelping = new JTextPane();
		txtpnTrippinIsHelping.setEditable(false);
		txtpnTrippinIsHelping.setFont(new Font("Georgia", Font.BOLD, 19));
		txtpnTrippinIsHelping.setContentType("text/plain/size");
		txtpnTrippinIsHelping.setBackground(new Color(0, 191, 255));
		txtpnTrippinIsHelping.setForeground(Color.WHITE);
		txtpnTrippinIsHelping.setText("Trippin' is helping your vacation get along nicely by offering different cities and plans.");
		txtpnTrippinIsHelping.setBounds(215, 194, 428, 75);
		frmMainmenu.getContentPane().add(txtpnTrippinIsHelping);
		artLabel = new JLabel(artImage);
		artLabel.setBounds(684, 154, 170, 131);
		frmMainmenu.getContentPane().add(artLabel);
		concertLabel = new JLabel(concertImage);
		concertLabel.setBounds(31, 365, 262, 144);
		frmMainmenu.getContentPane().add(concertLabel);
		JTextPane txtpnIfYouWant = new JTextPane();
		txtpnIfYouWant.setEditable(false);
		txtpnIfYouWant.setFont(new Font("Georgia", Font.BOLD, 17));
		txtpnIfYouWant.setForeground(Color.WHITE);
		txtpnIfYouWant.setBackground(new Color(102, 0, 153));
		txtpnIfYouWant.setText("If you want to have fun, Trippin' is exactly what you are looking for.");
		txtpnIfYouWant.setBounds(303, 385, 341, 56);
		frmMainmenu.getContentPane().add(txtpnIfYouWant);
		
		JLabel lblTrippin = new JLabel("Trippin'");
		lblTrippin.setForeground(Color.WHITE);
		lblTrippin.setFont(new Font("Arial", Font.BOLD, 24));
		panel_2.add(lblTrippin);
	}
	public String getText()
	{
		return this.text;
	}
	public class planClicked implements ActionListener
	  {
	   public void actionPerformed( ActionEvent k)
	   { 
        JButton button7 = (JButton)k.getSource();
	    planWindow.planWindow(button7.getText(), name);
	    }
	   public planClicked()
	   {
		   planWindow.setPlanText(getText());
		   
	   }
	   
	  }
	public String getUserName()
	{
		return name;
	}
}

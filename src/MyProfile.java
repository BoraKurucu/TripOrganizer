	import java.awt.*;
	import java.awt.event.*;
	import java.io.File;
	import java.util.*;
	import javax.swing.*;
	import java.io.*;
	
	public class MyProfile {
	private File file1 =  new File( "User.txt");
	private File file2 = new File( "Friends.txt");
	private FriendProfile friendPrfl = new FriendProfile();
	private static User user = new User("","","","");
	private JFrame frmMyProfile;
	private JPanel panel;
	private JComboBox comboBox;
	private JLabel name;
	private JLabel gender;
	private JLabel age;
	private JLabel imageLabel;
	private Friends friends = new Friends();
	private static String name2;
	private String[] friendList;
	private ImageIcon image = new ImageIcon(getClass().getResource("mapp.png"));
	private ImageIcon image2 = new ImageIcon(getClass().getResource("mapp.png"));
	private MyTrips trips = new MyTrips();
	private ImageIcon imageIcon;
	private Image newimg;
	private JLabel pinLabel;
	private ImageIcon pinImage = new ImageIcon(getClass().getResource("pin.png"));
	private JPanel pinPanell;
	private ArrayList<JLabel> labelList;
	private Friends friend = new Friends();
	public static void newScreen(String userName) {
	EventQueue.invokeLater(new Runnable() {
	public void run() {
	try {
	name2 = userName;
	user = user.getUserByScan(name2);
	MyProfile my = new MyProfile();
	my.name.setText( user.getUserName());
	my.gender.setText(user.getGender());
	my.age.setText( user.getAge());
	my.frmMyProfile.setVisible( true);
	my.showPins();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	});
	}
public MyProfile() {

			friendList = new String[friends.findFriendsByName(name2).size()];

			for ( int i = 0; i < friends.findFriendsByName(name2).size(); i++)

			{

			friendList[i] = friends.findFriendsByName(name2).get(i);

			}

			initialize();

			}
	public void initialize() {
		labelList = new ArrayList<JLabel>();
	frmMyProfile = new JFrame( "Profile Page");
	frmMyProfile.setBackground(Color.WHITE);
	frmMyProfile.getContentPane().setBackground(Color.WHITE);
	frmMyProfile.setTitle("Your Profile");
	frmMyProfile.getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
	frmMyProfile.getContentPane().setLayout(null);
	frmMyProfile.setBounds(0, 0, 1252,843);
	pinPanell = new JPanel();
	pinPanell.setBackground(Color.WHITE);
	pinPanell.setBounds(0, 0, 1252, 843);
	frmMyProfile.getContentPane().add(pinPanell);
	pinPanell.setOpaque(false);
	pinPanell.setLayout( null);
	
	
	JLabel Denizli = new JLabel("");
	Denizli.setBounds(318, 463, 20, 61);
	pinPanell.add(Denizli);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(102, 0, 153));
	panel_1.setBounds(0, 0, 1242, 29);
	pinPanell.add(panel_1);
	
	JLabel label = new JLabel("Trippin'");
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Arial", Font.BOLD, 20));
	panel_1.add(label);
	pinLabel = new JLabel(pinImage);
	    
	imageLabel = new JLabel(image);
	imageLabel.setBounds(0, 52, 1234, 744);
	panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setBounds(0, 0, 1252,843);
	frmMyProfile.getContentPane().add(panel);
	panel.setLayout(null);
	panel.add( imageLabel);
	
	JComboBox comboBox_1 = new JComboBox(friendList);
	comboBox_1.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
		String userName = (String)comboBox_1.getSelectedItem();
		friendPrfl.newScreen(userName);
	}
	});
	comboBox_1.setBounds(10, 132, 119, 20);
	panel.add(comboBox_1);
	JLabel lblFriendsList = new JLabel("Friends List");
	lblFriendsList.setHorizontalAlignment(SwingConstants.CENTER);
	lblFriendsList.setBounds(10, 102, 119, 28);
	panel.add(lblFriendsList);
	JLabel lblName = new JLabel("Name:");
	lblName.setBounds(179, 60, 46, 14);
	panel.add(lblName);
	JLabel lblGender = new JLabel("Gender:");
	lblGender.setBounds(179, 82, 46, 14);
	panel.add(lblGender);
	JLabel lblAge = new JLabel("Age:");
	lblAge.setBounds(179, 107, 46, 14);                                             
	panel.add(lblAge);
	name = new JLabel("");
	name.setBounds(235, 60, 137, 14);
	panel.add(name);
	 
	  gender = new JLabel("");
	  gender.setBounds(235, 82, 137, 14);
	  panel.add(gender);
	  
	   age = new JLabel("");
	   age.setBounds(235, 107, 137, 14);
	   panel.add(age);
	   
	    JLabel Istanbul = new JLabel("");
	    JLabel Istanbul2 = new JLabel( "Istanbul");
	        Istanbul.setBounds(302, 288, 56, 16);
	        frmMyProfile.getContentPane().add(Istanbul);
	        labelList.add(Istanbul2);
	        
	        JLabel Ankara = new JLabel("");
	        JLabel Ankara2 = new JLabel( "Ankara");
	        Ankara.setBounds(463, 363, 42, 39);
	        frmMyProfile.getContentPane().add(Ankara);
	        labelList.add(Ankara2);
	        
	        JLabel Izmir = new JLabel("");
	        JLabel Izmir2 = new JLabel( "Izmir");
	        Izmir.setBounds(222, 436, 42, 39);
	        frmMyProfile.getContentPane().add(Izmir);
	        labelList.add(Izmir2);
	        
	        JLabel Canakkale = new JLabel("");
	        JLabel Canakkale2 = new JLabel( "Canakkale");
	        Canakkale.setBounds(202, 342, 56, 16);
	        frmMyProfile.getContentPane().add(Canakkale);
	        labelList.add(Canakkale2);
	        
	        JLabel Antalya = new JLabel("");
	        JLabel Antalya2 = new JLabel( "Antalya");
	        Antalya.setBounds(366, 525, 74, 39);
	        frmMyProfile.getContentPane().add(Antalya);
	        labelList.add(Antalya2);
	}
	private void pinPlacer(int x, int y) {
		pinLabel = new JLabel( pinImage);
		pinLabel.setBounds(x - 25 ,y - 25 , 50, 50);
		pinPanell.add(pinLabel);
		pinPanell.repaint();
	}
	 public void addPin(String cityName)
     {
	
     	for(int x = 0; x < labelList.size();x++)
     	{
     		if( labelList.get(x).getText().equals(cityName))
     		{
     			trips.addTrip(name2, cityName);
     			pinPlacer(labelList.get(x).getHorizontalAlignment(),labelList.get(x).getVerticalAlignment());
     		}
     	}
     }
	 
	 public ArrayList<JLabel> getLabelList()
	 {
		 return labelList;
	 }
	 
	 
	 private void showPins() {
		boolean exist = false;
		System.out.println("Ýn show Pins");
		ArrayList<String> tripList = trips.getTrips(name2);
		System.out.println(tripList. get(0));
		
		
		if(tripList.size() != 0) {
			while (tripList.get(0) != null) {
				
				if(tripList.get(0). equalsIgnoreCase("Istanbul")) {
					pinLabel.setBounds(302 - 25 ,288 - 25 , 50, 50);
					tripList.remove(0);
				} else
				if(tripList.get(0). equalsIgnoreCase("Ankara")) {
					pinLabel.setBounds(455  ,329 - 25 , 50, 50);
					tripList.remove(0);
				} else
			    if (tripList.get(0). equalsIgnoreCase("Antalya")) {
			    	pinLabel.setBounds(333  ,525 - 25 , 50, 50);
			    	tripList.remove(0);
			    } else
			    if(tripList.get(0). equalsIgnoreCase("Izmir")) {
			    	pinLabel.setBounds(200  ,436 - 25 , 50, 50);
			    	tripList.remove(0);
			    } else
			    if(tripList.get(0). equalsIgnoreCase("Canakkale")) {
			    	pinLabel.setBounds(202  ,313 - 25 , 50, 50);
			    	tripList.remove(0);
			    }
				pinPanell.add(pinLabel);
				pinLabel = new JLabel(pinImage);
			}
			
		}
		pinPanell.repaint();
		
	}
	}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
public class PlanViewer extends JFrame {
	private JPanel contentPane;
	private Plan plan = new Plan("","","");
	private String desc;
	private String userSName;
	private String comments2;
	private User user = new User("","","","");
	private File file = new File("Comments.txt");
	private File file2 = new File("Ratings.txt");
	private ArrayList<String> commentList;
	private ArrayList<String> users;
	private ArrayList<Double> ratings;
	private String[] userArray;
	private String avgRatingKeeper;
	private String userRatingKeeper;
	private JLabel lblYourRating;
	private JLabel lblAvgRating;
	private JComboBox rating;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JTextArea comments;
	private JLabel title;
	private JPanel titlePanel;
	private ImageIcon image;
	private JLabel imageLabel;
	private JTextField writeComments;
	private JButton btnMainmenu;
	private JButton btnMyprofile;
	private MyProfile myProf;
	/** * Launch the application. */
	public void PlanView( String text, String textUser, String textPlan) {EventQueue.invokeLater(new Runnable() 
	{
		public void run() {
			try {
				userSName = textUser;
				desc = text;
				user = user.getUserByScan( userSName);
				PlanViewer frame = new PlanViewer( desc, userSName, textPlan);
				frame.setVisible(true);
				} 
				catch (Exception e) {
				e.printStackTrace();
				}
			}
		}
	);
	}
	/** * Create the frame. */
	public PlanViewer( String text, String textUser, String textPlan) {
		myProf = new MyProfile();
		userSName = textUser;
		desc = text;
		setPlan( plan.getPlanByName( textPlan));
		avgRatingKeeper = "Rating of this plan: " + getAvgRating( textPlan);
		userRatingKeeper = "Your Rating: " + getUserRating( textPlan, textUser);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 543);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		lblNewLabel = new JLabel(desc);
		contentPane.setLayout(null);
		textArea = new JTextArea(5, 5);
		textArea.setBounds(5, 29, 373, 335);
		textArea.setText(desc);
		textArea.setEditable(false);
		comments = new JTextArea(5, 5);
		comments.setBounds(388, 29, 373, 335);
		comments.setEditable(false);
		
		contentPane.add(textArea);
		contentPane.add(comments);
		lblNewLabel.setBounds(42, 39, 349, 126);
		lblNewLabel.setSize(200, 200);
		titlePanel = new JPanel();
		titlePanel.setBounds(5, 0, 756, 29);
		titlePanel.setBackground(new Color(102, 0, 153));
		
		
		title = new JLabel("Trippin'");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setForeground(Color.WHITE);
		titlePanel.add(title);
		contentPane.add(titlePanel);

		image = new ImageIcon("cameltrip.jpg");
		
		imageLabel = new JLabel(image);
		imageLabel.setBounds(5, 342, 524, -1);
	    contentPane.add(imageLabel);
	    
		users = getUsers();
		System.out.println( users);
		userArray = new String[users.size()];
		for ( int i = 0; i < users.size(); i++) {
			userArray[i] = users.get(i);
			System.out.println( );
		}
		JComboBox commentBox = new JComboBox( userArray);
		commentBox.setForeground(new Color(102, 0, 153));
		commentBox.setBackground(Color.WHITE);
		commentBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				comments.setText( "");
				String userName = (String)commentBox.getSelectedItem();
				comments.setText( textModify( userName));
			}
		});
		commentBox.setBounds(485, 450, 78, 20);
		contentPane.add(commentBox);
		writeComments = new JTextField();
		writeComments.addActionListener(new ActionListener( ){
			public void actionPerformed(ActionEvent e)
			{
				addComment( userSName, writeComments.getText());
				contentPane.revalidate();
				contentPane.repaint();
			}
			});
		
		writeComments.setBounds(5, 450, 436, 20);
		contentPane.add(writeComments);
		writeComments.setColumns(10);
		
		lblYourRating = new JLabel( userRatingKeeper);
		lblYourRating.setFont(new Font("Arial", Font.BOLD, 12));
		lblYourRating.setForeground(new Color(102, 0, 153));
		lblYourRating.setBounds(616, 386, 102, 24);
		contentPane.add(lblYourRating);
		
		lblAvgRating = new JLabel( avgRatingKeeper);
		lblAvgRating.setFont(new Font("Arial", Font.BOLD, 12));
		lblAvgRating.setForeground(new Color(102, 0, 153));
		lblAvgRating.setBounds(616, 421, 135, 24);
		contentPane.add(lblAvgRating);
		
		String[] points = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		rating = new JComboBox( points);
		rating.setForeground(new Color(102, 0, 153));
		rating.setBackground(Color.WHITE);
		rating.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				double rate = (Double.valueOf( (String)rating.getSelectedItem()));
				rate( rate, userSName);
				String p = plan.getPlanName();
				setVisible( false);
				PlanView( desc, userSName, p);
			}
		});
		btnMainmenu = new JButton("MainMenu");
		btnMainmenu.setForeground(new Color(102, 0, 153));
		btnMainmenu.setBackground(Color.WHITE);
		btnMainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu main = new MainMenu();
				setVisible(false);
				main.newScreen(main.getUserName());
			}
		});
		btnMainmenu.setBounds(15, 480, 111, 23);
		contentPane.add(btnMainmenu);
		
		btnMyprofile = new JButton("MyProfile");
		btnMyprofile.setForeground(new Color(102, 0, 153));
		btnMyprofile.setBackground(Color.WHITE);
		btnMyprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyProfile profile = new MyProfile();
		  		MainMenu main = new MainMenu();
		  	    setVisible(false);
		  		profile.newScreen(main.getUserName());
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(102, 0, 153));
		btnRegister.setBackground(Color.WHITE);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 plan.setChecked(true);
				 MyTrips trips = new MyTrips();
				 trips.addTrip(userSName, plan.getCityName());
		    	   System.out.println("Before initialisng plan");
		    	   plan = plan.getPlanByDescription(desc);
		    	   myProf.addPin(plan.getCityName());
		    	   System.out.println("After initialisng plan");
		    	   JOptionPane.showMessageDialog(null,"Successfully registered!");
			}
		});
		btnRegister.setBounds(99, 390, 89, 23);
		contentPane.add(btnRegister);
	
		btnMyprofile.setBounds(160, 480, 138, 23);
		contentPane.add(btnMyprofile);
		rating.setBounds(485, 388, 55, 20);
		contentPane.add(rating);
		
		JLabel lblNewLabel_2 = new JLabel("Rate this trip: ");
		lblNewLabel_2.setBounds(416, 388, 69, 20);
		contentPane.add(lblNewLabel_2);
	}
		
	public int containTimes( String text, char ch)
	{
		int keep = 0;
		for ( int i = 0; i < text.length(); i++) {
			if( text.charAt(i) == ch) {
				keep++;
			}
		}
		return keep;
	}
	public ArrayList<String> getUsers()
	{
		boolean found = false;
		users = new ArrayList<String>();
		ArrayList<String> usersDupe = new ArrayList<String>();
		Scanner scan = null;
		try
		{
			scan = new Scanner( file);
		}
		catch( Exception e)
		{
			
		}
		try
		{
			while( scan.hasNextLine())
			{
				String line = scan.nextLine();
				usersDupe.add( line.substring(0, line.indexOf( "|")));
			}
		}
		catch( Exception e) {
			
		}
		finally {
			scan.close();
		}
		for( int i = 0; i < usersDupe.size(); i++)
		{
			if( users.size() == 0)
			{
				users.add( usersDupe.get(i));
			}
			else
			{
				for( int j = 0; j < users.size(); j++)
				{
					if( users.get(j).equals( usersDupe.get(i)))
					{
						found = true;
						break;
					}
				}
				if( !found)
				{
					users.add( usersDupe.get(i));
				}
			}
			found = false;
		}
		return users;
	}
	public ArrayList<String> getCommentsOfUser( String userName)
	{
		commentList = new ArrayList<String>();
		Scanner scan = null;
		try
		{
			scan = new Scanner( file );
		}
		catch( Exception e)
		{
			
		}
		try
		{
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				if(line.contains( userName + "|" + plan.getPlanName()))
				{
					int place1 = line.indexOf("|");
					int place2 = line.indexOf("|", place1 + 1);
					int place3 = line.indexOf("|", place2 + 1);
					commentList.add( line.substring(place2 + 1, place3));
				}
			}
	        
	     }catch(Exception e){
	        e.printStackTrace();
	     }
	     finally
	     {
	        scan.close();
	     }
	     return commentList;
	}
	
	public void addComment( String userName, String text)
		{
			String txt = "";
			PrintWriter  writer = null;
			try
			{
					writer = new PrintWriter(new FileWriter( file,true));
					writer.println( userName + "|" + plan.getPlanName() + "|" + text + "|");
					writer.close();
			}
			catch( Exception e)
			{
				
			}	
		}
	public static void renameFile(File toBeRenamed, String new_name)
		    throws IOException {
		    //need to be in the same path
		    File fileWithNewName = new File(toBeRenamed.getParent(), new_name);
		    if (fileWithNewName.exists()) {
		        throw new IOException("file exists");
		    }
		    // Rename file (or directory)
		    boolean success = toBeRenamed.renameTo(fileWithNewName);
		    if (!success) {
		        // File was not successfully renamed
		    }
		}
	public boolean userHasCommented( String userName)
	{
		boolean exist = false;
		Scanner scan = null;
	    try{
	       scan = new Scanner( file );
	    }
	    catch( Exception e)
	    {
	    }
	    try
	    {
	    	while ( scan.hasNextLine()) {
	    	String line = scan.nextLine();
	    		if( line.contains( userName))
	    		{
	    			exist = true;
	    			return exist;
	    		}
	    	}
	    }
	    catch(Exception e){
	        e.printStackTrace();
	     }
	     finally
	     {
	        scan.close();
	     }return exist;
	}
	public void setPlanText(String str){
		textArea.setText(str);
	}
	public Plan getPlan(){
		return plan;
	}
	public void setPlan( Plan p){
		plan = p;
	}
	public JTextArea getLbl(){
		return textArea;
	}
	public String textModify( String userText) {
		String text = "";
		if( userHasCommented( userText)) {
			for( int i = 0; i < getCommentsOfUser( userText).size(); i++) {
					text = text + comments.getText() + "\n" + getCommentsOfUser( userText).get(i);
			}
		}
		System.out.println( "text is: " + text);
		return text;
	}
	
	public void rate( double rating, String userName)
	{
		PrintWriter writer = null;
		try
		{
			writer = new PrintWriter( new FileWriter( file2, true));
			writer.println( plan.getPlanName() + "|" + userName + "|" + rating + "|");
		}
		catch( Exception e)
		{
			
		}
		finally 
		{
			writer.close();
		}
	}
	public double getAvgRating( String planName)
	{
		ratings = new ArrayList<Double>();
		Scanner scan = null;
		try
		{
			scan = new Scanner( file2);
		}
		catch( Exception e)
		{
			
		}
		try
		{
			while( scan.hasNextLine())
			{
				String line = scan.nextLine();
				if( line.contains( planName))
				{
					int place1 = line.indexOf("|");
					int place2 = line.indexOf("|", place1 + 1);
					int place3 = line.indexOf("|", place2 + 1);
					Double rating = Double.parseDouble( line.substring( place2 + 1, place3));
					System.out.println( rating);
					ratings.add( rating);
				}
			}
		}
		catch( Exception e)
		{
			
		}
		if( ratings.size() == 0)
		{
			ratings.add(0.0);
		}
		Double big = 0.0;
		for( int i = 0; i < ratings.size(); i++)
		{
			big = big + ratings.get(i);
		}
		big = big / ratings.size();
		String h = String.format(Locale.US, "%.1f", big);
		big = Double.valueOf( h);
		ratings.clear();
		return big;
	}
	public double getUserRating( String planName, String userName)
	{
		ratings = new ArrayList<Double>();
		Scanner scan = null;
		try
		{
			scan = new Scanner( file2);
		}
		catch( Exception e)
		{
			
		}
		try
		{
			while( scan.hasNextLine())
			{
				String line = scan.nextLine();
				if( line.contains( planName + "|" + userName))
				{
					int place1 = line.indexOf("|");
					int place2 = line.indexOf("|", place1 + 1);
					int place3 = line.indexOf("|", place2 + 1);
					Double rating = Double.parseDouble( line.substring( place2 + 1, place3));
					ratings.add( rating);
					
				}
			}
		}
		catch( Exception e)
		{
			
		}
		if( ratings.size() == 0)
		{
			ratings.add(0.0);
		}
		Double big = 0.0;
		for( int i = 0; i < ratings.size(); i++)
		{
			big = big + ratings.get(i);
		}
		big = big / ratings.size();
		String h = String.format(Locale.US, "%.1f", big);
		big = Double.valueOf( h);
		ratings.clear();
		return big;
	}
}

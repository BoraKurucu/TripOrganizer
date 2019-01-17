import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class PlanWindow extends JFrame {

 private JPanel contentPane = new JPanel();
 private ArrayList<Plan> planList = new ArrayList<Plan>();
 private ArrayList<JButton> buttonList = new ArrayList<JButton>();
 private User user = new User( "","","","");
 private Plan plan = new Plan("","","");
private String cityName;
private String userSName;
PlanViewer planView = new PlanViewer("","","");
private String description = "";
private JLabel planLabel;
private ImageIcon planImage = new ImageIcon(getClass().getResource("beach.jpg"));


 /**
  * Launch the application.
  */
 public  void planWindow(String text, String text2) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
    	PlanWindow planWindow = new PlanWindow();
    	cityName = text;
    	userSName = text2;
    	user = user.getUserByScan(userSName);
    	planList = plan.getPlanList(cityName);
    	organiseButtons();
    	lblNewLabel.setText(text);
     	    setVisible(true);
     	    revalidate();
     	    repaint();
     	    planList.clear();
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the frame.
  */
 private JLabel lblNewLabel;
 public PlanWindow() {
  setTitle("Plans");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 747, 525);
  contentPane.setBackground(Color.WHITE);
  contentPane.setBorder(new EmptyBorder(0, 0, 600, 500));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  lblNewLabel = new JLabel("New label");
  lblNewLabel.setBackground(Color.WHITE);
  lblNewLabel.setBounds(34, 167, 93, 50);
  contentPane.add(lblNewLabel);
  
  JButton btnNewButton = new JButton("New button");
  btnNewButton.setForeground(new Color(102, 0, 153));
  btnNewButton.setBackground(Color.WHITE);
  btnNewButton.setBounds(466, 304, 174, 57);
  btnNewButton.setVisible(false);
  contentPane.add(btnNewButton);
  buttonList.add(btnNewButton);
  
  JButton btnNewButton_1 = new JButton("New button");
  btnNewButton_1.setForeground(new Color(102, 0, 153));
  btnNewButton_1.setBackground(Color.WHITE);
  btnNewButton_1.setVisible(false);
  btnNewButton_1.setBounds(34, 307, 170, 50);
  contentPane.add(btnNewButton_1);
  buttonList.add(btnNewButton_1);
  
  JButton btnNewButton_2 = new JButton("New button");
  btnNewButton_2.setForeground(new Color(102, 0, 153));
  btnNewButton_2.setBackground(Color.WHITE);
  btnNewButton_2.setVisible(false);
  btnNewButton_2.setBounds(466, 227, 174, 57);
  contentPane.add(btnNewButton_2);
  buttonList.add(btnNewButton_2);
  
  JButton btnNewButton_3 = new JButton("New button");
  btnNewButton_3.setForeground(new Color(102, 0, 153));
  btnNewButton_3.setBackground(Color.WHITE);
  btnNewButton_3.setVisible(false);
  btnNewButton_3.setBounds(34, 227, 174, 57);
  contentPane.add(btnNewButton_3);
  buttonList.add(btnNewButton_3);
  
  JButton btnNewButton_4 = new JButton("New button");
  btnNewButton_4.setForeground(new Color(102, 0, 153));
  btnNewButton_4.setBackground(Color.WHITE);
  btnNewButton_4.setVisible(false);
  btnNewButton_4.setBounds(70, 409, 89, 23);
  contentPane.add(btnNewButton_4);
  buttonList.add(btnNewButton_4);
  
  JButton btnNewButton_5 = new JButton("New button");
  btnNewButton_5.setForeground(new Color(102, 0, 153));
  btnNewButton_5.setBackground(Color.WHITE);
  btnNewButton_5.setVisible(false);
  btnNewButton_5.setBounds(70, 376, 89, 23);
  contentPane.add(btnNewButton_5);
  buttonList.add(btnNewButton_5);
  
  JButton btnNewButton_6 = new JButton("New button");
  btnNewButton_6.setForeground(new Color(102, 0, 153));
  btnNewButton_6.setBackground(Color.WHITE);
  btnNewButton_6.setVisible(false);
  btnNewButton_6.setBounds(516, 409, 89, 23);
  contentPane.add(btnNewButton_6);
  buttonList.add(btnNewButton_6);
  
  JButton btnNewButton_7 = new JButton("New button");
  btnNewButton_7.setForeground(new Color(102, 0, 153));
  btnNewButton_7.setBackground(Color.WHITE);
  btnNewButton_7.setVisible(false);
  btnNewButton_7.setBounds(516, 376, 89, 23);
  contentPane.add(btnNewButton_7);
  buttonList.add(btnNewButton_7);
  JTextPane txtpnHereAreThe = new JTextPane();
  txtpnHereAreThe.setFont(new Font("Arial", Font.BOLD, 15));
  txtpnHereAreThe.setEditable(false);
  txtpnHereAreThe.setForeground(Color.WHITE);
  txtpnHereAreThe.setBackground(new Color(102, 0, 153));
  txtpnHereAreThe.setText("Here are the plans we prepared for you. With the plans you will be able to evaluate your time in the most beatiful way.");
  txtpnHereAreThe.setBounds(253, 227, 170, 134);
  contentPane.add(txtpnHereAreThe);
  
  JButton btnMainMenu = new JButton("Main Menu");
  btnMainMenu.setForeground(new Color(102, 0, 153));
  btnMainMenu.setBackground(Color.WHITE);
  btnMainMenu.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent arg0) {
  		MainMenu main = new MainMenu();
  		setVisible(false);
		main.newScreen(main.getUserName());
  	}
  });
  btnMainMenu.setBounds(10, 456, 132, 23);
  contentPane.add(btnMainMenu);
  
  JButton btnMyProfile = new JButton("My Profile");
  btnMyProfile.setForeground(new Color(102, 0, 153));
  btnMyProfile.setBackground(Color.WHITE);
  btnMyProfile.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent arg0) {
  		MyProfile profile = new MyProfile();
  		MainMenu main = new MainMenu();
  		setVisible(false);
  		profile.newScreen(main.getUserName());
  	}
  });
  btnMyProfile.setBounds(163, 456, 141, 23);
  contentPane.add(btnMyProfile);
  
  JPanel panel = new JPanel();
  panel.setBackground(new Color(102, 0, 153));
  panel.setBounds(0, 0, 742, 39);
  contentPane.add(panel);
  
  JLabel label = new JLabel("Trippin'");
  label.setForeground(Color.WHITE);
  label.setFont(new Font("Arial", Font.BOLD, 24));
  panel.add(label);
  planLabel = new JLabel(planImage);
  planLabel.setBounds(91, 28, 570, 159);
  contentPane.add(planLabel);
 }
 public void setPlanText( String str)
 {
	 lblNewLabel.setText(str);
 }
 public void addButton(JButton button)
 {
	 contentPane.add(button);
 }
 public JPanel getContentPane()
 {
	 return contentPane;
 }
 public void organiseButtons()
 {
	 for(int x = 0;x < planList.size();x++) 
	 {
		 System.out.println("for: " + description);
		 description = planList.get(x).getDescription();
		 buttonList.get(x).setText(planList.get(x).getPlanName());
		 buttonList.get(x).addActionListener(new PlanGo());
		 buttonList.get(x).setVisible(true);
	 }
 }
 public String getDescription()
 {
	 return description;
 }
 public class PlanGo implements ActionListener
 {
	 public void actionPerformed(ActionEvent e) 
	 {	 
		JButton dupeButton = (JButton)e.getSource();
		if(plan.planExist(dupeButton.getText()))
		{
			Plan plan2 = plan.getPlanByName(dupeButton.getText());
			planView.PlanView( plan2.getDescription(), user.getUserName(), dupeButton.getText());
		}
		else
		{
			planView.PlanView("We are working on new plans!", "", "");
		}
	 }
	 public PlanGo()
	 {
		 planView.setPlanText(getDescription());
	 }	 
 }
}


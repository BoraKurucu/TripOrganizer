import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;


public class Istanbul extends JFrame {

 private JPanel contentPane;

 /**
  * Launch the application.
  */
 public static void Ist() {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Istanbul frame = new Istanbul();
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
 private PlanWindow planWindow;
 public Istanbul() {
   planWindow = new PlanWindow();
  Plan plan = new Plan("","","");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 450, 300);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JPanel panel = new JPanel();
  panel.setBounds(10, 29, 382, 124);
  contentPane.add(panel);
  panel.setLayout(new GridLayout(0, 1, 0, 0));
  JLabel lblNewLabel = new JLabel("Plans for you");
  lblNewLabel.setBounds(10, 4, 118, 14);
  contentPane.add(lblNewLabel);
  plan.createPlanList();
  panel.setLayout(new GridLayout(plan.getList().size(), 1, 0, 0));
  
  for( int i = 0; i < plan.getList().size();i++)
  {
   planClicked clicked = new planClicked();
   JButton button3 = new JButton();
   button3.addActionListener(clicked);
   button3.setText(plan.getList().get(i).getPlanName());
   panel.add(button3);
   //planWindow.setPlanText("nbr");
  
  }
 }
  public class planClicked implements ActionListener
  {
   public void actionPerformed( ActionEvent k)
   {
    
    planWindow.planWindow("nbr");
   }
   
  }
}
  
  
 

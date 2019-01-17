import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class AdminPlanAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private ArrayList<JTextField> list = new ArrayList<JTextField>();
	private JLabel lblMorning;
	private String text = "";
	private JComboBox<String> comboBox_1;
	Plan plan = new Plan("","","");
	private int i;
	

	/**
	 * Launch the application.
	 */
	public static void adminPlanAdd() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPlanAdd frame = new AdminPlanAdd();
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
	public AdminPlanAdd() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 427);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddPlan = new JLabel("Add Plan");
		lblAddPlan.setFont(new Font("Arial", Font.BOLD, 14));
		lblAddPlan.setForeground(new Color(102, 0, 153));
		lblAddPlan.setBounds(10, 49, 80, 32);
		contentPane.add(lblAddPlan);
		
		i = 1;
		lblMorning = new JLabel("Morning");
		lblMorning.setFont(new Font("Arial", Font.BOLD, 12));
		lblMorning.setBounds(395, 95, 97, 14);
		contentPane.add(lblMorning);
		
		JLabel lblPlanCity = new JLabel("Plan City");
		lblPlanCity.setFont(new Font("Arial", Font.BOLD, 12));
		lblPlanCity.setBackground(Color.WHITE);
		lblPlanCity.setBounds(10, 94, 86, 14);
		contentPane.add(lblPlanCity);
		
		
		JLabel lblPlanName = new JLabel("Plan Name");
		lblPlanName.setFont(new Font("Arial", Font.BOLD, 12));
		lblPlanName.setBounds(10, 118, 78, 14);
		contentPane.add(lblPlanName);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(131, 119, 119, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPlanStepNumber = new JLabel("Plan step number:");
		lblPlanStepNumber.setFont(new Font("Arial", Font.BOLD, 12));
		lblPlanStepNumber.setBounds(10, 156, 112, 14);
		contentPane.add(lblPlanStepNumber);
		
	
		
		JLabel lblStep = new JLabel("Step1:");
		lblStep.setFont(new Font("Arial", Font.BOLD, 12));
		lblStep.setBackground(Color.WHITE);
		lblStep.setBounds(10, 197, 46, 14);
		contentPane.add(lblStep);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 191, 328, 20);
		textField_2.setVisible(false);
		list.add(textField_2);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblStep_1 = new JLabel("Step2:");
		lblStep_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblStep_1.setBounds(10, 229, 46, 14);
		contentPane.add(lblStep_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 223, 328, 20);
		textField_3.setVisible(false);
		contentPane.add(textField_3);
		list.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblStep_2 = new JLabel("Step3:");
		lblStep_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblStep_2.setBackground(Color.WHITE);
		lblStep_2.setBounds(10, 259, 46, 14);
		contentPane.add(lblStep_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 253, 328, 20);
		textField_4.setVisible(false);
		contentPane.add(textField_4);
		list.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Step4:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 289, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(131, 283, 328, 22);
		textField_5.setVisible(false);
		list.add(textField_5);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBackground(Color.WHITE);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {
				JComboBox<Integer> temp = (JComboBox<Integer>)k.getSource();
				int planNumber = (int)temp.getSelectedItem();
				for(int i = 0;i < planNumber;i++)
				{
					list.get(i).setVisible(true);
					revalidate();
					repaint();
				}
				for( int m = list.size() - 1; m > planNumber - 1;m--)
				{

					list.get(m).setVisible(false);
					revalidate();
					repaint();
				}
			}
		});
					
				
		comboBox.setBounds(131, 154, 64, 20);
		comboBox.addItem(1);  
		comboBox.addItem(2);  
		comboBox.addItem(3); 
		comboBox.addItem(4);  
		contentPane.add(comboBox);
		
		
		JLabel lblPressOkEverytime = new JLabel("Press enter everytime you complete the steps for each plan time!");
		lblPressOkEverytime.setFont(new Font("Arial", Font.BOLD, 12));
		lblPressOkEverytime.setBounds(10, 313, 384, 14);
		contentPane.add(lblPressOkEverytime);
		
		JButton btnAddPlan = new JButton("Add Plan");
		btnAddPlan.setForeground(new Color(102, 0, 153));
		btnAddPlan.setBackground(Color.WHITE);
		btnAddPlan.setEnabled(false);
		JButton btnOk = new JButton("OK!");
		btnOk.setForeground(new Color(102, 0, 153));
		btnOk.setBackground(Color.WHITE);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.setEditable(false);
				comboBox_1.setEnabled(false);
				boolean full = true;
				ArrayList<JTextField> visibleList = new ArrayList<JTextField>();
				for( int x = 0; x < list.size();x++)
				{
					if(list.get(x).isVisible())
						visibleList.add(list.get(x));
				}
				for( int m = 0; m < visibleList.size();m++)
				{
					String k = visibleList.get(m).getText();
					if( k.equals(""))
						full = false;
				}
				if( full == false)
				{
					JOptionPane.showMessageDialog( null,"Please fill all of the blanks","Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String stopper = "";
					String current = lblMorning.getText();
					
					text =  text + "-" + current +  " ";
					
					for( int m = 0; m < visibleList.size();m++)
					{
						text = text + i + ". " + visibleList.get(m).getText() + " ";
						i++;
					}
					textField_1.setEditable(false);
					
					for( int z = 0; z < list.size();z++)
					{
						list.get(z).setText("");
					}
					if( lblMorning.getText().equals("Morning"))
					{
						lblMorning.setText("Evening");
						i = 1;
					}
					
					else if(lblMorning.getText().equals("Evening"))
					{
						lblMorning.setText("Night");
						i = 1;
					}
					else if(lblMorning.getText().equals("Night"))
					{
						stopper = "stop";
						i = 1;
					}
					
					if( stopper.equals("stop"))
					{
						btnOk.setEnabled(false);
						btnAddPlan.setEnabled(true);
					}
						
			}
		}});
		btnOk.setBounds(33, 337, 97, 32);
		contentPane.add(btnOk);
		MyProfile profile = new MyProfile();
		ArrayList<JLabel> labelList = profile.getLabelList();

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBackground(Color.WHITE);

		for( int x = 0; x < labelList.size();x++)

		{

		System.out.println("adminplan size: " + labelList.size());

		System.out.println("list ,i " + labelList.get(x).getText());

		comboBox_1.addItem(labelList.get(x).getText());

		}

		comboBox_1.setBounds(131, 91, 112, 20);

		contentPane.add(comboBox_1);
		
		
		btnAddPlan.setBounds(178, 337, 89, 32);
		contentPane.add(btnAddPlan);
		
		JLabel lblPlanTime = new JLabel("Plan Time:");
		lblPlanTime.setFont(new Font("Arial", Font.BOLD, 12));
		lblPlanTime.setBounds(298, 94, 78, 14);
		contentPane.add(lblPlanTime);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 0, 576, 39);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Trippin'");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(label);
		
		
		btnAddPlan.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			String cityName2 = (String)comboBox_1.getSelectedItem();

			plan.addPlan(cityName2, textField_1.getText(), text);

			JOptionPane.showMessageDialog(null,"Plan successfully added");

			}

			});
		
				
		}
}


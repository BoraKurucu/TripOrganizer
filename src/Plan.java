import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Plan
{
private String cityName;
private String planName;
private String description;
private boolean checked;
private File file = new File("Plans.txt");
private PrintWriter writer;
private Plan plan;
private ArrayList<Plan> planList;
private int counter;
private ArrayList<Plan> planList2 = new ArrayList<Plan>();

public  Plan( String cityName,String planName,String description)
{
this.cityName = cityName;
this.planName = planName;
this.description = description;
this.checked = false;
}
public boolean isChecked(){
	return checked;
}
public void setChecked( boolean isChecked) 
{
	this.checked = isChecked;
}
public String getPlanName()
{
	return planName;
}
public String getCityName()
{
	return cityName;
}
public String getDescription()
{
	
	String desc = description;
	for(int i = 1; i < desc.length(); i++) 
	{
		if(desc.charAt(i) == '-' || Character.isDigit(desc.charAt(i))) 
		{
			desc = desc.substring(0,i-1) + "\n" + desc.substring(i);
		}
	}
	return desc;
}

public void addPlan( String cityName,String planName,String description)

{

try

{

PrintWriter writer = new PrintWriter(new FileWriter(file,true));

writer.println(cityName + "|" + planName + "|" + description + "|");

writer.close();

}

catch( Exception e)

{

}

}
public void deletePlan(String planName)
{
	 PrintWriter writerTemp = null;
     File fileTemp = new File( "PlanTemp.txt");
     try
     {
        writerTemp = new PrintWriter(new FileWriter(fileTemp,true));
     }catch( Exception e)
     {
     }
     Scanner scan = null;
     try{
        scan = new Scanner( file );
     }
     catch( Exception e)
     {
     }
     boolean found = false;
     try
     {
        while(scan.hasNextLine())
        {
           String line = scan.nextLine();
           int index = line.indexOf("|");
           int index2 = line.indexOf("|",index +1);
           String planTempName = line.substring(index + 1,index2);
           if(!(planName.equals(planTempName)))
           {
              writerTemp.println( line);
              
           }     
        }
        
     }catch(Exception e){
        e.printStackTrace();
     }
     
        scan.close();
        writerTemp.close();
        fileTemp = file;
        file.delete();
        fileTemp.renameTo(new File("Plans.txt"));
        
     
     
}
public void createPlanList()
{
	planList = new ArrayList<Plan>();
     Scanner scan = null;
     try{
        scan = new Scanner( file );
     }
     catch( Exception e)
     {
     }
     boolean found = false;
     try
     {
        while(scan.hasNextLine())
        {
       	 String line = scan.nextLine();
	            int place1 = line.indexOf( "|");
	            int place2 = line.indexOf("|",place1 + 1);
	            int place3 = line.indexOf("|",place2 + 1);
	            String cityName1 = line.substring( 0,place1);
	            String planName1 = line.substring(place1 + 1, place2);
	            String description1 = line.substring(place2 + 1, place3);
	            //todo
	  
	            
	            Plan h = new Plan(cityName1,planName1,description1);
           	planList.add(h);
                 
        }
        
     }catch(Exception e){
        e.printStackTrace();
     }
     finally
     {
        scan.close();
     }
}
public ArrayList<Plan> getList()
{
	createPlanList();
	return planList;
}
public Plan getPlanByName(String name)
{
	Plan plan = null;
	ArrayList<Plan> list = getList();
	for( int x = 0; x < list.size();x++)
	{
		if(list.get(x).getPlanName().equals(name))
		plan = list.get(x);	
	}
	return plan;
}
public ArrayList<Plan> getPlanList2(String cityName)
{
	ArrayList<Plan> list = getList();
	for( int x = 0; x < list.size();x++)
	{
		if(list.get(x).getCityName().equals(cityName))
		planList2.add(list.get(x));
	}
	return planList2;
}
public boolean planExistInCity(String cityName)
{
	boolean found = false;
	ArrayList<Plan> list = getList();
	for( int x = 0; x < list.size();x++)
	{
		if(list.get(x).getCityName().equals(cityName))
		found = true;
	}
	return found;
}
public boolean planExist(String planName)
{
	boolean found = false;
	ArrayList<Plan> list = getList();
	for( int x = 0; x < list.size();x++)
	{
		if(list.get(x).getPlanName().equals(planName))
		found = true;
	}
	return found;
}
public ArrayList<Plan> getPlanList(String cityName)
{
	ArrayList<Plan> list = getList();

	for( int x = 0; x < list.size();x++)
	{
		if(list.get(x).getCityName().equals(cityName))
		planList2.add(list.get(x));
	}
	return planList2;
}
public ArrayList<JButton> getPlanButtonList(String cityName)
{
	ArrayList<Plan> list = getList();
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	JButton button;
	for( int x = 0; x < list.size();x++)
	{
		if(list.get(x).getCityName().equals(cityName))
		{
			button = new JButton("x+1");
			buttonList.add(button);
		}
			
	}
		return buttonList;
}

public Plan getPlanByDescription(String desc)
{
	Plan plan = null;
	ArrayList<Plan> list = getList();
	for( int x = 0; x < list.size();x++)
	{
		if(list.get(x).getDescription().equals(desc))
		plan = list.get(x);	
	}
	return plan;
}

}
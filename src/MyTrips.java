import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class MyTrips{
    private static String name2;
    private static User user = new User("","","","");
    private PrintWriter writer;
    private File file = new File( "Trips.txt");
    public MyTrips(){
    	
    	
    }
    
    
    public boolean findTrip(String userName,String cityName)
	{
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
	            if((scan.nextLine().equals(userName + "|" + cityName + "|")))
	            {
	               found = true;
	               break;
	            }     
	         }   
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	      finally
	      {
	         scan.close();
	      }
	      return found;
	}
public ArrayList<String> getTrips( String userName){
    	
    	ArrayList<String> tripList = new ArrayList<String>();
	      Scanner scan = null;
	      String scanText = "";
	      try{
	         scan = new Scanner( file );
	         while(scan.hasNext()) {
	        	 scanText = scanText + scan.next();
	         }
	      }
	      catch( Exception e)
	      {
	      }
	     
	      try
	      {
	    	  System.out.println(scanText);
	         while(scanText.indexOf(userName) != -1 )
	         {
	        	 
	             int place1 = scanText.indexOf( userName) + userName.length();
	             scanText = scanText.substring(place1);
	             int place2 = scanText.indexOf("|", 1);
	             String cityName = scanText.substring(1, place2);
	             
	            if(cityName != null)
	            {
	            	tripList.add( cityName);
	            }     
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	      finally
	      {
	         scan.close();
	      }
	      return tripList;
    }
	public void addTrip( String userName, String cityName)
	{
		if(!findTrip(userName,cityName))
		{
		try
	      {
	         writer = new PrintWriter(new FileWriter( file,true));
	         writer.println( userName + "|" + cityName + "|");
	         writer.close();
	      }
	      catch( Exception e)
	      {
	    	 
	      } 
		}
	   }
    }

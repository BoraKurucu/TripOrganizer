import java.io.*;
import java.util.*;
import javax.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;
public class Friends {
	File file;
 PrintWriter writer;
 private BufferedReader reader;
	
	public Friends()
	{
		file = new File( "Friends.txt");
	}
	public void addFriend( String userName, String friendName)

	{

	if(findCombination(userName,friendName) == false)

	{

	try

	{

	writer = new PrintWriter(new FileWriter( file,true));

	writer.println( userName + "|" + friendName + "|");

	writer.println( friendName + "|" + userName + "|");

	writer.close();

	}

	catch( Exception e)

	{

	}

	}

	}		 
	public ArrayList<String> findFriendsByName(String userName)
	{
		ArrayList<String> friendList = new ArrayList<String>();
	      Scanner scan = null;
	      try{
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
	             int place1 = line.indexOf( "|");
	             int place2 = line.indexOf("|",place1 + 1);
	             String userName1 = line.substring( 0,place1);
	             String friendName = line.substring(place1 + 1, place2);
	            if(userName.equals(userName1))
	            {
	            	friendList.add( friendName);
	            }     
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	      finally
	      {
	         scan.close();
	      }
	      return friendList;
	}
	public boolean findCombination(String userName,String friendName)
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
	            if((scan.nextLine().contains(userName + "|" + friendName)))
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
	

}

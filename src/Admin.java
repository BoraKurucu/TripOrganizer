import java.io.*;
import java.util.*;
import javax.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class Admin {
	private String code;
	private File file = new File("Admin.txt");
	
	public Admin( String code)
	{
		this.code = code;
	}
	public void addCode(String code)
	{
		 try
	      {
	         PrintWriter  writer = new PrintWriter(new FileWriter( file,true));
	         writer.println( code);
	         writer.close();
	      }
	      catch( Exception e)
	      {   
	      }   
    }
	 public boolean login( String code)
	   {
		   String text = code;
		   if( getText2().contains(text))
			   return true;
		   else
			   return false;
			   
	   }
	 public String getText2()
	   {
		   String line = "";
	       String oldtext = "";
		   try
		      {
		         BufferedReader reader = new BufferedReader(new FileReader(file));
		         while((line = reader.readLine()) != null)
		         {
		            oldtext += line;
		         }
		         reader.close();
		      }
		      catch (IOException ioe)
		      {
		         ioe.printStackTrace();
		      }
		  // System.out.println(oldtext);
		   return oldtext;
	   }
	   

}

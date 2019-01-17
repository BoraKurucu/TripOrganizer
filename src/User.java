import java.io.*;
import java.util.*;
import javax.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;



public class User
{
   
   private String userName;
   private String password;
   private String gender;
   private String age;
   
   private  File file;
   private BufferedReader reader;
   private PrintWriter writer;
   private ArrayList<User> friends;
   
   public User( String userName, String password,String gender,String age)
   {
      this.userName = userName;
      this.password = password;
      this.gender = gender;
      this.age = age;
      file  =  new File( "User.txt");
      friends = new ArrayList<>();
      
   }
   
   public String getUserName()
   {
      return userName;
   }
   public void setUserName( String other)
   {
    userName = other;
   }
   public String getPassword()
   {
      return password;
   }
   public String getGender()
   {
      return gender;
   }
   public String getAge()
   {
      return age;
   }
   public ArrayList<User> getFriends()
   {
    return friends;
   }
   public boolean login( String userName,String password)
   {
    String text = userName + "|" + password;
    if( getText().contains(text))
     return true;
    else
     return false;
     
   }

   public String getText()
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
    return oldtext;
   }

   public void addUser( String userName, String password,String gender,String age)

   {

   if( findUserByName( userName) == false)

   {

   try

   {

   PrintWriter writer = new PrintWriter(new FileWriter( file,true));

   writer.println(userName + "|" + password + "|" + gender + "|" + age);

   writer.close();

   JOptionPane.showMessageDialog(null,"Successfully signed up!");

   }

   catch( Exception e)

   {

   }

   }

   else if(!(userName.equals("")))

   {

   JOptionPane.showMessageDialog( null,"This username is taken,try a different one.","Signup error",JOptionPane.ERROR_MESSAGE);

   }

   }
   
   public boolean findUserByName( String userName)
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
            if((scan.nextLine().contains(userName)))
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
  
   public  void replaceString( String oldString,String newString)
   {
      try
      {
         BufferedReader reader = new BufferedReader(new FileReader(file));
         String line = "", oldtext = "";
         while((line = reader.readLine()) != null)
         {
            oldtext += line + "\r\n";
         }
         reader.close();
         String newtext = oldtext.replaceAll(oldString, newString);
         
         FileWriter writer = new FileWriter("User.txt",false);
         writer.write(newtext);
         writer.close();
      }
      catch (IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
   
  
public User getUserByScan( String userName)
{
 User user = null;
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
        if(line.contains(userName))
        {
             int place1 = line.indexOf( "|");
             int place2 = line.indexOf("|",place1 + 1);
             int place3 = line.indexOf("|",place2 + 1);
             String password = line.substring(place1 + 1, place2);
             String gender = line.substring(place2 + 1, place3);
             String age = line.substring( place3 + 1, line.length());
             user = new User( userName, password, gender, age);
        }
       }
       
    }catch(Exception e){
       e.printStackTrace();
    }
    finally
    {
       scan.close();
    }
    return user;
}
public String toString()
{
 return userName + "|"  + password + "|" + gender + "|" + age;
} 
}
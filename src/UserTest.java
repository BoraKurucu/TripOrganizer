import java.io.*;
import java.util.*;
public class UserTest
{
   public static void main( String[] args)
   {
      User user = new User("","","","");
      user.addUser( "metehan","1234","male","20");  
      user.addUser( "kaan","5110","male","13");
   //   user.changePassword( "1234","nns");
      user.addUser( "bora", "15", "male", "20");
      }
}
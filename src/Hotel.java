import java.io.*;
import java.util.*;
public class Hotel
{
   String cityName;
   private  File file  =  new File( "Hotel.txt");
   private String hotelName;
   private String address;
   private String price;
   
   public Hotel( String cityName,String hotelName,String address,String price)
   {
      this.cityName = cityName;
      this.hotelName = hotelName;
      this.address = address;
      this.price = price;
   }
   
   public  String getName()
   {
      return hotelName;
   }
   public  String getAdress()
   {
      return address;
   }
   public  String getPrice()
   {
      return price;
   }
   
   public  void addHotel( String cityName,String hotelName,String address, int starNumber)
   {
      if( findHotelByName( hotelName) == false)
      {
         try
         {
            PrintWriter  writer = new PrintWriter(new FileWriter(file,true));
            writer.println( cityName + "|" + hotelName + "|" + address + "|" + starNumber + "|");
            writer.close();
         }
         
         catch( Exception e)
         {
            
         }
      }
   }
   
   public void deleteCity( String hotelName)
   {
      PrintWriter writerTemp = null;
      File fileTemp = new File( "HotelTemp.txt");
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
            if(!(hotelName.equals(line)))
            {
               writerTemp.println( line);
               
            }     
         }
         
      }catch(Exception e){
         e.printStackTrace();
      }
      finally
      {
         scan.close();
         writerTemp.close();
         fileTemp = file;
         file.delete();
         fileTemp.renameTo(new File("Hotel.txt"));
         
      }
      
   }
   
   public boolean findHotelByName( String hotelName)
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
        	 String line = scan.nextLine();
	            int place1 = line.indexOf( "|");
	            int place2 = line.indexOf("|",place1 + 1);
	            String name = line.substring(place1 + 1, place2);
            if(hotelName.equals(name))
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
   
   public  ArrayList<Hotel> findListHotelByCityName( String cityName)
   {
	   ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
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
	            String cityName1 = line.substring( 0,place1);
	            String hotelName = line.substring(place1 + 1, place2);
	            int place3 = line.indexOf("|",place2 + 1);
	            String adress =line.substring(place2 + 1, place3);
	            int place4 = line.indexOf("|",place3 + 1);
	            String price =line.substring(place3 + 1, place4);
            if(cityName.equals(cityName1))
            {
            	Hotel h = new Hotel(cityName,hotelName,adress,price);
            	hotelList.add(h);
               
            }     
         }
         
      }catch(Exception e){
         e.printStackTrace();
      }
      finally
      {
         scan.close();
      }
      return hotelList;
   }
   
   public void updateHotel( String hotelOldName,String hotelNewName)
   {
      PrintWriter writerTemp = null;
      File file = new File( "Hotel.txt");
      try
      {
     writerTemp = new PrintWriter(new FileWriter(file,true));
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
            if(!(hotelOldName.equals(line)))
            {
               writerTemp.println( line);
              
            } 
            else
            {
               writerTemp.println( hotelNewName);
            }
         }
         
      }catch(Exception e){
         e.printStackTrace();
      }
      finally
      {
         scan.close();
         writerTemp.close();
      } 
   }
   
   public String getAdress(String hotelName)
   {
	     PrintWriter writerTemp = null;
	      String adress = "";
	      File file = new File( "Hotel.txt");
	      try
	      {
	     writerTemp = new PrintWriter(new FileWriter(file,true));
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
	      
	   try
	      {
	         while(scan.hasNextLine())
	         {
	            String line = scan.nextLine();
	            int place1 = line.indexOf( "|");
	            int place2 = line.indexOf("|",place1 + 1);
	            String name = line.substring(place1 + 1, place2);
	            
	            if(hotelName.equals(name))
	            {
	               int place3 = line.indexOf( "|",place2 + 1);
	               adress = line.substring(place2 + 1,place3);   
	            }     
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	   return adress;   
   }
   
   public double getPrice(String hotelName)
   {
	   String priceStr = "5.5";
	      File file = new File( "Hotel.txt");
	     
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
	            String name = line.substring(place1 + 1, place2);
	            
	            if(hotelName.equals(name))
	            {
	               int place3 = line.indexOf( "|",place2 + 1);
	               int place4 = line.indexOf("|",place3 + 1);
	               priceStr = line.substring(place3 + 1,place4);
	            }     
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	   return Double.parseDouble(priceStr);   
}
   
   public String toString()
   {
      return "Hotel place: " +cityName + " name: " + hotelName + " address: " + address + " price: " + price + "\n";
   }
   
   
}
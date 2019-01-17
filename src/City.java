import java.io.*;
import java.util.*;
public  class City
{
   private String cityName;
   private  File file  =  new File( "City.txt");
   private ArrayList<String> cityList;
   
   public City( String cityName)
   {
      this.cityName = cityName;
   }
  
   public  String getName()
   {
      return cityName;
   }
   public  void addCity(String cityName)
   {
    if( findCityByName(cityName) == false)
    {
      try
      {
         PrintWriter  writer = new PrintWriter(new FileWriter(file,true));
         writer.println( cityName);
         writer.close();
      }
      
      catch( Exception e)
      {
         
      }
   }
   }
   public ArrayList<String> getCityList()
   {
    cityList = new ArrayList<String>();
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
               cityList.add(line);
                
           }
           
        }catch(Exception e){
           e.printStackTrace();
        }
        finally
        {
           scan.close();
        }
        return cityList;
   }
   
   public void deleteCity( String cityName)
   {
       PrintWriter writerTemp = null;
      File fileTemp = new File( "CityTemp.txt");
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
            if(!(cityName.equals(line)))
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
         fileTemp.renameTo(new File("City.txt"));
        
      }
      
   }
   
   public boolean findCityByName( String cityName)
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
            if(cityName.equals(scan.nextLine()))
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
   
   public void updateCity( String cityOldName,String cityNewName)
   {
      PrintWriter writerTemp = null;
      File fileTemp = new File( "CityTemp.txt");
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
            if(!(cityOldName.equals(line)))
            {
               writerTemp.println( line);
              
            } 
            else
            {
               writerTemp.println( cityNewName);
            }
         }
         
      }catch(Exception e){
         e.printStackTrace();
      }
      finally
      {
         scan.close();
         writerTemp.close();
         
        file.delete();
         fileTemp.renameTo(new File("City.txt"));
      } 
   }
   
}

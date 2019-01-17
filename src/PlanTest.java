import java.util.ArrayList;

public class PlanTest {
	public static void main(String[] args)
	{
		Plan plan = new Plan("","","");
		City city = new City("");
		String text = "";
		ArrayList<Plan> list = plan.getList();
		String text2 = "";
		//plan.addPlan("Istanbul", "One Week In Istanbul", "Visit Ayasofya");
		//plan.addPlan( "Istanbul", "3 days in Istanbul", "Visit Topkapý");
		//plan.addPlan("Istanbul", "nbr", "nbr");
		 for( int i = 0; i < city.getCityList().size();i++)
		  {
		   text = city.getCityList().get(i);
		   System.out.println("text: " + text);
			
			for( int x = 0; x < list.size();x++)
			{
				if(text.equals(list.get(x).getCityName()))
				{
					text2 = list.get(x).getDescription();
					System.out.println(text2);
				}
			}
	}
	

}
}

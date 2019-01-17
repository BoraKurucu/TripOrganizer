
public class PlanTester {
	public static void main( String[] args) {
	PlanViewer test = new PlanViewer("","","");
	Plan plan = new Plan("","","");
	test.setPlan( plan.getPlanByName("Plan 1 for Istanbul"));
	//System.out.println( test.userHasCommented("bora"));
	test.addComment( "bora", "nice city");
	//	System.out.println( test.userHasCommented("bora"));
	test.addComment("kaan", "boi");
	test.addComment("bora", "boi");
	//System.out.println( test.userHasCommented( "özgün"));
	//System.out.println( test.getCommentsOfUser( "özgün"));
	System.out.println(test.getUserRating( "Plan 1 for Istanbul", "özgün"));
	//System.out.println( test.getCommentsOfUser( "özgün"));
	//System.out.println( test.userHasCommented( "özgün"));
	//System.out.println( test.getUsers());
	}
}

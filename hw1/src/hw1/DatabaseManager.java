package hw1;
public class DatabaseManager {
	
	private static DatabaseManager obj;
	private DatabaseManager() {}
	
	public static DatabaseManager TheDatabaseManager()
	 {
	     if (obj==null)
	     {
	         obj = new DatabaseManager();
	         System.out.println("Instance Created");
	     }
	     else 
	     {
	    	 	System.out.println("Previously Created instance returned");
	     }
	     
	     return obj;
	 }
}



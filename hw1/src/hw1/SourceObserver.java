package hw1;
import java.util.*;

public class SourceObserver implements Observer {
	String name;
	Map<String, String> history;
	
	public SourceObserver(String name) {
		this.name = name;
		history = new HashMap<String, String>();
	}
	
	@Override
	public void attachBook(LibraryBook libraryBook) {
		history.put(libraryBook.name, "");
	}
	
	@Override
	public void detachBook(LibraryBook libraryBook) {
		history.remove(libraryBook.name);
	}
	
//	@Override
//	public void update(LibraryBook libraryBook) {
//		if (history == null)
//		{
//			System.out.println(name + " OBSERVED " + libraryBook.name + " LEAVING STATE: UNOBSERVED");
//			history = libraryBook.state;
//		}
//		else 
//		{
//			if (!libraryBook.state.toString().equals(history.toString()))
//				System.out.println(name + " OBSERVED " + libraryBook.name + " LEAVING STATE: " + history.toString());
//			
//			history = libraryBook.state;
//		}
//	}
	@Override
	public void update(LibraryBook libraryBook) {
		if (history.get(libraryBook.name).equals(""))
		{
			//System.out.println(name + " OBSERVED " + libraryBook.name + " REACHING STATE: UNOBSERVED");
			System.out.println(name + " OBSERVED " + libraryBook.name + " LEAVING STATE: UNOBSERVED");   
			history.put(libraryBook.name, libraryBook.state.toString());

		}
		else
		{
			//if (!libraryBook.state.toString().equals(history.toString()))
//			System.out.println(name + " " + libraryBook.state.toString());
//			System.out.println(name + " " + history.get(libraryBook.state.toString()));
			if (!libraryBook.state.toString().equals(history.get(libraryBook.name)))
				System.out.println(name + " OBSERVED " + libraryBook.name + " LEAVING STATE: " + history.get(libraryBook.name));
			
			history.put(libraryBook.name, libraryBook.state.toString());
		}
	}
	
	@Override 
	public String getName() {
		return name;
	}
	
	public int hashCode() {
		return this.getName().hashCode();
	}
}

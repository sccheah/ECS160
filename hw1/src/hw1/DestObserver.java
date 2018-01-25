package hw1;
import java.util.*;

public class DestObserver implements Observer {
	String name;
	//LBState history;
	Map<String, String> history;

	
	public DestObserver(String name) {
		this.name = name;
		history = new HashMap<String, String>();
	}
	
	@Override
	public void attachBook(LibraryBook libraryBook) {
		history.put(libraryBook.name, new String(""));
	}
	
	@Override
	public void detachBook(LibraryBook libraryBook) {
		history.remove(libraryBook.name);
	}
	
	//public DestObserver(LibraryBook subject) {
	//	this.subject = subject;
	//	this.subject.attach(this);
	//}
	
	@Override 
	public String getName() {
		return name;
	}
	
	@Override
	public void update(LibraryBook libraryBook) {
		//if (history.get(libraryBook.name).equals(new String("")))
		if (history.get(libraryBook.name) == null)
		{
			//System.out.println(name + " OBSERVED " + libraryBook.name + " REACHING STATE: UNOBSERVED");
			history.put(libraryBook.name, new String (libraryBook.state.toString()));
			System.out.println(name + " OBSERVED " + libraryBook.name + " REACHING STATE: " + libraryBook.state.toString());   
		}
		else
		{
			//System.out.println(name + " " + libraryBook.state.toString());
			//System.out.println(name + " " + history.get(libraryBook.state.toString()));
			//if (!libraryBook.state.toString().equals(history.toString()))
			if (!libraryBook.state.toString().equals(history.get(libraryBook.name)))
				System.out.println(name + " OBSERVED " + libraryBook.name + " REACHING STATE: " + libraryBook.state.toString());
			
			history.put(libraryBook.name, new String (libraryBook.state.toString()));
		}
	}
	
	public int hashCode() {
		return this.getName().hashCode();
	}
}
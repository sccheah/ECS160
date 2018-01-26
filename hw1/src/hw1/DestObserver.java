package hw1;
import java.util.*;

public class DestObserver implements Observer {
	String name;
	//LBState history;
	Map<LibraryBook, String> history;

	
	public DestObserver(String name) {
		this.name = name;
		history = new HashMap<LibraryBook, String>();
	}
	
	@Override
	public void attachBook(LibraryBook libraryBook) {
		history.put(libraryBook, "");
	}
	
	@Override
	public void detachBook(LibraryBook libraryBook) {
		history.remove(libraryBook);
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
		if (history.get(libraryBook).equals(""))
		{
			System.out.println(name + " OBSERVED " + libraryBook.name + " REACHING STATE: " + libraryBook.state.toString());   
			history.put(libraryBook, libraryBook.state.toString());

		}
		else
		{
			if (!libraryBook.state.toString().equals(history.get(libraryBook)))
				System.out.println(name + " OBSERVED " + libraryBook.name + " REACHING STATE: " + libraryBook.state.toString());
			
			history.put(libraryBook, libraryBook.state.toString());
		}
	}
	
	public int hashCode() {
		return this.getName().hashCode();
	}
}
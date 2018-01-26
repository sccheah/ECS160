package hw1;
import java.util.*;

public class SourceObserver implements Observer {
	String name;
	Map<LibraryBook, String> history;
	
	public SourceObserver(String name) {
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
	
	@Override
	public void update(LibraryBook libraryBook) {
		if (history.get(libraryBook).equals(""))
		{
			System.out.println(name + " OBSERVED " + libraryBook.name + " LEAVING STATE: UNOBSERVED");   
			history.put(libraryBook, libraryBook.state.toString());

		}
		else
		{
			if (!libraryBook.state.toString().equals(history.get(libraryBook)))
				System.out.println(name + " OBSERVED " + libraryBook.name + " LEAVING STATE: " + history.get(libraryBook));
			
			history.put(libraryBook, libraryBook.state.toString());
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

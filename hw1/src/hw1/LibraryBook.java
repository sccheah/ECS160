package hw1;
import java.util.ArrayList;
import java.util.List;

public class LibraryBook {
	private List<Observer> observers = new ArrayList<Observer>();
	public String name;
	LBState state;
	
	public LibraryBook(String title) {
		name = title;
		state = Shelved.getInst();
	}
	
	public String getName() {
		return name;
	}
	
	public void setState(LBState state)
	{
		this.state = state;
	}
	
	public void shelf() {
		try {
			state.shelf(this);
			Notify();
		}
		catch (NotAllowedException ex){
			System.out.println(ex);
		}
	}

	public void returnBook() {
		try {
			state.returnBook(this);
			Notify();
		}
		catch (NotAllowedException ex){
			System.out.println(ex);
		}
	}

	public void borrow() {
		try {
			state.borrow(this);
			Notify();
		}
		catch (NotAllowedException ex){
			System.out.println(ex);
		}
	}

	public void extend() {
		try {
			state.extend(this);
			Notify();
		}
		catch (NotAllowedException ex){
			System.out.println(ex);
		}
	}
	
	public void attach(Observer observer) {
		System.out.println(observer.getName() + " is now watching " + name);
		observers.add(observer);
		observer.attachBook(this);
	}
	
	public void detach(Observer observer) {
		for (Observer o : observers) {
			if (observer.getName().equals(o.getName()))
			{
				System.out.println(observer.getName() + " is no longer watching " + name);
				observers.remove(observer);
				observer.detachBook(this);
			}
		}
	}
	
	public void Notify() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
	
	public LBState getState() {
		return state;
	}
}






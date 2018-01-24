package hw1;

public class LibraryBook {
	public String name;
	LBState state;
	
	public LibraryBook(String title) {
		name = title;
		state = Shelved.getInst();
	}
	
	public void setState(LBState state)
	{
		this.state = state;
	}
	
	public void shelf() {
		try {
			state.shelf(this);
		}
		catch (NotAllowedException ex){
			System.out.println(ex);
		}
		
	}

	public void returnBook() {
		//state.returnBook(this);
		try {
			state.returnBook(this);
			//throw new NotAllowedException();
		}
		catch (NotAllowedException ex){
			System.out.println(ex);

		}
	}

	public void borrow() {
		//state.borrow(this);
		try {
			state.borrow(this);
		}
		catch (NotAllowedException ex){
			System.out.println(ex);

		}
	}

	public void extend() {
		//state.extend(this);
		try {
			state.extend(this);
		}
		catch (NotAllowedException ex){
			System.out.println(ex);

		}
	}
}
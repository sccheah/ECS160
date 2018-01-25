package hw1;

public class Shelved implements LBState{
	
	private static Shelved obj;
	Shelved() {}
	
	public static Shelved getInst()
	 {
	     if (obj==null)
	     {
	         obj = new Shelved();
	         System.out.println("Shelved Instance Created");
	     }
	     
	     return obj;
	 }
	
	public String toString() {
		return "Shelved";
	}

	@Override
	public void shelf(LibraryBook book) throws NotAllowedException{
		throw new NotAllowedException("Can't use shelf in Shelved state");
	}

	@Override
	public void returnBook(LibraryBook book) throws NotAllowedException{
		throw new NotAllowedException("Can't use returnBook in Shelved state");
	}

	@Override
	public void borrow(LibraryBook book) throws NotAllowedException{
		//System.out.println("Leaving State " + this.toString() +  " for State OnLoan");
		book.setState(OnLoan.getInst());
		System.out.println("Leaving State " + this.toString() +  " for State OnLoan");

	}

	@Override
	public void extend(LibraryBook book) throws NotAllowedException{
		throw new NotAllowedException("Can't use extend in Shelved state");
		
	}
}

package hw1;

public class Returned implements LBState{
	
	private static Returned obj;
	Returned() {}
	
	public static Returned getInst()
	 {
	     if (obj==null)
	     {
	         obj = new Returned();
	         System.out.println("Returned Instance Created");
	     }
	     
	     return obj;
	 }
	
	public String toString() {
		return "Returned";
	}

	@Override
	public void shelf(LibraryBook book) throws NotAllowedException{
		book.setState(Shelved.getInst());
		System.out.println("Leaving State " + this.toString() +  " for State Shelved");

		
	}

	@Override
	public void returnBook(LibraryBook book) throws NotAllowedException{
		throw new NotAllowedException("Can't use returnBook in Returned state");
		
	}

	@Override
	public void borrow(LibraryBook book) throws NotAllowedException{
		throw new NotAllowedException("Can't use borrow in Returned state");
		
	}

	@Override
	public void extend(LibraryBook book) throws NotAllowedException{
		throw new NotAllowedException("Can't use extend in Returned state");
		
	}
}

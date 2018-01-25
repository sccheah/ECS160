package hw1;

public class OnLoan implements LBState{
	
	private static OnLoan obj;
	OnLoan() {}
	
	public static OnLoan getInst()
	 {
	     if (obj==null)
	     {
	         obj = new OnLoan();
	         System.out.println("OnLoan Instance Created");
	     }
	     
	     return obj;
	 }
	
	public String toString() {
		return "OnLoan";
	}

	@Override
	public void shelf(LibraryBook book) throws NotAllowedException{
		throw new NotAllowedException("Can't use shelf in OnLoan state");
	}

	@Override
	public void returnBook(LibraryBook book) throws NotAllowedException{
		book.setState(Returned.getInst());
		System.out.println("Leaving state " + this.toString() + " for State Returned");
		
	}

	@Override
	public void borrow(LibraryBook book) throws NotAllowedException {
		throw new NotAllowedException("Can't use borrow in Onloan state");
	}

	@Override
	public void extend(LibraryBook book) {
		book.setState(this);
		System.out.println("Leaving State " + this.toString() + " for State OnLoan");

		
	}
}

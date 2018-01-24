package hw1;

public interface LBState {
	public void shelf(LibraryBook book) throws NotAllowedException;
	public void returnBook(LibraryBook book) throws NotAllowedException;
	public void borrow(LibraryBook book) throws NotAllowedException;
	public void extend(LibraryBook book) throws NotAllowedException;
}

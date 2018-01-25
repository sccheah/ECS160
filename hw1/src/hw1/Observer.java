package hw1;

public interface Observer {
	public abstract String getName();
	public abstract void update(LibraryBook libraryBook);
	public abstract void attachBook(LibraryBook libraryBook);
	public abstract void detachBook(LibraryBook libraryBook);
}
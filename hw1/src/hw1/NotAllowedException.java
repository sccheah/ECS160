package hw1;

public class NotAllowedException extends Exception{
	private static final long serialVersionUID = 1L;

	public NotAllowedException() { }
	
	public NotAllowedException(String message) {
		super(message);
	}
	
	public NotAllowedException (Throwable cause) {
        super (cause);
    }

    public NotAllowedException (String message, Throwable cause) {
        super (message, cause);
    }
}
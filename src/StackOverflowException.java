public class StackOverflowException extends Exception {

	private static final long serialVersionUID = -9144560126822686752L;

	public StackOverflowException() {

	}
	
	public StackOverflowException(String message) {
		super(message);
	}
}
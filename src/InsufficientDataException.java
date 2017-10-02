
public class InsufficientDataException extends RuntimeException {
	
	private String message;
	
	public InsufficientDataException(String message) {
		this.message = message;
	}

	public InsufficientDataException() {

	}
	
	@Override
	public String toString() {
		return "InsufficientDataException [message=" + message + "]";
	}
}

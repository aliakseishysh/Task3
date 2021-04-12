package by.alekseyshysh.task3.exception;

public class FiguresException extends Exception {

	private static final long serialVersionUID = -3303410395502061392L;

	public FiguresException() {
		super();
	}

	public FiguresException(String message) {
		super(message);
	}

	public FiguresException(String message, Throwable cause) {
		super(message, cause);
	}

	public FiguresException(Throwable cause) {
		super(cause);
	}
}

package exceptions;

public class FullBookShelfException extends LibraryException {

    public FullBookShelfException() {
        super("The shelf is full");
    }
}
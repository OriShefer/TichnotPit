package exceptions;

public class InvalidShelfNumberException extends LibraryException {
    public InvalidShelfNumberException() {
        super("There is no such shelf in the library");
    }
}
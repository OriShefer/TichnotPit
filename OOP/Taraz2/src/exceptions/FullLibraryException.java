package exceptions;

public class FullLibraryException extends LibraryException {

    public FullLibraryException() {
        super("The library is full!");
    }
}

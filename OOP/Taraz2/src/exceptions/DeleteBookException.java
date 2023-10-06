package exceptions;

public class DeleteBookException extends LibraryException{


    public DeleteBookException(){
        super("The book is not found");
    }

}

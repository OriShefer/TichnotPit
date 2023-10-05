public class InvalidInputException extends Exception {
  public InvalidInputException(String exceptionMessage) {
    super("InvalidInputException -> " + exceptionMessage);
  }
}
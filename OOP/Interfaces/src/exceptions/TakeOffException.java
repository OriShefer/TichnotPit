package exceptions;

public class TakeOffException extends FlyException {
  public TakeOffException() {
    super();
  }

  private String message = "Unable to take off";

  public TakeOffException(String extraInfo) {
    super();
    this.message += ", " + extraInfo;
  }

  public String getMessage() {
    return this.message;
  }
}

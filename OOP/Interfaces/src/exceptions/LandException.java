package exceptions;

public class LandException extends FlyException {
    public LandException() {
        super();
    }

    private String message = "Unable to land";

    public LandException(String extraInfo) {
        super();
        this.message += ", " + extraInfo;
    }

    public String getMessage() {
        return this.message;
    }
}

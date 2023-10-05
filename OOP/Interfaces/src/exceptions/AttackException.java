package exceptions;

public class AttackException extends Exception {

    public AttackException() {
        super();
    }

    private String message = "Unable to attack";

    public AttackException(String extraInfo) {
        super();
        this.message += ", " + extraInfo;
    }

    public String getMessage() {
        return this.message;
    }
}
package week4;

public class UnknownException extends Exception {

    public UnknownException() {
        super();
        // this  -> reference to the current object
        // super -> reference to the super class'
    }

    public UnknownException(String message) {
        super(message);
    }

}

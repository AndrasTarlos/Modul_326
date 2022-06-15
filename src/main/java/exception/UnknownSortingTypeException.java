package exception;

public class UnknownSortingTypeException extends Exception {
    public UnknownSortingTypeException() {
        super("There is no such sorting type...");
    }
}

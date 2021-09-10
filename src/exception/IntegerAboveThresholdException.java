package exception;

public class IntegerAboveThresholdException extends RuntimeException {

    public IntegerAboveThresholdException(String message) {
        super(message);
    }
    //These two classes in the "exception" package are used for creating custom exceptions,
    // when there is a specific error from the input
}

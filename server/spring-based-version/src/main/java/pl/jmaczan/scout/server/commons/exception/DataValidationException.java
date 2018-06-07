package pl.jmaczan.scout.server.commons.exception;

public class DataValidationException extends RuntimeException {

    public DataValidationException() {
        super();
    }

    public DataValidationException(String message) {
        super(message);
    }

    public DataValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

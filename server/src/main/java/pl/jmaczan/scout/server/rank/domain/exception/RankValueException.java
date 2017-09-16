package pl.jmaczan.scout.server.rank.domain.exception;

public class RankValueException extends RuntimeException {

    public RankValueException() {
        super();
    }

    public RankValueException(String message) {
        super(message);
    }

    public RankValueException(String message, Throwable cause) {
        super(message, cause);
    }
}

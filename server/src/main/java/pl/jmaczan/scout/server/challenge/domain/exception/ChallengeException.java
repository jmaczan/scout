package pl.jmaczan.scout.server.challenge.domain.exception;

public class ChallengeException extends RuntimeException{

    public ChallengeException() {
        super();
    }

    public ChallengeException(String message) {
        super(message);
    }

    public ChallengeException(String message, Throwable cause) {
        super(message, cause);
    }
}

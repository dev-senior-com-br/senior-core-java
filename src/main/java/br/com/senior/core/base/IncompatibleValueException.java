package br.com.senior.core.base;

public class IncompatibleValueException extends RuntimeException {
    private static final long serialVersionUID = -1856334325097257021L;

    public IncompatibleValueException(String message) {
        super(message);
    }

    public IncompatibleValueException(String message, Throwable cause) {
        super(message, cause);
    }
}

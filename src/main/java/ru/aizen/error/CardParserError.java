package ru.aizen.error;

public class CardParserError extends Exception{
    public CardParserError() {
        super();
    }

    public CardParserError(String message) {
        super(message);
    }

    public CardParserError(String message, Throwable cause) {
        super(message, cause);
    }

    public CardParserError(Throwable cause) {
        super(cause);
    }
}

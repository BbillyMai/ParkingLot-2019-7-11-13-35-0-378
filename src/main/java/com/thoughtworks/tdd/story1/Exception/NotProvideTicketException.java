package com.thoughtworks.tdd.story1.Exception;

public class NotProvideTicketException extends Exception {
    private final String message = "Please provide your parking ticket.";

    @Override
    public String getMessage() {
        return message;
    }
}

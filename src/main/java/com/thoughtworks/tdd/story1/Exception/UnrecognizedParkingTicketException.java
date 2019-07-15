package com.thoughtworks.tdd.story1.Exception;

public class UnrecognizedParkingTicketException extends Exception {
    private final String message = "Unrecognized parking ticket.";

    @Override
    public String getMessage() {
        return message;
    }
}

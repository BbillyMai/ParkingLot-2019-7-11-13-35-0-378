package com.thoughtworks.tdd.story1.Exception;

public class NotEnoughPositionException extends Exception {

    private final String messge = "Not enough position.";

    public String getMessge() {
        return messge;
    }
}

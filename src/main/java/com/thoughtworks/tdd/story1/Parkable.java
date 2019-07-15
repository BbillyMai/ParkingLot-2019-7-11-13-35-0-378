package com.thoughtworks.tdd.story1;


public interface Parkable {
    Ticket park(Car car) throws Exception;

    Car fetch(Ticket ticket) throws Exception;

    boolean isFull();

    boolean containsTicket();
}

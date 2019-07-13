package com.thoughtworks.tdd.story1;


public interface ParkAndFetchCar {
    Ticket park(Car car) throws Exception;

    Car fetch(Ticket ticket) throws Exception;

    Car fetch() throws Exception;
}

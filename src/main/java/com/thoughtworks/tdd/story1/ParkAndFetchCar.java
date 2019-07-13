package com.thoughtworks.tdd.story1;


public interface ParkAndFetchCar {
    Ticket park(Car car);

    Car fetch(Ticket ticket);
}

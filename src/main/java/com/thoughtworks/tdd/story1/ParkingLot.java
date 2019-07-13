package com.thoughtworks.tdd.story1;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements ParkAndFetchCar {
    private int capacity;
    private Map<Ticket, Car> cars = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Ticket park(Car car) {
        if (capacity < cars.size()) {
            return null;
        }
        Ticket ticket = new Ticket();
        cars.put(ticket, car);
        return ticket;
    }

    @Override
    public Car fetch(Ticket ticket) {
        if (ticket == null) {
            return null;
        }
        return cars.remove(ticket);
    }
}

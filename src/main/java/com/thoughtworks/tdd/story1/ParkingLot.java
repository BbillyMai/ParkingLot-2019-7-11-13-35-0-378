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
    public Ticket park(Car car) throws Exception {
        if (isFull()) {
            throw new Exception("Not enough position.");
        }
        Ticket ticket = new Ticket();
        cars.put(ticket, car);
        return ticket;
    }

    @Override
    public Car fetch(Ticket ticket) throws Exception {
        if (ticket == null) {
            throw new Exception("Unrecognized parking ticket.");
        }
        return cars.remove(ticket);
    }

    @Override
    public Car fetch() throws Exception {
        throw new Exception("Please provide your parking ticket.");
    }

    public boolean isFull() {
        return capacity <= cars.size();
    }

    public int getFreeCapacity() {
        return capacity - getCars().size();
    }

    public Map<Ticket, Car> getCars() {
        return cars;
    }
}

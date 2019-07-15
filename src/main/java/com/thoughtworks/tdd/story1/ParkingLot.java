package com.thoughtworks.tdd.story1;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {
    private int capacity;
    private Map<Ticket, Car> cars = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Ticket park(Car car) throws Exception {

        Ticket ticket = new Ticket();
        cars.put(ticket, car);
        return ticket;
    }

    @Override
    public Car fetch(Ticket ticket) throws Exception {
        return cars.remove(ticket);
    }



    public boolean isFull() {
        return capacity <= cars.size();
    }

    @Override
    public boolean containsTicket(Ticket ticket) {
        return cars.containsKey(ticket);
    }

    public int getFreeCapacity() {
        return capacity - getCars().size();
    }

    public Map<Ticket, Car> getCars() {
        return cars;
    }
}

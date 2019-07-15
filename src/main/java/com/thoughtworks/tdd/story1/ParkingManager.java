package com.thoughtworks.tdd.story1;

import com.thoughtworks.tdd.story1.Exception.*;

import java.util.Arrays;
import java.util.List;

public class ParkingManager {

    private List<Parkable> parkables;

    public ParkingManager(Parkable... parkables) {
        this.parkables = Arrays.asList(parkables);
    }

    public Ticket park(Car car) throws Exception {
        for (Parkable parkable : parkables) {
            if (!parkable.isFull()) {
                return parkable.park(car);
            }
        }
        throw new NotEnoughPositionException();
    }

    public Car fetch(Ticket ticket) throws Exception {
        if (ticket == null) {
            throw new NotProvideTicketException();
        }
        for (Parkable parkable : parkables) {
            if (parkable.containsTicket(ticket)) {
                return parkable.fetch(ticket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

}

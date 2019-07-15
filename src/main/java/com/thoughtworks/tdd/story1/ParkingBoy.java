package com.thoughtworks.tdd.story1;

import com.thoughtworks.tdd.story1.Exception.NotEnoughPositionException;
import com.thoughtworks.tdd.story1.Exception.NotProvideTicketException;
import com.thoughtworks.tdd.story1.Exception.UnrecognizedParkingTicketException;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy extends Parker {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
        this.parkingLots = Arrays.asList(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws Exception {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }
        throw new NotEnoughPositionException();
    }

}

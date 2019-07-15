package com.thoughtworks.tdd.story1;

import com.thoughtworks.tdd.story1.Exception.NotEnoughPositionException;
import com.thoughtworks.tdd.story1.Exception.NotProvideTicketException;
import com.thoughtworks.tdd.story1.Exception.UnrecognizedParkingTicketException;

import java.util.List;

public class ParkingBoy extends Parker {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
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

    @Override
    public Car fetch(Ticket ticket) throws Exception {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCars().size() > 0) {
                Car car = parkingLot.fetch(ticket);
                if (car != null) {
                    return car;
                }
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

}

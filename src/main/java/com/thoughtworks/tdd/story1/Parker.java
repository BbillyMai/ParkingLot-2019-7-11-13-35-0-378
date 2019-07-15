package com.thoughtworks.tdd.story1;

import com.thoughtworks.tdd.story1.Exception.UnrecognizedParkingTicketException;

import java.util.List;

public abstract class Parker implements Parkable {

    private List<ParkingLot> parkingLots;

    public Parker(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }


    public abstract Ticket park(Car car) throws Exception;

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

    @Override
    public boolean isFull(){
        return false;
    }

    @Override
    public boolean containsTicket(){
        return false;
    }
}

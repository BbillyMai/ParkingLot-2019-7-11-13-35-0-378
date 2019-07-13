package com.thoughtworks.tdd.story1;

import java.util.List;

public class ParkingBoy implements ParkAndFetchCar {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket park(Car car) throws Exception {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }
        throw new Exception("Not enough position.");
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
        throw new Exception("Unrecognized parking ticket.");
    }

    @Override
    public Car fetch() throws Exception {
        throw new Exception("Please provide your parking ticket.");
    }
}

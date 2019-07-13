package com.thoughtworks.tdd.story1;

public class ParkingBoy implements ParkAndFetchCar {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    @Override
    public Ticket park(Car car) {
        return parkingLot.park(car);
    }

    @Override
    public Car fetch(Ticket ticket) {
        return parkingLot.fetch(ticket);
    }
}
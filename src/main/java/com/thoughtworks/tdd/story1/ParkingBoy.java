package com.thoughtworks.tdd.story1;

public class ParkingBoy implements ParkAndFetchCar {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    @Override
    public Ticket park(Car car) throws Exception{
        return parkingLot.park(car);
    }

    @Override
    public Car fetch(Ticket ticket) throws Exception{
        return parkingLot.fetch(ticket);
    }

    @Override
    public Car fetch() throws Exception{
        throw new Exception("Please provide your parking ticket.");
    }
}

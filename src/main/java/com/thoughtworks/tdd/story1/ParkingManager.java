package com.thoughtworks.tdd.story1;

import java.util.List;

public class ParkingManager extends ParkingBoy {

    private List<Parker> parkingBoys;

    private List<ParkingLot> parkingLots;

    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public ParkingManager(List<ParkingLot> parkingLots, List<Parker> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
        this.parkingLots = parkingLots;
    }

    public Ticket selectParkingBoyPark(Car car, Parker selectedBoy) throws Exception {
        for (Parker parkingBoy : parkingBoys) {
            if (selectedBoy.equals(parkingBoy)) {
                return parkingBoy.park(car);
            }
        }

        throw new Exception("Not appoint parkingBoy to park car");
    }

    public Car selectParkingBoyFetchCar(Ticket ticket, Parker selectedBoy) throws Exception {

        for (Parker parkingBoy : parkingBoys) {
            if (selectedBoy.equals(parkingBoy)) {
                return parkingBoy.fetch(ticket);
            }
        }

        throw new Exception("Not appoint parkingBoy to fetch car");
    }

    public Ticket park(Car car) throws Exception {
        return super.park(car);
    }

    public Car fetch(Ticket ticket) throws Exception {
        return super.fetch(ticket);
    }

    public void addParkingBoy(Parker parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public void removeParkingBoy(Parker removedParkingBoy) {
        for (Parker parkingBoy : parkingBoys) {
            if (removedParkingBoy.equals(parkingBoy)) {
                parkingBoys.remove(parkingBoy);
                return;
            }
        }
    }

    public List<Parker> getParkingBoys() {
        return parkingBoys;
    }
}

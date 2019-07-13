package com.thoughtworks.tdd.story1;

import java.util.List;

public class ParkingManager extends ParkingBoy {

    private List<ParkingBoy> parkingBoys;

    private List<ParkingLot> parkingLots;

    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
        this.parkingLots = parkingLots;
    }

    public Ticket selectParkingBoyPark(Car car, ParkingBoy selectedBoy) throws Exception {
        for (ParkingBoy parkingBoy : parkingBoys) {
            if (selectedBoy.equals(parkingBoy)) {
                if (selectedBoy instanceof SuperSmartParkingBoy) {
                    return ((SuperSmartParkingBoy) parkingBoy).park(car);
                } else if (selectedBoy instanceof SmartParkingBoy) {
                    return ((SmartParkingBoy) parkingBoy).park(car);
                } else if (selectedBoy instanceof ParkingBoy) {
                    return ((ParkingBoy) parkingBoy).park(car);
                }
            }
        }

        throw new Exception("Not appoint parkingBoy to park car");
    }

    public Car selectParkingBoyfetchCar(Ticket ticket, ParkingBoy selectedBoy) throws Exception {

        for (ParkingBoy parkingBoy : parkingBoys) {
            if (selectedBoy.equals(parkingBoy)) {
                return ((ParkingBoy) parkingBoy).fetch(ticket);
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

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public void removeParkingBoy(ParkingBoy removedParkingBoy) {
        for (ParkingBoy parkingBoy : parkingBoys) {
            if (removedParkingBoy.equals(parkingBoy)) {
                parkingBoys.remove(parkingBoy);
                return;
            }
        }
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }
}

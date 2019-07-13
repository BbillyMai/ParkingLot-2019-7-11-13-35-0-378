package com.thoughtworks.tdd.story1;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket park(Car car) throws Exception {
        int index = 0;
        int max = 1;
        for (int i = 0; i < parkingLots.size(); i++) {
            int free = parkingLots.get(i).getFreeCapacity();
            if (max <= free) {
                max = free;
                index = i;
            }
        }
        return parkingLots.get(index).park(car);
    }
}

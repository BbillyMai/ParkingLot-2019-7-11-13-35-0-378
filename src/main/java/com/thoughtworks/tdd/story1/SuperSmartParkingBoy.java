package com.thoughtworks.tdd.story1;

import java.util.Arrays;
import java.util.List;

public class SuperSmartParkingBoy extends Parker {

    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
        this.parkingLots = Arrays.asList(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws Exception {
        int index = 0;
        double max = 0;
        for (int i = 0; i < parkingLots.size(); i++) {
            int free = parkingLots.get(i).getFreeCapacity();
            int total = parkingLots.get(i).getCars().size();
            double availableRate = ((double) free) / total;
            if (max <= availableRate) {
                max = availableRate;
                index = i;
            }
        }
        return parkingLots.get(index).park(car);
    }
}

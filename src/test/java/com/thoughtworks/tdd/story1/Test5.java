package com.thoughtworks.tdd.story1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test5 {
    @Test
    public void should_park_car_by_large_available_rate_when_super_smart_boy_park_car_given_park_car() throws Exception{
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());

        assertEquals(1,parkingLot1.getCars().size());
        assertEquals(3,parkingLot2.getCars().size());
    }
}

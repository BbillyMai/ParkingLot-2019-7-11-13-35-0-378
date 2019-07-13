package com.thoughtworks.tdd.story1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test4 {
    @Test
    public void should_park_car_to_right_position_when_smart_boy_park_car_given_park_car() throws Exception{
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        smartParkingBoy.park(new Car());

        assertEquals(0,parkingLot1.getCars().size());
        assertEquals(1,parkingLot2.getCars().size());
    }
}

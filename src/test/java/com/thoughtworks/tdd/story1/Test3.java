package com.thoughtworks.tdd.story1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test3 {
    @Test
    public void park_in_second_parkinglot_when_first_parkinglot_given_park_car() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        assertEquals(1,parkingLot1.getCars().size());
        assertEquals(1,parkingLot2.getCars().size());
    }

}

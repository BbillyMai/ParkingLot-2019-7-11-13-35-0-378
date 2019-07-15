package com.thoughtworks.tdd.story1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test3 {
    @Test
    public void park_in_second_parkinglot_when_first_parkinglot_given_park_car() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1,parkingLot2);

        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        assertEquals(1,parkingLot1.getCars().size());
        assertEquals(1,parkingLot2.getCars().size());
    }

}

package com.thoughtworks.tdd.story1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test5 {
    @Test
    public void should_park_car_by_large_available_rate_when_super_smart_boy_park_car_given_park_car() throws Exception{
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(10);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot1,parkingLot2);

        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());

        assertEquals(1,parkingLot1.getCars().size());
        assertEquals(3,parkingLot2.getCars().size());
    }
}

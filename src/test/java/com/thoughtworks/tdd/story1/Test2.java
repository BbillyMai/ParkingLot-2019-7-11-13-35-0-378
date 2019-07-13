package com.thoughtworks.tdd.story1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test2 {
    @Test
    void should_get_Unrecognized_parking_ticket_when_query_message_given_a_wrong_ticket() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        Car car1 = parkingBoy.fetch(ticket);
        Exception exception = assertThrows(Exception.class, () -> {
            parkingBoy.fetch(null);
        });
        Exception exception1 = assertThrows(Exception.class, () -> {
            parkingBoy.fetch(null);
        });
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
        assertEquals("Unrecognized parking ticket.", exception1.getMessage());
    }

    @Test
    void should_get_Please_provide_your_parking_ticket_message_when_fetch_car_no_given_ticket() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Exception exception = assertThrows(Exception.class, () -> {
            parkingBoy.fetch();
        });
        assertEquals("Please provide your parking ticket.",exception.getMessage());
    }

    @Test
    void should_get_no_enough_position_when_parking_given_car()throws Exception{
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(new Car());

        Exception exception = assertThrows(Exception.class,()->{
            parkingBoy.park(new Car());
        });
        assertEquals("Not enough position.",exception.getMessage());
    }
}

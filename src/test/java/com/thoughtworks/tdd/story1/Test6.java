package com.thoughtworks.tdd.story1;

import com.thoughtworks.tdd.story1.Exception.NotEnoughPositionException;
import com.thoughtworks.tdd.story1.Exception.NotProvideTicketException;
import com.thoughtworks.tdd.story1.Exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test6 {
    @Test
    public void should_manager_parking_boy_and_can_park_and_fetch_when_manager_select_parking_boy_given_car() throws Exception {
        ParkingManager parkingManager = new ParkingManager(new ParkingBoy(new ParkingLot(1)), new SmartParkingBoy(new ParkingLot(1)), new SmartParkingBoy(new ParkingLot(1)));
        Car car = new Car();
        Ticket ticket = parkingManager.park(car);
        Car fetchedCar = parkingManager.fetch(ticket);
        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_manager_like_standard_parking_boy_when_manager_park_and_fetch_given_car_and_ticket() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingManager parkingManager = new ParkingManager(parkingLot1);
        Car car = new Car();
        Ticket ticket = parkingManager.park(car);
        Car fetchCar = parkingManager.fetch(ticket);

        assertEquals(car, fetchCar);
    }

    @Test
    public void should_show_error_messge_when_parkingBoy_failed_given_parkingBoy_park_and_fetch() throws Exception {

        ParkingManager parkingManager = new ParkingManager(new ParkingLot(1),new ParkingBoy(new ParkingLot(1)));
        parkingManager.park(new Car());
        parkingManager.park(new Car());

        assertThrows(NotEnoughPositionException.class,()-> parkingManager.park(new Car()));
        assertThrows(NotProvideTicketException.class,()-> parkingManager.fetch(null));
        assertThrows(UnrecognizedParkingTicketException.class,()-> parkingManager.fetch(new Ticket()));
    }
}

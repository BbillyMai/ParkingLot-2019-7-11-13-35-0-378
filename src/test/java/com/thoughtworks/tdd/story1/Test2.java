package com.thoughtworks.tdd.story1;

import com.thoughtworks.tdd.story1.Exception.NotEnoughPositionException;
import com.thoughtworks.tdd.story1.Exception.NotProvideTicketException;
import com.thoughtworks.tdd.story1.Exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test2 {
    @Test
    void should_get_Unrecognized_parking_ticket_when_query_message_given_a_wrong_ticket() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        Car car1 = parkingBoy.fetch(ticket);
        assertThrows(NotProvideTicketException.class, () -> parkingBoy.fetch(null));
        assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(ticket));

    }

    @Test
    void should_get_Please_provide_your_parking_ticket_message_when_fetch_car_no_given_ticket() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        assertThrows(NotProvideTicketException.class, () -> parkingBoy.fetch(null));
    }

    @Test
    void should_get_no_enough_position_when_parking_given_car()throws Exception{
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.park(new Car());

        assertThrows(NotEnoughPositionException.class,()-> parkingBoy.park(new Car()));
    }
}

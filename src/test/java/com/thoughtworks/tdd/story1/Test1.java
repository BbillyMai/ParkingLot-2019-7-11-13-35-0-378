package com.thoughtworks.tdd.story1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {

    @Test
    public void should_customer_fetch_car_when_customer_fetch_car_given_boy_park_car() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        ParkingBoy boy = new ParkingBoy(parkingLot);

        // given
        Ticket ticket = boy.park(car);
        // when
        Car fetchedCar = boy.fetch(ticket);
        // return
        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_fetch_right_car_when_boy_fetch_car_given_correspond_ticket() throws Exception {

        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy boy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();

        // given
        Ticket ticket1 = boy.park(car1);
        Ticket ticket2 = boy.park(car2);
        // when
        Car fetchedCar1 = boy.fetch(ticket1);
        Car fetchedCar2 = boy.fetch(ticket2);
        // return
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }

    @Test
    void should_not_fetch_car_when_fetch_car_given_wrong_ticket() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy boy = new ParkingBoy(parkingLot);

        // given
        Ticket wrongTicket = null;
        // when
        Car car = boy.fetch(wrongTicket);
        // return
        assertEquals(null, car);
    }

    @Test
    void should_not_fetch_car_when_fetch_car_given_used_ticket() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy boy = new ParkingBoy(parkingLot);
        Car car = new Car();
        // given
        Ticket ticket = boy.park(car);
        Car car1 = boy.fetch(ticket);
        // when
        Car car2 = boy.fetch(ticket);
        //return
        assertEquals(null, car2);
    }

    @Test
    void should_not_park_car_and_no_ticket_when_parkingLot_full_given_park_car() throws Exception {

        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy boy = new ParkingBoy(parkingLot);

        for (int i = 0; i < 11; i++) {
            Car car = new Car();
            boy.park(car);
        }
        Car car11 = new Car();
        Ticket ticket = boy.park(car11);
        assertEquals(null, ticket);
    }
}

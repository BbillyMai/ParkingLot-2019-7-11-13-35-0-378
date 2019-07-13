package com.thoughtworks.tdd.story1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test6 {
    @Test
    public void should_manager_parking_boy_and_can_park_and_fetch_when_manager_select_parking_boy_given_car() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(10);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        parkingBoys.add(smartParkingBoy);
        parkingBoys.add(superSmartParkingBoy);

        ParkingManager manager = new ParkingManager(parkingLots, parkingBoys);

        // test manager manage parkingBoy
        assertEquals(3, manager.getParkingBoys().size());
        manager.removeParkingBoy(superSmartParkingBoy);
        assertEquals(2, manager.getParkingBoys().size());
        manager.addParkingBoy(superSmartParkingBoy);

        // test manager appoint parkingBoy park car
        Car parkingBoyCar = new Car();
        Car smartParkingBoyCar = new Car();
        Car superSmartParkingBoyCar1 = new Car();
        Car superSmartParkingBoyCar2 = new Car();
        Ticket ticket1 = manager.selectParkingBoyPark(parkingBoyCar, parkingBoy);
        Ticket ticket2 = manager.selectParkingBoyPark(smartParkingBoyCar, smartParkingBoy);
        Ticket ticket3 = manager.selectParkingBoyPark(superSmartParkingBoyCar1, superSmartParkingBoy);
        Ticket ticket4 = manager.selectParkingBoyPark(superSmartParkingBoyCar2, superSmartParkingBoy);

        assertEquals(1, parkingLot1.getCars().size());
        assertEquals(3, parkingLot2.getCars().size());

        // test manager appoint parkingBoy fetch car
        Car car1 = manager.selectParkingBoyfetchCar(ticket1, smartParkingBoy);
        Car car2 = manager.selectParkingBoyfetchCar(ticket2, parkingBoy);
        Car car3 = manager.selectParkingBoyfetchCar(ticket3, parkingBoy);
        Car car4 = manager.selectParkingBoyfetchCar(ticket4, superSmartParkingBoy);

        assertEquals(parkingBoyCar, car1);
        assertEquals(smartParkingBoyCar, car2);
        assertEquals(superSmartParkingBoyCar1, car3);
        assertEquals(superSmartParkingBoyCar2, car4);
    }

    @Test
    public void should_manager_like_standard_parking_boy_when_manager_park_and_fetch_given_car_and_ticket() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        ParkingManager parkingManager = new ParkingManager(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingManager.park(car);
        Car fetchCar = parkingManager.fetch(ticket);

        assertEquals(car, fetchCar);
    }

    @Test
    public void should_show_error_messge_when_parkingBoy_failed_given_parkingBoy_park_and_fetch() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        ParkingManager parkingManager = new ParkingManager(parkingLots, parkingBoys);

        Exception exception = assertThrows(Exception.class, () -> {
            parkingManager.selectParkingBoyfetchCar(new Ticket(), parkingBoy);
        });
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }
}

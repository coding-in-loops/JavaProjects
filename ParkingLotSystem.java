//Implementing design patterns -> creation patterns, structural patterns, behavioral pattterns

/*
 * Design a parking lot system:
 * Requirements:
 * 1. Able to park the vehicles (car,bikes)
 * 2. know at any moment, number of available or blocked slots
 * 3. Charge the vehicle based on the time they spent in the parking lot
 */

import java.util.ArrayList;
import java.util.List;

// Creational pattern
interface Vehicle {
    void park(ParkingSlot slot);
    String getRegistrationNumber();
}

class Car implements Vehicle {
    private String registrationNumber;

    public Car(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public void park(ParkingSlot slot) {
        slot.park(this);
    }

    @Override
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }
}

class Bike implements Vehicle {
    private String registrationNumber;

    public Bike(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public void park(ParkingSlot slot) {
        slot.park(this);
    }

    @Override
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }
}

interface VehicleFactory {
    Vehicle createVehicle(String registrationNumber);
}

class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String registrationNumber) {
        return new Car(registrationNumber);
    }
}

class BikeFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String registrationNumber) {
        return new Bike(registrationNumber);
    }
}

// Structural pattern
interface ParkingStructure {
    void add(ParkingStructure structure);
    void remove(ParkingStructure structure);
    boolean isOccupied();
}

class ParkingArea implements ParkingStructure {
    private String name;
    private List<ParkingStructure> structures;

    public ParkingArea(String name) {
        this.name = name;
        this.structures = new ArrayList<>();
    }

    @Override
    public void add(ParkingStructure structure) {
        structures.add(structure);
    }

    @Override
    public void remove(ParkingStructure structure) {
        structures.remove(structure);
    }

    @Override
    public boolean isOccupied() {
        return structures.stream().anyMatch(ParkingStructure::isOccupied);
    }
}

class ParkingSlot implements ParkingStructure {
    private String id;
    private boolean occupied;

    public ParkingSlot(String id) {
        this.id = id;
        this.occupied = false;
    }
    public String getId(){
        return id;
    }
    @Override
    public boolean isOccupied() {
        return occupied;
    }

    public void park(Vehicle vehicle) {
        occupied = true;
        System.out.println(vehicle.getClass().getSimpleName() + " parked in slot " + id);
    }

    public void leave() {
        occupied = false;
        System.out.println("Slot " + id + " is now empty");
    }

    // ParkingSlot doesn't support add and remove operations
    @Override
    public void add(ParkingStructure structure) {
        throw new UnsupportedOperationException("Cannot add to ParkingSlot");
    }

    @Override
    public void remove(ParkingStructure structure) {
        throw new UnsupportedOperationException("Cannot remove from ParkingSlot");
    }
}

// Behavioral pattern 
interface ParkingObserver {
    void update(ParkingSlot slot);
}

class PaymentObserver implements ParkingObserver {
    private PaymentSystem paymentSystem;

    public PaymentObserver(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    @Override
    public void update(ParkingSlot slot) {
        if (!slot.isOccupied()) {
            System.out.println("Collecting payment for slot " + slot.getId());
            Ticket ticket = new Ticket(System.currentTimeMillis(), slot.getClass().getSimpleName());
            paymentSystem.takePayment(ticket);
        }
    }
}

// Subject interface for managing observers
interface ParkingSubject {
    void registerObserver(ParkingObserver observer);
    void removeObserver(ParkingObserver observer);
    void notifyObservers(ParkingSlot slot);
}

class ParkingSlotManager implements ParkingSubject {
    private List<ParkingObserver> observers;

    public ParkingSlotManager() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(ParkingObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ParkingObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(ParkingSlot slot) {
        for (ParkingObserver observer : observers) {
            observer.update(slot);
        }
    }
}

class Address {
    private int id;
    private int pincode;
    private int streetNumber;
    private String city;
    private String country;

    public Address(int id, int pincode, int streetNumber, String city, String country) {
        this.id = id;
        this.pincode = pincode;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public int getPincode() {
        return pincode;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}

// Ticket class representing a parking ticket
class Ticket {
    private static int ticketIdCounter = 1;

    private int id;
    private long timestamp;
    private String type; // Type of vehicle (Car, Bike)

    public Ticket(long timestamp, String type) {
        this.id = ticketIdCounter++;
        this.timestamp = timestamp;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }
}

// PaymentSystem class for handling payments
class PaymentSystem {
    public void takePayment(Ticket ticket) {
        System.out.println("Payment taken for Ticket ID: " + ticket.getId());
    }
}

// ParkingManagementSystem for managing parking operations
class ParkingManagementSystem {
    private ParkingArea parkingArea;
    private ParkingSlotManager slotManager;

    public ParkingManagementSystem(String parkingAreaName, PaymentSystem paymentSystem) {
        this.parkingArea = new ParkingArea(parkingAreaName);
        this.slotManager = new ParkingSlotManager();
        this.slotManager.registerObserver(new PaymentObserver(paymentSystem));
    }

    public void parkVehicle(Vehicle vehicle, ParkingSlot slot) {
        vehicle.park(slot);
        slotManager.notifyObservers(slot); // Notify observers when vehicle is parked
    }

    public void unparkVehicle(ParkingSlot slot) {
        slot.leave();
        slotManager.notifyObservers(slot); // Notify observers when vehicle leaves
    }

    public int getAvailableSlots() {
        return parkingArea.isOccupied() ? 0 : 1; 
    }

    public int getBlockedSlots() {
        return parkingArea.isOccupied() ? 1 : 0; 
    }
}

public class ParkingLotSystem {
    public static void main(String[] args) {
        // Create a parking management system
        ParkingManagementSystem parkingSystem = new ParkingManagementSystem("Main Parking Area", new PaymentSystem());

        // Create some parking slots
        ParkingSlot slot1 = new ParkingSlot("A1");
        ParkingSlot slot2 = new ParkingSlot("A2");
        ParkingSlot slot3 = new ParkingSlot("B1");

        // Park some vehicles
        Vehicle car1 = new Car("ABC123");
        Vehicle bike1 = new Bike("XYZ456");
        Vehicle car2 = new Car("DEF789");

        parkingSystem.parkVehicle(car1, slot1);
        parkingSystem.parkVehicle(bike1, slot2);
        parkingSystem.parkVehicle(car2, slot3);

        // Output current parking status (example)
        System.out.println("Available Slots: " + parkingSystem.getAvailableSlots());
        System.out.println("Blocked Slots: " + parkingSystem.getBlockedSlots());

        //unparking a vehicle
        parkingSystem.unparkVehicle(slot1);

        // Output updated parking status (example)
        System.out.println("Available Slots: " + parkingSystem.getAvailableSlots());
        System.out.println("Blocked Slots: " + parkingSystem.getBlockedSlots());
    }
}

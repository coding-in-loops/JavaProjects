/*
 * Vehicle renting Application implementing design patterns
 * Requirements:
 * 1. Able to rent various types of vehicles (cars, bikes, etc.).
 * 2. Manage vehicle availability and rental status.
 * 3. Calculate rental charges based on vehicle type and rental duration.
 * 4. Support flexible payment options.
 * 5. Track rented vehicles and notify users when their rental period is about to end.
 */
import java.util.List;
import java.util.ArrayList;
// Creational Patterns

// Singleton
class RentalService {
    private static RentalService instance;

    private RentalService() {
    }

    public static RentalService getInstance() {
        if (instance == null) {
            instance = new RentalService();
        }
        return instance;
    }

    public void rentVehicle(Vehicle vehicle) {
        System.out.println("Renting vehicle: " + vehicle.getRegistrationNumber());
    }

    public void returnVehicle(Vehicle vehicle) {
        System.out.println("Returning vehicle: " + vehicle.getRegistrationNumber());
    }
}

// Factory
interface Vehicle {
    String getRegistrationNumber();
}

class Car implements Vehicle {
    private String registrationNumber;

    public Car(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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

// Builder
class RentalAgreement {
    private String renterName;
    private Vehicle vehicle;
    private long rentalStartTime;
    private long rentalEndTime;

    private RentalAgreement(RentalAgreementBuilder builder) {
        this.renterName = builder.renterName;
        this.vehicle = builder.vehicle;
        this.rentalStartTime = builder.rentalStartTime;
        this.rentalEndTime = builder.rentalEndTime;
    }

    public static class RentalAgreementBuilder {
        private String renterName;
        private Vehicle vehicle;
        private long rentalStartTime;
        private long rentalEndTime;

        public RentalAgreementBuilder withRenterName(String renterName) {
            this.renterName = renterName;
            return this;
        }

        public RentalAgreementBuilder withVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public RentalAgreementBuilder withRentalStartTime(long rentalStartTime) {
            this.rentalStartTime = rentalStartTime;
            return this;
        }

        public RentalAgreementBuilder withRentalEndTime(long rentalEndTime) {
            this.rentalEndTime = rentalEndTime;
            return this;
        }

        public RentalAgreement build() {
            return new RentalAgreement(this);
        }
    }
}
    // Adapter
interface PaymentGateway {
    void processPayment(double amount);
}

class PayPalGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " through PayPal.");
    }
}

class AnotherPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of " + amount + " through another method.");
    }
}

class AnotherPaymentAdapter implements PaymentGateway {
    private AnotherPaymentGateway paymentGateway;

    public AnotherPaymentAdapter(AnotherPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        paymentGateway.makePayment(amount);
    }
}

// Composite
interface VehicleComponent {
    void displayDetails();
}

class SingleVehicle implements VehicleComponent {
    private Vehicle vehicle;

    public SingleVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle: " + vehicle.getRegistrationNumber());
    }
}

class VehicleCollection implements VehicleComponent {
    private List<VehicleComponent> vehicles = new ArrayList<>();

    public void addVehicle(VehicleComponent vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(VehicleComponent vehicle) {
        vehicles.remove(vehicle);
    }

    @Override
    public void displayDetails() {
        for (VehicleComponent vehicle : vehicles) {
            vehicle.displayDetails();
        }
    }
}

// Decorator
abstract class VehicleDecorator implements Vehicle {
    protected Vehicle decoratedVehicle;

    public VehicleDecorator(Vehicle vehicle) {
        this.decoratedVehicle = vehicle;
    }

    public String getRegistrationNumber() {
        return decoratedVehicle.getRegistrationNumber();
    }
}

class GPSDecorator extends VehicleDecorator {
    public GPSDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public String getRegistrationNumber() {
        return decoratedVehicle.getRegistrationNumber() + " with GPS";
    }
}
// Strategy
interface PricingStrategy {
    double calculatePrice(long rentalDuration);
}

class HourlyPricingStrategy implements PricingStrategy {
    private static final double HOURLY_RATE = 5.0;

    @Override
    public double calculatePrice(long rentalDuration) {
        return HOURLY_RATE * rentalDuration;
    }
}

class DailyPricingStrategy implements PricingStrategy {
    private static final double DAILY_RATE = 20.0;

    @Override
    public double calculatePrice(long rentalDuration) {
        return DAILY_RATE * rentalDuration;
    }
}

// Observer
interface RentalObserver {
    void update(Vehicle vehicle);
}

class NotificationObserver implements RentalObserver {
    @Override
    public void update(Vehicle vehicle) {
        System.out.println("Notifying user about vehicle: " + vehicle.getRegistrationNumber());
    }
}

class RentalSubject {
    private List<RentalObserver> observers = new ArrayList<>();

    public void registerObserver(RentalObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(RentalObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Vehicle vehicle) {
        for (RentalObserver observer : observers) {
            observer.update(vehicle);
        }
    }
}

// Command
interface Command {
    void execute();
}

class RentVehicleCommand implements Command {
    private Vehicle vehicle;
    private RentalService rentalService;

    public RentVehicleCommand(Vehicle vehicle, RentalService rentalService) {
        this.vehicle = vehicle;
        this.rentalService = rentalService;
    }

    @Override
    public void execute() {
        rentalService.rentVehicle(vehicle);
        System.out.println("Vehicle " + vehicle.getRegistrationNumber() + " has been rented.");
    }
}

class ReturnVehicleCommand implements Command {
    private Vehicle vehicle;
    private RentalService rentalService;

    public ReturnVehicleCommand(Vehicle vehicle, RentalService rentalService) {
        this.vehicle = vehicle;
        this.rentalService = rentalService;
    }

    @Override
    public void execute() {
        rentalService.returnVehicle(vehicle);
        System.out.println("Vehicle " + vehicle.getRegistrationNumber() + " has been returned.");
    }
}

// Main application
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create a rental service (Singleton)
        RentalService rentalService = RentalService.getInstance();

        // Create vehicle factories
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory bikeFactory = new BikeFactory();

        // Create vehicles
        Vehicle car = carFactory.createVehicle("CAR123");
        Vehicle bike = bikeFactory.createVehicle("BIKE456");

        // Create rental agreements using builder
        RentalAgreement rentalAgreement = new RentalAgreement.RentalAgreementBuilder()
                .withRenterName("name")
                .withVehicle(car)
                .withRentalStartTime(System.currentTimeMillis())
                .withRentalEndTime(System.currentTimeMillis() + 3600000)
                .build();

        // Rent vehicles using commands
        Command rentCarCommand = new RentVehicleCommand(car, rentalService);
        Command returnCarCommand = new ReturnVehicleCommand(car, rentalService);

        rentCarCommand.execute();
        returnCarCommand.execute();

        // Payment using Adapter pattern
        PaymentGateway paypalGateway = new PayPalGateway();
        PaymentGateway anotherPaymentGateway = new AnotherPaymentAdapter(new AnotherPaymentGateway());

        paypalGateway.processPayment(50.0);
        anotherPaymentGateway.processPayment(100.0);

        // Use composite pattern to manage vehicle fleets
        VehicleComponent carComponent = new SingleVehicle(car);
        VehicleComponent bikeComponent = new SingleVehicle(bike);
        VehicleCollection fleet = new VehicleCollection();
        fleet.addVehicle(carComponent);
        fleet.addVehicle(bikeComponent);

        fleet.displayDetails();

        // Add GPS to vehicle using Decorator pattern
        Vehicle gpsCar = new GPSDecorator(car);
        System.out.println(gpsCar.getRegistrationNumber());

        // Notify user using Observer pattern
        RentalSubject rentalSubject = new RentalSubject();
        RentalObserver notificationObserver = new NotificationObserver();
        rentalSubject.registerObserver(notificationObserver);
        rentalSubject.notifyObservers(car);
    }
}




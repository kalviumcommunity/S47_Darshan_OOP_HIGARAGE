import java.util.*;

// Interface to define the behavior of all vehicles
interface Vehicle {
    void displayInfo(); // Common method for all vehicles
}

// Class to manage user information
class UserInfo {
    private String userName; // Stores user name (Encapsulation)
    private static int totalUsers = 0; // Tracks total number of users

    // Constructor to initialize userName and increment user count
    public UserInfo(String userName) {
        this.userName = userName;
        totalUsers++;
    }

    // Getter to access the user name
    public String getName() {
        return userName;
    }

    // Setter to update the user name
    public void setName(String userName) {
        this.userName = userName;
    }

    // Static method to get the total user count
    public static int getTotalUsers() {
        return totalUsers;
    }
}

// Abstract class for common vehicle properties
abstract class BaseVehicle implements Vehicle {
    protected String lastServiceDate; // Service date (protected for inheritance)

    public BaseVehicle(String serviceDate) {
        this.lastServiceDate = serviceDate;
    }

    @Override
    public abstract void displayInfo(); // Ensures derived classes implement this
}

// Class to represent four-wheelers (base for all four-wheelers)
class FourWheeler extends BaseVehicle {
    public FourWheeler(String serviceDate) {
        super(serviceDate);
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a generic four-wheeler.");
    }
}

// Specific vehicle class for Wagonr
class Wagonr extends FourWheeler {
    public Wagonr(String serviceDate) {
        super(serviceDate);
    }

    @Override
    public void displayInfo() {
        System.out.println("Wagonr Info: Distance driven: 100km, Mileage: 15kmpl, Last service date: " + lastServiceDate);
    }
}

// Specific vehicle class for HondaCity
class HondaCity extends FourWheeler {
    public HondaCity(String serviceDate) {
        super(serviceDate);
    }

    @Override
    public void displayInfo() {
        System.out.println("HondaCity Info: Distance driven: 50km, Mileage: 10kmpl, Last service date: " + lastServiceDate);
    }
}

// Specific vehicle class for Duke390 (a two-wheeler)
class Duke390 extends BaseVehicle {
    public Duke390(String serviceDate) {
        super(serviceDate);
    }

    @Override
    public void displayInfo() {
        System.out.println("Duke390 Info: Distance driven: 250km, Mileage: 8kmpl, Last service date: " + lastServiceDate);
    }
}

// Service class to manage vehicle-related operations
class VehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void displayAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }

    public int getTotalVehicles() {
        return vehicles.size();
    }
}

// Factory class to create vehicles dynamically (adhering to OCP)
class VehicleFactory {
    public static Vehicle createVehicle(String type, String serviceDate) {
        switch (type.toLowerCase()) {
            case "wagonr":
                return new Wagonr(serviceDate);
            case "hondacity":
                return new HondaCity(serviceDate);
            case "duke390":
                return new Duke390(serviceDate);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

// Main class to handle user interaction
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to my Garage!");

        // Collect user information
        System.out.print("Enter Your Name: ");
        String userName = sc.nextLine();
        UserInfo user = new UserInfo(userName);

        // Option to update the user name
        System.out.print("Would you like to update your name? (yes/no): ");
        String updateNameChoice = sc.nextLine();
        if (updateNameChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter your new name: ");
            String newName = sc.nextLine();
            user.setName(newName);
        }

        // Prompt to choose vehicle types
        System.out.println("Available vehicles: Wagonr, HondaCity, Duke390");
        System.out.print("Enter the type of vehicle you want to add (comma-separated for multiple): ");
        String[] vehicleTypes = sc.nextLine().split(",");

        VehicleService vehicleService = new VehicleService();

        // Add vehicles based on user input
        for (String vehicleType : vehicleTypes) {
            try {
                vehicleService.addVehicle(VehicleFactory.createVehicle(vehicleType.trim(), "14 December 2024"));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Display vehicle information
        System.out.println("\nHey " + user.getName() + ", here are the vehicles in your garage:");
        vehicleService.displayAllVehicles();

        // Display total counts
        System.out.println("\nTotal users so far: " + UserInfo.getTotalUsers());
        System.out.println("Total vehicles recorded: " + vehicleService.getTotalVehicles());

        sc.close();
    }
}
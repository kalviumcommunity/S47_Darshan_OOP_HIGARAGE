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

        // Prompt to choose a vehicle category
        System.out.print("Press 1 for four-wheelers, or 2 for two-wheelers: ");
        int userChoice = sc.nextInt();

        VehicleService vehicleService = new VehicleService();

        // Add vehicles based on the user’s choice
        switch (userChoice) {
            case 1:
                vehicleService.addVehicle(new Wagonr("14 December 2024"));
                vehicleService.addVehicle(new HondaCity("14 December 2024"));
                break;

            case 2:
                vehicleService.addVehicle(new Duke390("14 December 2024"));
                break;

            default:
                System.out.println("Invalid category selected!");
                sc.close();
                return;
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

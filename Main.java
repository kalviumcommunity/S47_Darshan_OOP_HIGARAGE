import java.util.*;

// Interface to define the behavior of all vehicles
interface Vehicle {
    void displayInfo(); // Common method for all vehicles
}

// Class to manage user information
class UserInfo {
    private String userName; // Stores user name (Encapsulation)
    public static int totalUsers = 0; // Tracks total number of users

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

// Class to represent the Wagonr vehicle
class Wagonr implements Vehicle {
    private String currDate; // Stores current date
    private final String lastVehicleServiceDate = "12 November 2024"; // Service date (constant)
    public static int totalVehicles = 0; // Tracks total number of vehicles of any type

    // Constructor to initialize currDate and increment vehicle count
    public Wagonr(String currDate) {
        this.currDate = currDate;
        totalVehicles++;
    }

    // Displays information about the Wagonr
    public void displayInfo() {
        System.out.println("Displaying info about Wagonr:");
        System.out.println("Distance driven: 100km, Mileage: 15kmpl, Last service date: " + lastVehicleServiceDate);
    }

    // Static method to get the total vehicle count
    public static int getTotalVehicles() {
        return totalVehicles;
    }
}

// Class to represent the HondaCity vehicle
class HondaCity implements Vehicle {
    private String currDate; // Stores current date
    private final String lastVehicleServiceDate = "24 October 2024"; // Service date (constant)

    // Constructor to initialize currDate and increment vehicle count
    public HondaCity(String currDate) {
        this.currDate = currDate;
        Wagonr.totalVehicles++;
    }

    // Displays information about the HondaCity
    public void displayInfo() {
        System.out.println("Displaying info about HondaCity:");
        System.out.println("Distance driven: 50km, Mileage: 10kmpl, Last service date: " + lastVehicleServiceDate);
    }
}

// Class to represent the Duke390 vehicle
class Duke390 implements Vehicle {
    private String currDate; // Stores current date
    private final String lastVehicleServiceDate = "24 July 2024"; // Service date (constant)

    // Constructor to initialize currDate and increment vehicle count
    public Duke390(String currDate) {
        this.currDate = currDate;
        Wagonr.totalVehicles++;
    }

    // Displays information about the Duke390
    public void displayInfo() {
        System.out.println("Displaying info about Duke390:");
        System.out.println("Distance driven: 250km, Mileage: 8kmpl, Last service date: " + lastVehicleServiceDate);
    }
}

// Main class to interact with the user
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

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        // Add vehicles based on the user’s choice
        switch (userChoice) {
            case 1:
                vehicles.add(new Wagonr("14 December 2024"));
                vehicles.add(new HondaCity("14 December 2024"));
                break;

            case 2:
                vehicles.add(new Duke390("14 December 2024"));
                break;

            default:
                System.out.println("Invalid category selected!");
                sc.close();
                return;
        }

        // Display vehicle information
        System.out.println("\nHey " + user.getName() + ", here are the vehicles in your garage:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            vehicle = null;
        }

        // Display total counts
        System.out.println("\nTotal users so far: " + UserInfo.getTotalUsers());
        System.out.println("Total vehicles recorded: " + Wagonr.getTotalVehicles());

        sc.close();
    }
}

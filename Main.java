import java.util.*;

// Interface to represent all vehicles
interface Vehicle {
    void displayInfo();    
}

// Class demonstrating encapsulation for user information
class UserInfo {
    private String userName; // Encapsulation: private field
    public static int totalUsers = 0; 

    public UserInfo(String userName) {
        this.userName = userName; // Encapsulation: controlled access via constructor
        totalUsers++; 
    }

    public String getName() { // Getter to access private field
        return userName;
    }

    public void setName(String userName) { // Setter to modify private field
        this.userName = userName;
    }

    public static int getTotalUsers() { // Getter for static field
        return totalUsers;
    }
}

// Class demonstrating encapsulation for vehicle information
class Wagonr implements Vehicle {
    private String currDate; // Encapsulation: private field
    private final String lastVehicleServiceDate = "12 November 2024"; // Encapsulation: controlled access

    public static int totalVehicles = 0;

    public Wagonr(String currDate) {
        this.currDate = currDate; // Encapsulation: controlled access via constructor
        totalVehicles++; 
    }

    public void displayInfo() {
        System.out.println("Displaying info about Wagonr!!");
        System.out.print("Distance driven:- 100km, ");
        System.out.print("Mileage from the vehicle:- 15kmpl, Last service date:- " + lastVehicleServiceDate);
        System.out.println();
    }

    public static int getTotalVehicles() { // Getter for static field
        return totalVehicles;
    }
}

// Class demonstrating encapsulation for vehicle information
class HondaCity implements Vehicle {
    private String currDate; // Encapsulation: private field
    private final String lastVehicleServiceDate = "24 October 2024"; // Encapsulation: controlled access

    public HondaCity(String currDate) {
        this.currDate = currDate; // Encapsulation: controlled access via constructor
        Wagonr.totalVehicles++; 
    }

    public void displayInfo() {
        System.out.println("Displaying info about HondaCity!!");
        System.out.print("Distance driven:- 50km, ");
        System.out.print("Mileage from the vehicle:- 10kmpl, Last service date:- " + lastVehicleServiceDate);
        System.out.println();
    }
}

// Class demonstrating encapsulation for vehicle information
class Duke390 implements Vehicle {
    private String currDate; // Encapsulation: private field
    private final String lastVehicleServiceDate = "24 July 2024"; // Encapsulation: controlled access

    public Duke390(String currDate) {
        this.currDate = currDate; // Encapsulation: controlled access via constructor
        Wagonr.totalVehicles++; 
    }

    public void displayInfo() {
        System.out.println("Displaying info about Duke390!!");
        System.out.print("Distance driven:- 250km, ");
        System.out.print("Mileage from the vehicle:- 8kmpl, Last service date:- " + lastVehicleServiceDate);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my Garage:- ");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your Name:- ");
        String userName = sc.nextLine();

        UserInfo user = new UserInfo(userName); // Encapsulation: managing user data via class

        System.out.print("Would you like to update your name? (yes/no): ");
        String updateNameChoice = sc.nextLine();
        if (updateNameChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter your new name: ");
            String newName = sc.nextLine();
            user.setName(newName); // Setter used to modify private data
        }

        System.out.print("Press 1 to display the four-wheelers info, and Press 2 to display the two-wheelers info:- ");
        int userChoice = sc.nextInt();
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        switch (userChoice) {
            case 1:
                vehicles.add(new Wagonr("14 December 2024")); // Encapsulation via constructor
                vehicles.add(new HondaCity("14 December 2024")); // Encapsulation via constructor
                break;

            case 2:
                vehicles.add(new Duke390("14 December 2024")); // Encapsulation via constructor
                break;

            default:
                System.out.println("Invalid category of vehicle selected!!");
                return;
        }

        System.out.println("Hey " + user.getName() + ", here are the list of all the vehicles you have in your garage:");

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }

        System.out.println("Total users so far: " + UserInfo.getTotalUsers()); // Getter used to access static field
        System.out.println("Total vehicles recorded in the system: " + Wagonr.getTotalVehicles()); // Getter used to access static field

        sc.close(); 
    }
}

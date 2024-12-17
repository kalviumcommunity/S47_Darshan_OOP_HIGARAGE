import java.util.*;

interface Vehicle {
    // Abstraction: Specifies the common behavior for all vehicles without showing how it is implemented.
    void displayInfo();    
}

class UserInfo {
    private String userName; // Encapsulation: userName is private to restrict direct access.
    
    public static int totalUsers = 0; // Public: totalUsers is accessible globally to track all users.

    public UserInfo(String userName) {
        this.userName = userName; // Encapsulation: Private field set via constructor.
        totalUsers++; // Increments totalUsers whenever a new UserInfo object is created.
    }

    public String getName() { // Public getter method to access private userName.
        return userName;
    }

    public void setName(String userName) { // Public setter method to update private userName.
        this.userName = userName;
    }

    public static int getTotalUsers() { // Public method to retrieve total users.
        return totalUsers;
    }
}

class Wagonr implements Vehicle {
    private String currDate; // Encapsulation: currDate is private to prevent external modification.
    private final String lastVehicleServiceDate = "12 November 2024"; // Private constant field, cannot be modified.

    public static int totalVehicles = 0; // Public: Tracks the total number of vehicles globally.

    public Wagonr(String currDate) {
        this.currDate = currDate; // Encapsulation: currDate is initialized through the constructor.
        totalVehicles++; // Updates the total vehicle count for all vehicles.
    }

    public void displayInfo() { // Abstraction: Implementation of the abstract method from the Vehicle interface.
        System.out.println("Displaying info about Wagonr!!");
        System.out.print("Distance driven:- 100km, ");
        System.out.print("Mileage from the vehicle:- 15kmpl, Last service date:- " + lastVehicleServiceDate);
        System.out.println();
    }

    public static int getTotalVehicles() { // Public method to retrieve the total vehicle count.
        return totalVehicles;
    }
}

class HondaCity implements Vehicle {
    private String currDate; // Encapsulation: currDate is private to restrict direct access.
    private final String lastVehicleServiceDate = "24 October 2024"; // Private constant for service date.

    public HondaCity(String currDate) {
        this.currDate = currDate; // Encapsulation: currDate is set via the constructor.
        Wagonr.totalVehicles++; // Updates the shared vehicle count.
    }

    public void displayInfo() { // Abstraction: HondaCity-specific implementation of displayInfo.
        System.out.println("Displaying info about HondaCity!!");
        System.out.print("Distance driven:- 50km, ");
        System.out.print("Mileage from the vehicle:- 10kmpl, Last service date:- " + lastVehicleServiceDate);
        System.out.println();
    }
}

class Duke390 implements Vehicle {
    private String currDate; // Encapsulation: currDate is private to restrict access.
    private final String lastVehicleServiceDate = "24 July 2024"; // Private constant for service date.

    public Duke390(String currDate) {
        this.currDate = currDate; // Encapsulation: currDate is set through the constructor.
        Wagonr.totalVehicles++; // Updates the shared vehicle count.
    }

    public void displayInfo() { // Abstraction: Duke390-specific implementation of displayInfo.
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

        // Prompting user for their information
        System.out.print("Enter Your Name:- ");
        String userName = sc.nextLine();

        UserInfo user = new UserInfo(userName); // Encapsulation: UserInfo object handles user details privately.

        // Option to update user name
        System.out.print("Would you like to update your name? (yes/no): ");
        String updateNameChoice = sc.nextLine();
        if (updateNameChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter your new name: ");
            String newName = sc.nextLine();
            user.setName(newName); // Updating the private field via setter method.
        }

        // Prompting user to choose a vehicle category
        System.out.print("Press 1 to display the four-wheelers info, and Press 2 to display the two-wheelers info:- ");
        int userChoice = sc.nextInt();
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        // Adding vehicles based on user choice
        switch (userChoice) {
            case 1:
                vehicles.add(new Wagonr("14 December 2024")); // Four-wheeler added to list.
                vehicles.add(new HondaCity("14 December 2024")); // Four-wheeler added to list.
                break;

            case 2:
                vehicles.add(new Duke390("14 December 2024")); // Two-wheeler added to list.
                break;

            default:
                System.out.println("Invalid category of vehicle selected!!");
                return; // Exit program for invalid input.
        }

        // Displaying vehicle info
        System.out.println("Hey " + user.getName() + ", here are the list of all the vehicles you have in your garage:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo(); // Polymorphism: displayInfo() called on different vehicle types.
        }

        // Displaying total users and vehicles
        System.out.println("Total users so far: " + UserInfo.getTotalUsers());
        System.out.println("Total vehicles recorded in the system: " + Wagonr.getTotalVehicles());

        sc.close(); // Closing the scanner resource.
    }
}

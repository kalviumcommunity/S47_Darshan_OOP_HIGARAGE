import java.util.*;

interface Vehicle{
    void displayInfo();    
}

class UserInfo{
    private String userName;
    
    public UserInfo(String userName){
        this.userName = userName; 
    }
    
    public String getName(){
        return userName;
    }
}

class Wagonr implements Vehicle{
    private String currDate;
    private final String last_vehicle_service_date = "12 November 2024";
    
    public Wagonr(String currDate){
        this.currDate = currDate;
    }
    
    public void displayInfo(){
        System.out.println("Displaying info about Wagonr!!");
        System.out.print("Distance driven:- 100km, ");
        System.out.print("Milage from the vehicle:- 15kmpl, Last service date:- " + last_vehicle_service_date);
    }
}

class HondaCity implements Vehicle{
    private String currDate;
    private final String last_vehicle_service_date = "24 October 2024";
    
    public HondaCity(String currDate){
        this.currDate = currDate;
    }
    
    public void displayInfo(){
        System.out.println("Displaying info about HondaCity!!");
        System.out.print("Distance driven:- 50km, ");
        System.out.print("Milage from the vehicle:- 10kmpl, Last service date:- " + last_vehicle_service_date);
    }
}

class Duke390 implements Vehicle{
    private String currDate;
    private final String last_vehicle_service_date = "24 July 2024";
    
    public Duke390(String currDate){
        this.currDate = currDate;
    }
    
    public void displayInfo(){
        System.out.println("Displaying info about Duke390!!");
        System.out.print("Distance driven:- 250km, ");
        System.out.print("Milage from the vehicle:- 8kmpl, Last service date:- " + last_vehicle_service_date);
    }
}

public class Main
{
    public static void main(String[] args) {
        System.out.println("Welcome to my Garage:- ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Name:- ");
        String userName = sc.nextLine();
        UserInfo user = new UserInfo(userName);
        
        
        System.out.print("Press 1 to display the fourwheelers info, and Press 2 to diplay the Two wheelers info:- ");
        int userChoice = sc.nextInt();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        switch (userChoice) {
            case 1:
                vehicles.add(new Wagonr("14 December 2024"));
                vehicles.add(new HondaCity("14 December 2024"));
                break;
            case 2:
                vehicles.add(new Duke390("14 December 2024"));
                break;
            default:
                System.out.println("Invalid category of vehicle selected!!");
                return;
        }
        
        System.out.println("Hey " + user.getName() + ", here are the list of all the vehicles you have in your garage");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }
}
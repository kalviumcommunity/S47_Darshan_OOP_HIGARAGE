class UserInfo{
    private String userName;
    private int age;
    
    public UserInfo(String userName, int age){
        this.userName = userName;
        this.age = age;
    }
}

class Wagonr {
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

class HondaCity {
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

class Duke390{
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
        Wagonr wagon = new Wagonr("24 October 2024");
        wagon.displayInfo();
    }
}
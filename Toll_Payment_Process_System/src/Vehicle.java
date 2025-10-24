import java.util.*;
class Vehicle {
    String vehicleNumber;
    String vehicleType;
    boolean isVIP;
    List<Journey> journeys;

    public Vehicle(String vehicleNumber,String vehicleType,boolean isVIP) {
        this.vehicleNumber = vehicleNumber;
        this.isVIP = isVIP;
        this.vehicleType = vehicleType;
        this.journeys=new ArrayList<>();
    }

    public void addJourney(Journey journey){
        journeys.add(journey);
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + vehicleType + ", VIP: " + isVIP);
        for (Journey journey : journeys) {
            System.out.println("Journey: " + journey.startPoint + " -> " + journey.endPoint);
            System.out.println("Tolls Passed: " + journey.tollsPassed);
            System.out.println("Amount Paid: ₹" + journey.amountPaid);
        }
        int totalPaid = journeys.stream().mapToInt(j -> j.amountPaid).sum();
        System.out.println("Total Amount Paid: ₹" + totalPaid);
    }
}

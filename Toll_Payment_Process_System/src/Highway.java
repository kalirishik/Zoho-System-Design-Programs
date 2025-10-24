import java.util.*;

class Highway {
    List<Toll> tollPoints;
    //vehicleRecords.put("TN02CD5678", bike);
    Map<String, Vehicle> vehicleRecords;

    public Highway(List<Toll> tollPoints) {
        this.tollPoints = tollPoints;
        this.vehicleRecords = new HashMap<>();
    }

    // Process the journey for the regular path between start and end
    public void processJourney(String vehicleNumber, String vehicleType, boolean isVIP, String start, String end, List<Integer> tollRoute) {
        //If vehicle not present in vehicleRecords, then create new
        Vehicle vehicle = vehicleRecords.computeIfAbsent(vehicleNumber, vn -> new Vehicle(vn, vehicleType, isVIP));
        int totalAmount = 0;
        //show screenshot
        for (int tollId : tollRoute) {
            Toll toll = tollPoints.get(tollId);

            int charge = toll.calculateToll(vehicleType, isVIP);
            //recordVehicle is present in Toll.java class
            toll.recordVehicle(vehicle, charge);
            totalAmount += charge;
        }
        //Creating journey object
        Journey journey = new Journey(start, end, tollRoute, totalAmount);
        vehicle.addJourney(journey);

        System.out.println("Journey completed! Total Toll Paid: " + totalAmount);
    }

    public void displayTollDetails() {
        for (Toll toll : tollPoints) {
            toll.displayDetails();
        }
    }

    public void displayVehicleDetails() {
        for (Vehicle vehicle : vehicleRecords.values()) {
            vehicle.displayDetails();
        }
    }

    // Find shortest route considering circular path
    public List<Integer> findCircularRoute(int start, int end) {
        List<Integer> forwardRoute = new ArrayList<>();
        List<Integer> backwardRoute = new ArrayList<>();
        int totalTolls = tollPoints.size();

        // Forward route
        for (int i = start; i != end; i = (i + 1) % totalTolls) {
            forwardRoute.add(i);   // [0, 1, 2]
        }
        forwardRoute.add(end);

        // Backward route
        //The line i = (i - 1 + totalTolls) % totalTolls ensures that when i goes below 0, it wraps around back to totalTolls - 1 (circular route in reverse direction).
        for (int i = start; i != end; i = (i - 1 + totalTolls) % totalTolls) {
            backwardRoute.add(i);
        }
        backwardRoute.add(end);

        return forwardRoute.size() <= backwardRoute.size() ? forwardRoute : backwardRoute;
    }

    // Calculate toll for regular route between start and end
    public int calculateRegularTollForRoute(int start, int end, String vehicleType, boolean isVIP) {
        int totalCost = 0;
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                Toll toll = tollPoints.get(i);
                totalCost += toll.calculateToll(vehicleType, isVIP);
            }
        } else {
            // [0, 1, 2]
            for (int i = start; i < tollPoints.size(); i++) {
                Toll toll = tollPoints.get(i);
                totalCost += toll.calculateToll(vehicleType, isVIP);
            }
            for (int i = 0; i <= end; i++) {
                Toll toll = tollPoints.get(i);
                totalCost += toll.calculateToll(vehicleType, isVIP);
            }
        }
        return totalCost;
    }

    // Calculate toll for a specific route
    public int calculateTollForRoute(List<Integer> tollRoute, String vehicleType, boolean isVIP) {
        int totalCost = 0;
        for (int tollId : tollRoute) {
            Toll toll = tollPoints.get(tollId);
            totalCost += toll.calculateToll(vehicleType, isVIP);
        }
        return totalCost;
    }
}
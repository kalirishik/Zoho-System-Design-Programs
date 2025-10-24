import java.util.*;
class Toll {
    int tollId;
    Map<String,Integer> chargesPerVehicleType;
    List<VehiclePayment> vehiclesPassed;
    int totalRevenue;

    public Toll(int tollId, Map<String, Integer> chargesPerVehicleType) {
        this.tollId = tollId;
        this.chargesPerVehicleType = chargesPerVehicleType;
        this.vehiclesPassed=new ArrayList<>();
        this.totalRevenue=0;
    }

    public int calculateToll(String vehicleType, boolean isVIP) {
        for (Map.Entry<String, Integer> entry : chargesPerVehicleType.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(vehicleType)) {
                int charge = entry.getValue();
                if (isVIP)
                    charge = charge - (charge / 5);
                return charge;
            }
        }
        return 0; // if not found
    }


    public void recordVehicle(Vehicle vehicle, int charge){
        vehiclesPassed.add(new VehiclePayment(vehicle.vehicleNumber,charge));
        totalRevenue+=charge;
    }

    public void displayDetails(){
        System.out.println("Toll ID: "+tollId);
        if(!vehiclesPassed.isEmpty())
            System.out.println("Vehicle Passed: ");
        for(VehiclePayment vp:vehiclesPassed){
            System.out.println("Vehicle: "+vp.vehicleNumber+" , Paid: "+vp.amountPaid);
        }
        System.out.println("Total Revenue: "+totalRevenue);
    }
}

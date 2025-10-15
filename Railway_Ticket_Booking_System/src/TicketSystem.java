import java.util.*;
public class TicketSystem {
    List<String> availableBerths = new ArrayList<>(Arrays.asList("U", "L", "M"));//3 Berths
    Queue<Passenger> racQueue=new LinkedList<>();
    Queue<Passenger> waitingListQueue=new LinkedList<>();
    List<Passenger> confirmedTickets=new ArrayList<>();
    int ticketCount=1;

    void bookTicket(String name,int age,String gender,String berthPreference){
        String ticketId="T"+ticketCount++;
        Passenger passenger;
        if(!availableBerths.isEmpty()){
            String allocatedBerth=allocateBerth(age,gender,berthPreference);
            passenger=new Passenger(name,age,gender,berthPreference,allocatedBerth,ticketId);
            confirmedTickets.add(passenger);
            availableBerths.remove(allocatedBerth);
            System.out.println("Ticket Confirmed: "+passenger);
        }
        else if(racQueue.size()<1){
            passenger=new Passenger(name,age,gender,berthPreference,"RAC",ticketId);
            racQueue.offer(passenger);
            System.out.println("Ticket in RAC: "+passenger);
        }
        else if(waitingListQueue.size()<1){
            passenger=new Passenger(name,age,gender,berthPreference,"RAC",ticketId);
            waitingListQueue.offer(passenger);
            System.out.println("Ticket in Waiting List: "+passenger);
        }
        else
            System.out.println("No Ticket Available");
    }
    String allocateBerth(int age, String gender, String berthPreference){
        if(age>60 || gender.equalsIgnoreCase("Female") && availableBerths.contains("L"))
            return "L";
        if(availableBerths.contains(berthPreference))
            return berthPreference;
        return availableBerths.get(0);
    }
    void cancelTicket(String ticketId){
        Optional<Passenger> passengerOpt=confirmedTickets.stream()
                .filter(p->p.ticketId.equalsIgnoreCase(ticketId))
                .findFirst();
        if(passengerOpt.isPresent()){
            Passenger passenger=passengerOpt.get();
            confirmedTickets.remove(passenger);
            availableBerths.add(passenger.getAllottedBerth());
            if(!racQueue.isEmpty()){
                Passenger racPassenger=racQueue.poll();
                String alloctedBerth=allocateBerth(racPassenger.getAge(),racPassenger.getGender(),racPassenger.getBerthPreference());
                racPassenger.setAllottedBerth(alloctedBerth);
                confirmedTickets.add(racPassenger);
                availableBerths.remove(alloctedBerth);
                System.out.println("RAC ticket moved to Confirmed Ticket: "+racPassenger);

            }
            if(!waitingListQueue.isEmpty()){
                Passenger waitingPassenger=waitingListQueue.poll();
                racQueue.offer(waitingPassenger);
                waitingPassenger.setAllottedBerth("RAC");
                System.out.println("Waiting List Ticket Moved To RAC Ticket: "+waitingPassenger);
            }
            System.out.println("Ticket Cancelled Successfully for Id: "+ticketId);
        }
        else
            System.out.println("No Ticket Found With Id: "+ticketId);
    }

    public void viewConfirmedTickets() {
        if(confirmedTickets.size()==0)
            System.out.println("No Confirmed Tickets.");
        else{
            System.out.println("Confirmed Tickets");
            for(Passenger passenger:confirmedTickets)
                System.out.println(passenger);
        }
    }

    public void viewAvailableTickets() {
        System.out.println("Available Berths: "+availableBerths.size());
        System.out.println("Available RAC Tickets: "+ (1-racQueue.size()));
        System.out.println("Available Waiting List Tickets: "+ (1-waitingListQueue.size()));
    }

    public void viewRACTickets() {
        if(racQueue.size()==0)
            System.out.println("No RAC Tickets.");
        else{
            System.out.println("RAC Tickets");
            for(Passenger passenger:racQueue)
                System.out.println(passenger);
        }
    }

    public void viewWaitingListTickets() {
        if(waitingListQueue.size()==0)
            System.out.println("No Waiting List Tickets.");
        else{
            System.out.println("Waiting Tickets");
            for(Passenger passenger:waitingListQueue)
                System.out.println(passenger);
        }
    }
}

import java.util.*;

public class Flight {
    private String flightName;
    private int availableSeats;
    private int ticketPrice;
    Map<String,Passenger> bookings;
    int bookingCounter;

    public Flight(String flightName){
        this.flightName=flightName;
        this.availableSeats=50;
        this.ticketPrice=5000;
        this.bookingCounter=0;
        this.bookings=new HashMap<>();
    }

    public String bookTicket(String passengerName,int age, int seats){
        if(seats<=availableSeats){
            bookingCounter++;
            String bookingId="T"+bookingCounter;
            Passenger passenger=new Passenger(bookingId,passengerName,age,seats);
            bookings.put(bookingId,passenger);
            availableSeats-=seats;
            ticketPrice+=200*seats;
            return bookingId;
        }
        else{
            System.out.println("Booking Failed: Not enough seats available");
            return null;
        }
    }

    public boolean cancelTicket(String bookingId){
        Passenger passenger=bookings.get(bookingId);
        if(passenger!=null){
            int seats=passenger.getSeatsBooked();
            availableSeats+=seats;
            ticketPrice-=200*seats;
            bookings.remove(bookingId);
            System.out.println("Booking Cancelled Successfully. Refund Issued for "+seats+" Seats.");
            return true;
        }
        else{
            System.out.println("Booking Id Not Foound");
            return false;
        }
    }

    public void displayDetails(){
        System.out.println("Flight: "+flightName);
        System.out.println("Available Seats: "+availableSeats);
        System.out.println("Current Ticket Price: "+ticketPrice);
    }

    public void printDetails(){
        System.out.println("Flight: "+flightName);
        System.out.println("Available Seats: "+availableSeats);
        System.out.println("Current Ticket Price: "+ticketPrice);
        System.out.println("----- Passengers -----");
        if(bookings.size()==0)
            System.out.println("Nil");
        else{
            for(Passenger passenger:bookings.values())
                System.out.println(passenger);
        }
    }
}

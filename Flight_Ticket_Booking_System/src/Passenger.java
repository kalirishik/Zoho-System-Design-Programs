public class Passenger {
    private String bookingId;
    private String name;
    private int age;
    private int seatsBooked;

    public Passenger(String bookingId, String name, int age, int seatsBooked) {
        this.bookingId = bookingId;
        this.name = name;
        this.age = age;
        this.seatsBooked = seatsBooked;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    @Override
    public String toString() {
        return  "bookingId='" + bookingId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", seatsBooked=" + seatsBooked ;
    }
}

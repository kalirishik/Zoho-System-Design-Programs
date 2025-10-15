public class Passenger{
    String name;
    int age;
    String gender;
    String berthPreference;
    String allottedBerth;
    String ticketId;

    public Passenger(String name, int age, String gender, String berthPreference, String allottedBerth, String ticketId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.allottedBerth = allottedBerth;
        this.ticketId = ticketId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }

    public String getAllottedBerth() {
        return allottedBerth;
    }

    public void setAllottedBerth(String allottedBerth) {
        this.allottedBerth = allottedBerth;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return
                " TicketId= " + ticketId +
                ", name= " + name +
                ", age= " + age +
                ", gender= " + gender +
                ", allottedBerth= " + allottedBerth ;
    }
}
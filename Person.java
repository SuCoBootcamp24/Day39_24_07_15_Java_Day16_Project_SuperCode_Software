import java.time.LocalDate;

public class Person {

    private static long lastID = 1;

    private final long ID;
    private final LocalDate BIRTHDAY;
    private String lastname;
    private String firstname;
    private String address;
    private String email;


    public Person(String firstname, String lastname, LocalDate birthday, String address, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.BIRTHDAY = birthday;
        this.ID = lastID + 1;
        Person.lastID++;
        this.address = address;
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public long getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBIRTHDAY() {
        return BIRTHDAY;
    }

    @Override
     public String toString() {
        String message = getFirstname() + " " + getLastname() + "\nEmail: " +getEmail() + "\nBirthday: " + getBIRTHDAY() + "\nAdress: " + getAddress();
        return message;
        
    }

    

}
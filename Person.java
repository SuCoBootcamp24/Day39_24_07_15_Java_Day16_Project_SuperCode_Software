import java.time.LocalDate;

public class Person {

    private String lastname;
    private String firstname;
    private static long lastID = 0;
    private long ID;
    private String address;
    private String email;
    private LocalDate birthday;

    public Person(String firstname, String lastname, LocalDate birthday, String address, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
     public String toString() {
        String message = getFirstname() + " " + getLastname() + "\nEmail: " +getEmail() + "\nBirthday: " + getBirthday() + "\nAdress: " + getAddress();
        return message;
        
    }

    

}
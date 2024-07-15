import java.time.LocalDate;

public class Person {

    public static long getLastID = 0;
    private String lastname;
    private String firstname;
    private static long lastID;
    private long ID;
    private String address;
    private String email;
    private LocalDate birthday;

    public Person(String lastname, String firstname, LocalDate birthday, String address, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
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
        return "Student " + this.ID + ": " +
                "DOB: " + birthday + 
                "Address: " + address + 
                "Email: " + email;
    }

    

}
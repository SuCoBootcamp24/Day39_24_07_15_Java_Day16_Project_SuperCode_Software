import java.time.LocalDate;
import java.util.ArrayList;

public class Trainer extends Person {
    private ArrayList<String> licenses;
    private LocalDate inCompanySice;

    public Trainer(String lastname, String firstname, LocalDate birthday, String address, String email, LocalDate inCompanySince) {
        super(lastname, firstname, birthday, address, email);
        this.inCompanySice = inCompanySince;
        this.licenses = new ArrayList<>();
    }

    public ArrayList<String> getLicenses() {
        return licenses;
    }

    public LocalDate getInCompanySice() {
        return inCompanySice;
    }

    public void addLicenseToList(String license) {
        if (license.isEmpty())
            throw new IllegalArgumentException("String of new lincense is Empty.");
        if(!getLicenses().contains(license)) licenses.add(license);
    }
    
    @Override
    public String toString() {
        return "Trainer " + getID() + " " +
                getFirstname() + " " + getLastname() + ": " +
                "DOB: " + getBirthday() +
                " Licenses: " + licenses.toString();
    }
}

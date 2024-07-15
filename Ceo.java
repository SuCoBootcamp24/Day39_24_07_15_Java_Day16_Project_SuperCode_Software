import java.time.LocalDate;
import java.util.ArrayList;

public class Ceo extends Person{

    private ArrayList<EducationalCompany> companyList = new ArrayList<>();
    private LocalDate inCompany;

    public Ceo(String lastname, String firstname, LocalDate birthday, String address, String email, LocalDate inCompany, EducationalCompany educationalCompany) {
        super(lastname, firstname, birthday, address, email);
        addCampany(educationalCompany);
        setInCompany(inCompany);

    }


    public ArrayList<EducationalCompany> getCompanyList() {
        return companyList;
    }

    public void addCampany(EducationalCompany company) {

        if (this.companyList.contains(company))this.companyList.add(company);
    }

    public void removeCompany(EducationalCompany company) {
        if (getCompanyList().contains(company)) getCompanyList().remove(company);
    }

    public LocalDate getInCompany() {
        return inCompany;
    }

    public void setInCompany(LocalDate inCompany) {
        this.inCompany = inCompany;
    }

    @Override
    public String toString() {
        String message = "Ceo: " + getFirstname() + " " + getLastname() + "\n" +
                        "Birthday: " + getBirthday() +
                        "Ceo since:: " + getInCompany() + "\nCompanys:\n";

        for (EducationalCompany e : companyList) {
            if (e != null) message += "\t" + e.getName() + "\n";
        }
        
        return message;
    }
}

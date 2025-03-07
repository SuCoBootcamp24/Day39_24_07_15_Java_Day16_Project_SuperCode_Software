import java.time.LocalDate;
import java.util.ArrayList;

public class Ceo extends Person{

    private ArrayList<EducationalCompany> companyList = new ArrayList<>();
    private LocalDate inCompany;

    public Ceo(String firstname, String lastname, LocalDate birthday, String address, String email, LocalDate inCompany, EducationalCompany educationalCompany) {
        super(firstname, lastname, birthday, address, email);
        addCompany(educationalCompany);
        setInCompany(inCompany);

    }


    public ArrayList<EducationalCompany> getCompanyList() {
        return companyList;
    }

    public void addCompany(EducationalCompany company) {
        if (company == null) throw new IllegalArgumentException("String of new company is Empty.");
        if (!this.companyList.contains(company))this.companyList.add(company);
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
        StringBuilder message = new StringBuilder("Ceo: " + getFirstname() + " " + getLastname() + "\n" +
                "Birthday: " + getBIRTHDAY() +
                "Ceo since:: " + getInCompany() + "\nCompanys:\n");

        for (EducationalCompany e : companyList) {
            if (e != null) message.append("\t").append(e.getName()).append("\n");
        }

        return message.toString();
    }

    public void printCompanys() {
        System.out.println("The Company(s) of " + getFirstname() + " " + getLastname() + ":");

        for (EducationalCompany e : companyList) {
            if (e != null) System.out.println("\t" + e.getName());
        }

    }
}

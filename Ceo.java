

import java.time.LocalDate;
import java.util.ArrayList;

public class Ceo extends Person{

    private ArrayList<EducationalCompany> campanyList = new ArrayList<>();
    private LocalDate inCompany;

    public Ceo(String lastname, String firstname, LocalDate birthday, String address, String email, LocalDate inCompany, EducationalCompany educationalCompany) {
        super(lastname, firstname, birthday, address, email);
        addCampany(educationalCompany);
        setInCompany(inCompany);

    }


    public ArrayList<EducationalCompany> getCampanyList() {
        return campanyList;
    }

    public void addCampany(EducationalCompany company) {

        if (this.campanyList.contains(company))this.campanyList.add(company);
    }


    public LocalDate getInCompany() {
        return inCompany;
    }

    public void setInCompany(LocalDate inCompany) {
        this.inCompany = inCompany;
    }

}

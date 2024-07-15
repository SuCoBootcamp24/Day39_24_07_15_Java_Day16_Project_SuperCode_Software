import java.time.LocalDate;

public class Administration {
    public static void main(String[] args) {
        
        LocalDate birthday = LocalDate.of(1990, 2, 24);
        LocalDate inCompanyDate = LocalDate.of(2007, 2, 24);
        
        EducationalCompany company1 = new EducationalCompany("SuperTest", inCompanyDate, "Software-Development");

        Ceo ceo1 = new Ceo("Reiner", "Zufall", birthday, "Muster Straße 1", "Reiner@Zufall.de", inCompanyDate, company1);
        ceo1.printCompanys();
    }
}

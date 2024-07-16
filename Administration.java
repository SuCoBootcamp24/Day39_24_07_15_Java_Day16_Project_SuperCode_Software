import java.time.LocalDate;

public class Administration {
    public static void main(String[] args) {
        
        LocalDate birthday = LocalDate.of(1990, 2, 24);
        LocalDate inCompanyDate = LocalDate.of(2007, 2, 24);
        
        EducationalCompany company1 = new EducationalCompany("SuperTest", inCompanyDate, "Software-Development");

        Ceo ceo1 = new Ceo("Reiner", "Zufall", birthday, "Muster Straße 1", "Reiner@Zufall.de", inCompanyDate, company1);
        System.out.println("");
        System.out.println(ceo1);
        System.out.println("");

        Trainer trainer1 = new Trainer("Zufall", "Reiner", birthday, "abcstraße", "bla@asg.de", inCompanyDate);
        trainer1.addLicenseToList("abc");
        System.out.println(trainer1);

        System.out.println("");
        Student student1 = new Student("abs", "srg", birthday, "af", "sadg@awf.de", "dev");
        System.out.println(student1);

        System.out.println("");
        Task task1 = new Task("Install Git", "1.1", 1);
        System.out.println(task1);

        Module module1 = new Module("module1", birthday, inCompanyDate);
        module1.addTaskToList(task1);
        System.out.println("");
        module1.printTasks();


        System.out.println(module1);
        module1.printTrainerForThisModule();
    }
}

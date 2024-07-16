import java.time.Duration;
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

        // Module module1 = new Module("module1", birthday, inCompanyDate, "JAVA");
        // module1.addTaskToList(task1);
        // System.out.println("");
        // module1.printTasks();

        LocalDate start1 = LocalDate.of(2024, 01, 01);
        LocalDate end1 = LocalDate.of(2024, 03, 01);
        LocalDate start2 = LocalDate.of(2024, 04, 02);
        LocalDate end2 = LocalDate.of(2024, 04, 01);

        Module module1 = new Module("module1", start1, end1, "JAVA");
        Module module2 = new Module("module2", start2, end2, "HTML");
        for (int i = 0; i < Duration.between(module1.getStart().atStartOfDay(), module1.getEnd().atStartOfDay()).toDays(); i++) {
            module1.addTaskToList(new Task("null", "null", 1));
        }

        // System.out.println(module1);
        // module1.printTrainerForThisModule();

        Course course1 = new Course("test-course", birthday, inCompanyDate);
        course1.addModule(module1);
        course1.addModule(module2);
        course1.printModules();
        
        
        
        
    




    }
}

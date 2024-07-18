import java.time.Duration;
import java.time.LocalDate;

public class AdministrationErrors {
    public static void main(String[] args) {

        LocalDate birthday = LocalDate.of(1990, 2, 24);
        LocalDate inCompanyDate = LocalDate.of(2007, 2, 24);

        LocalDate start1 = LocalDate.of(2024, 1, 1);
        LocalDate end1 = LocalDate.of(2024, 2, 2);

        LocalDate start2 = LocalDate.of(2024, 3, 3);
        LocalDate end2 = LocalDate.of(2024, 4, 4);

        LocalDate start3 = LocalDate.of(2024, 5, 5);
        LocalDate end3 = LocalDate.of(2024, 6, 6);

        LocalDate start4 = LocalDate.of(2024, 7, 7);
        LocalDate end4 = LocalDate.of(2024, 8, 8);

        Trainer trainer1 = new Trainer("1","1", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer2 = new Trainer("2","1", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer3 = new Trainer("3","1", birthday,"address","abs@abc.de", inCompanyDate);

        // -----Trainer erhalten Lizenzen-----
        trainer1.addLicenseToList("JAVA");
        trainer1.addLicenseToList("GIT");
        trainer2.addLicenseToList("JAVA");
        trainer3.addLicenseToList("HTML");

        //------Student erstellen ----
        Student student1 = new Student("s1","1", birthday,"address","abs@abc.de", "java");
        Student student2 = new Student("s2","1", birthday,"address","abs@abc.de", "html");
        Student student3 = new Student("s3","1", birthday,"address","abs@abc.de", "JAVA");
        Student student4 = new Student("s4","1", birthday,"address","abs@abc.de", "JAVA");
        Student student5 = new Student("s5","1", birthday,"address","abs@abc.de", "html");
        Student student6 = new Student("s6","1", birthday,"address","abs@abc.de", "JAVA");
        Student student7 = new Student("s7","1", birthday,"address","abs@abc.de", "html");
        Student student8 = new Student("s8","1", birthday,"address","abs@abc.de", "JAVA");
        Student student9 = new Student("s9","1", birthday,"address","abs@abc.de", "java");

        EducationalCompany company1 = new EducationalCompany("SuperTest", inCompanyDate, "Software-Development");

        // ------Trainer ins Unternehmen einstellen.------
        company1.addTrainer(trainer1);
        company1.addTrainer(trainer2);
        company1.addTrainer(trainer3);

        // ------Teilnehmer einschreiben------
        company1.addStudent(student1);
        company1.addStudent(student2);
        company1.addStudent(student3);
        company1.addStudent(student4);
        company1.addStudent(student5);
        company1.addStudent(student6);
        company1.addStudent(student7);
        company1.addStudent(student8);
        company1.addStudent(student9);

        Course course1 = new Course("Java1", start1, end3);
        Course course2 = new Course("HTML1", start2, end3);

        // ------Module inkl. Tasks (<) für den Kurse erstellen------
        Module module1 = new Module("JAVA2", start2,end2, "JAVA");
        for (int i = 0; i < 10; i++) {
            module1.addTaskToList(new Task("null", "null", 1));
        }

        // ------Modul ohne Tasks für den Kurs erstellen------
        Module module2 = new Module("FRONTEND4", start4,end4, "FRONTEND");

        // ------Modul ohne Tasks für den Kurs erstellen------
        Module module3 = new Module("UXUI6", start4,end4, "UXUI");

        // ------Module1 zum Kurs1 hinzufuegen------
        course1.addModule(module1);
        course1.addModule(module2);
        course1.addModule(module3);

        // -----Kurs in das Unternehmen speichern-------
        company1.addCourse(course1);
        company1.addCourse(course2);
    }
}

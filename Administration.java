import java.time.Duration;
import java.time.LocalDate;

public class Administration {
    public static void main(String[] args) {


        // ------Date variablen erstellen------
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

        // ------Personen erstellen------
        // ------Trainer erstellen----
        Trainer trainer1 = new Trainer("1","1", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer2 = new Trainer("2","1", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer3 = new Trainer("3","1", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer4 = new Trainer("4","1", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer5 = new Trainer("5","1", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer6 = new Trainer("6","1", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer7 = new Trainer("7","1", birthday,"address","abs@abc.de", inCompanyDate);


        // -----Trainer erhalten Lizenzen-----
        trainer1.addLicenseToList("JAVA");
        trainer1.addLicenseToList("GIT");
        trainer2.addLicenseToList("JAVA");
        trainer3.addLicenseToList("HTML");
        trainer4.addLicenseToList("FRONTEND");
        trainer4.addLicenseToList("UXUI");
        trainer5.addLicenseToList("ASSIST");
        trainer6.addLicenseToList("ASSIST");

        //------Student erstellen ----
        Student student1 = new Student("s1","1", birthday,"address","abs@abc.de", "java");
        Student student2 = new Student("s2","1", birthday,"address","abs@abc.de", "JAVA");
        Student student3 = new Student("s3","1", birthday,"address","abs@abc.de", "JAVA");
        Student student4 = new Student("s4","1", birthday,"address","abs@abc.de", "JAVA");
        Student student5 = new Student("s5","1", birthday,"address","abs@abc.de", "JAVA");
        Student student6 = new Student("s6","1", birthday,"address","abs@abc.de", "JAVA");
        Student student7 = new Student("s7","1", birthday,"address","abs@abc.de", "JAVA");
        Student student8 = new Student("s8","1", birthday,"address","abs@abc.de", "JAVA");
        Student student9 = new Student("s9","1", birthday,"address","abs@abc.de", "java");
        Student student10 = new Student("s10","1", birthday,"address","abs@abc.de", "HTML");
        Student student11 = new Student("s11","1", birthday,"address","abs@abc.de", "HTML");
        Student student12 = new Student("s12","1", birthday,"address","abs@abc.de", "HTML");
        Student student13 = new Student("s13","1", birthday,"address","abs@abc.de", "HTML");
        Student student14 = new Student("s14","1", birthday,"address","abs@abc.de", "HTML");
        Student student15 = new Student("s15","1", birthday,"address","abs@abc.de", "HTML");

        // ------Bildungsunternehmen------
        EducationalCompany company1 = new EducationalCompany("SuperTest", inCompanyDate, "Software-Development");
        Ceo ceo1 = new Ceo("Reiner", "Zufall", birthday, "address", "a@a.de", inCompanyDate, company1);

        System.out.println(ceo1);
        System.out.println(company1.getCeo());

        // ------Trainer ins Unternehmen einstellen.------
        company1.addTrainer(trainer1);
        company1.addTrainer(trainer2);
        company1.addTrainer(trainer3);
        company1.addTrainer(trainer4);
        company1.addTrainer(trainer5);
        company1.addTrainer(trainer6);
        company1.addTrainer(trainer7);

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
        company1.addStudent(student10);
        company1.addStudent(student11);
        company1.addStudent(student12);
        company1.addStudent(student13);
        company1.addStudent(student14);
        company1.addStudent(student15);

        // ------Kurse erstellen------
        Course course1 = new Course("Java1", start1, end3);
        Course course2 = new Course("HTML1", start2, end3);

        // ------Module inkl. Tasks (==) für den Kurse erstelle------
        Module module1 = new Module("GIT1", start1,end1, "GIT");
        for (int i = 0; i < Duration.between(module1.getStart().atStartOfDay(), module1.getEnd().atStartOfDay()).toDays(); i++) {
            module1.addTaskToList(new Task("null", "null", 1));
        }

        // ------Module inkl. Tasks (<) für den Kurse erstellen------
        Module module2 = new Module("JAVA2", start2,end2, "JAVA");
        for (int i = 0; i < Duration.between(module2.getStart().atStartOfDay(), module2.getEnd().atStartOfDay()).toDays() + 2; i++) {
            module2.addTaskToList(new Task("null", "null", 1));
        }

        // ------Module inkl. Tasks (==) für den Kurse erstelle------
        Module module3 = new Module("HTML3", start3,end3, "HTML");
        for (int i = 0; i < Duration.between(module3.getStart().atStartOfDay(), module3.getEnd().atStartOfDay()).toDays(); i++) {
            module3.addTaskToList(new Task("null", "null", 1));
        }

        // ------Modul ohne Tasks für den Kurs erstellen------
        Module module4 = new Module("FRONTEND4", start4,end4, "FRONTEND");

        // ------Module inkl. Tasks (==) für den Kurse erstelle------
        Module module5 = new Module("BACKEND5", start2,end4, "BACKEND");
        for (int i = 0; i < Duration.between(module5.getStart().atStartOfDay(), module5.getEnd().atStartOfDay()).toDays(); i++) {
            module5.addTaskToList(new Task("null", "null", 1));
        }

        // ------Modul ohne Tasks für den Kurs erstellen------
        Module module6 = new Module("UXUI6", start4,end4, "UXUI");


        // ------Module zum Kurs1 hinzufuegen------
        course1.addModule(module1);
        course1.addModule(module2);
        course1.addModule(module3);

        // ------Module zum Kurs2 hinzufuegen------
        course2.addModule(module4);
        course2.addModule(module5);
        course2.addModule(module6);

        // -----Kurs in das Unternehmen speichern-------
        company1.addCourse(course1);
        company1.addCourse(course2);

        // ------Alle Module im Kurs1 anzeigenlassen------
        course1.showAllTrainersInAllModules();
        System.out.println();

        // ------Alle Module im Kurs2 anzeigenlassen------
        course2.showAllTrainersInAllModules();

        // ------Trainer zu dem Kurs hinzufuegen------
        company1.addTrainerToCourse(course1);
        System.out.println();

        // ------Assistent trainer zu dem Kurs hinzufuegen------
        company1.addAssistTrainerToCourse(course1);

        // -----Alle Trainer im Kurs anzeigen-----
        course1.showAllTrainersInAllModules();

        // -----Teilnehmer in die gewuenschen Kurse verteilen----
        company1.addStudentToCourse(course1);
        company1.addStudentToCourse(course2);


        // ----Teilnehmer 1 hat nach dem Kursende heute einen neuen Job gefunden-----
        student1.setJobBegin(LocalDate.now());


        // ------- STATISTIK---------
        // # Jobvermittlungsquote
            // Bester / Schlechtester Kurs bis heute
        company1.bestCourseWithJobPlacementRate();
        System.out.println();
            // Bester / Schlechtester Kurs bis n Tage nach Kursende
        company1.bestCourseWithJobPlacementRateAfterNDays(10);

            // Jobvermittlungsquote eines Kurses
        course1.printJobPlacementRate();
        System.out.println();
        course2.printJobPlacementRate();

        // # Bewertung des Kurses von den Absolventen
        System.out.println();

        // Studenten bewerten den Kurs
        student1.addFeedback(course1, "The course has changed my life", 5);
        student2.addFeedback(course1, "The course has changed my life", 4);
        student3.addFeedback(course1, "The course has changed my life", 2);
        student4.addFeedback(course1, "The course has changed my life", 5);

        student10.addFeedback(course2, "The course has changed my life", 1);
        student11.addFeedback(course2, "The course has changed my life", 1);
        student12.addFeedback(course2, "The course has changed my life", 1);
        student13.addFeedback(course2, "The course has changed my life", 1);

        // Bewertungsergebnisse des Kurses
        company1.bestReviewedCourse();


    }
}
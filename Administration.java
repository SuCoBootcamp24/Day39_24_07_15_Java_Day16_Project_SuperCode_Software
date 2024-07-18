import java.time.Duration;
import java.time.LocalDate;

public class Administration {
    public static void main(String[] args) {


        // ------Date variablen erstellen------
        LocalDate birthday = LocalDate.of(1990, 2, 24);
        LocalDate inCompanyDate = LocalDate.of(2007, 2, 24);

        LocalDate start0101 = LocalDate.of(2024, 1, 1);
        LocalDate end0202 = LocalDate.of(2024, 2, 2);

        LocalDate start0302 = LocalDate.of(2024, 2, 3);
        LocalDate end0404 = LocalDate.of(2024, 4, 4);

        LocalDate start0504 = LocalDate.of(2024, 4, 5);
        LocalDate end0606 = LocalDate.of(2024, 6, 6);

        LocalDate start0706 = LocalDate.of(2024, 6, 7);
        LocalDate end0808 = LocalDate.of(2024, 8, 8);

        // ------Personen erstellen------
        // ------Trainer erstellen----
        Trainer trainer1 = new Trainer("trasiner1","Blabla", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer2 = new Trainer("trasiner2","Blabla", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer3 = new Trainer("trasiner3","Blabla", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer4 = new Trainer("trasiner4","Blabla", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer5 = new Trainer("trasiner5","Blabla", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer6 = new Trainer("trasiner6","Blabla", birthday,"address","abs@abc.de", inCompanyDate);
        Trainer trainer7 = new Trainer("trasiner7","Blabla", birthday,"address","abs@abc.de", inCompanyDate);


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
        Student student1 = new Student("student1","smith", birthday,"address","abs@abc.de", "java");
        Student student2 = new Student("student2","smith", birthday,"address","abs@abc.de", "JAVA");
        Student student3 = new Student("student3","smith", birthday,"address","abs@abc.de", "html");
        Student student4 = new Student("student4","smith", birthday,"address","abs@abc.de", "JAVA");
        Student student5 = new Student("student5","smith", birthday,"address","abs@abc.de", "html");
        Student student6 = new Student("student6","smith", birthday,"address","abs@abc.de", "JAVA");
        Student student7 = new Student("student7","smith", birthday,"address","abs@abc.de", "JAVA");
        Student student8 = new Student("student8","smith", birthday,"address","abs@abc.de", "JAVA");
        Student student9 = new Student("student9","smith", birthday,"address","abs@abc.de", "java");
        Student student10 = new Student("student10","smith", birthday,"address","abs@abc.de", "HTML");
        Student student11 = new Student("student11","smith", birthday,"address","abs@abc.de", "HTML");
        Student student12 = new Student("student12","smith", birthday,"address","abs@abc.de", "java");
        Student student13 = new Student("student13","smith", birthday,"address","abs@abc.de", "HTML");
        Student student14 = new Student("student14","smith", birthday,"address","abs@abc.de", "HTML");
        Student student15 = new Student("student15","smith", birthday,"address","abs@abc.de", "HTML");

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
        Course course1 = new Course("Java1", start0101, end0404);
        Course course2 = new Course("HTML1", start0504, end0808);

        // - Module1, Module2 for course1
        // ------Module inkl. Tasks (>) für den Kurse erstelle------
        Module module1 = new Module("GIT1", start0101,end0202, "GIT");
        for (int i = 0; i < module1.calcAllModuleTimeInDays(); i++) {
            module1.addTaskToList(new Task("null", "null", 1));
        }

        // ------Module inkl. Tasks (>) für den Kurse erstellen------
        Module module2 = new Module("JAVA2", start0302,end0404, "JAVA");
        for (int i = 0; i < module2.calcAllModuleTimeInDays(); i++) {
            module2.addTaskToList(new Task("null", "null", 1));
        }

        // - Module3 and Module4 for course2
        // ------Module inkl. Tasks (>) für den Kurse erstelle------
        Module module3 = new Module("HTML3", start0504,end0606, "HTML");
        for (int i = 0; i < module3.calcAllModuleTimeInDays(); i++) {
            module3.addTaskToList(new Task("null", "null", 1));
        }

        // -----Module inkl. Tasks (>) für den Kurse erstelle------
        Module module4 = new Module("FRONTEND4", start0706,end0808, "FRONTEND");
        for (int i = 0; i < module4.calcAllModuleTimeInDays(); i++) {
            module4.addTaskToList(new Task("null", "null", 1));
        }

        // ------Module zum Kurs1 hinzufuegen------
        course1.addModule(module1);
        course1.addModule(module2);

        // ------Module zum Kurs2 hinzufuegen------
        course2.addModule(module3);
        course2.addModule(module4);

        // -----Kurs in das Unternehmen speichern-------
        company1.addCourse(course1);
        company1.addCourse(course2);

        // ------Kurse aus dem Unternehmen anzeigenlassen------
        company1.printCourse();
        System.out.println();

        // ------Alle Module im Kurs1 anzeigenlassen------
        course1.printModules();
        System.out.println();

        // ------Alle Module im Kurs2 anzeigenlassen------
        course2.printModules();
        System.out.println();

        // ------Trainer zu dem Kurs hinzufuegen------
        company1.addTrainerToCourse(course1);
        System.out.println();

        // ------Assistent trainer zu dem Kurs hinzufuegen------
        company1.addAssistTrainerToCourse(course1);

        // -----Alle Trainer im Kurs anzeigen-----
        course1.showAllTrainersInAllModules();
        System.out.println();

        // -----Teilnehmer in die gewuenschen Kurse verteilen----
        company1.addStudentToCourse(course1);
        company1.addStudentToCourse(course2);


        // ----Teilnehmer 1 hat nach dem Kursende heute einen neuen Job gefunden-----
        student1.setJobBegin(LocalDate.now());
        student2.setJobBegin(LocalDate.now());
        student4.setJobBegin(LocalDate.now());
        student6.setJobBegin(LocalDate.now());

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
        System.out.println();

        // # Bewertung des Kurses von den Absolventen

        // Studenten bewerten den Kurs
        student1.addFeedback(course1, "The course has changed my life", 5);
        student2.addFeedback(course1, "The course has changed my life", 4);
        student4.addFeedback(course1, "The course has changed my life", 2);
        student6.addFeedback(course1, "The course has changed my life", 5);

        student10.addFeedback(course2, "The course has changed my life", 1);
        student11.addFeedback(course2, "The course has changed my life", 1);
        student13.addFeedback(course2, "The course has changed my life", 1);
        student14.addFeedback(course2, "The course has changed my life", 1);

        // Bewertungsergebnisse des Kurses
        company1.bestReviewedCourse();
    }
}
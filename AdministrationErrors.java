
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdministrationErrors {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

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
        ArrayList<Trainer> trainerList = getTrainerArrayList();

        // -----Trainer erhalten Lizenzen-----
        trainerList.get(0).addLicenseToList("JAVA");

        //------Student erstellen ----
        ArrayList<Student> studentList = getStudentArrayList();

        // ------Bildungsunternehmen------
        EducationalCompany company1 = new EducationalCompany("SuperTest", inCompanyDate, "Software-Development");
        Ceo ceo1 = new Ceo("Reiner", "Zufall", birthday, "address", "a@a.de", inCompanyDate, company1);

        System.out.println(ANSI_PURPLE_BACKGROUND + "Ceo: " + ANSI_RESET );
        System.out.println(ceo1);

        // ------Trainer ins Unternehmen einstellen.------
        for (Trainer trainer : trainerList) {
            company1.addTrainer(trainer);
        }

        // ------Teilnehmer einschreiben------
        for (Student student : studentList) {
            company1.addStudent(student);
        }

        // ------Kurse erstellen------
        Course course1 = new Course("Java1", start0101, end0404);
        Course course2 = new Course("HTML1", start0504, end0808);

        // -----Module1, Module2 for course1
        // ------Module1 inkl. Tasks (>) für den Kurse erstelle------
        Module module1 = new Module("GIT1", start0101,end0202, "GIT");
        fillUpModule(module1);

        // ------Module2 inkl. Tasks (>) für den Kurse erstellen------
        Module module2 = new Module("JAVA2", start0101,end0404, "JAVA");
        fillUpModule(module2);

        // - Module3 and Module4 for course2
        // ------Module3 inkl. Tasks (>) für den Kurse erstelle------
        Module module3 = new Module("HTML3", start0302,start0504, "HTML");
        fillUpModule(module3);

        // - Module3 and Module4 for course2
        // ------Module3 inkl. Tasks (>) für den Kurse erstelle------
        Module module4 = new Module("HTML3", start0302,end0404, "HTML");
        fillUpModule(module4);

        // ------Module zum Kurs1 hinzufuegen------
        System.out.println(ANSI_PURPLE_BACKGROUND + "Module im Kurs speicher " + ANSI_RESET );
        course1.addModule(module1);
        course1.addModule(module2);
        course1.addModule(module3);
        course1.addModule(module4);

        // -----Kurs in das Unternehmen speichern-------
        System.out.println(ANSI_PURPLE_BACKGROUND + "Kurse in Unternehmen" + ANSI_RESET );
        company1.addCourse(course1);

        // ------Kurse aus dem Unternehmen anzeigenlassen------
        company1.printCourse();
        System.out.println();

        // ------Alle Module im Kurs1 anzeigenlassen------
        System.out.println(ANSI_PURPLE_BACKGROUND + "alle Module im Kurs" + ANSI_RESET );
        course1.printModules();
        System.out.println();


        // ------Trainer zu den Kursen hinzufuegen------
        System.out.println(ANSI_PURPLE_BACKGROUND + "Trainer Zuordnung" + ANSI_RESET );
        company1.addTrainerToCourse(course1);
        System.out.println();


        // ------Assistent trainer zu dem Kurs hinzufuegen------
        System.out.println(ANSI_PURPLE_BACKGROUND + "Assistenttrainer Zuordnung" + ANSI_RESET );
        company1.addAssistTrainerToCourse(course1);
        System.out.println();


        // -----Alle Trainer im Kurs anzeigen-----
        System.out.println(ANSI_PURPLE_BACKGROUND + "Zugeorndete mitarbeiter in den Modulen" + ANSI_RESET );
        course1.showAllTrainersInAllModules();
        System.out.println();

        // -----Teilnehmer in die gewuenschen Kurse verteilen----
        System.out.println(ANSI_PURPLE_BACKGROUND + "Zuordnung der Teilnehmer in die Kurse" + ANSI_RESET );
        company1.addStudentToCourse(course1);
        System.out.println();


        // ----Teilnehmer 1-4 haben nach dem Kursende heute einen neuen Job gefunden-----
        studentList.get(0).setJobBegin(LocalDate.now());
        studentList.get(1).setJobBegin(LocalDate.now());
        studentList.get(3).setJobBegin(LocalDate.now());
        studentList.get(5).setJobBegin(LocalDate.now());

        // ------- STATISTIK---------
        System.out.println(ANSI_CYAN_BACKGROUND + "STATISTIK" + ANSI_RESET );
        // # Jobvermittlungsquote
        // Bester / Schlechtester Kurs bis heute
        System.out.println(ANSI_CYAN_BACKGROUND + "Best Course With Job Placement Rate" + ANSI_RESET );
        company1.bestCourseWithJobPlacementRate();
        System.out.println();
        // Bester / Schlechtester Kurs bis n Tage nach Kursende
        System.out.println(ANSI_CYAN_BACKGROUND + "Best Course With Job Placement Rate after 30 days" + ANSI_RESET );
        company1.bestCourseWithJobPlacementRateAfterNDays(30);
        System.out.println();

        // Jobvermittlungsquote eines Kurses
        System.out.println(ANSI_CYAN_BACKGROUND + "Jobvermittlungsquote" + ANSI_RESET );
        course1.printJobPlacementRate();
        System.out.println();

        // # Bewertung des Kurses von den Absolventen

        // Studenten bewerten den Kurs
        System.out.println(ANSI_CYAN_BACKGROUND + "Bewertung der Kurse" + ANSI_RESET );
        studentList.get(0).addFeedback(course1, "This course provided great insights and practical knowledge. Highly recommend!", 5);
        studentList.get(1).addFeedback(course1, "Very informative course with good examples. Could use a bit more depth in certain areas.", 4);
        studentList.get(3).addFeedback(course2, "The course content was okay, but I found the delivery a bit lacking. Needs improvement.", 2);
        studentList.get(5).addFeedback(course1, "Excellent course! The instructor was very knowledgeable and engaging.", 5);

        System.out.println();
        // Bewertungsergebnisse des Kurses
        System.out.println(ANSI_CYAN_BACKGROUND + "Feedbackquote" + ANSI_RESET );
        company1.bestReviewedCourse();




    }

    private static ArrayList<Student> getStudentArrayList() {
       return new ArrayList<>(List.of(
                new Student("John", "Smith", LocalDate.of(2000, 1, 1), "123 Main St", "john.smith1@abc.de", "Java"),
                new Student("Jane", "Doe", LocalDate.of(2000, 2, 2), "124 Main St", "jane.doe2@abc.de", "Java"),
                new Student("Alice", "Johnson", LocalDate.of(2000, 3, 3), "125 Main St", "alice.johnson3@abc.de", "HTML"),
                new Student("Bob", "Brown", LocalDate.of(2000, 4, 4), "126 Main St", "bob.brown4@abc.de", "Java"),
                new Student("Charlie", "Davis", LocalDate.of(2000, 5, 5), "127 Main St", "charlie.davis5@abc.de", "HTML"),
                new Student("Diana", "Miller", LocalDate.of(2000, 6, 6), "128 Main St", "diana.miller6@abc.de", "Java"),
                new Student("Eve", "Wilson", LocalDate.of(2000, 7, 7), "129 Main St", "eve.wilson7@abc.de", "Java"),
                new Student("Frank", "Moore", LocalDate.of(2000, 8, 8), "130 Main St", "frank.moore8@abc.de", "Java"),
                new Student("Grace", "Taylor", LocalDate.of(2000, 9, 9), "131 Main St", "grace.taylor9@abc.de", "Java"),
                new Student("Hank", "Anderson", LocalDate.of(2000, 10, 10), "132 Main St", "hank.anderson10@abc.de", "HTML"),
                new Student("Ivy", "Thomas", LocalDate.of(2000, 11, 11), "133 Main St", "ivy.thomas11@abc.de", "HTML"),
                new Student("Jack", "Jackson", LocalDate.of(2000, 12, 12), "134 Main St", "jack.jackson12@abc.de", "Java"),
                new Student("Kelly", "White", LocalDate.of(2001, 1, 13), "135 Main St", "kelly.white13@abc.de", "HTML"),
                new Student("Leo", "Harris", LocalDate.of(2001, 2, 14), "136 Main St", "leo.harris14@abc.de", "HTML"),
                new Student("Mia", "Martin", LocalDate.of(2001, 3, 15), "137 Main St", "mia.martin15@abc.de", "HTML")
        ));
    }

    private static ArrayList<Trainer> getTrainerArrayList() {
        Trainer trainer1 = new Trainer("Mario", "Rossi", LocalDate.of(1980, 5, 12), "Via Roma 1, Milano", "mario.rossi@example.com", LocalDate.of(2010, 1, 15));
        Trainer trainer2 = new Trainer("Luisa", "Bianchi", LocalDate.of(1975, 7, 22), "Via Verdi 10, Roma", "luisa.bianchi@example.com", LocalDate.of(2012, 3, 10));
        Trainer trainer3 = new Trainer("Giovanni", "Neri", LocalDate.of(1982, 3, 5), "Corso Italia 15, Torino", "giovanni.neri@example.com", LocalDate.of(2014, 8, 5));
        Trainer trainer4 = new Trainer("Anna", "Verdi", LocalDate.of(1985, 11, 30), "Viale Trieste 22, Napoli", "anna.verdi@example.com", LocalDate.of(2016, 6, 1));
        Trainer trainer5 = new Trainer("Francesco", "Bruni", LocalDate.of(1990, 1, 17), "Piazza Dante 3, Firenze", "francesco.bruni@example.com", LocalDate.of(2018, 9, 14));
        Trainer trainer6 = new Trainer("Sara", "Rossi", LocalDate.of(1987, 4, 9), "Via Garibaldi 5, Bologna", "sara.rossi@example.com", LocalDate.of(2020, 2, 19));
        Trainer trainer7 = new Trainer("Paolo", "Ferrari", LocalDate.of(1992, 6, 25), "Largo Manzoni 12, Genova", "paolo.ferrari@example.com", LocalDate.of(2021, 4, 21));
        Trainer trainer8 = new Trainer("Martina", "Gallo", LocalDate.of(1995, 9, 18), "Via Leopardi 8, Palermo", "martina.gallo@example.com", LocalDate.of(2023, 5, 30));

        return new ArrayList<>(List.of(trainer1, trainer2, trainer3, trainer4, trainer5,trainer6, trainer7, trainer8));
    }

    private static void fillUpModule(Module module1) {
        for (int i = 0; i < module1.calcAllModuleTimeInDays(); i++) {
            module1.addTaskToList(new Task("name " + i, "null", 1));
        }
    }
}
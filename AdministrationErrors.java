import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdministrationErrors {
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
            Trainer trainer1 = new Trainer("Mario", "Rossi", LocalDate.of(1980, 5, 12), "Via Roma 1, Milano", "mario.rossi@example.com", LocalDate.of(2010, 1, 15));
            Trainer trainer2 = new Trainer("Luisa", "Bianchi", LocalDate.of(1975, 7, 22), "Via Verdi 10, Roma", "luisa.bianchi@example.com", LocalDate.of(2012, 3, 10));
            Trainer trainer3 = new Trainer("Giovanni", "Neri", LocalDate.of(1982, 3, 5), "Corso Italia 15, Torino", "giovanni.neri@example.com", LocalDate.of(2014, 8, 5));
            Trainer trainer4 = new Trainer("Anna", "Verdi", LocalDate.of(1985, 11, 30), "Viale Trieste 22, Napoli", "anna.verdi@example.com", LocalDate.of(2016, 6, 1));
            Trainer trainer5 = new Trainer("Francesco", "Bruni", LocalDate.of(1990, 1, 17), "Piazza Dante 3, Firenze", "francesco.bruni@example.com", LocalDate.of(2018, 9, 14));
            Trainer trainer6 = new Trainer("Sara", "Rossi", LocalDate.of(1987, 4, 9), "Via Garibaldi 5, Bologna", "sara.rossi@example.com", LocalDate.of(2020, 2, 19));
            Trainer trainer7 = new Trainer("Paolo", "Ferrari", LocalDate.of(1992, 6, 25), "Largo Manzoni 12, Genova", "paolo.ferrari@example.com", LocalDate.of(2021, 4, 21));
            Trainer trainer8 = new Trainer("Martina", "Gallo", LocalDate.of(1995, 9, 18), "Via Leopardi 8, Palermo", "martina.gallo@example.com", LocalDate.of(2023, 5, 30));

            ArrayList<Trainer> trainerList = new ArrayList<>(List.of(trainer1, trainer2, trainer3, trainer4, trainer5,trainer6, trainer7, trainer8));

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
            ArrayList<Student> studentList = new ArrayList<>(List.of(
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
                    new Student("Mia", "Martin", LocalDate.of(2001, 3, 15), "137 Main St", "mia.martin15@abc.de", "HTML"),
                    new Student("Nina", "Clark", LocalDate.of(1990, 1, 16), "138 Main St", "nina.clark16@abc.de", "java"),
                    new Student("Oscar", "Lewis", LocalDate.of(1991, 2, 17), "139 Main St", "oscar.lewis17@abc.de", "java")
            ));

            // ------Bildungsunternehmen------
            EducationalCompany company1 = new EducationalCompany("SuperTest", inCompanyDate, "Software-Development");
            Ceo ceo1 = new Ceo("Reiner", "Zufall", birthday, "address", "a@a.de", inCompanyDate, company1);

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
            company1.addTrainerToCourse(course2);
            System.out.println();

            // ------Assistent trainer zu dem Kurs hinzufuegen------
            company1.addAssistTrainerToCourse(course1);
            company1.addAssistTrainerToCourse(course2);
            System.out.println();


            // -----Alle Trainer im Kurs anzeigen-----
            course1.showAllTrainersInAllModules();
            System.out.println();

            // -----Teilnehmer in die gewuenschen Kurse verteilen----
            company1.addStudentToCourse(course1);
            System.out.println();
            company1.addStudentToCourse(course2);
            System.out.println();


            // ----Teilnehmer 1 hat nach dem Kursende heute einen neuen Job gefunden-----
            studentList.get(0).setJobBegin(LocalDate.now());
            studentList.get(1).setJobBegin(LocalDate.now());
            studentList.get(3).setJobBegin(LocalDate.now());
            studentList.get(5).setJobBegin(LocalDate.now());

            // ------- STATISTIK---------
            // # Jobvermittlungsquote
            // Bester / Schlechtester Kurs bis heute
            System.out.println("Best Course With Job Placement Rate");
            company1.bestCourseWithJobPlacementRate();
            System.out.println();
            // Bester / Schlechtester Kurs bis n Tage nach Kursende
            System.out.println("Best Course With Job Placement Rate after 30 days");
            company1.bestCourseWithJobPlacementRateAfterNDays(30);
            System.out.println();

            // Jobvermittlungsquote eines Kurses

            course1.printJobPlacementRate();
            System.out.println();
            course2.printJobPlacementRate();
            System.out.println();

            // # Bewertung des Kurses von den Absolventen

            // Studenten bewerten den Kurs
            studentList.get(0).addFeedback(course1, "The course has changed my life", 5);
            studentList.get(1).addFeedback(course1, "The course has changed my life", 4);
            studentList.get(3).addFeedback(course1, "The course has changed my life", 2);
            studentList.get(5).addFeedback(course1, "The course has changed my life", 5);

            System.out.println();
            // Bewertungsergebnisse des Kurses
            company1.bestReviewedCourse();
        }
    }
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class EducationalCompany {

    private final LocalDate FOUNDING_DATE;

    private Ceo ceo;
    private String name;
    private String category;
    private ArrayList<Trainer> trainerList = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();


  


    public EducationalCompany(String name, LocalDate foundingDate, String category) {

  
        setName(name);
        this.FOUNDING_DATE = foundingDate;
        setCategory(category);
    }
    
    //-----Getter / Setter-----

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //---
    public Ceo getCeo() {
        return ceo;
    }

    public void setCeo(Ceo ceo) {
        this.ceo = ceo;
    }


    //---
    public LocalDate getFOUNDING_DATE() {
        return FOUNDING_DATE;
    }


    //---
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    //---
    public ArrayList<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(ArrayList<Trainer> trainerList) {
        this.trainerList = trainerList;
    }


   //---
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

   //---
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    //------other

    public void addTrainer(Trainer trainer) {
        if (!getTrainerList().contains(trainer)) getTrainerList().add(trainer);
    }

    public void removeTrainer(Trainer trainer) {
        if (getTrainerList().contains(trainer)) getTrainerList().remove(trainer);
    }

    public void addStudent(Student student) {
        if (!getStudentList().contains(student)) getStudentList().add(student);
    }

    public void removeStudent(Student student) {
        if (getStudentList().contains(student)) getStudentList().add(student);
    }

    public void addCourse(Course course) {
        if (!course.modulesCoverEntirePeriod()) {
            System.out.printf("Course: %s is not complete, due to a lack of modules. It can't be added to the course list.%n", course.getName());
            return;
        }
        if (!getCourseList().contains(course)) getCourseList().add(course);
    }

    public void removeCourse(Course course) {
        if (getCourseList().contains(course)) getCourseList().add(course);
    }

    public void printTrainer() {
        System.out.println("List of Trainers for " + getName() + ":");
        if(trainerList == null) System.out.println(" Trainers not added");
        else {
            for (Trainer t : trainerList) {
                System.out.println("\t" + t);
            }
        }
    }

    public void printCourse() {
        System.out.println("List of Courses for " + getName() + ":");
        if(courseList == null) System.out.println(" Courses not added");
        else {
            for (Course c : courseList) {
                System.out.println("\t" + c + " rate: " + c.jobPlacementRate());
            }
        }
    }

    public void addTrainerToCourse(Course course) {
        if(courseIsNotInCourseList(course)) {
            System.out.printf("Course: %s is not in the course list. It's not possible to add a Trainer yet.%n", course.getName());
            return;
        }
        sortTrainersList();
        for (Module courseModule : course.getModules()) {

            if (courseModule.getTrainer() == null) {
                boolean trainerAssigned = false;
                for (Trainer t : trainerList) {

                    if (t.hasLicense(courseModule.getRequiredLicense()) && t.TrainerIsFree(courseModule)) {

                        courseModule.setTrainer(t);
                        System.out.println("Trainer " + t.getFirstname() + " " + t.getLastname() + " assigned to module " + courseModule.getName() + " in Course " + course.getName());
                        trainerAssigned = true;
                        break; // exit the loop once a trainer is assigned
                    }
                }
                if (!trainerAssigned) {
                    System.out.println("No available trainers for module " + courseModule.getName() + " in Course" + course.getName());
                }
            }
        }
    }

    private boolean courseIsNotInCourseList(Course course) {
        for (Course c : courseList) {
            if (c.equals(course)) return false;
        }
        return true;
    }

    public void addAssistTrainerToCourse(Course course) {
        if(courseIsNotInCourseList(course)) {
            System.out.printf("Course: %s is not in the course list. It's not possible to add an Assistant yet.%n", course.getName());
            return;
        }
        sortTrainersList();
        for (Module courseModule : course.getModules()) {


            if (courseModule.getAssistant() == null) {
                boolean assistTrainerAssigned = false;
                for (Trainer t : trainerList) {

                    if (t.hasLicense("ASSIST") && t.TrainerIsFree(courseModule)) {

                        courseModule.setAssistant(t);
                        System.out.println("Assistant " + t.getFirstname() + " " + t.getLastname() + " assigned to module " + courseModule.getName() + " in Course " + course.getName());
                        assistTrainerAssigned = true;
                        break; // exit the loop once a trainer is assigned

                        }
                    }

                }
                if (!assistTrainerAssigned) {
                    System.out.println("No available Assistant for module " + courseModule.getName() + " in Course" + course.getName());
                }
            }
        }
    }


    public void addStudentToCourse(Course course) {
        int remainingSeats = 0;
        for (Student student : studentList) {
            boolean isAlreadyEnrolled = student.getHisCourse() != null;
            if (!isAlreadyEnrolled) {

                if (student.desireTheCourse(course)) {
                    if (!course.isAlreadyFull()) {
                        course.addStudent(student);
                        System.out.println("Student " + student.getFirstname() + " " + student.getLastname() + " added" + " to Course " + course.getName());
                    } else {
                        System.out.println("Student " + student.getFirstname() + " " + student.getLastname() + "not added" + " to Course " + course.getName() + " - course is already overbooked");
                        remainingSeats++;
                    }
                }
            }

        }
        System.out.println("Remaining Student to locate in Courses are: " + remainingSeats);

    }

    private void sortTrainersList() {
        trainerList.sort(new Comparator<Trainer>() {
            public int compare(Trainer t1, Trainer t2) {
                return Integer.compare(t1.getModulList().size(), t2.getModulList().size());
            }
        });
    }

    public void bestCourseWithJobPlacementRate() {
        courseList.sort((new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return Double.compare(c1.jobPlacementRate(), c2.jobPlacementRate());
            }
        }));
        bestCourseLogicHelper();
    }

    public void bestCourseWithJobPlacementRateAfterNDays(int days) {
        courseList.sort((new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return Double.compare(c1.jobPlacementRate(days), c2.jobPlacementRate(days));
            }
        }));

        bestCourseLogicHelper();
    }

    private void bestCourseLogicHelper() {
        if (courseList.isEmpty()){
             System.out.println("There are currently no courses");
             return;
        }
        if (courseList.getLast().jobPlacementRate() == -1) System.out.println("There is currently no completed course");
        else System.out.println("Best Course: " + courseList.getLast() + " with " + courseList.getLast().jobPlacementRate() + "%" );


        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).jobPlacementRate() != -1) {
                if (i == courseList.size() -1 ) break;
                else {
                    System.out.println("Worse Course: " + courseList.get(i) + " with " + courseList.get(i).jobPlacementRate() + "%");
                    break;
                }
            }
        }
    }

    public void bestReviewedCourse() {
        if (courseList.isEmpty()) {
            System.out.println("There are currently no courses");
            return;
        }
        Course bestCourse = getBestCourseByFeedback();
        System.out.println("Best reviewd course is Course: " + bestCourse.getName() + " with a review rate of: " + bestCourse.getReviewAverage());

        Course worseCourse = getWorseCourseByFeedback();
        System.out.println("Worse reviewd course is Course: " + worseCourse.getName() + " with a review rate of: " + worseCourse.getReviewAverage());
    }

    private Course getBestCourseByFeedback() {
        double bestRevie = 0;
        Course bestCourse = courseList.getFirst();
        for (Course course : courseList) {
            if (course.getFeedbackBox().isEmpty()) continue;
            double review = course.getReviewAverage();
            if (review > bestRevie) {
                bestRevie = review;
                bestCourse = course;
            }
        }
        return bestCourse;
    }

    private Course getWorseCourseByFeedback() {
        double worseRevie = 6;
        Course worseCourse = courseList.getFirst();
        for (Course course : courseList) {
            if (course.getFeedbackBox().isEmpty()) continue;
            double review = course.getReviewAverage();
            if (review < worseRevie) {
                worseRevie = review;
                worseCourse = course;
            }
        }
        return worseCourse;
    }

    @Override
    public String toString(){
        return getName() + ", Category: " + getCategory() + ", Founding Date: " + getFOUNDING_DATE();
    }

}

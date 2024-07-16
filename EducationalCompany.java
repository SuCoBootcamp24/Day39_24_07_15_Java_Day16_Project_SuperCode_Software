import java.time.LocalDate;
import java.util.ArrayList;

public class EducationalCompany {

    private Ceo ceo;
    private String name;
    private LocalDate foundingDate;
    private String category;
    private ArrayList<Trainer> trainerList = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();



    public EducationalCompany(String name, LocalDate foundingDate, String category) {
        setName(name);
        this.foundingDate = foundingDate;
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
    public LocalDate getFoundingDate() {
        return foundingDate;
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
                System.out.println("\t" + c);
            }
        }
    }

    @Override
    public String toString(){
        return getName() + ", Category: " + getCategory() + ", Founding Date: " + getFoundingDate();
    }

    public void addTrainerToCourse(Course course) {

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

    public void addAssistTrainerToCourse(Course course) {

            for (Module courseModule : course.getModules()) {

                if (courseModule.getAssistent() == null) {
                    boolean assistTrainerAssigned = false;
                    for (Trainer t : trainerList) {

                        if (t.hasLicense("ASSIST") && t.TrainerIsFree(courseModule)) {

                            courseModule.setAssistent(t);
                            System.out.println("Assistant " + t.getFirstname() + " " + t.getLastname() + " assigned to module " + courseModule.getName() + " in Course " + course.getName());
                            assistTrainerAssigned = true;
                            break; // exit the loop once a trainer is assigned
                        }
                    }
                    if (!assistTrainerAssigned) {
                        System.out.println("No available Assistant for module " + courseModule.getName() + " in Course" + course.getName());
                    }
                }
            }
        }


    public int CaddStudentToCourse(Course course) {
        return 0;
    }

}

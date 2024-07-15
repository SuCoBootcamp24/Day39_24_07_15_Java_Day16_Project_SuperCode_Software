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
=======
    public EducationalCompany(Ceo ceo, LocalDate foundingDate, String category) {
        setCeo(ceo);
>>>>>>> 2207aa3 (update EducationalCompany)
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

    }

    public void removeTrainer(Trainer trainer) {

    }

    public void addStudent(Student student) {

    }

    public void removeStudent(Student student) {

    }

    public void addCourse(Course course) {

    }

    public void printTrainer() {

    }

    public void printCourse() {

    }

    @Override
    public String toString(){
        return null;
    }

    public void addTrainerToCourse(Course course) {

    }


    public int CaddStudentToCourse(Course course) {
        return 0;
    }

    public void removeCourse(Course course){

    }



}

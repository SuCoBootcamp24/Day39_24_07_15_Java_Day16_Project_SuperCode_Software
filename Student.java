import java.time.LocalDate;

public class Student extends Person {
    private Course hisCourse;
    private String desiredCourse;

    public Student(String lastname, String firstname, LocalDate birthday, String address, String email, String desiredCourse) {
        super(lastname, firstname, birthday, address, email);
        this.desiredCourse = desiredCourse;
        this.hisCourse = new Course();
    }
    
    public void setCourse(Course course) {
        this.hisCourse = course;
    }
}

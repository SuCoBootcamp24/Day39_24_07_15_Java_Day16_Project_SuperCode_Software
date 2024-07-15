import java.time.LocalDate;

public class Student extends Person {
    private Course hisCourse;
    private String desiredCourse;
    private LocalDate jobBegin;

    public Course getHisCourse() {
        return hisCourse;
    }

    public String getDesiredCourse() {
        return desiredCourse;
    }

    public LocalDate getJobBegin() {
        return jobBegin;
    }

    public Student(String lastname, String firstname, LocalDate birthday, String address, String email, String desiredCourse) {
        super(lastname, firstname, birthday, address, email);
        this.desiredCourse = desiredCourse;
    }
    
    public void setCourse(Course course) {
        this.hisCourse = course;
    }

    public void setJobBegin (LocalDate jobBegin) {
        this.jobBegin = jobBegin;
    }

}

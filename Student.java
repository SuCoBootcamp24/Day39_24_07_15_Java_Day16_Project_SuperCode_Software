import java.time.Duration;
import java.time.LocalDate;

public class Student extends Person {
    private Course hisCourse;
    private String desiredCourse;
    private LocalDate jobBegin;

    // - constructor

    public Student(String firstname, String lastname, LocalDate birthday, String address, String email, String desiredCourse) {
        super(firstname, lastname, birthday, address, email);
        this.desiredCourse = desiredCourse;
    }

    // - getter

    public Course getHisCourse() {
        return hisCourse;
    }

    public String getDesiredCourse() {
        return desiredCourse;
    }

    public LocalDate getJobBegin() {
        return jobBegin;
    }

    // - setter

    public void setCourse(Course course) {
        this.hisCourse = course;
    }

    public void setJobBegin (LocalDate jobBegin) {
        this.jobBegin = jobBegin;
    }

    // - methods

    public int calcDiffDaysToJobBeginn() {
        if (this.jobBegin == null) {
            System.out.println("Student did not start to work yet");
            return -1;
        }
        Duration duration = Duration.between(hisCourse.getEndingDate().atStartOfDay(), jobBegin.atStartOfDay());
        return (int) duration.toDays();
    }

    public void addJobBegin(LocalDate jobBeginDate) {
        this.jobBegin = jobBeginDate;
    }

    @Override
    public String toString() {
        String message = super.toString();
        if (this.hisCourse == null) {
            message += "\nNot enrolled in any course yet";
        } else {
            message += "\nIn Course: " + getHisCourse();
        }
        return message;
    }
}

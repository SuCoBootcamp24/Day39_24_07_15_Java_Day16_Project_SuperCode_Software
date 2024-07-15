import java.time.Duration;
import java.time.LocalDate;

public class Student extends Person {
    private Course hisCourse;
    private String desiredCourse;
    private LocalDate jobBegin;

    // - constructor

    public Student(String lastname, String firstname, LocalDate birthday, String address, String email, String desiredCourse) {
        super(lastname, firstname, birthday, address, email);
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
        Duration duration = Duration.between(LocalDate.now(), jobBegin);
        return (int) duration.toDays();
    }

    public void addJobBegin(LocalDate jobBeginDate) {
        this.jobBegin = jobBeginDate;
    }

    @Override
    public String toString() {
        if (this.hisCourse == null)
            return super.getLastname() + " " +
                    super.getFirstname() + ", DOB: " +
                    super.getBirthday() + ", " +
                    super.getAddress() + ", Not enrolled in any course yet";
        return super.getLastname() + " " +
                super.getFirstname() + ", DOB: " +
                super.getBirthday() + ", " +
                super.getAddress() +  ", " +
                this.hisCourse;
    }
}

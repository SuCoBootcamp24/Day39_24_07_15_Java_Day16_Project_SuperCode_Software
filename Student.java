import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

public class Student extends Person {
    private Course hisCourse;
    private LocalDate jobBegin;
    private String desiredCourse;

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

    public void setHisCourse(Course course) {
        this.hisCourse = course;
    }

    public void setDesiredCourse(String desiredCourse) {
        this.desiredCourse = desiredCourse;
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

    public boolean desireTheCourse(Course course) {
        return course.getName().toUpperCase().contains(this.getDesiredCourse().toUpperCase());
    }

    public void addFeedback(Course course, String s, double review) {
        if (this.hisCourse == course) course.addFeedbackForCourse(this, s, review);
        else System.out.printf("Student %s %s was not in course %s. It's not possible to add a feedback.%n", getFirstname(), getLastname(), course.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getFirstname(), student.getFirstname()) &&
                Objects.equals(getLastname(), student.getLastname()) &&
                Objects.equals(getBIRTHDAY(), student.getBIRTHDAY()) &&
                Objects.equals(getAddress(), student.getAddress()) &&
                Objects.equals(getEmail(), student.getEmail());
    }
}

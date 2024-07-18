public class Feedback {

    private Student student;
    private String message;
    private double note;




    public Feedback(Student student, String message, double note) {
        setStudent(student);
        setMessage(message);
        setNote(note);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "{" + student +
                ", " + message +
                ", " + note +
                '}';
    }
}

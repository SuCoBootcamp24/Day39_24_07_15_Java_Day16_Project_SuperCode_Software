public class Feedback {

    private Student student;
    private String message;
    private Double note;




    public Feedback(Student student, String text, double note) {
        setStudent(student);
        setMessage(text);
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

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
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

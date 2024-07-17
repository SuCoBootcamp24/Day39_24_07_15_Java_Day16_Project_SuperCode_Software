public class Feedback {

    private Student key;
    private String value1;
    private Double value2;




    public Feedback(Student student, String text, double note) {
        setKey(student);
        setValue1(text);
        setValue2(note);
    }

    public Student getKey() {
        return key;
    }

    public void setKey(Student key) {
        this.key = key;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "{" + key +
                ", " + value1 +
                ", " + value2 +
                '}';
    }
}

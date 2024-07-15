import java.time.LocalDate;

public class Verwaltung {
    public static void main(String[] args) {
        Student vittorio = new Student("Vittorio", "De Marzi", LocalDate.now(), "Rochwstraße", "vittoriodm7@",
                "Java Back-End");
        
        System.out.println(vittorio.toString());
    }
}
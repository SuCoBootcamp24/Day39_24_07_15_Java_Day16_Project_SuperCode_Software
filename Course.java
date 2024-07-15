
import java.lang.classfile.instruction.ThrowInstruction;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;


public class Course {
    private static long lastID = 0;
    private long ID;
    private String name;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private final int MAX_STUDENT = 8;

    public Course(String name, LocalDate startingDate, LocalDate endingDate) {
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.ID = lastID + 1;
        Course.lastID++;
        this.modules = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    
    public long getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }
    
    public LocalDate getStartingDate() {
        return startingDate;
    }
    
    public LocalDate getEndingDate() {
        return endingDate;
    }
    
    public ArrayList<Module> getModules() {
        return modules;
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }
    
    public int getMAX_STUDENT() {
        return MAX_STUDENT;
    }

    public void addModule(Module module) {
        // to implementieren
        // -verifyModuleTasks()
        // -verifyModuleTime()

    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public long calcCourseTimeInDays() {
        Duration duration = Duration.between(startingDate, endingDate);
        return duration.toDays();
    }

    public void printModules(){
        for (Module module : modules) {
            System.out.println(module.toString());
        }
    }
}

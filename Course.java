
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;


public class Course {
    private static long lastID = 1;
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
        this.ID = lastID;
        lastID++;
        this.modules = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    
    // - getter setter

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
        boolean weHaveEnoughTasks = module.verifyModuleTasks();
        // boolean weHaveEnoughTasks = true;
        boolean fitsWithModulesTime = verifyModuleTime(module);
        if (weHaveEnoughTasks && fitsWithModulesTime)
            modules.add(module);
        else if (!weHaveEnoughTasks && fitsWithModulesTime)
            System.out.println("Module not added - Not enough tasks");
        else System.out.println("Module not added - Time is overlapping");
    }

    private boolean verifyModuleTime(Module module) {
        for (Module m : modules) {
            boolean isOverlapping = module.getEnd().isAfter(m.getStart()) && module.getStart().isBefore(m.getEnd());
            if (isOverlapping)
                return false;
        }
        return true;
    }

    public void removeModule(Module module) {
        if (modules.contains(module))
            modules.remove(module);
        else System.out.println("Student not enrolled in this course.");
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        if (students.contains(student))
            students.remove(student);
        else System.out.println("Student not enrolled in this course.");
    }

    public long calcCourseTimeInDays() {
        Duration duration = Duration.between(startingDate.atStartOfDay(), endingDate.atStartOfDay());
        return duration.toDays();
    }

    public void printModules() {
        System.out.println("Modules for course " + toString());
        if (modules.isEmpty())
            System.out.println("\tModules are not given yet");
        
        else {
            for (Module module : modules) {
                System.out.println("\t" + module.toString());
            }
        }
    }

    @Override
    public String toString() {
        return ID + ", " + name + ", Course-time: " + startingDate + " - " + endingDate;
    }

    
}

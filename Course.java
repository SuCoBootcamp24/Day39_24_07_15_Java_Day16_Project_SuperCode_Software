
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;


public class Course {
    private static long lastID = 1;

    private final int MAX_STUDENT = 8;
    private final long ID;

    private String name;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private ArrayList<Feedback> feedbackBox;


    public Course(String name, LocalDate startingDate, LocalDate endingDate) {
        setName(name);
        setStartingDate(startingDate);
        setEndingDate(endingDate);
        modules = new ArrayList<>();
        students = new ArrayList<>();
        feedbackBox = new ArrayList<>();
        ID = lastID++;
    }
    
    // ----getter / setter methods------

    public long getID() {
        return ID;
    }

    //---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //----
    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    //----
    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    //----
    public ArrayList<Module> getModules() {
        return modules;
    }

    //----
    public ArrayList<Student> getStudents() {
        return students;
    }

    //----
    public ArrayList<Feedback> getFeedbackBox() {
        return feedbackBox;
    }

    //----
    public int getMAX_STUDENT() {
        return MAX_STUDENT;
    }

    // ----- Other methods-----

    public void addModule(Module module) {
        boolean weHaveEnoughTasks = module.verifyModuleTasks();
        boolean isInCourseTime = (module.getStart().isEqual(getStartingDate())  || (module.getStart().isAfter(getStartingDate()) && module.getEnd().isEqual(getEndingDate()))
        || module.getEnd().isBefore(getEndingDate()));
        boolean fitsWithModulesTime = verifyModuleTime(module);

        if (isInCourseTime) {
            if (weHaveEnoughTasks && fitsWithModulesTime)
              getModules().add(module);
            else if (!weHaveEnoughTasks && fitsWithModulesTime)
                System.out.println("Module " + module.getID() + " not added to course " + getName() + " - Not enough tasks");
            else System.out.println("Module " + module.getID() + " not added to course " + getName() + " - Time is overlapping");
        } else System.out.println("Module " + module.getID() + " is out of Corse - Module not added to course " + getName() + "!");
        }

    private boolean verifyModuleTime(Module module) {
        boolean isOverlapping = false;

            for (Module m : getModules()) {
                isOverlapping = module.getEnd().isAfter(m.getStart()) && module.getStart().isBefore(m.getEnd());
                if (isOverlapping)
                    return false;

                }
                return true;
    }

    public void removeModule(Module module) {
        if (getModules().contains(module))
            getModules().remove(module);
        else System.out.println("Student not enrolled in this course.");
    }

    public void addStudent(Student student) {
        if (getStudents().contains(student))
            throw new IllegalStateException("Student already enrolled in the course");
        getStudents().add(student);
        student.setHisCourse(this);
    }

    public void removeStudent(Student student) {
        if (getStudents().contains(student))
            getStudents().remove(student);
        else System.out.println("Student not enrolled in this course.");
    }

    public long calcCourseTimeInDays() {
        Duration duration = Duration.between(getStartingDate().atStartOfDay(), getEndingDate().atStartOfDay());
        return duration.toDays();
    }

    public void printModules() {
        System.out.println("Modules for course " + toString());
        if (getModules().isEmpty())
            System.out.println("\tModules are not given yet");
        
        else {
            for (Module module : getModules()) {
                System.out.println("\t" + module.toString());
            }
        }
    }

    public void addFeedbackForCourse(Student student, String message, double note) {
        if (getEndingDate().isAfter(LocalDate.now()) || getEndingDate().isEqual(LocalDate.now())) System.out.println("Course " + getName() + " is not finished yet, you cannot give a feedback before the end!");
        else if (note<1 || note>5) System.out.println("Note must be between 1 and 5");
        else {
            for (Feedback f : getFeedbackBox()) {
                if (f.getStudent().equals(student)) {
                    System.out.println("Student " + student.getFirstname() + " " + student.getLastname() + " already has a feedback for this course!");
                    return;
                }
            }
            getFeedbackBox().add(new Feedback(student, message, note));
        }
    }

    public void showAllTrainersInAllModules() {
        for (Module module : getModules()) {
            module.printTrainerForThisModule();
        }
    }

    public boolean isAlreadyFull() {
        return getStudents().size() == getMAX_STUDENT();
    }

    public double jobPlacementRate(){
        if (!getEndingDate().isBefore(LocalDate.now())) return -1;
        int count = 0;
        for(Student s : getStudents()) {
            if (s.getJobBegin() != null) {
                count++;
            }
        }
        return ((double) count / getStudents().size()) * 100;
    }

    public double jobPlacementRate(int days){
        LocalDate toDayToCheck = getEndingDate().plusDays(days);
        if (!getEndingDate().isBefore(LocalDate.now())) return -1;

        int count = 0;
        for(Student s : getStudents()) {

            if (s.getJobBegin() != null && (s.getJobBegin().isEqual(toDayToCheck) || s.getJobBegin().isBefore(toDayToCheck))) {
                count++;
            }
        }
        return ((double) count / getStudents().size()) * 100;
    }

    public void printJobPlacementRate() {
        double rate = jobPlacementRate();
        if (rate == -1) System.out.println("Course " + getName() + " is not over yet");
        else System.out.println("Job placement rate Course " + getName() + " is: " + jobPlacementRate() + "%");
    }

    public double getReviewAverage() {
        if (getFeedbackBox().isEmpty()) return -1;
        double sum = 0;
        for (Feedback feedback : getFeedbackBox()) {
            sum += feedback.getNote();
        }
        return sum / getFeedbackBox().size();
    }


    @Override
    public String toString() {
        return getID() + ", " + getName() + ", Course-time: " + getStartingDate() + " - " + getEndingDate();
    }
}

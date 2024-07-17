
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
    private ArrayList<Feedback> feedbackBox;

    private final int MAX_STUDENT = 8;

    public Course(String name, LocalDate startingDate, LocalDate endingDate) {
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.ID = lastID;
        lastID++;
        this.modules = new ArrayList<>();
        this.students = new ArrayList<>();
        this.feedbackBox = new ArrayList<>();

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

    public ArrayList<Feedback> getFeedbackBox() {
        return feedbackBox;
    }

    public void setFeedbackBox(ArrayList<Feedback> feedbackBox) {
        this.feedbackBox = feedbackBox;
    }

    public void addFeedbackForCourse(Student student, String text, double note) {
        if (endingDate.isAfter(LocalDate.now()) || endingDate.isEqual(LocalDate.now())) System.out.println("Course " + this.name + " is not finished yet, you cannot give a feedback before the end!");
        else if (note<1 || note>5) System.out.println("Note must be between 1 and 5");
        else {
            for (Feedback f : feedbackBox) {
                if (f.getStudent().equals(student)) {
                    System.out.println("Student " + student.getFirstname() + " " + student.getLastname() + " already has a feedback for this course!");
                    return;
                }
            }
            feedbackBox.add(new Feedback(student, text, note));
        }
    }

    public int getMAX_STUDENT() {
        return MAX_STUDENT;
    }

    public void addModule(Module module) {
        boolean weHaveEnoughTasks = module.verifyModuleTasks();
        boolean isInCourseTime = (module.getStart().isEqual(getStartingDate())  || (module.getStart().isAfter(getStartingDate()) && module.getEnd().isEqual(getEndingDate()))
        || module.getEnd().isBefore(getEndingDate()));
        boolean fitsWithModulesTime = verifyModuleTime(module);

        if (isInCourseTime) {
            if (weHaveEnoughTasks && fitsWithModulesTime)
              modules.add(module);
            else if (!weHaveEnoughTasks && fitsWithModulesTime)
                System.out.println("Module " + module.getId() + " not added to course " + this.name + " - Not enough tasks");
            else System.out.println("Module " + module.getId() + " not added to course " + this.name + " - Time is overlapping");
        } else System.out.println("Module " + module.getId() + " is out of Corse - Module not added to course " + this.name + "!");
        }

    private boolean verifyModuleTime(Module module) {
        boolean isOverlapping = false;

            for (Module m : modules) {
                isOverlapping = module.getEnd().isAfter(m.getStart()) && module.getStart().isBefore(m.getEnd());
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
        if (students.contains(student))
            throw new IllegalStateException("Student already enrolled in the course");
        students.add(student);
        student.setHisCourse(this);
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

    public void showAllTrainersInAllModules() {
        for (Module module : modules) {
            module.printTrainerForThisModule();
        }
    }

    public boolean isAlreadyFull() {
        return students.size() == MAX_STUDENT;
    }

    public double jobPlacementRate(){
        if (!getEndingDate().isBefore(LocalDate.now())) return -1;
        int count = 0;
        for(Student s : students) {
            if (s.getJobBegin() != null) {
                count++;
            }
        }
        return ((double) count / students.size()) * 100;
    }

    public double jobPlacementRate(int days){
        LocalDate toDayToCheck = getEndingDate().plusDays(days);
        if (!getEndingDate().isBefore(LocalDate.now())) return -1;

        int count = 0;
        for(Student s : students) {

            if (s.getJobBegin() != null && (s.getJobBegin().isEqual(toDayToCheck) || s.getJobBegin().isBefore(toDayToCheck))) {
                count++;
            }
        }
        return ((double) count / students.size()) * 100;
    }

    public void printJobPlacementRate() {
        double rate = jobPlacementRate();
        if (rate == -1) System.out.println("Course " + getName() + " is not over yet");
        else System.out.println("Job placement rate Course " + getName() + " is: " + jobPlacementRate() + "%");
    }

    public double getReviewAverage() {
        if (feedbackBox.isEmpty()) return -1;
        double sum = 0;
        for (Feedback feedback : feedbackBox) {
            sum += feedback.getNote();
        }
        return sum / feedbackBox.size();
    }
}

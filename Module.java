import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Module {
    
    private static long lastId = 1;

    private long id;
    private String name;
    private HashMap<Task, Integer> taskList = new HashMap<>();
    private LocalDate start;
    private LocalDate end;
    private String requiredLicense;
    private Trainer trainer;
    private Trainer assistent;


    public Module(String name, LocalDate start, LocalDate end, String requiredLicense) {
        setName(name);
        setStart(start);
        setEnd(end);
        setRequiredLicense(requiredLicense);
        this.id = lastId++;
    }

     //----getter() / setter()---
    public long getId() {
        return id;
    }


    //----
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 

    //----
    public HashMap<Task, Integer> getTaskList() {
        return taskList;
    }

    public void setTaskList(HashMap<Task, Integer> taskList) {
        this.taskList = taskList;
    }

    //----

    public String getRequiredLicense() {
        return requiredLicense;
    }

    public void setRequiredLicense(String requiredLicense) {
        this.requiredLicense = requiredLicense;
    }

    //----
    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    
    //----
    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }


    //----
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

   //----
    public Trainer getAssistent() {
        return assistent;
    }

    public void setAssistent(Trainer assistent) {
        this.assistent = assistent;
    }

    //----other---

    public void addTaskToList(Task task) {
        if(task == null)   throw new IllegalArgumentException("new Task is Empty.");
        if(!getTaskList().containsKey(task)) getTaskList().put(task, task.getDuration());
    }

    private long CalcAllModuleTimeInDays() {
        return Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays();
    }

    private int calcAllTaskDays() {
        int sum = 0;
        for (Map.Entry<Task, Integer> task : taskList.entrySet()) {
            sum += task.getValue();
        }
        return sum;
    }


    public void printTasks() {
        System.out.println("All Tasks in this Module:");
        for (Map.Entry<Task, Integer> task : taskList.entrySet()) {
            System.out.println("\t-" + task.getKey() + "\n");
        }
    }

    @Override
    public String toString(){
        return getId() + ", Name: " + getName() + ", Module-Time: " + getStart() + " - " + getEnd();
    }

    public void printTrainerForThisModule() {
        System.out.println("Trainer for Module " + toString());
        if (getTrainer() == null) { 
            System.out.println("Trainer dosn't exist");
        } else if (getAssistent() == null) {
            System.out.println("Assistent dosn't exist");
        } else {
        System.out.println("\t-Trainer: " + getTrainer().getFirstname() + " " + getTrainer().getLastname() + "\n\t-Assist" + getAssistent().getFirstname() + " " + getAssistent().getLastname());
        }
    }

    public boolean verifyModuleTasks() {
        System.out.println(calcAllTaskDays() >= CalcAllModuleTimeInDays());
        return calcAllTaskDays() >= CalcAllModuleTimeInDays();
    }
}


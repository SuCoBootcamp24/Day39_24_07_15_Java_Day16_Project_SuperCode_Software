import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Module {
    
    private static long lastId = 1;
    private final long ID;
    private String name;
    private HashMap<Task, Integer> taskList = new HashMap<>();
    private LocalDate start;
    private LocalDate end;
    private String requiredLicense;
    private Trainer trainer;
    private Trainer assistent;


    public Module(String name, LocalDate start, LocalDate end, String requiredLicense) {
        setName(name);
        setStartAndEnd(start, end);
        setRequiredLicense(requiredLicense);
        this.ID = lastId++;
    }

    
    //----getter() / setter()---
    public long getID() {
        return ID;
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
        trainer.addModuleToList(this);
    }

   //----
    public Trainer getAssistant() {
        return assistent;
    }

    public void setAssistant(Trainer assistant) {
        this.assistent = assistant;
    }

    //----other---
    private void setStartAndEnd(LocalDate start, LocalDate end) {
        if (start.isBefore(end)) {
            setStart(start);
            setEnd(end);
        } else
            throw new IllegalArgumentException("Starting Date is after end Date.");
    }

    public void addTaskToList(Task task) {
        if(task == null)   throw new IllegalArgumentException("new Task is Empty.");
        if(!getTaskList().containsKey(task)) getTaskList().put(task, task.getDuration());
    }

    public void printTasks() {
        System.out.println("All Tasks in this Module:");
        for (Map.Entry<Task, Integer> task : taskList.entrySet()) {
            System.out.println("\t-" + task.getKey() + "\n");
        }
    }

    @Override
    public String toString(){
        return getID() + ", Name: " + getName() + ", Module-Time: " + getStart() + " - " + getEnd();
    }

    public void printTrainerForThisModule() {
        System.out.println("Trainer for Module " + toString());
        if (getTrainer() == null) { 
            System.out.println("Trainer doesn't exist");
        } else if (getAssistant() == null) {
            System.out.println("Assistent doesn't exist");
        } else {
        System.out.println("\t-Trainer: " + getTrainer().getFirstname() + " " + getTrainer().getLastname() + "\n\t-Assist" + getAssistant().getFirstname() + " " + getAssistant().getLastname());
        }
    }

    public boolean verifyModuleTasks() {
        long allModuleDays = calculateWorkingDays(getStart(), getEnd());
        long allTaskDays = calcAllTaskDays();
        return allTaskDays >= allModuleDays;
    }

    public long calcAllModuleTimeInDays() {
        return Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays() + 1;
    }

    private int calcAllTaskDays() {
        int sum = 0;
        for (Integer duration : taskList.values()) {
            sum += duration;
        }
        return sum;
    }

    public int calculateWorkingDays(LocalDate startDate, LocalDate endDate) {
        int workingDays = 0;
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (currentDate.getDayOfWeek()!= DayOfWeek.SATURDAY && currentDate.getDayOfWeek()!= DayOfWeek.SUNDAY) {
                workingDays++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return workingDays;
    }

}


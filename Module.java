import java.time.LocalDate;
import java.util.HashMap;

public class Module {
    
    private static long lastId = 0;

    private long id;
    private String name;
    private HashMap<Task, Integer> taskList = new HashMap<>();
    private LocalDate start;
    private LocalDate end;
    private Trainer trainer;
    private Trainer assistent;


    public Module(String name, LocalDate start, LocalDate end) {
        setName(name);
        setStart(start);
        setEnd(end);
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


    private int CalcAllModuleTimeInDays() {
        return 0;
    }

    private int calcAllTaskDays() {
        return 0;
    }

    public void addTask(Task task) {

    }

    public void printTasks() {

    }

    @Override
    public String toString(){
        return "";
    }


    private boolean hasLicense(Trainer trainer) {
        return false;
    }

    public boolean trainerIsFree(Trainer trainer) {
        return false;
    }
}

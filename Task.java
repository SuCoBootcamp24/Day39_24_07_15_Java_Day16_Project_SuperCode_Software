public class Task {
    
    private String name;
    private String level;
    private int duration;

    public Task(String name, String level, int duration){
        setName(name);
        setLevel(level);
        setDuration(duration);
    }


    //----getter() / setter()---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

   //---
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String toString() {
        return getName()+ ", Level: " + getLevel() + ", Duration: " + getDuration() + "Day(s)";
    }
}

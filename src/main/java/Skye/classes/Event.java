package Skye.classes;
public class Event extends Task{
    protected String start;
    protected String end;

    public Event(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public String getTaskType() {
        return "E";
    }

    @Override
    public String toString() {
        return String.format("[%s]%s (from: %s to: %s)" , getTaskType(), super.toString(), this.start, this.end);
    }

    @Override
    public String getTaskData() {
        return String.format("%s|%s|%s", super.getTaskData(), this.start, this.end);
    }
}

package Skye.classes;
public class Deadline extends Task{
    protected String dueDate;

    public Deadline(String name, String date) {
        super(name);
        this.dueDate = date;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public String toString() {
        return String.format("[%s]%s (by: %s)" , getTaskType(), super.toString(), this.dueDate);
    }

    @Override
    public String getTaskData() {
        return String.format("%s|%s", super.getTaskData(), this.dueDate);
    }
}

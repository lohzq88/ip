package Skye.classes;
public class Deadline extends Task{
    protected String dueDate;

    public Deadline(String name, String date) {
        super(name);
        this.dueDate = date;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)" , super.toString(), this.dueDate);
    }
}

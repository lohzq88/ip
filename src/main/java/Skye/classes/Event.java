package Skye.classes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    protected LocalDate start;
    protected LocalDate end;

    public Event(String name, LocalDate start, LocalDate end) {
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
        return String.format("[%s]%s (from: %s to: %s)" , getTaskType(), super.toString(),
                this.start.format(DateTimeFormatter.ofPattern(Task.DATE_TIME_FORMAT)),
                this.end.format(DateTimeFormatter.ofPattern(Task.DATE_TIME_FORMAT)));
    }

    @Override
    public String getTaskData() {
        return String.format("%s|%s|%s", super.getTaskData(),
                this.start.format(DateTimeFormatter.ofPattern(Task.DATE_TIME_FORMAT)),
                this.end.format(DateTimeFormatter.ofPattern(Task.DATE_TIME_FORMAT)));
    }
}

package Skye.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    protected LocalDate dueDate;

    public Deadline(String name, LocalDate date) {
        super(name);
        this.dueDate = date;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public String toString() {
        return String.format("[%s]%s (by: %s)" , getTaskType(), super.toString(),
                this.dueDate.format(DateTimeFormatter.ofPattern(Task.DATE_TIME_FORMAT)));
    }

    @Override
    public String getTaskData() {
        return String.format("%s|%s", super.getTaskData(),
                this.dueDate.format(DateTimeFormatter.ofPattern(Task.DATE_TIME_FORMAT)));
    }
}

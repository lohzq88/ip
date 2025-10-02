package Skye.classes;
public class Task {
    protected String taskName;
    protected boolean isComplete;
    protected static final String DATE_TIME_FORMAT = "MMM dd yyyy";

    public Task(String name) {
        this.taskName = name;
        this.isComplete = false;
    }

    public void setTaskComplete() {
        this.isComplete = true;
    }

    public void setTaskIncomplete() {
        this.isComplete = false;
    }

    public String getStatusIcon() {
        return (this.isComplete ? "X" : " ");
    }

    public String getTaskType() {
        return " ";
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), this.taskName);
    }

    /**
     * Gets the string for writing into data file
     * @return String of the correct format for data file write
     */
    public String getTaskData() {
        return String.format("%s|%s|%s", getTaskType(), (this.isComplete ? "Y" : "N"), this.taskName);
    }

    /**
     * Check if the task name contains the given string
     * @param name given string to check against
     * @return boolean
     */
    public boolean containName(String name){
        return this.taskName.contains(name);
    }
}

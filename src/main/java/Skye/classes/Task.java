package Skye.classes;
public class Task {
    protected String taskName;
    protected boolean isComplete;

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

    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), this.taskName);
    }
}

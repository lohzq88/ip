public class Task {
    protected String taskName;
    protected boolean isComplete;

    public Task(String name) {
        taskName = name;
        isComplete = false;
    }

    public void setTaskComplete() {
        isComplete = true;
    }

    public void setTaskIncomplete() {
        isComplete = false;
    }

    public String getStatusIcon() {
        return (isComplete ? "X" : " ");
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), taskName);
    }
}

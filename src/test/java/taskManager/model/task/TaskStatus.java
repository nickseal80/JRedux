package taskManager.model.task;

public enum TaskStatus {
    STATUS_TODO("todo"),
    STATUS_IN_PROGRESS("in progress"),
    STATUS_DONE("done");

    private String status;
    TaskStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}

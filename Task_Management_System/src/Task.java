import java.util.Date;
import java.util.Set;

public class Task {
    int taskId;
    String taskName;
    String taskDescriptions;
    Date dueDate;
    Priority priority;// HIGH, MEDIUM, LOW
    Set<String> categories;

    public Task(int taskId, String taskName, String taskDescriptions, Date dueDate, Priority priority, Set<String> categories) {
        this.taskDescriptions = taskDescriptions;
        this.taskName = taskName;
        this.taskId = taskId;
        this.dueDate=dueDate;
        this.priority=priority;
        this.categories=categories;
    }
    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public String getTaskDescriptions() {
        return taskDescriptions;
    }

    public void setTaskDescriptions(String taskDescriptions) {
        this.taskDescriptions = taskDescriptions;
    }
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}

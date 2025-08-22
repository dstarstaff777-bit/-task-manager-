package Task;

import Interface.Printable;
import Status.TaskStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Task implements Printable, Serializable {
    private final int id;
    private String title;
    private String description;
    private final LocalDateTime createdAt;
    private TaskStatus status;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.status = TaskStatus.NEW;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    public abstract void execute();

    @Override
    public void printInfo() {
        System.out.println("[" + id + "] " + title + " (" + status.getDescription() + ")");
        System.out.println("Описание: " + description);
        System.out.println("Дата создания: " + createdAt);
    }
}

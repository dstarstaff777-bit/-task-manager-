package App.status;

public enum TaskStatus {
    NEW("Новая"),
    IN_PROGRESS("В процессе"),
    DONE("Выполнена"),
    CANCELLED("Отменена");

    private final String description;

    TaskStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

package Task;

import Status.TaskStatus;

public class PersonalTask extends Task {
    private int priority;

    public PersonalTask(int id, String title, String description, int priority) {
        super(id, title, description);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if(priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Priority must be between 1 and 5");
        }
        this.priority = priority;
    }

    @Override
    public void execute() {
        System.out.println("Выполняется личное задание: " + getTitle() + " с приоритетом " + priority);
        setStatus(TaskStatus.IN_PROGRESS);
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Приоритет: " + priority);
    }
}

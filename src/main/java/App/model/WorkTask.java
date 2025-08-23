package App.model;

import App.status.TaskStatus;

public class WorkTask extends Task{
    private String projectName;
    public WorkTask(int id, String title, String description, String projectName) {
        super(id, title, description);
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public void execute() {
        System.out.println("Выполняется рабочая задача: " + getTitle() + " в проекте " + getProjectName());
        setStatus(TaskStatus.IN_PROGRESS);
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Проект: " + projectName);
    }
}

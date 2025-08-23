package App;

import App.status.TaskStatus;
import App.model.PersonalTask;
import App.model.Task;
import App.model.WorkTask;
import App.service.TaskManager;

import java.util.Scanner;

public class Launch {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Показать все задачи");
            System.out.println("4. Найти задачу по названию");
            System.out.println("5. Изменить статус задачи");
            System.out.println("6. Сохранить задачи");
            System.out.println("7. Загрузить задачи");
            System.out.println("8. Выход");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTaskMenu(taskManager, scanner);
                    break;
                case "2":
                    removeTaskMenu(taskManager, scanner);
                    break;
                case "3":
                    taskManager.printAllTasks();
                    break;
                case "4":
                    findTaskMenu(taskManager, scanner);
                    break;
                case "5":
                    updateTaskStatusMenu(taskManager, scanner);
                    break;
                case "6":
                    saveTasks(taskManager, scanner);
                    break;
                case "7":
                    loadTasks(taskManager, scanner);
                    break;
                case "8":
                    running = false;
                    System.out.println("Выход....");
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
        scanner.close();
    }

    private static void addTaskMenu(TaskManager taskManager, Scanner scanner) {
        try {
            System.out.println("Введите ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите название: ");
            String title = scanner.nextLine();

            System.out.println("Введите описание: ");
            String description = scanner.nextLine();

            System.out.println("Тип задачи (1 - Рабочая, 2 - Личная): ");
            String type = scanner.nextLine();

            Task task;
            if (type.equals("1")) {
                System.out.println("Введите название проекта: ");
                String project = scanner.nextLine();
                task = new WorkTask(id, title, description, project);
            } else {
                System.out.println("Введите приоритет (1 - 5): ");
                int priority = Integer.parseInt(scanner.nextLine());
                task = new PersonalTask(id, title, description, priority);
            }
            taskManager.addTask(task);
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении задачи!");
        }
    }

    private static void removeTaskMenu(TaskManager taskManager, Scanner scanner) {
        try {
            System.out.println("Введите ID задачи: ");
            int id = Integer.parseInt(scanner.nextLine());
            taskManager.removeTask(id);
        } catch (Exception e) {
            System.out.println("Ошибка: введите корректный ID!");
        }
    }

    private static void findTaskMenu(TaskManager taskManager, Scanner scanner) {
        System.out.println("Введите ключевое слово для поиска: ");
        String keyword = scanner.nextLine();
        var result = taskManager.findTaskByTitle(keyword);
        if (result.isEmpty()) {
            System.out.println("Задачи не найдены.");
        } else {
            result.forEach(Task::printInfo);
        }
    }

    private static void updateTaskStatusMenu(TaskManager taskManager, Scanner scanner) {
        try {
            System.out.println("Введите ID задачи: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Выберите новый статус: ");
            for (TaskStatus status : TaskStatus.values()) {
                System.out.println(status.ordinal() + 1 + ". " + status.getDescription());

            }
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 1 && choice <= TaskStatus.values().length) {
                TaskStatus newStatus = TaskStatus.values()[choice - 1];
                taskManager.updateTaskStatus(id, newStatus);
            } else {
                System.out.println("Ошибка: некорректный выбор статуса!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректные данные!");
        }
    }

    private static void saveTasks(TaskManager taskManager, Scanner scanner) {
        System.out.println("Введите путь к файлу: ");
        String path = scanner.nextLine();
        try {
            taskManager.save(path);
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private static void loadTasks(TaskManager taskManager, Scanner scanner) {
        System.out.println("Введите путь к файлу: ");
        String path = scanner.nextLine();
        try {
            taskManager.load(path);
        } catch (Exception e) {
            System.out.println("Ошибка при загрузке: " + e.getMessage());
        }
    }
}



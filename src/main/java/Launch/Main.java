package Launch;

import Task.Task;
import Task.TaskManager;

import java.util.Scanner;

public class Main {
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

        private static void addTaskMenu(TaskManager taskManager, Scanner scanner) {
            try {
                System.out.println("Введите ID: ");
                int id = Integer.parseInt(scanner.nextLine(
                System.out.println("Введите название: ");
                String title = scanner.nextLine();
                System.out.println("Введите описание: ");
                String description = scanner.nextLine();
                System.out.println("Тип задачи (1 - Рабочая, 2 - Личная): ");
                String type = scanner.nextLine();

                Task task;
                if(type.equals("1") {
                    System.out.println("Введите название проекта: ");
                    String project = scanner.nextLine();
                    task = new WorkTask(id, title, description, project);
                } else {
                    System.out.println("Введите приоритет (1 - 5): ");
                    int priority = Integer.parseInt(scanner.nextLine());
                    task = new PersonalTask(id, title, description, priority);
                }
                taskManager.addTask(task);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ID или приоритета");
            } catch (IllegalArgumentException e)
                }
            }
        }
    }
}

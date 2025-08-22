package Task;

import Interface.Persistable;
import Status.TaskStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager implements Persistable {
    private final Map<Integer, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if(tasks.containsKey(task.getId())) {
            throw new IllegalArgumentException("Задача с таким ID уже существует: " + task.getId());
        }
        tasks.put(task.getId(), task);
        System.out.println("Задача добавлена: " + task.getTitle());
    }

    public boolean removeTask(int id) {
        if(tasks.remove(id) != null) {
            System.out.println("Задача удалена: ID " + id);
        } else {
            System.out.println("Задача с ID " + id + " не найдена");
        }
        return false;
    }
    public List<Task> findTaskByTitle(String keyword) {
        List<Task> results = new ArrayList<>();
        for (Task task : tasks.values()) {
            if(task.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(task);
            }
        }
        return results;
    }
    public void updateTaskStatus(int id, TaskStatus status) {
        if(tasks.get(id) != null) {
            tasks.get(id).setStatus(status);
            System.out.println("Статус задачи ID: " +  id + " изменена на " + status.getDescription());
        } else {
            System.out.println("Задача с ID " + id + " не найдена");
        }
    }
    public void printAllTasks() {
        if(tasks.isEmpty()) {
            System.out.println("Нет задач для отображения.");
            return;
        }
        for (Task task : tasks.values()) {
            task.printInfo();
            System.out.println("-------------");
        }
    }
    public Task getTaskById(int id) {
         return tasks.get(id);
    }

    @Override
    public void save(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(tasks);
            System.out.println("'Saved to " + filePath);
        }
    }

    @Override
    public void load(String filePath) throws IOException, ClassNotFoundException {
          try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
              Object object = ois.readObject();
              if(object instanceof Map) {
                  tasks.clear();
                  tasks.putAll((Map<Integer, Task>) object);
                  System.out.println("Loaded from " + filePath);
              } else {
                  throw new IOException("Файл поврежден или имеет неверный формат");
              }
          }
    }
}
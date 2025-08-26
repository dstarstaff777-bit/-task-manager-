import App.model.PersonalTask;
import App.model.Task;
import App.model.WorkTask;
import App.service.TaskManager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    void testAddTask() {
        TaskManager manager = new TaskManager();
        WorkTask task = new WorkTask(1, "Find title", "Init quest", "SuperToDO");

        manager.addTask(task);
        List<Task> tasks = manager.getAllTasks();
        assertEquals(1, tasks.size());    // проверяем, что добавилась 1 задача
        assertTrue(tasks.contains(task));         // проверяем, что именно наша задача там есть
    }
    @Test
    void testRemoveTask() {
        TaskManager manager = new TaskManager();
        WorkTask task = new WorkTask(1, "Find title", "Init quest", "SuperToDO");
        manager.addTask(task);

        manager.removeTask(task.getId());

        assertEquals(0, manager.getAllTasks().size());
        assertFalse(manager.getAllTasks().contains(task));
    }
    @Test
    void testGetAllTask() {
        TaskManager manager = new TaskManager();
        WorkTask issue = new WorkTask(1, "Find title", "Init quest", "SuperToDO");
        PersonalTask problem = new PersonalTask(2, "No problem", "LoadPath", 100);

        manager.addTask(issue);
        manager.addTask(problem);

        List<Task> tasks = manager.getAllTasks();
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(issue));
        assertTrue(tasks.contains(problem));
    }
}

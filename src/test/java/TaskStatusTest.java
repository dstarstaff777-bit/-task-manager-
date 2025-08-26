import App.status.TaskStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskStatusTest {

    @Test
    void testDescription() {
        assertEquals("NEW", TaskStatus.NEW.getDescription());
        assertEquals("DONE", TaskStatus.DONE.getDescription());
        assertEquals("IN_PROGRESS", TaskStatus.IN_PROGRESS.getDescription());
        assertEquals("CANCELLED",TaskStatus.CANCELLED.getDescription());
    }

    @Test
    void testValueOf() {
        TaskStatus status = TaskStatus.valueOf("NEW");
        assertEquals(TaskStatus.NEW, status);
    }
    @Test
    void testValuesCount() {
        TaskStatus[] statuses = TaskStatus.values();
        assertEquals(4,statuses.length);         // ожидаем 4 статуса
    }
}

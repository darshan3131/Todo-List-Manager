// File: TodoManager.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TodoManager {
    private List<Task> tasks;
    private int nextId;
    private static final String FILE_NAME = "tasks.dat";

    public TodoManager() {
        tasks = new ArrayList<>();
        nextId = 1;
        loadTasks();
    }

    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Error: Task description cannot be empty!");
            return;
        }
        Task task = new Task(nextId++, description);
        tasks.add(task);
        saveTasks();
        System.out.println("Task added successfully! (ID: " + (nextId - 1) + ")");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet. Add some to get started!");
            return;
        }
        System.out.println("\n=== Your To-Do List ===");
        for (Task task : tasks) {
            System.out.println(task);
        }
        System.out.println("=======================\n");
    }

    public void markComplete(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setCompleted(true);
            saveTasks();
            System.out.println("Task " + id + " marked as complete!");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public void deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            saveTasks();
            System.out.println("Task " + id + " deleted successfully!");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
            oos.writeInt(nextId);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadTasks() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                tasks = (List<Task>) ois.readObject();
                nextId = ois.readInt();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading tasks (starting fresh): " + e.getMessage());
            }
        }
    }
}
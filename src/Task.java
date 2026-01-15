import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private String description;
    private boolean completed;

    public Task(int id, String description) {
        this.id = id;
        this.description = description.trim();
        this.completed = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description.trim();
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        String status = completed ? "[✓]" : "[ ]";
        return status + " " + id + ". " + description;
    }
}
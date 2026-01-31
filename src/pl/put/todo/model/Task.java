package pl.put.todo.model;

import java.time.LocalDateTime;
import java.util.Objects;
import pl.put.todo.persistence.Storable;

public abstract class Task implements Storable {

    private final long id;
    private final String title;
    private final String description;
    private final Category category;
    private final Priority priority;

    private TaskStatus status;
    private final LocalDateTime createdAt;

    protected Task(long id, String title, String description, Category category, Priority priority) {
        if (id <= 0) throw new IllegalArgumentException("id must be > 0");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title cannot be blank");
        if (category == null) throw new IllegalArgumentException("category cannot be null");
        if (priority == null) throw new IllegalArgumentException("priority cannot be null");

        this.id = id;
        this.title = title.trim();
        this.description = (description == null) ? "" : description.trim();
        this.category = category;
        this.priority = priority;

        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now();
    }

    /** ABSTRACT METHOD (wymaganie) */
    public abstract String getKind();

    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }
    public Priority getPriority() { return priority; }
    public TaskStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void markInProgress() {
        status = TaskStatus.IN_PROGRESS;
    }

    public void markDone() {
        status = TaskStatus.DONE;
    }

    /** Używane przy wczytywaniu z pliku */
    public void setStatusForLoad(TaskStatus status) {
        if (status != null) this.status = status;
    }

    @Override
    public String serialize() {
        return "kind=" + getKind()
                + ";id=" + id
                + ";title=" + title
                + ";desc=" + description
                + ";category=" + category
                + ";priority=" + priority
                + ";status=" + status
                + ";createdAt=" + createdAt;
    }

    @Override
    public String toString() {
        return "#" + id + " [" + status + "] " + title
                + " | " + category
                + " | " + priority;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Task t) && id == t.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


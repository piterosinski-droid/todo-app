package pl.put.todo.service;

import pl.put.todo.model.Task;

public class TaskValidator {

    /** METODA STATYCZNA (wymaganie) */
    public static void validate(Task task) {
        if (task == null) throw new IllegalArgumentException("Task cannot be null");
        if (task.getTitle() == null || task.getTitle().isBlank())
            throw new IllegalArgumentException("Task title cannot be empty");
        if (task.getPriority() == null)
            throw new IllegalArgumentException("Task priority must be set");
        if (task.getCategory() == null)
            throw new IllegalArgumentException("Task category must be set");
    }

    // żeby dało się wstrzyknąć do TaskService jako obiekt
    public void validateInstance(Task task) {
        validate(task);
    }
}


package pl.put.todo.service;

import pl.put.todo.model.*;

public class TaskFactory {

    /** METODA STATYCZNA (wymaganie) */
    public static Task createSimpleTask(long id, String title, String description, Category category, Priority priority) {
        Task task = new SimpleTask(id, title, description, category, priority);
        TaskValidator.validate(task);
        return task;
    }
}




package pl.put.todo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.put.todo.exception.TaskNotFoundException;
import pl.put.todo.model.Task;
import pl.put.todo.persistence.TaskRepository;

public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private final TaskRepository repository;
    private final TaskValidator validator;

    public TaskService(TaskRepository repository, TaskValidator validator) {
        if (repository == null) throw new IllegalArgumentException("repository cannot be null");
        if (validator == null) throw new IllegalArgumentException("validator cannot be null");
        this.repository = repository;
        this.validator = validator;

        // wczytanie istniejących zadań (jeśli są)
        tasks.addAll(repository.findAll());
    }

    public void add(Task task) {
        validator.validateInstance(task);
        tasks.removeIf(t -> t.getId() == task.getId());
        tasks.add(task);
        repository.save(task);
    }

    public List<Task> getAll() {
        return Collections.unmodifiableList(tasks);
    }

    public Task getById(long id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task with id=" + id + " not found"));
    }

    public void markDone(long id) {
        Task t = getById(id);
        t.markDone();
        repository.save(t);
    }

    public void remove(long id) {
        Task t = getById(id);
        tasks.remove(t);
        repository.deleteById(id);
    }
}





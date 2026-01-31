package pl.put.todo.persistence;

import java.util.List;
import java.util.Optional;
import pl.put.todo.model.Task;

public interface TaskRepository {

    void save(Task task);

    List<Task> findAll();

    Optional<Task> findById(long id);

    void deleteById(long id);
}


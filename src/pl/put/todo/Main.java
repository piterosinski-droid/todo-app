package pl.put.todo;

import java.nio.file.Path;
import pl.put.todo.model.*;
import pl.put.todo.persistence.*;
import pl.put.todo.service.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== MODEL TEST ===");

        Category cat = new Category(CategoryType.STUDY, "PO - projekt");

        Task task = TaskFactory.createSimpleTask(
                1L,
                "Zrobić UML",
                "Diagram klas do projektu",
                cat,
                Priority.HIGH
        );

        System.out.println(task);

        task.markInProgress();
        System.out.println("Po markInProgress(): " + task);

        task.markDone();
        System.out.println("Po markDone(): " + task);

        System.out.println("Serialized:");
        System.out.println(task.serialize());

        System.out.println("\n=== SERVICE + PERSISTENCE TEST ===");

        TaskRepository repository = new FileTaskRepository(Path.of("tasks.txt"));
        TaskValidator validator = new TaskValidator();
        TaskService service = new TaskService(repository, validator);

        service.add(task);
        service.markDone(1L);

        System.out.println("Lista zadań:");
        service.getAll().forEach(System.out::println);
    }
}



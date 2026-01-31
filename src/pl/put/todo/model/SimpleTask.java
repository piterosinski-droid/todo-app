package pl.put.todo.model;

public class SimpleTask extends Task {

    public SimpleTask(long id, String title, String description, Category category, Priority priority) {
        super(id, title, description, category, priority);
    }

    @Override
    public String getKind() {
        return "SimpleTask";
    }
}


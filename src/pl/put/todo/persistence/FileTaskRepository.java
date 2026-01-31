package pl.put.todo.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pl.put.todo.model.*;

public class FileTaskRepository implements TaskRepository {

    private final Path file;

    public FileTaskRepository(Path file) {
        if (file == null) throw new IllegalArgumentException("file cannot be null");
        this.file = file;
    }

    public FileTaskRepository(String filePath) {
        this(Path.of(filePath));
    }

    @Override
    public void save(Task task) {
        if (task == null) throw new IllegalArgumentException("task cannot be null");
        List<Task> all = loadAllSafe();
        all.removeIf(t -> t.getId() == task.getId());
        all.add(task);
        saveAllSafe(all);
    }

    @Override
    public List<Task> findAll() {
        return loadAllSafe();
    }

    @Override
    public Optional<Task> findById(long id) {
        return loadAllSafe().stream().filter(t -> t.getId() == id).findFirst();
    }

    @Override
    public void deleteById(long id) {
        List<Task> all = loadAllSafe();
        all.removeIf(t -> t.getId() == id);
        saveAllSafe(all);
    }

    // ====== I/O (wewnętrzne) ======

    private void saveAllSafe(List<Task> tasks) {
        try {
            saveAll(tasks);
        } catch (IOException e) {
            throw new RuntimeException("Cannot save tasks to file: " + file, e);
        }
    }

    private List<Task> loadAllSafe() {
        try {
            return loadAll();
        } catch (IOException e) {
            throw new RuntimeException("Cannot load tasks from file: " + file, e);
        }
    }

    private void saveAll(List<Task> tasks) throws IOException {
        if (file.getParent() != null) Files.createDirectories(file.getParent());

        try (BufferedWriter bw = Files.newBufferedWriter(file)) {
            for (Task t : tasks) {
                bw.write(t.serialize());
                bw.newLine();
            }
        }
    }

    private List<Task> loadAll() throws IOException {
        List<Task> result = new ArrayList<>();
        if (!Files.exists(file)) return result;

        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                Task t = parseTask(line.trim());
                if (t != null) result.add(t);
            }
        }
        return result;
    }

    private Task parseTask(String s) {
        try {
            String kind = getValue(s, "kind");
            String idStr = getValue(s, "id");
            String title = getValue(s, "title");
            String desc = getValue(s, "desc");
            String categoryStr = getValue(s, "category");
            String priorityStr = getValue(s, "priority");
            String statusStr = getValue(s, "status");

            long id = Long.parseLong(idStr);

            // category: "Nazwa (TYPE)"
            String categoryName = categoryStr;
            String categoryTypeStr = "OTHER";

            int idx1 = categoryStr.lastIndexOf('(');
            int idx2 = categoryStr.lastIndexOf(')');
            if (idx1 >= 0 && idx2 > idx1) {
                categoryName = categoryStr.substring(0, idx1).trim();
                categoryTypeStr = categoryStr.substring(idx1 + 1, idx2).trim();
            }

            CategoryType ct = CategoryType.valueOf(categoryTypeStr);
            Category category = new Category(ct, categoryName);

            Priority prio = Priority.valueOf(priorityStr);

            Task task;
            if ("SimpleTask".equals(kind) || kind.isBlank()) {
                task = new SimpleTask(id, title, desc, category, prio);
            } else {
                // na razie tylko SimpleTask
                task = new SimpleTask(id, title, desc, category, prio);
            }

            if (!statusStr.isBlank()) {
                task.setStatusForLoad(TaskStatus.valueOf(statusStr));
            }

            return task;
        } catch (Exception e) {
            return null;
        }
    }

    private String getValue(String s, String key) {
        String prefix = key + "=";
        int start = s.indexOf(prefix);
        if (start < 0) return "";
        start += prefix.length();
        int end = s.indexOf(';', start);
        if (end < 0) end = s.length();
        return s.substring(start, end);
    }
}



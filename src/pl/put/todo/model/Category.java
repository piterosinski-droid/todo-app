package pl.put.todo.model;

public class Category {

    private String name;
    private CategoryType type;

    public Category() {
        this.type = CategoryType.OTHER;
        this.name = "Unnamed";
    }

    public Category(CategoryType type, String name) {
        setType(type);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public CategoryType getType() {
        return type;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name.trim();
    }

    public void setType(CategoryType type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}



import java.util.*;
class Teacher {
    private String name;
    private int id;

    public Teacher(String name, int id) {
        this.name = name;
        this.id = id;
    }

     public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + "]";
    }
}



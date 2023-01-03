package data;

public class Curator {
    private int id;
    private String name;

    public Curator (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
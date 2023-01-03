package data;

public class Student {

    private int id;
    private String name;
    private char sex;
    private int groupId;

    public Student(int id, String name, char sex, int groupId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getGroupId() {
        return groupId;
    }
}
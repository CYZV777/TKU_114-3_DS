package hw3;

public class Course {
    public String id;
    public String name; 
    public int capacity;
    public int currentCount;

    public Course(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.currentCount = 0;
    }

    public boolean isFull() {
        return currentCount >= capacity;
    }

    @Override
    public String toString() {
        return "代碼: " + id + ", 名稱: " + name + ", 人數: " + currentCount + "/" + capacity + (isFull() ? " (額滿)" : "");
    }
}
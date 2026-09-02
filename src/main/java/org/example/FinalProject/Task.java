package org.example.FinalProject;

public class Task {
    private int id;
    private String title;
    private Priority priority;
    private boolean isCompleted;

    public enum Priority { LOW, MEDIUM, HIGH }

    public Task(int id, String title, Priority priority, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public Priority getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    // Manual string parsing for File I/O
    public String toCsv() {
        return id + "," + title + "," + priority + "," + isCompleted;
    }

    public static Task fromCsv(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Task(
                Integer.parseInt(parts[0]),
                parts[1],
                Priority.valueOf(parts[2]),
                Boolean.parseBoolean(parts[3])
        );
    }

    @Override
    public String toString() {
        return String.format("[%s] ID: %d | %s | Priority: %s",
                (isCompleted ? "X" : " "), id, title, priority);
    }
}

package org.example.FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "tasks.csv";

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        // try-with-resources handles closing the stream
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromCsv(line));
            }
        } catch (IOException e) {
            System.out.println("No existing task file found. Starting fresh.");
        }
        return tasks;
    }

    public void saveTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Task task : tasks) {
                writer.write(task.toCsv() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}
package org.example.FinalProject;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskManager {
    // Week 1: HashMap for O(1) ID lookups
    private Map<Integer, Task> taskMap;
    private FileHandler fileHandler;
    private int currentIdCounter = 1;

    public TaskManager() {
        this.fileHandler = new FileHandler();
        this.taskMap = new HashMap<>();

        // Load file and populate HashMap
        List<Task> loadedTasks = fileHandler.loadTasks();
        for (Task t : loadedTasks) {
            taskMap.put(t.getId(), t);
            if (t.getId() >= currentIdCounter) {
                currentIdCounter = t.getId() + 1;
            }
        }
    }

    public void addTask(String title, Task.Priority priority) {
        Task newTask = new Task(currentIdCounter++, title, priority, false);
        taskMap.put(newTask.getId(), newTask);
        saveState();
    }

    // Week 4: Optional + Week 3: Lambda
    public void markAsCompleted(int id) throws TaskNotFoundException {
        // Look up in HashMap
        Optional<Task> taskOpt = Optional.ofNullable(taskMap.get(id));

        Task task = taskOpt.orElseThrow(() ->
                new TaskNotFoundException("Task with ID " + id + " does not exist.")
        );

        task.setCompleted(true);
        saveState();
    }

    // Week 4: Streams + Week 3: Predicate
    public void printFilteredTasks(Predicate<Task> condition) {
        List<Task> filtered = taskMap.values().stream()
                .filter(condition)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No tasks found matching criteria.");
        } else {
            filtered.forEach(System.out::println);
        }
    }

    // Week 4: Algorithms + Generics
    public void printSortedByPriority() {
        List<Task> listToSort = new ArrayList<>(taskMap.values());

        // Lambda acting as a Comparator
        Algorithms.selectionSort(listToSort, (t1, t2) ->
                t1.getPriority().compareTo(t2.getPriority())
        );

        listToSort.forEach(System.out::println);
    }

    private void saveState() {
        fileHandler.saveTasks(new ArrayList<>(taskMap.values()));
    }
}
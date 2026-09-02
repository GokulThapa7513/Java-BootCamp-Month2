package org.example.FinalProject;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n=== TO-DO SYSTEM ===");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. View Pending Tasks");
            System.out.println("4. View All (Sorted by Priority)");
            System.out.println("5. Exit");
            System.out.print("Select: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Priority (HIGH, MEDIUM, LOW): ");
                        Task.Priority priority = Task.Priority.valueOf(scanner.nextLine().toUpperCase());
                        manager.addTask(title, priority);
                        break;
                    case "2":
                        System.out.print("Task ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        manager.markAsCompleted(id);
                        System.out.println("Marked as done.");
                        break;
                    case "3":
                        // Passing a Lambda as a Predicate
                        manager.printFilteredTasks(task -> !task.isCompleted());
                        break;
                    case "4":
                        manager.printSortedByPriority();
                        break;
                    case "5":
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid input format.");
            } catch (TaskNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

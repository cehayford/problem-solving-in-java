import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class persistence {
    private static final String FILE_NAME = "tasks.txt";
    private List<Task> tasks;
    private Scanner scanner;

    public persistence() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    private static class Task {
        private String id;
        private String title;
        private String description;
        private boolean completed;

        public Task(String id, String title, String description, boolean completed) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.completed = completed;
        }

        public String toFileString() {
            return id + "|" + title + "|" + description + "|" + completed;
        }

        public static Task fromFileString(String line) {
            String[] parts = line.split("\\|");
            if (parts.length == 4) {
                return new Task(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3]));
            }
            return null;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Title: " + title + ", Description: " + description + ", Completed: " + completed;
        }
    }

    public void createTask() {
        System.out.print("Enter task ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        
        Task task = new Task(id, title, description, false);
        tasks.add(task);
        saveTasksToFile();
        System.out.println("Task created successfully!");
    }

    // regernate all tasks
    public void readTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        
        System.out.println("\n=== All Tasks ===");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void updateTask() {
        System.out.print("Enter task ID to update: ");
        String id = scanner.nextLine();
        
        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }
        
        System.out.print("Enter new title (press Enter to keep current): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) {
            task.title = newTitle;
        }
        
        System.out.print("Enter new description (press Enter to keep current): ");
        String newDescription = scanner.nextLine();
        if (!newDescription.isEmpty()) {
            task.description = newDescription;
        }
        
        System.out.print("Is task completed? (true/false, press Enter to keep current): ");
        String completedInput = scanner.nextLine();
        if (!completedInput.isEmpty()) {
            task.completed = Boolean.parseBoolean(completedInput);
        }
        
        saveTasksToFile();
        System.out.println("Task updated successfully!");
    }

    public void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        String id = scanner.nextLine();
        
        Task task = findTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }
        
        tasks.remove(task);
        saveTasksToFile();
        System.out.println("Task deleted successfully!");
    }

    public void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            tasks.clear();
            
            while ((line = reader.readLine()) != null) {
                Task task = Task.fromFileString(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
            
            System.out.println("Tasks loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Task file not found. Starting with empty task list.");
        } catch (IOException e) {
            System.err.println("Error reading tasks from file: " + e.getMessage());
        }
    }

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    // Find task by ID
    private Task findTaskById(String id) {
        for (Task task : tasks) {
            if (task.id.equals(id)) {
                return task;
            }
        }
        return null;
    }

    // the engine of the program
    public void run() {
        loadTasksFromFile();
        
        while (true) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Create Task");
            System.out.println("2. Read Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            String choice = scanner.nextLine();
            
            if(choice != null) {
                switch(choice) {
                    case "1":
                        createTask();
                        break;
                    case "2":
                        readTasks();
                        break;
                    case "3":
                        updateTask();
                        break;
                    case "4":
                        deleteTask();
                        break;
                    case "5":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number based on the option provided for the task...");
            }
        }
    }

    public static void main(String[] args) {
        persistence manager = new persistence();
        manager.run();
    }
}
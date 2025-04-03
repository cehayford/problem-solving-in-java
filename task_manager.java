import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private int id;
    private String name;
    private String description;

    public Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Name: " + name + ", Description: " + description;
    }
}

public class task_manager {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private int nextId = 1;

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nTask Manager");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createTask();
                case 2 -> viewTasks();
                case 3 -> updateTask();
                case 4 -> deleteTask();
                case 5 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Exiting Task Manager. Goodbye!");
    }

    private void createTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task(nextId++, name, description);
        tasks.add(task);
        System.out.println("Task created successfully!");
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private void updateTask() {
        System.out.print("Enter the Task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Task task = findTaskById(id);
        if (task != null) {
            System.out.print("Enter new task name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isBlank()) {
                task.setName(name);
            }

            System.out.print("Enter new task description (leave blank to keep current): ");
            String description = scanner.nextLine();
            if (!description.isBlank()) {
                task.setDescription(description);
            }

            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Task not found.");
        }
    }

    private void deleteTask() {
        System.out.print("Enter the Task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found.");
        }
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        task_manager manager = new task_manager();
        manager.start();
    }
}

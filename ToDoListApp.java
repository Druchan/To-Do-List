import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + description;
    }
}

public class ToDoListApp {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1: addTask(); 
                    break;
                case 2: deleteTask(); 
                    break;
                case 3: markComplete(); 
                    break;
                case 4: displayTasks(); 
                    break;
                case 5: System.out.println("Exiting..."); 
                    break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addTask() {
        System.out.print("Enter task description: ");
        String desc = scan.nextLine();
        tasks.add(new Task(desc));
        System.out.println("Task added successfully!");
    }

    static void deleteTask() {
        displayTasks();
        System.out.print("Enter task number to delete: ");
        int index = scan.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void markComplete() {
        displayTasks();
        System.out.print("Enter task number to mark as complete: ");
        int index = scan.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).isCompleted = true;
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void displayTasks() {
        System.out.println("\n--- Your To-Do List ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            int i = 1;
            for (Task task : tasks) {
                System.out.println(i++ + ". " + task);
            }
        }
    }
}

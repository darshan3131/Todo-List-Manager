// File: TodoApp.java (Main class)
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        TodoManager manager = new TodoManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to TodoListManager!");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    manager.addTask(desc);
                    break;
                case 2:
                    manager.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter task ID to mark complete: ");
                    int completeId = getValidId(scanner);
                    manager.markComplete(completeId);
                    break;
                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = getValidId(scanner);
                    manager.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.println("Goodbye! Your tasks are saved.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }
        }
    }

    private static int getValidId(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid ID! Enter a number: ");
            }
        }
    }
}
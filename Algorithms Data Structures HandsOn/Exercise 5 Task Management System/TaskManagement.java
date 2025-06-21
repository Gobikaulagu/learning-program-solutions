import java.util.Scanner;

public class TaskManagement {

    static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static class TaskList {
        Node head;

        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Task added successfully.");
        }

        public void searchTask(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.taskId == taskId) {
                    System.out.println("Task Found: " + current.task);
                    return;
                }
                current = current.next;
            }
            System.out.println("Task not found.");
        }

        public void traverseTasks() {
            if (head == null) {
                System.out.println("No tasks available.");
                return;
            }
            Node current = head;
            System.out.println("Task List:");
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        public void deleteTask(int taskId) {
            if (head == null) {
                System.out.println("No tasks to delete.");
                return;
            }
            if (head.task.taskId == taskId) {
                head = head.next;
                System.out.println("Task deleted.");
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.task.taskId == taskId) {
                    current.next = current.next.next;
                    System.out.println("Task deleted.");
                    return;
                }
                current = current.next;
            }
            System.out.println("Task not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();
        int choice;

        do {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Show All Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Task Status: ");
                    String status = scanner.nextLine();
                    taskList.addTask(new Task(id, name, status));
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    taskList.searchTask(searchId);
                    break;

                case 3:
                    taskList.traverseTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskList.deleteTask(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

package assignments;

public class ToDoListApplication {

        public static class Task {
            public String title;
            public String description;
            public boolean completed;

            public Task(String title, String description) {
                this.title = title;
                this.description = description;
                this.completed = false;
            }

            public String getTitle() {
                return title;
            }

            public String getDescription() {
                return description;
            }

            public boolean isCompleted() {
                return completed;
            }

            public void markCompleted() {
                this.completed = true;
            }
        }

        public static class Node {
            public Task task;
            public Node next;

            public Node(Task task) {
                this.task = task;
                this.next = null;
            }
        }

        public static class ToDoList {
            private Node head;

            public ToDoList() {
                this.head = null;
            }

            public void addToDo(Task task) {
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
            }

            public void markToDoAsCompleted(String title) {
                Node current = head;
                while (current != null) {
                    if (current.task.getTitle().equals(title)) {
                        current.task.markCompleted();
                        return;
                    }
                    current = current.next;
                }
                System.out.println("Task not found: " + title);
            }

            public void viewToDoList() {
                Node current = head;
                while (current != null) {
                    Task task = current.task;
                    System.out.println("Title: " + task.getTitle() + ", Description: " + task.getDescription() + ", Completed: " + task.isCompleted());
                    current = current.next;
                }
            }

            public static void main(String[] args) {
                ToDoList toDoList = new ToDoList();
                Task task1 = new Task("study", "oop unit 1");
                Task task2 = new Task("do", "dsa project");

                toDoList.addToDo(task1);
                toDoList.addToDo(task2);

                System.out.println("To-Do List:");
                toDoList.viewToDoList();

                toDoList.markToDoAsCompleted("study");

                System.out.println("\nTo-Do List:");
                toDoList.viewToDoList();
            }
        }
}

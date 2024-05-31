package assignments;

public class Implementations {
    // Node class to represent each node in the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList class to manage operations on the singly linked list
    static class LinkedList {
        Node head;

        public LinkedList() {
            this.head = null;
        }

        // Method to insert a node at a specific position
        public void insertAtPos(int data, int position) {
            Node newNode = new Node(data);
            if (position == 1) {
                newNode.next = head;
                head = newNode;
                return;
            }
            Node current = head;
            int count = 1;
            while (current != null && count < position - 1) {
                current = current.next;
                count++;
            }
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        // Method to delete a node at a specific position
        public void deleteAtPosition(int position) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (position == 1) {
                head = head.next;
                return;
            }
            Node temp = head;
            for (int i = 0; temp != null && i < position - 2; i++) {
                temp = temp.next;
            }
            if (temp == null || temp.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            temp.next = temp.next.next;
        }

        // Method to delete the node after a given node
        public void deleteAfterNode(Node prevNode) {
            if (prevNode == null) {
                System.out.println("Previous node is null");
                return;
            }
            if (prevNode.next == null) {
                System.out.println("No node exists after the given node");
                return;
            }
            prevNode.next = prevNode.next.next;
        }

        // Method to search for a node with a specific value
        public String searchNode(int key) {
            Node current = head;
            while (current != null) {
                if (current.data == key) {
                    return "is here";
                }
                current = current.next;
            }
            return "is not here";
        }
    }

    // Stack class to implement stack operations using a linked list
    static class Stack {
        private Node top;

        public Stack() {
            this.top = null;
        }

        // Method to push an element onto the stack
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        // Method to pop an element from the stack
        public int pop() {
            if (top == null) {
                System.out.println("Stack is empty");
                return -1; // Return a sentinel value for empty stack
            }
            int popped = top.data;
            top = top.next;
            return popped;
        }

        // Method to peek at the top element of the stack
        public int peek() {
            if (top == null) {
                System.out.println("Stack is empty");
                return -1; // Return a sentinel value for empty stack
            }
            return top.data;
        }
    }

        public static void main(String[] args) {
            // Testing LinkedList operations
            LinkedList linkedList = new LinkedList();
            linkedList.insertAtPos(1, 1);
            linkedList.insertAtPos(2, 2);
            linkedList.insertAtPos(3, 3);
            linkedList.deleteAtPosition(2);
            System.out.println(linkedList.searchNode(2));  // Output: false
            System.out.println(linkedList.searchNode(3));  // Output: true

            // Testing Stack operations
            Stack stack = new Stack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println(stack.pop());  // Output: 3
            System.out.println(stack.peek());  // Output: 2
        }
}



class EventCategoryNode {
    String category;
    EventCategoryNode leftChild;
    EventCategoryNode rightChild;

    public EventCategoryNode(String cat) {
        category = cat;
        leftChild = null;
        rightChild = null;
    }
}

class EventCategoryTree {
    public EventCategoryNode root;

    public void insert(String cat) {
        EventCategoryNode newNode = new EventCategoryNode(cat);
        if (root == null) {
            root = newNode;
        } else {
            EventCategoryNode current = root;
            EventCategoryNode parent;
            while (true) {
                parent = current;
                if (cat.compareTo(current.category) < 0) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inorder(EventCategoryNode localRoot) {
        if (localRoot != null) {
            inorder(localRoot.leftChild);
            System.out.print(localRoot.category + " ");
            inorder(localRoot.rightChild);
        }
    }
}


class AttendeeNode {
    String name;
    AttendeeNode next;

    public AttendeeNode(String n) {
        name = n;
        next = null;
    }
}


class AttendeeLinkedList {
    private AttendeeNode first;

    public AttendeeLinkedList() {
        first = null;
    }

    public void insert(String name) {
        AttendeeNode newNode = new AttendeeNode(name);
        newNode.next = first;
        first = newNode;
    }

    public void displayList() {
        AttendeeNode current = first;
        while (current != null) {
            System.out.print(current.name + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}


class TicketQueue {
    private int maxSize;
    private String[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public TicketQueue(int size) {
        maxSize = size;
        queueArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(String ticketHolder) {
        if (rear == maxSize - 1) rear = -1;
        queueArray[++rear] = ticketHolder;
        nItems++;
    }

    public String remove() {
        String temp = queueArray[front++];
        if (front == maxSize) front = 0;
        nItems--;
        return temp;
    }

    public String peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public void displayQueue() {
        System.out.print("Queue (front to rear): ");
        int count = 0;
        int i = front;
        while (count < nItems) {
            System.out.print(queueArray[i] + " ");
            i = (i + 1) % maxSize;
            count++;
        }
        System.out.println();
    }
}


public class EventManagementApp {
    public static void main(String[] args) {
 
        EventCategoryTree tree = new EventCategoryTree();
        tree.insert("Music");
        tree.insert("Tech");
        tree.insert("Art");
        System.out.print("Event Categories (inorder): ");
        tree.inorder(tree.root);
        System.out.println();

        TicketQueue tickets = new TicketQueue(5);
        tickets.insert("Alice");
        tickets.insert("Bob");
        tickets.insert("Charlie");
        tickets.displayQueue();
        System.out.println("Serving ticket: " + tickets.remove());
        tickets.displayQueue();

        AttendeeLinkedList attendees = new AttendeeLinkedList();
        attendees.insert("Alice");
        attendees.insert("Bob");
        attendees.insert("Charlie");
        System.out.print("Attendees: ");
        attendees.displayList();
    }
}

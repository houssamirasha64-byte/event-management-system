# Event Management System

A Java console application that simulates a simple event management system using three core data structures.

It demonstrates core data-structure concepts while mimicking real-world event workflows.

## Data Structures Used

| Structure | Class | Purpose |
|-----------|-------|---------|
| Binary Tree | `EventCategoryTree` | Stores event categories ("Music", "Tech", "Art"); inorder traversal lists them alphabetically |
| Queue (circular, array-based) | `TicketQueue` | Ticket booking: `insert`, `remove`, `peekFront`, `displayQueue`, `isEmpty`, `isFull` |
| Linked List | `AttendeeLinkedList` | Attendee list; new attendees are inserted at the head, `displayList` prints them |

## Execution Flow

1. Categories are added to a binary tree and printed in order.
2. Users book tickets via the queue.
3. Ticket holders are added to the attendee list.
4. Queue and list contents are displayed in the console.

## Run

```bash
javac EventManagementApp.java
java EventManagementApp
```

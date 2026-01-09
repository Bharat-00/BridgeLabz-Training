// Singly Linked List for Student Record Management
public class StudentRecordManagement {
    // Node class representing each student
    class StudentNode {
        int rollNumber;
        String name;
        int age;
        char grade;
        StudentNode next;
        // Constructor
        StudentNode(int rollNumber, String name, int age, char grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }
    // Head of the linked list
    private StudentNode head;
    // 1. Add student at the beginning
    public void addAtBeginning(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
        System.out.println("Student added at beginning.");
    }
    // 2. Add student at the end
    public void addAtEnd(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            System.out.println("Student added as first record.");
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Student added at end.");
    }
    // 3. Add student at specific position (1-based index)
    public void addAtPosition(int position, int roll, String name, int age, char grade) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        StudentNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Student added at position " + position);
    }
    // 4. Delete student by Roll Number
    public void deleteByRollNumber(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Student record deleted.");
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student record deleted.");
        }
    }
    // 5. Search student by Roll Number
    public void searchByRollNumber(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Student Found:");
                displayStudent(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }
    // 6. Update grade by Roll Number
    public void updateGrade(int roll, char newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }
    // 7. Display all student records
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        StudentNode temp = head;
        System.out.println("\n---- Student Records ----");
        while (temp != null) {
            displayStudent(temp);
            temp = temp.next;
        }
    }
    // Helper method to display one student
    private void displayStudent(StudentNode student) {
        System.out.println("Roll No: " + student.rollNumber +
                ", Name: " + student.name +
                ", Age: " + student.age +
                ", Grade: " + student.grade);
    }
    // Main method for testing
    public static void main(String[] args) {
        StudentRecordManagement list = new StudentRecordManagement();
        list.addAtBeginning(101, "Amit", 20, 'A');
        list.addAtEnd(102, "Riya", 21, 'B');
        list.addAtEnd(103, "Karan", 19, 'A');
        list.addAtPosition(2, 104, "Neha", 20, 'C');
        list.displayAllStudents();
        list.searchByRollNumber(102);
        list.updateGrade(104, 'A');
        list.deleteByRollNumber(101);
        list.displayAllStudents();
    }
}

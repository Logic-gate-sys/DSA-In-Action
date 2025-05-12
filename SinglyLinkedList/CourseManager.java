package SinglyLinkedList;

public class CourseManager {
    public static void main(String[] args){
        // Add sample courses
        OScourse course1 = new OScourse("S001", "Operating Systems", 101);
        OScourse course2 = new OScourse("S002", "Data Structures", 102);
        OScourse course3 = new OScourse("S003", "Algorithms", 103);
        OScourse course4 = new OScourse("S004", "Computer Networks", 104);
        OScourse course5 = new OScourse("S005", "Databases", 105);
        CourseList courseList=new CourseList();
        // Add to front and end
        courseList.add_front(course1); // head: S001
        courseList.add_end(course2);   // tail: S002
        courseList.add_front(course3); // new head: S003
        courseList.add_end(course4);   // new tail: S004

        // Display current list
        System.out.println("\nInitial list:");
        courseList.display();

        // Insert at position
        System.out.println("\nInserting at position 2:");
        courseList.addAt(2, course5); // Should be inserted after S003

        // Display updated list
        courseList.display();

        // Find a course
        System.out.println("\nFinding course with ID S002:");
        System.out.println(courseList.find("S002"));

        // Remove a course
        System.out.println("\nRemoving course with ID S005:");
        courseList.remove("S005");

        // Display list after removal
        courseList.display();

        // Reverse the list
        System.out.println("\nReversed list:");
        courseList.reverse();
        courseList.display();
    }
}

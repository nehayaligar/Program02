import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseName;
    int marks;

    Course(String courseName, int marks) {
        this.courseName = courseName;
        this.marks = marks;
    }

    void displayCourseInfo() {
        System.out.println("Course: " + courseName + ", Marks: " + marks);
    }
}

class Student {
    String name;
    LocalDate dob;
    List<Course> courses;

    Student(String name, String dobString) {
        this.name = name;
        this.dob = LocalDate.parse(dobString);
        this.courses = new ArrayList<>();
    }

    void addCourse(String courseName, int marks) {
        courses.add(new Course(courseName, marks));
    }

    int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + getAge() + " years");
        System.out.println("Courses and Marks:");
        for (Course course : courses) {
            course.displayCourseInfo();
        }
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter date of birth (YYYY-MM-DD): ");
        String dobString = scanner.nextLine();

        Student student = new Student(name, dobString);

        System.out.println("Enter number of courses: ");
        int courseCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < courseCount; i++) {
            System.out.println("Enter course name: ");
            String courseName = scanner.nextLine();
            System.out.println("Enter marks obtained: ");
            int marks = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            student.addCourse(courseName, marks);
        }

        student.displayInfo();
        scanner.close();
    }
}

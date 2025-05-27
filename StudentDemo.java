package PROGRAM02;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class Student {
    String name;
    LocalDate dob;

    Student(String name, String dobString) {
        this.name = name;
        this.dob = LocalDate.parse(dobString);
    }

    int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + getAge() + " years");
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
        student.displayInfo();
        scanner.close();
    }
}

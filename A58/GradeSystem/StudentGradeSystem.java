
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeSystem {

    private Map<String, Integer> marksMap;

    public StudentGradeSystem() {
        marksMap = new HashMap<>();
    }

    // Method to add subject and marks
    public void addMarks(String subject, int marks) {
        marksMap.put(subject, marks);
    }

    // Method to calculate total marks
    public int calculateTotalMarks() {
        int total = 0;
        for (int marks : marksMap.values()) {
            total += marks;
        }
        return total;
    }

    // Method to calculate percentage
    public double calculatePercentage() {
        int totalMarks = calculateTotalMarks();
        int numberOfSubjects = marksMap.size();
        return (totalMarks / (double) (numberOfSubjects * 100)) * 100;
    }

    // Method to determine grade
    public String determineGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to display marks, total marks, percentage, and grade
    public void displayResults() {
        System.out.println("Subject Marks:");
        for (Map.Entry<String, Integer> entry : marksMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        int totalMarks = calculateTotalMarks();
        double percentage = calculatePercentage();
        String grade = determineGrade();
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        StudentGradeSystem studentGradeSystem = new StudentGradeSystem();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter subject name: ");
            String subject = sc.nextLine();
            System.out.print("Enter marks for " + subject + ": ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume newline
            studentGradeSystem.addMarks(subject, marks);
        }

        studentGradeSystem.displayResults();
        sc.close();
    }
}

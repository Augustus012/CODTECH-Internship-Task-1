import java.util.Scanner;

public class StudentGradeTracker1 {

    // Function to calculate average grade
    public static double calculateAverage(double[] grades, double[] weights, int numSubjects) {
        double sum = 0;
        double weightSum = 0;
        for (int i = 0; i < numSubjects; i++) {
            sum += grades[i] * weights[i];
            weightSum += weights[i];
        }
        return sum / weightSum;  // Weighted average
    }

    // Function to calculate GPA based on average
    public static double calculateGPA(double average) {
        if (average >= 90) {
            return 4.0;
        } else if (average >= 80) {
            return 3.0;
        } else if (average >= 70) {
            return 2.0;
        } else if (average >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    // Function to get letter grade based on average
    public static String getLetterGrade(double average, double[] gradeBoundaries) {
        if (average >= gradeBoundaries[0]) {
            return "A";
        } else if (average >= gradeBoundaries[1]) {
            return "B";
        } else if (average >= gradeBoundaries[2]) {
            return "C";
        } else if (average >= gradeBoundaries[3]) {
            return "D";
        } else {
            return "F";
        }
    }

    // Function to validate grade input
    public static double validateGrade(Scanner scanner) {
        double grade;
        while (true) {
            grade = scanner.nextDouble();
            if (grade >= 0 && grade <= 100) {
                break;
            } else {
                System.out.print("Invalid grade. Enter a value between 0 and 100: ");
            }
        }
        return grade;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Arrays to store subject names, grades, and weights
        String[] subjectNames = new String[numSubjects];
        double[] grades = new double[numSubjects];
        double[] weights = new double[numSubjects];

        // Input grade boundaries
        double[] gradeBoundaries = new double[4];
        System.out.print("Enter minimum grade for A: ");
        gradeBoundaries[0] = scanner.nextDouble();
        System.out.print("Enter minimum grade for B: ");
        gradeBoundaries[1] = scanner.nextDouble();
        System.out.print("Enter minimum grade for C: ");
        gradeBoundaries[2] = scanner.nextDouble();
        System.out.print("Enter minimum grade for D: ");
        gradeBoundaries[3] = scanner.nextDouble();

        // Input subject names, grades, and weights
        for (int i = 0; i < numSubjects; i++) {
            scanner.nextLine();
            System.out.print("Enter subject " + (i + 1) + " name: ");
            subjectNames[i] = scanner.nextLine();

            System.out.print("Enter grade for " + subjectNames[i] + ": ");
            grades[i] = validateGrade(scanner);

            System.out.print("Enter weight for " + subjectNames[i] + ": ");
            weights[i] = scanner.nextDouble();
        }

        // Calculate average and GPA
        double average = calculateAverage(grades, weights, numSubjects);
        double gpa = calculateGPA(average);
        String letterGrade = getLetterGrade(average, gradeBoundaries);

        // Display results
        System.out.println("\nGrade Report:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println(subjectNames[i] + ": " + grades[i]);
        }
        System.out.println("\nOverall Average (Weighted): " + average);
        System.out.println("GPA: " + gpa);
        System.out.println("Letter Grade: " + letterGrade);

        scanner.close();
    }
}
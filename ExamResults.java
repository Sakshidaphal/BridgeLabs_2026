import java.util.Scanner;

public class ExamResults {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] marks = new int[N];
        int[] reExam = new int[M];

        for (int i = 0; i < N; i++) {
            marks[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            reExam[i] = sc.nextInt();
        }

        int max = marks[0];
        int maxIndex = 0;

        for (int i = 1; i < N; i++) {
            if (marks[i] > max) {
                max = marks[i];
                maxIndex = i;
            }
        }

        System.out.println("Highest scorer: Roll " + (maxIndex + 1));

        int A = 0, B = 0, C = 0, F = 0;

        for (int i = 0; i < N; i++) {

            if (marks[i] >= 90) {
                A++;
            }
            else if (marks[i] >= 75) {
                B++;
            }
            else if (marks[i] >= 50) {
                C++;
            }
            else {
                F++;
            }
        }

        System.out.println("\nGrade A: " + A);
        System.out.println("Grade B: " + B);
        System.out.println("Grade C: " + C);
        System.out.println("Grade F: " + F);


        System.out.println("\nDuplicates:");

        int duplicateCount = 0;

        for (int i = 0; i < N; i++) {

            int count = 1;

            for (int j = i + 1; j < N; j++) {
                if (marks[i] == marks[j]) {
                    count++;
                }
            }

            boolean foundEarlier = false;

            for (int j = 0; j < i; j++) {
                if (marks[i] == marks[j]) {
                    foundEarlier = true;
                    break;
                }
            }

            if (count > 1 && !foundEarlier) {
                System.out.println(marks[i] + " -> " + count + " times");
                duplicateCount++;
            }
        }

        if (duplicateCount == 0) {
            System.out.println("No duplicated marks.");
        }

        for (int i = 0; i < N / 2; i++) {

            int temp = marks[i];
            marks[i] = marks[N - 1 - i];
            marks[N - 1 - i] = temp;
        }

        System.out.print("\nReversed: ");

        for (int i = 0; i < N; i++) {
            System.out.print(marks[i] + " ");
        }

        int[] backup = new int[N];

        for (int i = 0; i < N; i++) {
            backup[i] = marks[i];
        }

        int[] merged = new int[N + M];

        for (int i = 0; i < N; i++) {
            merged[i] = marks[i];
        }

        for (int i = 0; i < M; i++) {
            merged[N + i] = reExam[i];
        }

        System.out.print("\n\nMerged: ");

        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }

        sc.close();
    }
}

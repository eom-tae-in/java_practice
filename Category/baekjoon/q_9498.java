package Category.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class q_9498 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        System.out.println(grade.calculateGrade(score));
    }

    enum grade {

        A(90, 'A'),
        B(80, 'B'),
        C(70, 'C'),
        D(60, 'D'),
        F(0, 'F');
        private final int score;
        private final char grade;

        grade(int score, char grade) {
            this.score = score;
            this.grade = grade;
        }

         static char calculateGrade(int score) {
            return Arrays.stream(values()).filter(grade -> grade.score <= score)
                    .findFirst().get().grade;
        }
    }
}



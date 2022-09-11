package Category.baekjoon;

import java.util.Scanner;

public class q_15894 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        System.out.println(N * 2 + N + N); // 옆면의 개수는 2N개씩 늘고 가장 윗면과 가장 밑면의 합은 N+1이고 사이사이에 있는 
                                           // 가로 변의 길이는 N-1이다.
    }
}

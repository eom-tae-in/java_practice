package category.baekjoon;

import java.util.Scanner;

public class q_1018 {

    private static boolean[][] isWhite;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int weight = sc.nextInt();
        int count = Integer.MAX_VALUE;
        isWhite = new boolean[height][weight];

        for (int i = 0; i < height; i++) {
            String str = sc.next();
            for (int j = 0; j < weight; j++) {
                isWhite[i][j] = str.charAt(j) == 'W';
            }
        }

        for (int i = 0; i < height - 7; i++) {
            for (int j = 0; j < weight - 7; j++) {
                int calculateCount = calculateCount(i, j);
                count = Math.min(count, Math.min(calculateCount, 64 - calculateCount));
            }
        }
    }

    private static int calculateCount(final int startHeight, final int startWeight) {
        int count = 0;
        boolean state = isWhite[startHeight][startWeight];
        int h = startHeight + 8;
        int w = startWeight + 8;

        for (int i = startHeight; i < h; i++) {
            for (int j = startWeight; j < w; j++) {
                if (isWhite[i][j] != state) {
                    count++;
                }
                state = !state;
            }
            state = !state;
        }

        return count;
    }
}

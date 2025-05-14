package category.leetcode._2025.may;

import java.util.List;

public class May14th {

    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(
            final String s,
            final int t,
            final List<Integer> nums
    ) {
        int[][] matrix = getTransformationMatrix(nums);
        int[][] exponentiatedMatrix = exponentiateMatrix(matrix, t);
        int[] alphabetCounts = new int[26];

        for (char ch : s.toCharArray()) {
            alphabetCounts[ch - 'a']++;
        }

        long answer = 0;
        long[] lengths = new long[26];

        for (int i = 0; i < 26; i++) {
            if (alphabetCounts[i] == 0) {
                continue;
            }

            for (int j = 0; j < 26; j++) {
                lengths[i] += (((long) alphabetCounts[i] * exponentiatedMatrix[i][j]) % MOD);
            }
        }

        for (long length : lengths) {
            answer = (answer + length) % MOD;
        }

        return (int) answer;
    }

    private int[][] getTransformationMatrix(final List<Integer> nums) {
        int[][] matrix = new int[26][26];

        for (int i = 0; i < 26; i++) {
            for (int step = 1; step <= nums.get(i); step++) {
                matrix[i][(i + step) % 26]++;
            }
        }

        return matrix;
    }

    private int[][] multiplyMatrix(final int[][] primary, final int[][] secondary) {
        int[][] matrix = new int[26][26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    matrix[i][j] = (int) ((matrix[i][j] + (long) primary[i][k] * secondary[k][j]) % MOD);
                }
            }
        }

        return matrix;
    }

    private int[][] identityMatrix() {
        int[][] matrix = new int[26][26];

        for (int i = 0; i < 26; i++) {
            matrix[i][i] = 1;
        }

        return matrix;
    }

    private int[][] exponentiateMatrix(final int[][] matrix, final int n) {
        if (n == 0) {
            return identityMatrix();
        } else if (n % 2 == 1) {
            return multiplyMatrix(matrix, exponentiateMatrix(matrix, n - 1));
        }

        return exponentiateMatrix(multiplyMatrix(matrix, matrix), n / 2);
    }
}


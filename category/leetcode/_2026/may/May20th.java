package category.leetcode._2026.may;

public class May20th {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] count = new int[51];
        int n = A.length;
        int accumulate = 0;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            if (++count[A[i]] == 2) {
                accumulate++;
            }

            if (++count[B[i]] == 2) {
                accumulate++;
            }

            answer[i] = accumulate;
        }

        return answer;
    }
}

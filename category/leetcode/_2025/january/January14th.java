package category.leetcode._2025.january;

public class January14th {

    public int[] findThePrefixCommonArray(final int[] A, final int[] B) {
        int length = A.length;
        int[] counts = new int[length + 1];
        int[] answer = new int[length];
        int prefixCommonSum = 0;

        for (int i = 0; i < length; i++) {
            if (++counts[A[i]] == 2) {
                prefixCommonSum++;
            }
            if (++counts[B[i]] == 2) {
                prefixCommonSum++;
            }

            answer[i] = prefixCommonSum;
        }

        return answer;
    }
}

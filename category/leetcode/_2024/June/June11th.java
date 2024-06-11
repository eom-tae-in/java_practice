package category.leetcode._2024.June;

public class June11th {

    public int[] relativeSortArray(final int[] arr1, final int[] arr2) {
        int n = arr1.length;
        int[] counts = new int[1001];
        int[] answer = new int[n];
        for (int num : arr1) {
            counts[num]++;
        }

        int index = 0;
        for (int num : arr2) {
            while (counts[num]-- > 0) {
                answer[index++] = num;
            }
        }

        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                answer[index++] = i;
            }
        }

        return answer;
    }
}

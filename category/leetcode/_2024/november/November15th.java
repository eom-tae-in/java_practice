package category.leetcode._2024.november;

public class November15th {

    public int findLengthOfShortestSubarray(final int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        int answer = Math.min(n - 1 - left, right);
        int i = left;
        int j = n - 1;

        while (i >= 0 && j >= right && i < j) {
            if (arr[i] <= arr[j]) {
                j--;
            } else {
                i--;
            }
            answer = Math.min(answer, j - i);
        }

        return answer;
    }
}

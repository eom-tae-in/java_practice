package category.leetcode._2024.may;

public class May2nd {

    public int findMaxK(final int[] nums) {
        int answer = -1;
        int[] arr = new int[1001];
        for (int num : nums) {
            int absNums = Math.abs(num);
            if (arr[absNums] == -num) {
                answer = Math.max(answer, absNums);
            }
            arr[absNums] = num;
        }

        return answer;
    }
}

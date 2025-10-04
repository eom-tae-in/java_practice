package category.leetcode._2025.october;

public class October4th {

    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            answer = Math.max(answer, minHeight * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}

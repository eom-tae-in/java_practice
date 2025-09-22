package category.leetcode._2025.september;

public class September22nd {

    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int maxFreq = 0;
        int answer = 0;

        for (int num : nums) {
            count[num]++;
            maxFreq = Math.max(maxFreq, count[num]);
        }

        for (int c : count) {
            if (c == maxFreq) {
                answer += c;
            }
        }

        return answer;
    }
}

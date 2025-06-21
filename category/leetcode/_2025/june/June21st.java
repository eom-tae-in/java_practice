package category.leetcode._2025.june;

public class June21st {

    public int minimumDeletions(String word, int k) {
        int answer = Integer.MAX_VALUE;
        int[] count = new int[26];

        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int minFreq : count) {
            if (minFreq == 0) {
                continue;
            }

            int deleteCount = 0;

            for (int freq : count) {
                if (freq == 0) {
                    continue;
                }

                if (freq < minFreq) {
                    deleteCount += freq;
                } else {
                    deleteCount += Math.max(0, freq - (minFreq + k));
                }
            }

            answer = Math.min(answer, deleteCount);
        }

        return answer;
    }
}

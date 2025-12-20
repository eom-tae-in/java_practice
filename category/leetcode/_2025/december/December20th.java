package category.leetcode._2025.december;

public class December20th {

    public int minDeletionSize(String[] strs) {
        int answer = 0;
        int n = strs[0].length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}

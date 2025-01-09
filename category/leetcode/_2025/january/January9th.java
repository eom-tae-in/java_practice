package category.leetcode._2025.january;

public class January9th {

    public int prefixCount(final String[] words, final String pref) {
        int answer = 0;

        for (String word : words) {
            if (word.startsWith(pref)) {
                answer++;
            }
        }

        return answer;
    }
}

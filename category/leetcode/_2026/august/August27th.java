package category.leetcode._2026.august;

public class August27th {

    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        int idx = 0;

        while (idx < target.length()) {
            char curr = target.charAt(idx);

            if (count[curr - 'a'] <= 0) {
                break;
            }

            answer.append(curr);
            count[curr - 'a']--;
            idx++;
        }

        if (answer.length() < target.length()) {
            int larger = findLarger(target.charAt(idx) - 'a', count);

            if (larger != -1) {
                answer.append((char) (larger + 'a'));
                count[larger]--;
                appendAscending(answer, count);

                return answer.toString();
            }
        }

        for (int i = answer.length() - 1; i >= 0; i--) {
            int last = answer.charAt(i) - 'a';
            count[last]++;
            answer.deleteCharAt(i);
            int larger = findLarger(target.charAt(i) - 'a', count);

            if (larger != -1) {
                answer.append((char) (larger + 'a'));
                count[larger]--;
                appendAscending(answer, count);

                return answer.toString();
            }
        }

        return "";
    }

    private void appendAscending(StringBuilder answer, int[] count) {
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                answer.append((char) (i + 'a'));
                count[i]--;
            }
        }
    }

    private int findLarger(int curr, int[] count) {
        for (int i = curr + 1; i < 26; i++) {
            if (count[i] > 0) {
                return i;
            }
        }

        return -1;
    }
}

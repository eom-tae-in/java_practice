package category.leetcode._2026.june;

public class June22nd {

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        for (char ch : text.toCharArray()) {
            count[ch - 'a']++;
        }

        int answer = text.length();
        String one = "abn";
        String two = "lo";

        for (int i = 0; i < one.length(); i++) {
            answer = Math.min(answer, count[one.charAt(i) - 'a']);
        }

        for (int i = 0; i < two.length(); i++) {
            answer = Math.min(answer, count[two.charAt(i) - 'a'] / 2);
        }

        return answer;
    }
}

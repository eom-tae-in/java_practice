package category.leetcode._2025.may;

public class May13th {

    public int lengthAfterTransformations(final String s, final int t) {
        int mod = 1_000_000_007;
        int[] alphabets = new int[26];

        for (char ch : s.toCharArray()) {
            alphabets[ch - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int[] current = new int[26];

            for (int j = 0; j < 26; j++) {
                int currentCount = alphabets[j];

                if (j == 25) {
                    current[0] = (currentCount + current[0]) % mod;
                    current[1] = (currentCount + current[1]) % mod;
                } else {
                    current[j + 1] = currentCount % mod;
                }
            }

            alphabets = current;
        }

        int answer = 0;

        for (int alphabet : alphabets) {
            answer = (answer + alphabet) % mod;
        }

        return answer;
    }
}

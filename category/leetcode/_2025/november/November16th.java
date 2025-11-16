package category.leetcode._2025.november;

public class November16th {

    public int numSub(String s) {
        int answer = 0;
        int mod = 1_000_000_007;
        int ones = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
                answer = (answer + ones) % mod;
            } else {
                ones = 0;
            }
        }

        return answer;
    }
}

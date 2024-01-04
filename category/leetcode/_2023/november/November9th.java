package category.leetcode._2023.november;

public class November9th {

    public int countHomogenous(String s) {
        int mod = 1_000_000_007;
        int ans = 0;
        int count = 0;
        char current = 'A';

        for (char ch : s.toCharArray()) {
            count = current == ch ? count + 1 : 1;
            current = ch;
            ans += count;
            ans %= mod;
        }

        return ans;
    }
}

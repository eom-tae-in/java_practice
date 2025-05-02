package category.leetcode._2025.may;

public class May2nd {

    public String pushDominoes(final String dominoes) {
        char[] s = dominoes.toCharArray();
        int left = -1;
        int right = -1;

        for (int i = 0; i <= dominoes.length(); i++) {
            if (i == dominoes.length() || s[i] == 'R') {
                if (left < right) {
                    while (right < i) {
                        s[right++] = 'R';
                    }
                }

                right = i;
            } else if (s[i] == 'L') {
                if (right < left || left == -1 && right == -1) {
                    if (left == -1) {
                        left++;
                    }

                    while (left < i) {
                        s[left++] = 'L';
                    }
                } else {
                    int l = right + 1;
                    int r = i - 1;

                    while (l < r) {
                        s[l++] = 'R';
                        s[r--] = 'L';
                    }
                }

                left = i;
            }
        }

        return new String(s);
    }
}

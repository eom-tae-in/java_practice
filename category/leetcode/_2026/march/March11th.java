package category.leetcode._2026.march;

public class March11th {

    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        int num = n;

        while (num > 0) {
            count++;
            num /= 2;
        }

        int max = (int) Math.pow(2, count) - 1;

        return n ^ max;
    }
}

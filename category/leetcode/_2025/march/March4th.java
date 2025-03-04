package category.leetcode._2025.march;

public class March4th {

    public boolean checkPowersOfThree(int n) {
        int num = n;
        int count = 0;

        while (num >= 3) {
            num /= 3;
            count++;
        }

        for (int i = count; i >= 0; i--) {
            int current = (int) Math.pow(3, i);

            if (n >= current) {
                n -= current;
            }
        }

        return n == 0;
    }
}

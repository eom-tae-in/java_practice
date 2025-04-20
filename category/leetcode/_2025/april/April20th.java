package category.leetcode._2025.april;

public class April20th {

    public int numRabbits(final int[] answers) {
        int ans = 0;
        int[] count = new int[1000];

        for (int answer : answers) {
            if (count[answer] % (answer + 1) == 0) {
                ans += answer + 1;
            }

            ++count[answer];
        }

        return ans;
    }
}

package category.leetcode._2024.july;

public class July29th {
    public int numTeams(final int[] rating) {
        int count = 0;
        int n = rating.length;
        for (int i = 1; i < n - 1; i++) {
            int current = rating[i];
            int leftLess = 0;
            int leftGreater = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (current > rating[j]) {
                    leftLess++;
                } else if (current < rating[j]) {
                    leftGreater++;
                }
            }
            int rightLess = 0;
            int rightGreater = 0;
            for (int j = i + 1; j < n; j++) {
                if (current > rating[j]) {
                    rightLess++;
                } else if (current < rating[j]) {
                    rightGreater++;
                }
            }
            count += leftLess * rightGreater + leftGreater * rightLess;
        }

        return count;
    }
}

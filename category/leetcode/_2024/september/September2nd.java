package category.leetcode._2024.september;

public class September2nd {

    public int chalkReplacer(final int[] chalk, final int k) {
        int studentsSum = 0;
        int n = chalk.length;
        for (int i = 0; i < n; i++) {
            studentsSum += chalk[i];
            if (studentsSum > k) {
                return i;
            }
        }
        int rest = k % studentsSum;
        for (int i = 0; i < n; i++) {
            rest -= chalk[i];
            if (rest < 0) {
                return i;
            }
        }

        return 0;
    }
}

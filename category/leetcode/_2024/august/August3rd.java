package category.leetcode._2024.august;

public class August3rd {

    public boolean canBeEqual(final int[] target, final int[] arr) {
        int[] count = new int[1001];
        for (int num : target) {
            count[num]++;
        }
        for (int num : arr) {
            if (count[num] == 0) {
                return false;
            } else {
                count[num]--;
            }
        }
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}

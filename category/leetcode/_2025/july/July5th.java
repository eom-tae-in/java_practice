package category.leetcode._2025.july;

public class July5th {

    public int findLucky(int[] arr) {
        int arrLength = arr.length;
        int[] count = new int[arrLength + 1];

        for (int num : arr) {
            if (num <= arrLength) {
                count[num]++;
            }
        }

        for (int i = arrLength; i > 0; i--) {
            if (i == count[i]) {
                return i;
            }
        }

        return -1;
    }
}

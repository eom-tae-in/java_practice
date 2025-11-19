package category.leetcode._2025.november;

public class November19th {

    public int findFinalValue(int[] nums, int original) {
        int threshold = 1001;
        boolean[] visited = new boolean[threshold];

        for (int num : nums) {
            visited[num] = true;
        }

        while (original < threshold && visited[original]) {
            original *= 2;
        }

        return original;
    }
}

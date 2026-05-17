package category.leetcode._2026.may;

public class May17th {

    public boolean canReach(int[] arr, int start) {
        boolean[] seen = new boolean[arr.length];

        return dfs(start, arr, seen);
    }

    private boolean dfs(int idx, int[] arr, boolean[] seen) {
        if (idx < 0 || idx >= arr.length || seen[idx]) {
            return false;
        }

        if (arr[idx] == 0) {
            return true;
        }

        seen[idx] = true;

        return dfs(idx + arr[idx], arr, seen) || dfs(idx - arr[idx], arr, seen);
    }
}

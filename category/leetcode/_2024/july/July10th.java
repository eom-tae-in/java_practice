package category.leetcode._2024.july;

public class July10th {

    public int minOperations(final String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.startsWith("..")) {
                if (depth > 0) {
                    depth--;
                }
            } else {
                if (!log.startsWith(".")) {
                    depth++;
                }
            }
        }

        return depth;
    }
}

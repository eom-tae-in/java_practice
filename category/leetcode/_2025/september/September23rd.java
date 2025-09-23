package category.leetcode._2025.september;

public class September23rd {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);

        for (int i = 0; i < n; i++) {
            int num1 = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            int num2 = i >= v2.length ? 0 : Integer.parseInt(v2[i]);

            if (num1 > num2) {
                return 1;
            }

            if (num1 < num2) {
                return -1;
            }
        }

        return 0;
    }
}

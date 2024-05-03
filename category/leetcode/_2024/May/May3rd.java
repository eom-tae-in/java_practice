package category.leetcode._2024.May;

public class May3rd {

    public int compareVersion(final String version1, final String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int length = Math.max(version1Array.length, version2Array.length);

        for (int i = 0; i < length; ++i) {
            Integer v1 = i < version1Array.length ? Integer.parseInt(version1Array[i]) : 0;
            Integer v2 = i < version2Array.length ? Integer.parseInt(version2Array[i]) : 0;
            int result = v1.compareTo(v2);
            if (result != 0) {
                return result;
            }
        }

        return 0;
    }
}

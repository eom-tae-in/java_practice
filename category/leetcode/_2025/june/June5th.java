package category.leetcode._2025.june;

public class June5th {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind unionFind = new UnionFind(26);
        int loopCount = s1.length();

        for (int i = 0; i < loopCount; i++) {
            unionFind.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : baseStr.toCharArray()) {
            stringBuilder.append((char) ('a' + unionFind.find(ch - 'a')));
        }

        return stringBuilder.toString();
    }

    private static class UnionFind {

        private final int[] ids;

        private UnionFind(int n) {
            ids = new int[n];

            for (int i = 0; i < n; i++) {
                ids[i] = i;
            }
        }

        private void union(int u, int v) {
            int findU = find(u);
            int findV = find(v);

            if (findU > findV) {
                ids[findU] = findV;
            } else if (findU < findV) {
                ids[findV] = findU;
            }
        }

        private int find(int n) {
            if (ids[n] == n) {
                return n;
            }

            return ids[n] = find(ids[n]);
        }
    }
}

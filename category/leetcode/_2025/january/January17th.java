package category.leetcode._2025.january;

public class January17th {

    public boolean doesValidArrayExist(final int[] derived) {
        int current = 0;

        for (int num : derived) {
            current ^= num;
        }

        return current == 0;
    }
}

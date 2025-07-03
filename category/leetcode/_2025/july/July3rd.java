package category.leetcode._2025.july;

public class July3rd {

    public char kthCharacter(int k) {
        return (char) ('a' + Integer.bitCount(k - 1));
    }
}

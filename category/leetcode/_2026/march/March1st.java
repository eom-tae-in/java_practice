package category.leetcode._2026.march;

public class March1st {

    public int minPartitions(String n) {
        return Character.getNumericValue(n.chars().max().getAsInt());
    }
}

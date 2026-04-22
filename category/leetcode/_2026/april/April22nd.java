package category.leetcode._2026.april;

import java.util.ArrayList;
import java.util.List;

public class April22nd {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String q : queries) {
            for (String d : dictionary) {
                if (diffAtMostTwo(q, d)) {
                    result.add(q);
                    break;
                }
            }
        }

        return result;
    }

    private boolean diffAtMostTwo(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;

                if (diff > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}

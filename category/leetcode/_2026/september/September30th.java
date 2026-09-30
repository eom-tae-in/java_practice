package category.leetcode._2026.september;

public class September30th {

    public int[] maxDepthAfterSplit(String seq) {
        int[] answer = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);

            if (c == '(') {
                depth++;
                answer[i] = depth % 2;
            } else {
                answer[i] = depth % 2;
                depth--;
            }
        }

        return answer;
    }
}

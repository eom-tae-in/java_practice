package Category.leetcode.August;

import java.util.ArrayDeque;
import java.util.Deque;

public class August22rd {
    public String convertToTitle(int columnNumber) {
        Deque<Integer> alphabets = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int currentNumber = columnNumber;
        while (currentNumber > 26) {
            int restNumber = (currentNumber - 1) % 26;
            alphabets.offerFirst(restNumber);
            currentNumber = (currentNumber - 1) / 26;
        }
        alphabets.offerFirst(currentNumber - 1);
        for (int alphabet : alphabets) {
            sb.append((char) (alphabet + 'A'));
        }

        return sb.toString();
    }
}

package Category.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class July20rd {

    public int[] asteroidCollision(final int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean isLastCompareEquals;

        for (int asteroid : asteroids) {
            isLastCompareEquals = false;
            while (!deque.isEmpty()) {
                int peekedAsteroid = deque.peekLast();
                if (asteroid < 0 && peekedAsteroid > 0) {
                    int asteroidSize = Math.abs(asteroid);
                    int peekedAsteroidSize = Math.abs(peekedAsteroid);
                    if (asteroidSize > peekedAsteroidSize) {
                        deque.removeLast();
                    }
                    if (asteroidSize == peekedAsteroidSize) {
                        deque.removeLast();
                        isLastCompareEquals = true;
                        break;
                    }
                    if (asteroidSize < peekedAsteroidSize) {
                        break;
                    }
                } else {
                    deque.add(asteroid);
                }
            }
            if (deque.size() == 0 && !isLastCompareEquals) {
                deque.add(asteroid);
            }
        }
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}

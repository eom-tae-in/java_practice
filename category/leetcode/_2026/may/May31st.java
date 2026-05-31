package category.leetcode._2026.may;

import java.util.Arrays;

public class May31st {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;

        for (int asteroid : asteroids) {
            if (currMass < asteroid) {
                return false;
            }

            currMass += asteroid;
        }

        return true;
    }
}

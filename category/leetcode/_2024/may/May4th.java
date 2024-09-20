package category.leetcode._2024.may;

import java.util.Arrays;

public class May4th {

    public int numRescueBoats(final int[] people, final int limit) {
        int answer = 0;
        Arrays.sort(people);

        for (int left = 0, right = people.length - 1; left <= right; answer++) {
            int remainder = limit - people[right--];
            if (people[left] <= remainder) {
                left++;
            }
        }

        return answer;
    }
}

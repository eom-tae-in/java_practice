package category.leetcode._2026.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class April1st {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> answer = new ArrayList<>();
        Robot[] robots = new Robot[positions.length];
        List<Robot> stack = new ArrayList<>();

        for (int i = 0; i < positions.length; ++i) {
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }

        Arrays.sort(robots, Comparator.comparingInt((Robot robot) -> robot.position));

        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.add(robot);
                continue;
            }

            while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R' && robot.health > 0) {
                if (stack.get(stack.size() - 1).health == robot.health) {
                    stack.remove(stack.size() - 1);
                    robot.health = 0;
                } else if (stack.get(stack.size() - 1).health < robot.health) {
                    stack.remove(stack.size() - 1);
                    robot.health -= 1;
                } else {
                    stack.get(stack.size() - 1).health -= 1;
                    robot.health = 0;
                }
            }

            if (robot.health > 0) {
                stack.add(robot);
            }
        }

        stack.sort(Comparator.comparingInt((Robot robot) -> robot.index));

        for (Robot robot : stack) {
            answer.add(robot.health);
        }

        return answer;
    }

    private static class Robot {

        private int position;
        private int health;
        private int index;
        private char direction;

        private Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }
}

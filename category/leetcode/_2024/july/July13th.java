package category.leetcode._2024.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class July13th {

    public List<Integer> survivedRobotsHealths(final int[] positions, final int[] healths, final String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        List<Robot> stack = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(i, positions[i], directions.charAt(i), healths[i]);
        }
        Arrays.sort(robots, Comparator.comparingInt(Robot::getPosition));
        for (Robot robot : robots) {
            if (robot.getDirection() == 'R') {
                stack.add(robot);
                continue;
            }
            while (!stack.isEmpty() && stack.get(stack.size() - 1).getDirection() == 'R' && !robot.isDestroy()) {
                int lastIndex = stack.size() - 1;
                Robot prevRobot = stack.get(lastIndex);
                int prevRobotHealth = prevRobot.getHealth();
                int currentRobotHealth = robot.getHealth();
                if (prevRobotHealth > currentRobotHealth) {
                    prevRobot.hurt();
                    robot.destroy();
                } else if (prevRobotHealth == currentRobotHealth) {
                    prevRobot.destroy();
                    stack.remove(lastIndex);
                    robot.destroy();
                } else {
                    prevRobot.destroy();
                    stack.remove(lastIndex);
                    robot.hurt();
                }
            }
            if (robot.getHealth() > 0) {
                stack.add(robot);
            }
        }
        stack.sort(Comparator.comparingInt(Robot::getIndex));

        for (Robot robot : stack) {
            answer.add(robot.getHealth());
        }

        return answer;
    }
}

class Robot {
    private final int index;
    private final int position;
    private final char direction;
    private int health;

    Robot(final int index, final int position, final char direction, final int health) {
        this.index = index;
        this.position = position;
        this.direction = direction;
        this.health = health;
    }

    int getIndex() {
        return index;
    }

    int getPosition() {
        return position;
    }

    char getDirection() {
        return direction;
    }

    int getHealth() {
        return health;
    }

    void hurt() {
        health--;
    }

    void destroy() {
        health = 0;
    }

    boolean isDestroy() {
        return health <= 0;
    }
}

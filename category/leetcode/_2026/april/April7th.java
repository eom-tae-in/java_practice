package category.leetcode._2026.april;

public class April7th {

    private static class Robot {

        private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        private static final String[] DIR_NAMES = {"East", "North", "West", "South"};

        private final int width;
        private final int height;
        private final int perimeter;
        private int x;
        private int y;
        private int dir;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.perimeter = 2 * (width + height) - 4;
            this.x = 0;
            this.y = 0;
            this.dir = 0;
        }

        public void step(int num) {
            int move = num % perimeter;

            if (move == 0 && num > 0) {
                move = perimeter;
            }

            while (move > 0) {
                int dist = distanceToWall();

                if (dist >= move) {
                    x += DIRS[dir][0] * move;
                    y += DIRS[dir][1] * move;
                    move = 0;
                } else {
                    x += DIRS[dir][0] * dist;
                    y += DIRS[dir][1] * dist;
                    move -= dist;
                    dir = (dir + 1) % 4;
                }
            }
        }

        public int[] getPos() {
            return new int[]{x, y};
        }

        public String getDir() {
            return DIR_NAMES[dir];
        }

        private int distanceToWall() {
            if (dir == 0) {
                return width - 1 - x;
            }

            if (dir == 1) {
                return height - 1 - y;
            }

            if (dir == 2) {
                return x;
            }

            return y;
        }
    }
}

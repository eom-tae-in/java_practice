package Category.programmers;

import java.util.*;

public class pickUpItems {

    static int[][] ch;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static ArrayList<int[]> list;
    static class Work {
        int y;
        int x;
        int move;
        public Work(int y, int x, int move) {
            this.y = y;
            this.x = x;
            this.move = move;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] rectangle = new int[num][4];
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[0].length; j++) {
                rectangle[i][j] = sc.nextInt();
            }
        }
        int cX = sc.nextInt();
        int cY = sc.nextInt();
        int iX = sc.nextInt();
        int iY = sc.nextInt();
        System.out.println(solution(rectangle, cX, cY, iX, iY));
        for (int[] arr : ch) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int solution(int[][] rectangle, int cX, int cY, int iX, int iY) {
        list = new ArrayList<>();
        for (int i = 0; i < rectangle.length; i++) {
            list.add(new int[4]);
            for (int j = 0; j < 4; j++) {
                list.get(i)[j] = rectangle[i][j] * 2;
            }
        }
        cX *= 2;
        cY *= 2;
        iY *= 2;
        iX *= 2;
        ch = new int[102][102];
        chInit();
        return bfs(rectangle, cY, cX, iY, iX);
    }

    public static void chInit() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.get(i)[0]; j <= list.get(i)[2]; j++) {
                ch[list.get(i)[1]][j] = -1;
                ch[list.get(i)[3]][j] = -1;
            }
            for (int j = list.get(i)[1]; j <= list.get(i)[3]; j++) {
                ch[j][list.get(i)[0]] = -1;
                ch[j][list.get(i)[2]] = -1;
            }
        }
    }

    public static int bfs(int[][] rectangle, int cY, int cX, int iY, int iX) {
        Queue<Work> queue = new LinkedList<>();
        queue.add(new Work(cY, cX, 0));
        while (!queue.isEmpty()) {
            Work cd = queue.poll();
            int pY = cd.y;
            int pX = cd.x;
            if (pY == iY && pX == iX) {
                return cd.move / 2;
            }
            for (int i = 0; i < 4; i++) {
                int nY = pY + dy[i];
                int nX = pX + dx[i];
                if (ch[nY][nX] == -1 && checkEdge(rectangle,nY, nX)) {
                    ch[nY][nX] = 1;
                    queue.add(new Work(nY, nX, cd.move + 1));
                }
            }
        }
        return 0;
    }

    public static boolean checkEdge(int[][] rectangle, int cY, int cX) {
        for (int[] arr : rectangle) {
            if (cX > (arr[0] * 2) && cY > (arr[1] * 2) && cX < (arr[2] * 2) && cY < (arr[3] * 2)) {
                return false;
            }
        }
        return true;
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    public int x, y;
    Point(int y, int x){
        this.x=x;
        this.y=y;
    }
}
class Main {
    static int m, n, answer;
    static int[][] graph;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }
        BFS();

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(-1);
        } else if (answer == 1){
            System.out.println(0);
        } else {
            System.out.println(answer-1);
        }

    }

    public static void BFS() {

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int dx = p.x + disX[j];
                    int dy = p.y + disY[j];

                    if (dx >= 0 && dx < m && dy >= 0 && dy < n
                            && graph[dy][dx] == 0) {
                        q.offer(new Point(dy, dx));
                        graph[dy][dx] = 1;
                    }
                }
            }
            answer++;
        }
    }
}
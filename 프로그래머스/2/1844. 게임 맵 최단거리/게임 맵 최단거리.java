import java.util.*;
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static int[][] answer, map;
    static boolean[][] visited;
    static int[] disX = {1, -1, 0, 0};
    static int[] disY = {0, 0, 1, -1};
    static int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        map = maps;
        answer = new int[n][m];
        visited = new boolean[n][m];
        visited[0][0] = true;
        BFS(0, 0);
        if (answer[n-1][m-1] == 0) {
            return -1;
        }
        return answer[n-1][m-1];
    }
    
    public static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        answer[0][0] = 1;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + disX[i];
                int ny = p.y + disY[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    answer[nx][ny] = answer[p.x][p.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
    
    
}
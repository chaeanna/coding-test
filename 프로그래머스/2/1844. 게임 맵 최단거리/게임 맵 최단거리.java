import java.util.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static int[] disX = {0, 0, 1, -1};
    static int[] disY = {1, -1, 0, 0};
    static int[][] visited;
    static int[][] map;
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        BFS(maps, 0, 0);
        answer = visited[maps.length-1][maps[0].length-1];
        return answer == 0 ? -1 : answer;
    }
    
    public static void BFS(int[][] maps, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = 1;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                // 이동할 위치
                int nx = p.x + disX[i];
                int ny = p.y + disY[i];
                
                if (validLoc(nx, ny) 
                    && maps[nx][ny] == 1
                    && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    q.offer(new Point(nx, ny));
                }
                
            }
        }
        
    }
    
    public static boolean validLoc(int x, int y) {
        return x >= 0 && x < visited.length && y >= 0 && y < visited[0].length;
    }
}
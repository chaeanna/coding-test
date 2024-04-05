import java.io.*;
import java.util.*;

class Main {
    static int n, count;
    static int[][] house;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        house = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        visited = new boolean[n][n];
        visited[0][0] = true;
        DFS(0, 1, 'w'); // w : 가로, h : 세로, c : 대각선

        System.out.println(count);
    }

    public static void DFS(int x, int y, char type) {
        if (x >= n-1 && y >= n-1) {
            count++;
            return;
        }

        //가로
        if (type == 'w') {
            //오른쪽
            if (validRight(x, y)) {
                DFS(x, y+1, 'w');
            }
            //오른쪽 대각선
            if (validCross(x, y)) {
                if (type != 'c') {
                    DFS(x + 1, y + 1, 'c');
                } else {
                    DFS(x + 1, y, 'c');
                }
            }
        }
        //세로
        else if (type == 'h') {
            //오른쪽 대각선
            if (validCross(x, y)) {
                DFS(x + 1, y + 1, 'c');
            }
            //아래
            if (validDown(x, y)) {
                DFS(x + 1, y, 'h');
            }

        }
        //대각선
        else {
            //오른쪽
            if (validRight(x, y)) {
                DFS(x, y+1, 'w');
            }
            //오른쪽 대각선
            if (validCross(x, y)) {
                DFS(x + 1, y + 1, 'c');
            }
            //아래
            if (validDown(x, y)) {
                DFS(x + 1, y, 'h');
            }

        }
    }

    public static boolean validRight(int x, int y) {
        if (y + 1 < n && house[x][y + 1] == 0) {
            return true;
        }
        return false;
    }
    public static boolean validDown(int x, int y) {
        if (x + 1 < n && house[x + 1][y] == 0) {
            return true;
        }
        return false;
    }
    public static boolean validCross(int x, int y) {
        if (x + 1 < n && y + 1 < n
                && house[x][y + 1] == 0
                && house[x + 1][y] == 0
                && house[x + 1][y + 1] == 0) {
            return true;
        }
        return false;
    }
}
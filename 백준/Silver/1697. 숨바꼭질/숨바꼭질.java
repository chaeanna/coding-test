import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int n, k, answer;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[100001];
        BFS();
        System.out.println(answer-1);
    }

    public static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        boolean flag = false;
        while (!flag) {
            int len = q.size();
            answer++;
            for (int i = 0; i < len; i++) {
                int m = q.poll();
                if (!visited[m]) {
                    visited[m] = true;
                    if (m == k) {
                        flag = true;
                        break;
                    }
                    if (m - 1 >= 0 && !visited[m - 1]) {
                        q.offer(m-1);
                    }
                    if (m + 1 <= 100000 && !visited[m + 1]) {
                        q.offer(m+1);
                    }
                    if (m * 2 <= 100000 && !visited[m * 2]) {
                        q.offer(m*2);
                    }
                }
            }

        }
    }
}
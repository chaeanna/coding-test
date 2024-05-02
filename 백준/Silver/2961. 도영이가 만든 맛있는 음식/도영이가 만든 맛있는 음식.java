import java.io.*;
import java.util.*;


class Food {
    int s, b;
    public Food(int s, int b) {
        this.s = s;
        this.b = b;
    }
}
class Main {
    static Food[] food;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        food = new Food[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            food[i] = new Food(s, b);
        }
        visited = new boolean[N];
        List<Integer> list = new ArrayList<>();
        DFS(food, list);

        System.out.println(min);
    }

    public static void DFS(Food[] food, List<Integer> list) {
        if (list.size() > 0) {
            int s = 1;
            int b = 0;
            for (Integer i : list) {
                s *= food[i].s;
                b += food[i].b;
            }
            min = Math.min(min, Math.abs(s-b));
        }

        for (int i = 0; i < food.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                DFS(food, list);
                list.remove(Integer.valueOf(i));
                visited[i] = false;
            }
        }
    }
}
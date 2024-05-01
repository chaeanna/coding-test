import java.util.*;

class Solution {
    static boolean[] visited;
    static List<ArrayList<Integer>> list;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int check = computers[i][j];
                if (check == 1) {
                    list.get(i).add(j);
                } 
            }
        }
        
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                BFS(i);
                answer++;
            }
        }
        return answer;
    }
    
    public static void BFS(int computer) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(computer);
        
        while (!q.isEmpty()) {
            int com = q.poll();
            for (int i : list.get(com)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
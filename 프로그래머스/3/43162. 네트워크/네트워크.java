import java.util.*;

class Solution {
    static List<Set<Integer>> network;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        network = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            network.add(new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    network.get(i).add(j);
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
            for (int i : network.get(com)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }   
            }
        }
        
    }
}
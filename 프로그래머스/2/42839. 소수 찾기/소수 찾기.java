import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] piece;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        piece = numbers.split("");
        visited = new boolean[numbers.length()];
        
        DFS("", 0);
        return set.size();
    }
    
    public void DFS(String str, int idx) {
        if (!str.equals("")) {
            int num = Integer.parseInt(str);
            if (isPrime(num)) {
                set.add(num);
            }
        }
        if (idx == piece.length) {
            return;
        }
        
        for (int i = 0; i < piece.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(str+piece[i], idx+1);
                visited[i] = false;
            } 
        }
        
    }
    
    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
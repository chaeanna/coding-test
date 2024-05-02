import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        DFS(numbers, "");
        answer = set.size();
        return answer;
    }
    
    public static void DFS(String numbers, String str) {
        if (!str.equals("")) {
            int num = Integer.parseInt(str);
            if (isPrime(num)) {
                set.add(num);
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(numbers, str+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
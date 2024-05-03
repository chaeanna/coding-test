import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        DFS(words, begin, target, 0);
        return answer;
    }
    
    public static void DFS(String[] words, String begin, String target, int count) {
        if (begin.equals(target)) {
            answer = count;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                String str = words[i];
                int cnt = countWord(begin, str);
                if (cnt > 0) {
                    visited[i] = true;
                    DFS(words, str, target, count+1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static int countWord(String begin, String target) {
        int cnt = 0;
        for (int j = 0; j < target.length(); j++) {
            char c = target.charAt(j);
            if (c == begin.charAt(j)) {
                cnt++;
            }
        }
        
        return cnt == begin.length()-1 ? 1 : 0;
    }
}
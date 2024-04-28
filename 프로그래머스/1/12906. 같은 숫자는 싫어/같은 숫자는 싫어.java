import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        boolean[] visited = new boolean[10];
        Queue<Integer> q = new LinkedList<>();
        int before = -1;
        for (int i = 0; i < arr.length; i++) {
            if (before != arr[i]) {
                q.offer(arr[i]);
                before = arr[i];
            }
        }
        
        int len = q.size();
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            int num = q.poll();
            answer[i] = num;
        }
        
        return answer;
    }
}
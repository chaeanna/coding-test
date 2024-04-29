import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }
        int newScoville = 0;
        while (pq.size() > 1) {
            int s1 = pq.poll();
            if (s1 >= K) {
                break;
            }
            int s2 = pq.poll();
            newScoville = s1 + (s2 * 2);
            pq.offer(newScoville);
            answer++;
        }
        if (pq.peek() < K) {
            answer = -1;
        }
        
        return answer;
    }
}
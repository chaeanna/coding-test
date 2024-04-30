import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int work = 0; // 작업진도
        int time = 0; // 작업일수
        for (int i = 0; i < progresses.length; i++) {
            work = 100 - progresses[i];
            time = (work / speeds[i]) + (work % speeds[i] == 0 ? 0 : 1);
            q.offer(time);
        }
        
        List<Integer> list = new ArrayList<>(); // 각각 배포되는 기능 개수
        while (!q.isEmpty()) {
            int deploy = q.poll();
            int count = 1;
            while (!q.isEmpty()) {
                if (deploy >= q.peek()) {
                    q.poll();
                    count++;
                } else {
                    break;
                }
            }
            
            list.add(count);
        }
        
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
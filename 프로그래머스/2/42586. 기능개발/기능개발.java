import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            // 남은 작업량 계산
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if (remain % speeds[i] != 0) {
                day++;
            }
            
            // 작업량 큐에 넣기
            q.offer(day);
        }
        
        int max = q.poll();
        int count = 1;
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int num = q.poll();
            if (max >= num) {
                count++;
            } else {
                list.add(count);
                count = 1;
                max = num;
            }
        }
        
        list.add(count);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
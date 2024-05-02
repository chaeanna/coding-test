import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); // 번호, 우선순위
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
            q.offer(i);
        }
        List<Integer> priority = new ArrayList<>(map.values());
        Collections.sort(priority, Collections.reverseOrder());
        
        // location 순서 찾기
        while (!q.isEmpty()) {
            int order = priority.get(0);
            int process = q.poll();
            // 해당 우선순위가 아니면 다시 큐에 넣기
            if (map.get(process) != order) {
                q.offer(process);
            } else {
                answer++;
                if (location == process) {
                    return answer;
                }
                // 찾는 프로세스가 아니라면 반복문에서 나오기
                priority.remove(0);
            }
            
        }
        return answer;
    }
}
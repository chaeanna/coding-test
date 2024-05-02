import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int endIdx = 0;
        int endTime = 0;
        
        // jobs 요청이 빠른 순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 작업 소요시간이 짧은 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        
        while (count < jobs.length) {
            // 작업이 끝난 시간까지 들어온 작업 큐에 넣기
            while (endIdx < jobs.length && jobs[endIdx][0] <= endTime) {
                pq.offer(jobs[endIdx++]);
            }
            
            // 큐에 있는 작업 하나씩 진행하기
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                endTime += job[1];
                count++;
                answer += (endTime - job[0]);
            } else {
                // 큐에 있는 작업이 끝나면 새로운 작업부터 시작
                endTime = jobs[endIdx][0];
            }
        }
        
        return answer / jobs.length;
    }
}
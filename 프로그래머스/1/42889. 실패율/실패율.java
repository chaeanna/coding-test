import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        HashMap<Integer, Double> stage = new HashMap<>();
        // i번 스테이지
        for (int i = 0; i < N; i++) {
            int fail = 0;
            int users = 0;
            // 도전 현황
            for (int j = 0; j < stages.length; j++) {
                if(i+1 == stages[j]) {
                    fail++;
                }
                if (i+1 <= stages[j]) {
                    users++;
                }
            }
            if (users == 0) {
                stage.put(i+1, 0.0);
            } else {
                stage.put(i+1, (double) fail / users);
            }
            
        }
        List<Integer> answer = new ArrayList<>(stage.keySet());
        Collections.sort(answer, (v1, v2) -> Double.compare(stage.get(v2), stage.get(v1)));
        
        return answer;
    }
}
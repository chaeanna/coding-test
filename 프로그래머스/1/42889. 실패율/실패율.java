import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 스테이지에 도달한 유저 수
        int count = stages.length;
        
        HashMap<Integer, Double> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            int user = 0;
            for (int j = 0; j < stages.length; j++) {
                // 클리어 못한 유저 수
                if (i == stages[j]) {
                    user++;
                }
            }
            
            // 유저가 없으면 실패율 0
            if (user == 0) {
                map.put(i, (double) 0);
            } else {
                map.put(i, (double) user/count);
                count -= user;
            }
            
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        // 키의 value값을 기준으로 내림차순 정렬
        Collections.sort(list, (v1, v2) -> Double.compare(map.get(v2), map.get(v1)));
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
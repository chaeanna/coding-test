import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int count = stages.length;
        HashMap<Integer, Double> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            int user = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {
                    user++;
                }
            }
            if (user == 0) {
                map.put(i, (double) 0);
            } else {
                map.put(i, (double) user/count);
                count -= user;
            }
        }
        
        // for (Map.Entry<Integer, Double> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (v1, v2) -> Double.compare(map.get(v2), map.get(v1)));
        
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
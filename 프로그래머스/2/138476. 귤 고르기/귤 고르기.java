import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        
        Collections.sort(list, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (sum >= k) {
                break;
            }
            
            sum += list.get(i);
            answer++;
        }
        
        return answer;
    }
}

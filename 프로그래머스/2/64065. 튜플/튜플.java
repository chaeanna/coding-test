import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            String num = "";
            // 시작
            if (c == '{') {
                while (true) {
                    idx++; 
                    c = s.charAt(idx);
                    if (c == ',') {
                        int n = Integer.parseInt(num);
                        map.put(n, map.getOrDefault(n, 0) + 1);
                        num = "";
                        continue;
                    } else if (c == '}') {
                        int n = Integer.parseInt(num);
                        map.put(n, map.getOrDefault(n, 0) + 1);
                        break;
                    } else {
                        num += String.valueOf(c);
                    }
                }
            }
            idx++;
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (k1, k2) -> Integer.compare(map.get(k2), map.get(k1)));
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
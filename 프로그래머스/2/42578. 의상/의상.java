import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            // 종류 가짓수
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0) + 1);
        }
        
        // 각 종류의 개수
        Iterator<Integer> it = map.values().iterator();
        
        while (it.hasNext()) {
            // 안 입는 경우까지 포함해서 +1 하기
            answer *= it.next().intValue() + 1;
        }

        // 아무것도 안입었을 경우 -1
        return answer-1;
    }
}
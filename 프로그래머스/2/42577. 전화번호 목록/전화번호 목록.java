import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : phone_book) {
            map.put(s, s.length());
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            int len = map.get(phone_book[i]);
            for (int j = 1; j < len; j++) {
                // map은 중복이 안되므로 조금씩 길이를 늘려가며 접두사 찾기
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return answer;
    }
}
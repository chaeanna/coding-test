import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : phone_book) {
            map.put(s, 0);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            int len = phone_book[i].length();
            for (int j = 0; j < len; j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
}
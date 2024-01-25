import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        String[] str = s.split(" ");
        
        for (int i = 0; i < str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        
        Collections.sort(list);
        answer = String.valueOf(list.get(0)) + " " + String.valueOf(list.get(list.size()-1));
        return answer;
    }
}
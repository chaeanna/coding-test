import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < strings.length; i++) {
            // 해당 인덱스 값을 문자열 앞에 붙이기
            list.add(strings[i].charAt(n) + strings[i]);
        }
        // 정렬
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            // 앞 글자 제외하고 다시 붙이기
            answer[i] = list.get(i).substring(1);
        }
        
        return answer;
    }
}
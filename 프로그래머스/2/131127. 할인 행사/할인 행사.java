import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        String list = "";
        for (int i = 0; i < want.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                list += want[i];
            }
        }
        
        int max = discount.length - 10;
        for (int i = 0; i <= max; i++) {
            String check = list;
            for (int j = i; j < i+10; j++) {
                if (!list.contains(discount[j])) {
                    break;
                } else {
                    check = check.replaceFirst(discount[j], "");
                }
            }
            
            if (check.equals("")) {
                answer++;
            }
        }
        
        return answer;
    }
}
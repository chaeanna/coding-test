import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        boolean flag = false;
        List<String> list = new ArrayList<>();
        int count = 1;
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j <= n; j++) {
                // 중복 체크
                if (list.contains(words[i])) {
                    flag = true;
                    answer[0] = j;
                    answer[1] = count;
                    break;
                } else {
                    // 끝말잇기 체크
                    if (list.size() > 0) {
                        String str = list.get(list.size()-1);
                        char c = str.charAt(str.length()-1);
                        if (c == words[i].charAt(0)) {
                            list.add(words[i]);
                        } else {
                            flag = true;
                            answer[0] = j;
                            answer[1] = count;
                            break;
                        }
                    } else {
                        list.add(words[i]);
                    }
                    
                    if (j != n) {
                        i++;
                    }
                }
            }
            count++;
            
            if (flag) break;
        }

        if (!flag) {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}
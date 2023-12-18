import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        for (int w : win_nums) {
            list.add(w);
        }
        
        int lotto = 0;
        int zero = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (list.contains(lottos[i])) {
                lotto++;
            }
            if (lottos[i] == 0) {
                zero++;
            }
        }
        if (7 - lotto <= 5) {
            answer[1] = 7-lotto;
        } else {
            answer[1] = 6;
        }
        if ((7-(zero+lotto)) <= 5) {
            answer[0] = 7-(zero+lotto);
        } else {
            answer[0] = 6;
        }
        return answer;
    }
}
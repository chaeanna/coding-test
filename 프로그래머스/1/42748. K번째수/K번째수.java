import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] result = new int[commands[i][1] - (commands[i][0]-1)];
            int idx = 0;
            for (int j = commands[i][0] - 1; j <= commands[i][1]-1; j++) {
                result[idx] = array[j];
                idx++;
            }
            Arrays.sort(result);
            answer[i] = result[commands[i][2] - 1];
        }
        return answer;
    }
}
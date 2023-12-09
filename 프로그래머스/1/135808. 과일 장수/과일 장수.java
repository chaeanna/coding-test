import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        List<String> list = new ArrayList<>();
        int length = score.length;
        for (int j = 0; j < score.length / m; j++) {
            length -= m;
            list.add(String.valueOf(score[length] * m));
        }
        for (int i = 0; i < score.length / m; i++) {
            answer += Integer.parseInt(list.get(i));
        }
        return answer;
    }
}
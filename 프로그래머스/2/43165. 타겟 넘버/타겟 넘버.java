import java.util.*;

class Solution {
    static int count, len, targetValue;
    static int[] number;

    public int solution(int[] numbers, int target) {
        len = numbers.length;
        number = numbers;
        targetValue = target;
        DFS(0, 0);
        return count;
    }
    public static void DFS(int level, int idx) {
        if (level == len) {
            int sum = 0;
            for (int i : number) {
                sum += i;
            }
            if (sum == targetValue) {
                count++;
            }
        }
        for (int i = idx; i < len; i++) {
            DFS(level+1, i+1);
            number[i] = number[i] * -1;
            DFS(level+1, i+1);
        }
    }
}
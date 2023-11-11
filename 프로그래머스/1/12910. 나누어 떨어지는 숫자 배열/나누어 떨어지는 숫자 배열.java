import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = new int[arr.length];
        int count = 0;
        Arrays.sort(arr);
        if (divisor == 1) return arr;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[count] = arr[i];
                count++;
            }
        }
        int[] result = new int[count == 0 ? 1 : count];
        if (count == 0) {
            result[0] = -1;
        } else {
            for (int i = 0; i < count; i++) {
                result[i] = answer[i];
            }
        }
        return result;
    }
}
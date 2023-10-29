import java.util.*;

public class Solution {
    public int solution(int n) {
        String str = String.valueOf(n);
        char[] num = str.toCharArray();
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            result += (num[i] - '0');
        }

        return result;
    }
}
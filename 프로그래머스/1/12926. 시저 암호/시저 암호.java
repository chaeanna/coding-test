import java.util.*;

class Solution {
    public String solution(String s, int n) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char st : str) {
            if (st != ' ') {
                int num = (int) st+ n;
                if (num > 122) {
                    num -= 26;
                } else if ((int) st <= 90 && num > 90) {
                    num -= 26;
                } else if (num > 90 && num < 97) {
                    num -= 26;
                }
                st = (char) num;
            }
            sb.append(st);
        }
        return sb.toString();
    }
}
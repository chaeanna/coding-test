class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int sum = 0;
        for (int i = 0; i < a-1; i++) {
            sum += month[i];
        }
        sum += b;
        int r = sum % 7;
        if (r == 0) {
            answer = day[6];
        } else {
            answer = day[(sum % 7) - 1];
        }
        return answer;
    }
}
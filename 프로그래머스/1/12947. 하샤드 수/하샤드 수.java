class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int result = str.charAt(i) - '0';
            sum += result;
        }
        if (x % sum != 0) answer = false;
        return answer;
    }
}
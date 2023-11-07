class Solution {
    public long solution(long n) {
        long answer = -1;
        
        if ((Math.sqrt(n) / (int) Math.sqrt(n)) == 1) {
            long result = (long) Math.sqrt(n) + 1;
            answer = result*result;
            
        }
        
        return answer;
    }
}
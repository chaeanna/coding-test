class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int count = 0;
        
        for (String n : str) {
            if (n.contains(" ")) {
                count = 0;
            } else {
                count++;
            }
            
            if (count % 2 == 0) {
                answer += n.toLowerCase();
            } else {
                answer += n.toUpperCase();
            }
        }
        
        return answer;
    }
}
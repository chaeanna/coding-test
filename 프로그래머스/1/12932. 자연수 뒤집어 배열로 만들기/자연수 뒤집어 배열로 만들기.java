class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        
        int[] num = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            num[i] = str.charAt(str.length()-(i+1))-48;
        }
        
        return num;
        
    }
}
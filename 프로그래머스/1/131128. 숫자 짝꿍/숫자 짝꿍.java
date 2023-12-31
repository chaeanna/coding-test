class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] Xcount = new int[10];
        int[] Ycount = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            Xcount[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            Ycount[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < Math.min(Xcount[i], Ycount[i]); j++) {
                sb.append(i);
            }
        }
        
        if (sb.length() < 1) {
            return "-1";
        } else if (sb.toString().charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
        
    }
}
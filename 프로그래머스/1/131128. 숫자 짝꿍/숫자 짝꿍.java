class Solution {
    public String solution(String X, String Y) {
        int[] xcount = new int[10];
        int[] ycount = new int[10];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < X.length(); i++) {
            xcount[X.charAt(i) - '0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            ycount[Y.charAt(i) - '0']++;
        }
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < Math.min(xcount[i], ycount[i]); j++) {
                sb.append(i);
            }
        }
        
        if (sb.toString().equals("")) {
            return "-1";
        } else if(sb.toString().charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
        
    }
}
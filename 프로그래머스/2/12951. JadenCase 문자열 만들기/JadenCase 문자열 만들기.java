import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.equals(" ")) {
                sb.append(str);
            } else {
                sb.append(str.substring(0, 1).toUpperCase() + str.substring(1));
            }
            
        }
        return sb.toString();
    }
}
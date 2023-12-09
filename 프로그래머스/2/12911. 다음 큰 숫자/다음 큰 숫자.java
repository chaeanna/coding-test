class Solution {
    public int solution(int n) {
        int answer = 0;
        String nstr = String.valueOf(Integer.toBinaryString(n));
        int ncount = 0;
        for (int i = 0; i < nstr.length(); i++) {
            if (nstr.charAt(i) == '1') {
                ncount++;
            }
        }
        int m = n+1;
        while (true) {
            String mstr = String.valueOf(Integer.toBinaryString(m));
            int mcount = 0;
            for (int i = 0; i < mstr.length(); i++) {
                if (mstr.charAt(i) == '1') {
                    mcount++;
                }
            }
            if (mcount == ncount) return m;
            m++;
        }
    }
}
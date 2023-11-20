class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                sb.append(c[i]);
            } else {
                if (c[i] == 'z') {
                    sb.append("0");
                    i += 3;
                } else if (c[i] == 'o') {
                    sb.append("1");
                    i += 2;
                } else if (c[i] == 't') {
                    if (c[i+1] == 'w') {
                        sb.append("2");
                        i += 2;
                    } else {
                        sb.append("3");
                        i += 4;
                    }
                } else if (c[i] == 'f') {
                    if (c[i+1] == 'o') {
                        sb.append("4");
                        i += 3;
                    } else {
                        sb.append("5");
                        i += 3;
                    }
                } else if (c[i] == 's') {
                    if (c[i+1] == 'i') {
                        sb.append("6");
                        i += 2;
                    } else {
                        sb.append("7");
                        i += 4;
                    }
                } else if (c[i] == 'e') {
                    sb.append("8");
                    i += 4;
                } else if (c[i] == 'n') {
                    sb.append("9");
                    i += 3;
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
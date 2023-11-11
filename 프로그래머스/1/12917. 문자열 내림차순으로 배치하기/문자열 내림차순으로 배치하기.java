import java.util.*;
class Solution {
    public String solution(String s) {
        char[] result = s.toCharArray();
        List<String> list = new ArrayList<>();
        List<String> llist = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (result[i] >= 'a' && result[i] <= 'z') {
                list.add(String.valueOf(result[i]));
            } else {
                llist.add(String.valueOf(result[i]));
            }
            
        }
        Collections.sort(list, Collections.reverseOrder());
        Collections.sort(llist, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        for (int i = 0; i < llist.size(); i++) {
            sb.append(llist.get(i));
        }
        return sb.toString();
    }
}
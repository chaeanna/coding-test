import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i], " ");
            if (st.nextToken().equals("I")) {
                list.add(Integer.parseInt(st.nextToken()));
                Collections.sort(list);
            } else {
                if (st.nextToken().equals("-1")) {
                    if (list.size() != 0) {
                        list.remove(list.get(0));
                    }
                } else {
                    if (list.size() != 0) {
                        list.remove(list.get(list.size()-1));
                    }
                }
            }
        }
        
        if (list.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[1] = list.get(0);
            answer[0] = list.get(list.size()-1);
        }
        return answer;
    }
}
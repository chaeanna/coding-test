import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] soopo1 = {1, 2, 3, 4, 5};
        int[] soopo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] soopo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] soopo = new int[4];
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (soopo1[i % soopo1.length] == answer) {
                soopo[1]++;
            }
            if (soopo2[i % soopo2.length] == answer) {
                soopo[2]++;
            }
            if (soopo3[i % soopo3.length] == answer) {
                soopo[3]++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        if (soopo[1] > soopo[2]) {
            if (soopo[1] > soopo[3]) {
                list.add(1);
            } else if (soopo[1] == soopo[3]) {
                list.add(1);
                list.add(3);
            } else  {
                list.add(3);
            }
        } else if (soopo[1] == soopo[2]) {
            if (soopo[1] > soopo[3]) {
                list.add(1);
                list.add(2);
            } else if (soopo[1] == soopo[3]) {
                list.add(1);
                list.add(2);
                list.add(3);
            } else {
                list.add(3);
            }
        } else {
            if (soopo[2] > soopo[3]) {
                list.add(2);
            } else if (soopo[2] == soopo[3]) {
                list.add(2);
                list.add(3);
            } else {
                list.add(3);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
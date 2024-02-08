import java.util.*;

class Solution {
    public int solution(int[] elements) {  
        Set<Integer> set = new HashSet<>();
        
        int len = 0;
        while (len != elements.length) {
            len++;
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < len + i; j++) {
                    sum += elements[j % elements.length];
                    
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
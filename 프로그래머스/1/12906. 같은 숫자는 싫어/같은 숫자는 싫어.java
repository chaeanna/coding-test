import java.util.*;

public class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        // System.out.println(list.get(0));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != list.get(list.size()-1)) {
                list.add(arr[i]);
            }

        }
        return list;
    }
}
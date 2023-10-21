import java.util.*;

class Solution {

    public int solution(int[] queue1, int[] queue2) {

        int count = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        if((sum1+sum2)%2 != 0) return -1;

        while (sum1 != sum2) {
            if(count > (queue1.length + queue2.length) * 2)
                return -1;
            if (q1.isEmpty() || q2.isEmpty()) return -1;
            if (sum1 > sum2) {
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.add(poll);
            } else if (sum1 < sum2){
                int poll = q2.poll();
                sum1 += poll;
                sum2 -= poll;
                q1.add(poll);
            }
            count++;
        }

        return count;
    }
}
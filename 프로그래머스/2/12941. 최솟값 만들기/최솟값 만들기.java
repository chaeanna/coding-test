import java.util.*;
class Solution
{
    public int solution(int[] A, int[] B)
    {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }
        Collections.sort(a);
        Collections.sort(b,Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += (a.get(i) * b.get(i));
        }

        return answer;
    }
}
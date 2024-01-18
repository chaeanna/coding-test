class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        while(true) {
            // 순서 확인
            if ((a % 2 == 0 && a-1 == b) ||
               (b % 2 == 0 && b-1 == a)) {
                break;
            }
            answer++;
            
            if (a % 2 == 0 ) {
                a /= 2;
            } else {
                a++;
                a /= 2;
            }
            
            if (b % 2 == 0) {
                b /= 2;
            } else {
                b++;
                b /= 2;
            }
            
            
        }

        return answer;
    }
}
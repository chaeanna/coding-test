import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int caseCnt = 0;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            caseCnt++;
            if (L == 0 && P == 0 && V == 0) {
                break;
            }


            int use = V / P;
            int day = use * L;
            int remain = V % P;
            if (remain < L) {
                day += remain;
            } else {
                day += L;
            }

            sb.append("Case " + caseCnt + ": " + day).append("\n");
        }

        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] aList = new int[n];
        for (int i = 0; i < n; i++) {
            aList[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long sum = n;
        for (int i = 0; i < n; i++) {
            aList[i] -= b;
            if (aList[i] <= 0) continue;
            if (aList[i] <= c) {
                sum++;
            } else {
                int count = aList[i] / c;
                if (aList[i] % c != 0) {
                    count++;
                }
                sum += count;
            }
        }

        System.out.println(sum);
    }
}
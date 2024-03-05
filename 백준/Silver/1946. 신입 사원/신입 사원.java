import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Score implements Comparable<Score> {
    int t1, t2;

    public Score(int t1, int t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public int compareTo(Score o) {
        return this.t1 - o.t1;
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Score> list;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int t1 = Integer.parseInt(st.nextToken());
                int t2 = Integer.parseInt(st.nextToken());

                list.add(new Score(t1, t2));
            }

            Collections.sort(list);
            int min = Integer.MAX_VALUE;
            int count = 0;
            for (int k = 0; k < n; k++) {
                Score s = list.get(k);
                if (min > s.t2) {
                    min = s.t2;
                    count++;
                }

            }

            System.out.println(count);
        }


    }
}
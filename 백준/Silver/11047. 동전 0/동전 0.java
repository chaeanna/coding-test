import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (k >= num) {
                list.add(num);
            } else {
                break;
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        int answer = k;
        int count = 0;
        while (answer != 0) {
            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);
                if (num <= answer) {
                    count += (answer / num);
                    answer = k % num;
                }
                if (answer == 0) {
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
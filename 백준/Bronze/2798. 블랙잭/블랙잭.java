import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer( br.readLine(), " ");
        Integer[] num = new Integer[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num, Collections.reverseOrder());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (num[i] + num[j] + num[k] <= m) {
                        list.add(num[i] + num[j] + num[k]);
                        break;
                    }
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.get(list.size()-1));

    }

}

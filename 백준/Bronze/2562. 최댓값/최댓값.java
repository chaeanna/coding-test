import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[9];

        for (int i = 0; i < 9; i ++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int max = num[0];
        int maxIdx = 0;

        for (int i = 1; i < 9; i ++) {
            if (max < num[i]) {
                max = num[i];
                maxIdx = i;
            }
        }

        System.out.println(max);
        System.out.println(maxIdx+1);
    }
}

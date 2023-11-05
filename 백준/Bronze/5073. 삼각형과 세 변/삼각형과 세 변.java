import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] num = new int[3];
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            num[0] = Integer.parseInt(st.nextToken());
            num[1] = Integer.parseInt(st.nextToken());
            num[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(num);

            if (num[0] == 0) break;

            if (num[2] < num[0] + num[1]) {
                if (num[0] == num[2]) {
                    sb.append("Equilateral").append("\n");
                } else if (num[0] == num[1] || num[1] == num[2]) {
                    sb.append("Isosceles").append("\n");
                } else {
                    sb.append("Scalene").append("\n");
                }
            } else {
                sb.append("Invalid").append("\n");
            }

        }

        System.out.println(sb);
    }



}

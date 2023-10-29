import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while(n > 0) {
            String str = br.readLine();
            char[] strChar = str.toCharArray();
            boolean[] visited = new boolean[123];
            boolean flag = false;
            if (str.length() == 1) {
                count++;
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (visited[strChar[i]-'a']) {
                        if (strChar[i] == strChar[i-1]) continue;
                        flag = true;
                        break;
                    } else {
                        visited[strChar[i]-'a'] = true;
                    }
                }
                if(!flag) count++;
            }
            n--;
        }

        System.out.println(count);
    }
}

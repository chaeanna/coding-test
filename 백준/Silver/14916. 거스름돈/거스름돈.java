import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = -1;
        int result = n / 5;
        int remain = n % 5;
        if (remain % 2 == 0 ) {
            answer = (result + remain / 2);
        } else if (result != 0){
            while (true) {
                result--;
                remain = n - (result * 5);
                if (remain % 2 == 0) {
                    answer = (result + remain / 2);
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
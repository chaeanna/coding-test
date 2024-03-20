import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        Queue<Integer> numQ = new LinkedList<>();
        int len = str.length();
        int i = 0;
        int sum = 0;
        while (true) {
            if (i >= len) {
                break;
            }
            char c = str.charAt(i);
            if (c == '-') {
                int num = Integer.parseInt(sb.length() > 0 ? sb.toString() : "0");
                sum += num;
                sb.setLength(0);
                //괄호
                i++;
                while (true) {
                    if (i == len) {
                        break;
                    }
                    c = str.charAt(i);
                    if (c == '-') {
                        i--;
                        break;
                    } else if (c == '+') {
                        numQ.offer(Integer.parseInt(sb.toString()));
                        sb.setLength(0);
                    } else {
                        sb.append(c);
                    }
                    i++;
                }

                int n = Integer.parseInt(sb.length() > 0 ? sb.toString() : "0");
                sb.setLength(0);
                int result = n;
                while (!numQ.isEmpty()) {
                    result += numQ.poll();
                }

                sum -= result;

            } else if (c == '+') {
                int num = Integer.parseInt(sb.length() > 0 ? sb.toString() : "0");
                sum += num;
                sb.setLength(0);
            } else {
                sb.append(c);
            }
            i++;
        }

        int num = Integer.parseInt(sb.length() > 0 ? sb.toString() : "0");
        sum += num;
        System.out.println(sum);

    }
}
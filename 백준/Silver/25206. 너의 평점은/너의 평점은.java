import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        long sumCredit = 0;
        int n = 20;

        while(n-- > 0) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            switch(grade) {
                case "A+":
                    sum += (credit * 4.5);
                    sumCredit += credit;
                    break;
                case "A0":
                    sum += (credit * 4.0);
                    sumCredit += credit;
                    break;
                case "B+":
                    sum += (credit * 3.5);
                    sumCredit += credit;
                    break;
                case "B0":
                    sum += (credit * 3.0);
                    sumCredit += credit;
                    break;
                case "C+":
                    sum += (credit * 2.5);
                    sumCredit += credit;
                    break;
                case "C0":
                    sum += (credit * 2.0);
                    sumCredit += credit;
                    break;
                case "D+":
                    sum += (credit * 1.5);
                    sumCredit += credit;
                    break;
                case "D0":
                    sum += (credit * 1.0);
                    sumCredit += credit;
                    break;
                case "F":
                    sum += (credit * 0.0);
                    sumCredit += credit;
                default:
                    break;
            }
        }
        System.out.printf("%.6f", sum / sumCredit);
    }

}

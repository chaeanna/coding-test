import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        int count = 0;
        int length = str.length;
        for (int i = 0; i < length; i++) {
            char currentChar = str[i];
            if (currentChar == 'c' && i < length - 1) {
                if (str[i+1] == '=' || str[i+1] == '-') i++;
            } else if (currentChar == 'd' && i < length - 1) {
                if(str[i+1] == '-') {
                    i++;
                } else if(str[i+1] == 'z' && i < length - 2) {
                    if(str[i+2] == '=') {
                        i += 2;
                    }
                }
            } else if ((currentChar == 's' || currentChar == 'z') && i < length - 1) {
                if (str[i+1] == '=') i++;
            } else if ((currentChar == 'l' || currentChar == 'n') && i < length - 1) {
                if (str[i+1] == 'j') i++;
            }
            count++;
        }

        System.out.println(count);
    }
}

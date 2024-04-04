import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] levelList = new int[n];
        int maxIdx = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            levelList[i] = Integer.parseInt(st.nextToken());
            if (max < levelList[i]) {
                max = levelList[i];
                maxIdx = i;
            }
        }

        int level = maxIdx;

        int gold = 0;
        while (true) {
            if (level+1 >= n) break;
            gold += (levelList[maxIdx] + levelList[level+1]);
            level++;
        }
        level = maxIdx;
        while (true) {
            if (level-1 < 0) break;
            gold += (levelList[maxIdx] + levelList[level-1]);
            level--;
        }

        System.out.println(gold);


    }

}
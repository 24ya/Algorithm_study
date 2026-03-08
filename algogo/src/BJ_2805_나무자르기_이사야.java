import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2805_나무자르기_이사야 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer NM = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(NM.nextToken());
        long M = Long.parseLong(NM.nextToken());
        StringTokenizer wood = new StringTokenizer(input.readLine());
        long[] WOODS = new long[N];
        long MAX = 0;
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(wood.nextToken());
            if (x > MAX) {
                MAX = x;
            }
            WOODS[i] = x;
        }
        long L = 0;
        long R = MAX;
        long answer = 0;
        while (L <= R) {
            long temp = 0;
            long Mid = (L + R) / 2;
            for (int i = 0; i < N; i++) {
                if (WOODS[i] > Mid) {
                    temp += WOODS[i]-Mid;
                }
            }
            if (temp >= M) {
                answer = Mid;
                L = Mid+1;
            } else {
                R = Mid-1;
            }
        }
        output.append(answer).append("\n");
        System.out.println(output);
    }

}
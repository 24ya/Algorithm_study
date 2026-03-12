import java.io.*;
import java.util.*;

public class BJ_9465_스티커_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int T=Integer.parseInt(input.readLine());
        for(int test_case=1;test_case<=T;test_case++){
            int N=Integer.parseInt(input.readLine());
            int[][] stiker=new int[2][N];
            int[][] dp=new int[2][N];
            for (int i=0;i<2;i++){
                StringTokenizer st= new StringTokenizer(input.readLine());
                for(int j=0;j<N;j++){
                    stiker[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            if(N==1){
                output.append(Math.max(stiker[0][0],stiker[1][0])).append("\n");
                continue;
            }
            dp[0][0] = stiker[0][0];
            dp[1][0] = stiker[1][0];
            dp[1][1]=stiker[1][1]+stiker[0][0];
            dp[0][1]=stiker[1][0]+stiker[0][1];
            for(int i=2;i<N;i++){
                dp[0][i]=stiker[0][i]+Math.max(dp[1][i-1], dp[1][i-2]);
                dp[1][i]=stiker[1][i]+Math.max(dp[0][i-1], dp[0][i-2]);
            }
            output.append(Math.max(dp[0][N-1],dp[1][N-1])).append("\n");
        }
        System.out.println(output);
    }
}


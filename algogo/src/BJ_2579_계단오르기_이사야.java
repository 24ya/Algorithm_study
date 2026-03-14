import java.io.*;
import java.util.*;

public class BJ_2579_계단오르기_이사야 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        int[] score=new int[N+1];
        int[][] DP=new int[N+1][2];
        for (int i=1;i<N+1;i++){
            score[i]=Integer.parseInt(input.readLine());
        }
        DP[0][0]=DP[0][1]=0;
        DP[1][0]=DP[1][1]=score[1];
        for (int i=2;i<=N;i++){
            DP[i][0]=Math.max(DP[i-2][0]+score[i],DP[i-2][1]+score[i]);
            DP[i][1]=DP[i-1][0]+score[i];
        }
        System.out.println(Math.max(DP[N][0],DP[N][1]));
    }
}
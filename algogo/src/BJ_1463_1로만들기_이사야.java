import java.io.*;
import java.util.*;

public class BJ_1463_1로만들기_이사야 {
    static int[] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        DP=new int[N+1];
        DP[0]=DP[1]=0;
        for(int i=2; i<=N;i++){
            DP[i]=DP[i-1]+1;
            if (i%2==0){
                DP[i]=Math.min(DP[i],DP[i/2]+1);
            }
            if (i%3==0){
                DP[i]=Math.min(DP[i],DP[i/3]+1);
            }
        }
        System.out.println(DP[N]);
        
    }
}
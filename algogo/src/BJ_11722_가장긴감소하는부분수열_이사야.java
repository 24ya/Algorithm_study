import java.io.*;
import java.util.*;

public class BJ_11722_가장긴감소하는부분수열_이사야 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder output = new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        int[] a=new int[N];
        StringTokenizer st=new StringTokenizer(input.readLine());
        int[] dp=new int[N];
        int M=1;
        for(int i=0;i<N;i++){
            a[i]=Integer.parseInt(st.nextToken());
            dp[i]=1;
        }
        for(int i=0;i<N;i++){
            for (int j=0;j<i;j++){
                if(a[i]<a[j]&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            if (dp[i]>M){
                M=dp[i];
            }
        }
        System.out.println(M);
    }
}
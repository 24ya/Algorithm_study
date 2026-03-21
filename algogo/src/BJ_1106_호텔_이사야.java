import java.util.*;
import java.io.*;


public class BJ_1106_호텔_이사야{
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output=new StringBuilder();
		StringTokenizer CN= new StringTokenizer(input.readLine());
		int C=Integer.parseInt(CN.nextToken());
		int N=Integer.parseInt(CN.nextToken());
		int[] W=new int[N];
		int[] V=new int[N];
		int dp[]=new int[C*100+1];
		for(int i=0; i<N;i++){
			StringTokenizer st=new StringTokenizer(input.readLine());
			W[i]=Integer.parseInt(st.nextToken());
			V[i]=Integer.parseInt(st.nextToken());
		}
		int answer=Integer.MAX_VALUE;
		for (int i=0;i<N;i++){
			for (int j=W[i];j<C*100+1;j++){
				dp[j]=Math.max(dp[j],dp[j-W[i]]+V[i]);
				if (dp[j]>=C) {
					answer=Math.min(j,answer);
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
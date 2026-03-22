import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(input.readLine());
		int N=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		long[] nums=new long[N];
		st=new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++){
			nums[i]=Long.parseLong(st.nextToken());
		}
		int start=0,end=0;
		long total=0;
		while (end<N){
			total+=nums[end];
			if (total>=S) break;
			end++;
		}

		if (end==N){
			System.out.println(0);
			return;
		}
		int answer=end-start+1;

		while(end<N&&end>=start){
			if (total>=S){
				if (total-nums[start]>=S){
					total-=nums[start++];
					answer--;
				}
				else{
					total-=nums[start++];
					++end;
					if(end<N) total+=nums[end];
				}
			}
			else{
				total-=nums[start++];
				++end;
				if(end<N) total+=nums[end];
			}
		}
		System.out.println(answer);

	}
}
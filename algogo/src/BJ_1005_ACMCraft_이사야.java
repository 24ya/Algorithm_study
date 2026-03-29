import java.util.*;
import java.io.*;


public class BJ_1005_ACMCraft_이사야 {
	static int[] TIME,before;
	static boolean visited[];
	static ArrayList<Integer>[] next;
	static int N,K,W;
    public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int T=Integer.parseInt(input.readLine());
		for(int test_case=1;test_case<=T;test_case++){
			StringTokenizer NK=new StringTokenizer(input.readLine());
			N=Integer.parseInt(NK.nextToken());
			K=Integer.parseInt(NK.nextToken());
			TIME = new int[N+1];
			NK=new StringTokenizer(input.readLine());
			next=new ArrayList[N+1];
			visited=new boolean[N+1];
			before=new int[N+1];
			for(int i=1;i<=N;i++)next[i]=new ArrayList<>();
			for(int i=1;i<=N;i++) TIME[i]=Integer.parseInt(NK.nextToken());
			for(int i=0;i<K;i++){
				NK=new StringTokenizer(input.readLine());
				int a=Integer.parseInt(NK.nextToken());
				int b=Integer.parseInt(NK.nextToken());
				next[a].add(b);
				before[b]++;
			}
			W=Integer.parseInt(input.readLine());
			output.append(topologic()).append("\n");
		}
		System.out.println(output);
	}
	static int topologic(){
		int table[] =new int[N+1];
		Queue<Integer> myQueue=new LinkedList<>();
		for (int i=1;i<=N;i++){
			if (before[i]==0){
				myQueue.add(i);
				table[i]=TIME[i];
				visited[i]=true;
			}
		}
		while (!myQueue.isEmpty()){
			int now=myQueue.poll();
			if (now==W) return table[now];
			for(int i=0;i<next[now].size();i++){
				int to=next[now].get(i);
				table[to]=Math.max(table[now]+TIME[to],table[to]);
				before[to]--;
				if (before[to]==0){
					myQueue.add(to);
				}
			}
		}
		return 0;
	}
}
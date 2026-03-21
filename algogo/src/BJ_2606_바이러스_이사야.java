import java.util.*;
import java.io.*;


public class BJ_2606_바이러스{
	static boolean[][] V;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output=new StringBuilder();
		N = Integer.parseInt(input.readLine());
		int M = Integer.parseInt(input.readLine());
		V=new boolean[N+1][N+1];
		visited=new boolean[N+1];
		for (int i=0;i<M;i++){
			StringTokenizer st=new StringTokenizer(input.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			V[A][B]=V[A][B]^true;
			V[B][A]=V[B][A]^true;
		}
		System.out.println(BFS());
	}
	static int BFS(){
		int count=0;
		Queue<Integer> myQueue=new LinkedList<>();
		for(int i=1;i<N+1;i++) if (V[1][i]) myQueue.add(i);
		visited[1]=visited[1]^true;
		while(!myQueue.isEmpty()){
			int here=myQueue.poll();
			if (!visited[here]){
				visited[here]=true;
				count++;
				for(int i=1;i<=N;i++) if(V[here][i]&&!visited[i]) myQueue.add(i);
			}
		}
		return count;
	}
}
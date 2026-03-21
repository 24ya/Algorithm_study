import java.util.*;
import java.io.*;


public class BJ_1238_파티_이사야{
	static int[][] V,Vr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output=new StringBuilder();
		StringTokenizer st=new StringTokenizer(input.readLine());
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		V=new int[N+1][N+1];
		Vr=new int[N+1][N+1];
		for (int i=0;i<M;i++) {
			st=new StringTokenizer(input.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int q=Integer.parseInt(st.nextToken());
			V[x][y]=Vr[y][x]=q;
		}
		int answer=Integer.MIN_VALUE;
		int[] back=route(X);
		int[] front=routeG(X);
		for(int i=1;i<=N;i++) {
			answer=Math.max(back[i]+front[i],answer);
		}
		output.append(answer);
		System.out.println(output);
		
	}
	
	static int[] route(int s) {
		int[] cost=new int[N+1];
		for (int i=0;i<N+1;i++) {
			cost[i]=Integer.MAX_VALUE;
		}
		cost[s]=0;
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
		for(int i=0;i<N+1;i++) {
			if (V[s][i]>0) {
				pq.offer(new int[] {s,i,V[s][i]});
			}
		}
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int now_start=now[0];
			int now_to=now[1];
			int now_cost=now[2];
			// if(now_to==x) {
			// 	break;
			// }
			if(cost[now_start]+now_cost<cost[now_to]) {
				cost[now_to]=cost[now_start]+now_cost;
				for(int i=0;i<N+1;i++) {
					if (V[now_to][i]>0) {
						pq.offer(new int[] {now_to,i,V[now_to][i]});
					}
				}
			}
			
		}
		return cost;
		
	}
	static int[] routeG(int s) {
		int[] cost=new int[N+1];
		for (int i=0;i<N+1;i++) {
			cost[i]=Integer.MAX_VALUE;
		}
		cost[s]=0;
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
		for(int i=0;i<N+1;i++) {
			if (Vr[s][i]>0) {
				pq.offer(new int[] {s,i,Vr[s][i]});
			}
		}
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int now_start=now[0];
			int now_to=now[1];
			int now_cost=now[2];
			// if(now_to==x) {
			// 	break;
			// }
			if(cost[now_start]+now_cost<cost[now_to]) {
				cost[now_to]=cost[now_start]+now_cost;
				for(int i=0;i<N+1;i++) {
					if (Vr[now_to][i]>0) {
						pq.offer(new int[] {now_to,i,Vr[now_to][i]});
					}
				}
			}
			
		}
		return cost;
		
	}
}
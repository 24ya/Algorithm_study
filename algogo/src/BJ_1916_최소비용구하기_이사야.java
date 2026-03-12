import java.io.*;
import java.util.*;

public class BJ_1916_최소비용구하기_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        int M=Integer.parseInt(input.readLine());
        int[][] cost=new int[N+1][N+1];
        for (int i=1;i<N+1;i++){
            Arrays.fill(cost[i], -1);
        }
        

        int total[]=new int[N+1];
        Arrays.fill(total,Integer.MAX_VALUE);
        for(int i=0;i<M;i++){
            StringTokenizer st= new StringTokenizer(input.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int money=Integer.parseInt(st.nextToken());
            if(cost[start][end]==-1||cost[start][end]>money){
                cost[start][end]=money;
            }
        }
        StringTokenizer st= new StringTokenizer(input.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        total[start]=0;
        pq.offer(new int[] {start,0});
        while(!pq.isEmpty()){
            int now[]=pq.poll();
            int here=now[0];
            int nowcost=now[1];
            if (nowcost>total[here]){
                continue;
            }
            if (here==end){
                break;
            }
            for(int i=1;i<N+1;i++){
                    if (cost[here][i]>=0&&nowcost+cost[here][i]<total[i]){
                        total[i]=nowcost+cost[here][i];
                        pq.offer(new int[] {i,nowcost+cost[here][i]});
                    }
            }
            
        }
        output.append(total[end]);
        System.out.println(output);

    }
}


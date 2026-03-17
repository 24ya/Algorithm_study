import java.io.*;
import java.util.*;

public class BJ_2887_행성터널_이사야 {
    static int parents[];
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        parents=new int[N+1];
        for (int i=1;i<=N;i++){
            parents[i]=i;
        }
        ArrayList<int[]> xs=new ArrayList<>();
        ArrayList<int[]> ys=new ArrayList<>();
        ArrayList<int[]> zs=new ArrayList<>();
        for(int i=1;i<=N;i++){
            StringTokenizer st=new StringTokenizer(input.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());
            xs.add(new int[] {x,i});
            ys.add(new int[] {y,i});
            zs.add(new int[] {z,i});
        }
        xs.sort((a,b)->a[0]-b[0]);
        ys.sort((a,b)->a[0]-b[0]);
        zs.sort((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<N-1;i++){
            pq.offer(new int[] {xs.get(i)[1],xs.get(i+1)[1],Math.abs(xs.get(i+1)[0]-xs.get(i)[0])});
            pq.offer(new int[] {xs.get(i+1)[1],xs.get(i)[1],Math.abs(xs.get(i+1)[0]-xs.get(i)[0])});
            pq.offer(new int[] {ys.get(i)[1],ys.get(i+1)[1],Math.abs(ys.get(i+1)[0]-ys.get(i)[0])});
            pq.offer(new int[] {ys.get(i+1)[1],ys.get(i)[1],Math.abs(ys.get(i+1)[0]-ys.get(i)[0])});
            pq.offer(new int[] {zs.get(i)[1],zs.get(i+1)[1],Math.abs(zs.get(i+1)[0]-zs.get(i)[0])});
            pq.offer(new int[] {zs.get(i+1)[1],zs.get(i)[1],Math.abs(zs.get(i+1)[0]-zs.get(i)[0])});
        }
        int count=0,c=0;
        while (!pq.isEmpty()){
            int[] here=pq.poll();
            int from=here[0];
            int to =here[1];
            int cost= here[2];
            if(find(from)!=find(to)){
                union(from, to);
                c+=cost;
                count++;
            }
            if (count==N-1) break;
        }
        System.out.println(c);
    }

    static int find(int a){
        if (a==parents[a]){
            return a;
        }
        return parents[a]=find(parents[a]);
    }

    static void union(int a, int b){
        int rootA=find(a);
        int rootB=find(b);
        if (rootA!=rootB){
            parents[rootB]=rootA;
        }
    }
}
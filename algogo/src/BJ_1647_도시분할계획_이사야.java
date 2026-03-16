    import java.io.*;
    import java.util.*;

    public class BJ_1647_도시분할계획_이사야 {
        static int N,M;
        static int[][] cost;
        static int[] parents;
        public static void main(String[] args) throws IOException {
            BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
            StringBuilder output=new StringBuilder();
            StringTokenizer st=new StringTokenizer(input.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[2]-b[2]));
            for(int i=0;i<M;i++){
                StringTokenizer E = new StringTokenizer(input.readLine());
                int a= Integer.parseInt(E.nextToken());
                int b= Integer.parseInt(E.nextToken());
                int c= Integer.parseInt(E.nextToken());
                pq.add(new int[] {a,b,c});
            }
            parents=new int[N+1];
            for (int i=1;i<N+1;i++){
                parents[i]=i;
            }
            if (N == 2) {
                System.out.println(0);
                return;
            }
            int count=0;
            int C=0;
            while (!pq.isEmpty()){
                int[] V=pq.poll();
                int now=V[0];
                int next=V[1];
                int coster=V[2];
                if (find(now)!=find(next)){
                    count++;
                    C+=coster;
                    union(now, next);
                }
                if (count==N-2){
                    break;
                }
            }
            System.out.println(C);
        }

        static int find(int a){
            if (parents[a]==a){
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
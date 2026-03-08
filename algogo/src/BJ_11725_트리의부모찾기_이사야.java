import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11725_트리의부모찾기_이사야 {
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] connect;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        connect=new ArrayList[N+1];
        parents = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            connect[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<N-1;i++){
            StringTokenizer st=new StringTokenizer(input.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            connect[A].add(B);
            connect[B].add(A);
        }
        dfs(1);
        for (int i=2;i<=N;i++){
            output.append(parents[i]).append("\n");
        }
        System.out.println(output);
    }

    static void dfs(int n){
        visited[n]=true;
        for(int next:connect[n]){
            if(!visited[next]){
                parents[next]=n;
                dfs(next);
            }
        }
    }
}
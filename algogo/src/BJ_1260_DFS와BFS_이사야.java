import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS_이사야 {
    static ArrayList<Integer>[] connect;
    static boolean visited[];
    static StringBuilder output;
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        output=new StringBuilder();
        StringTokenizer st= new StringTokenizer(input.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int V=Integer.parseInt(st.nextToken());
        connect=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            connect[i]=new ArrayList<Integer>();
        }
        for (int i=0;i<M;i++){
            StringTokenizer AB=new StringTokenizer(input.readLine());
            int A=Integer.parseInt(AB.nextToken());
            int B=Integer.parseInt(AB.nextToken());
            connect[A].add(B);
            connect[B].add(A);
        }
        for(int i=1;i<=N;i++){
            connect[i].sort(Comparator.naturalOrder());
        }
        visited=new boolean[N+1];
        DFS(V);
        output.append("\n");
        visited=new boolean[N+1];
        BFS(V);
        System.out.println(output);
    }
    static void DFS(int n){
        visited[n]=true;
        output.append(n).append(" ");
        for(int e:connect[n]){
            if(!visited[e]){
                DFS(e);
            }
        }
    }
    static void BFS(int n){
        visited[n]=true;
        output.append(n).append(" ");
        Queue<Integer> myQueue=new LinkedList<>();
        for(int e:connect[n]){
            myQueue.add(e);
        }
        while(!myQueue.isEmpty()){
            int now=myQueue.poll();
            if (!visited[now]){
                output.append(now).append(" ");
                visited[now]=true;
                for(int e:connect[now]){
                    myQueue.add(e);
                }
            }
        }
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_이사야 {
    static boolean visited[];
    static int[][] JIDO;
    static int answer;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer NM=new StringTokenizer(input.readLine());
        N=Integer.parseInt(NM.nextToken());
        M=Integer.parseInt(NM.nextToken());
        visited=new boolean[26];
        JIDO=new int[N][M];
        answer=0;
        for (int i=0;i<N;i++){
            String st=input.readLine();
            for(int j=0;j<M;j++){
                JIDO[i][j]=st.charAt(j)-65;
            }
        }
        visited[JIDO[0][0]]=true;

        DFS(0,0,1);
        System.out.println(answer);
    }
    static void DFS(int x, int y, int depth) {
    answer = Math.max(answer, depth);
    for (int i = 0; i < 4; i++) {
        int nextx = x + dx[i];
        int nexty = y + dy[i];
        
        if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M) {
            int nextChar = JIDO[nextx][nexty];
            
            if (!visited[nextChar]) {
                visited[nextChar] = true; 
                DFS(nextx, nexty, depth + 1); 
                visited[nextChar] = false; 
            }
        }
    }
}
}


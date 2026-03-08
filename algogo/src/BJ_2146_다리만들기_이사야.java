import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2146_다리만들기_이사야 {
    static int[][] JIDO;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int answer=Integer.MAX_VALUE;
        N = Integer.parseInt(input.readLine());
        JIDO= new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(input.readLine());
            for(int j=0; j<N; j++){
                JIDO[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int marknum=2;
        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (JIDO[i][j]==1){
                    marking(i, j, marknum);
                    marknum++;
                }
            }
        }
        for(int i=2;i<marknum;i++){
            answer=Math.min(bfs(i),answer);
        }
        System.out.println(answer);
    }

    static void marking(int x,int y,int marknum){
        if(x<0||x>=N||y<0||y>=N||JIDO[x][y]==0||JIDO[x][y]==marknum){
            return;
        }
        else{
            JIDO[x][y]=marknum;
            for (int i=0;i<4;i++){
                marking(x+dx[i], y+dy[i], marknum);
            }
        }
    }

    static int bfs(int n){
        Queue<int[]> myQueue=new LinkedList<>();
        int[][] dist=new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                dist[i][j]=-1;
            }
        }
        for (int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                if (JIDO[i][j]==n){
                    myQueue.add(new int[] {i,j});
                    dist[i][j]=0;
                }
            }
        }
        while(!myQueue.isEmpty()){  
            int[] now=myQueue.poll();
            int nowx=now[0];
            int nowy=now[1];
            for (int i=0;i<4;i++){
                int nextx=nowx+dx[i];
                int nexty=nowy+dy[i];
                if(nextx>=0&&nextx<N&&nexty>=0&&nexty<N){
                    if (JIDO[nextx][nexty]==0&&dist[nextx][nexty]==-1){
                        dist[nextx][nexty]=dist[nowx][nowy]+1;
                        myQueue.add(new int[] {nextx,nexty});
                    }
                    else if(JIDO[nextx][nexty]>0&&JIDO[nextx][nexty]!=n){
                        return dist[nowx][nowy];
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2718_미로_이사야 {
    static int[][] MIRO;
    static int[][] MIRO_visited;
    static int answer =Integer.MAX_VALUE;
    static Queue<int[]> MyQueue=new LinkedList<>();
    static int N,M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer NM=new StringTokenizer(input.readLine());
        N=Integer.parseInt(NM.nextToken());
        M=Integer.parseInt(NM.nextToken());
        MIRO=new int[N][M];
        for (int i=0;i<N;i++){
            String Road=input.readLine();
            for(int j=0;j<M;j++){
                MIRO[i][j]=Road.charAt(j)-'0';
            }
        }
        MIRO_visited=MIRO.clone();
        System.out.println(goRoad(N,M));
    }


    static int goRoad(int N,int M){
        int[] start={0,0};
        MyQueue.add(start);
        MIRO_visited[0][0]=0;
        int count=1;

        int[] dx={0,0,-1,1};
        int[] dy={1,-1,0,0};
        boolean Stepcount=false;
        while (!MyQueue.isEmpty()) {
            int step=MyQueue.size();
            for(int j=0;j<step;j++){
                int[] here=MyQueue.poll();
                for(int i=0;i<4;i++){
                    int F=visit_check(here[0]+dx[i],here[1]+dy[i]);
                    if(F>0){
                        if(!Stepcount){
                            count++;
                            Stepcount=true;
                        }
                        if(F==2){
                            return count;
                        }
                        int[] next={here[0]+dx[i],here[1]+dy[i]};
                        MyQueue.add(next);
                    }
                }
            }
            Stepcount=false;
        }
        return count;
    }


    static int visit_check(int X,int Y){
        if (X<0||Y<0||X>=N||Y>=M||MIRO_visited[X][Y]==0){
            return 0;
        }
        MIRO_visited[X][Y]=0;
        if (X==N-1&&Y==M-1){
            return 2;
        } else{
            return 1;
        }
    }

}
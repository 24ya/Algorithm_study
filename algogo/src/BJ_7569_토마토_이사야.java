import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;




public class BJ_7569_토마토_이사야 {
    static int M,N,H;
    
    static int[][][] Tomato;
    static Queue<int[]> MyQueue=new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        StringTokenizer MN=new StringTokenizer(input.readLine());
        N=Integer.parseInt(MN.nextToken());
        M=Integer.parseInt(MN.nextToken());
        H=Integer.parseInt(MN.nextToken());
        Tomato=new int[H][M][N];
        for(int h=0;h<H;h++){
            for(int i=0;i<M;i++){
                StringTokenizer Ns=new StringTokenizer(input.readLine());
                for(int j=0;j<N;j++){
                    Tomato[h][i][j]=Integer.parseInt(Ns.nextToken());
                }
            }
        }
        int result_day=TomatoBox(M,N,H);
        for(int h=0;h<H;h++){
            for (int i=0;i<M;i++){
                for (int j=0;j<N;j++){
                    if (Tomato[h][i][j]==0){
                        result_day=-1;
                        break;
                    }
                }
            }
        }
        output.append(result_day);
        System.out.println(output);
    }

    static int TomatoBox(int M,int N,int H){
        int day=0;
        int dh[]={1,-1,0,0,0,0};
        int dx[]={0,0,0,0,-1,1};
        int dy[]={0,0,-1,1,0,0};
        //큐 생성 및 입력
        for (int h=0;h<H;h++){
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if (Tomato[h][i][j]==1){
                        int[] node={h,i,j};
                        MyQueue.add(node);
                    }
                }
            }
        }
        boolean day_counted=false;
        while(!MyQueue.isEmpty()){
            int one_day_end=MyQueue.size();
            for (int i=0;i<one_day_end;i++){
                int[] node=MyQueue.poll();
                for (int j=0;j<6;j++){
                    if(makeTomato(node[0]+dh[j],node[1]+dx[j],node[2]+dy[j])){
                        if (!day_counted){
                            day_counted=true;
                            day++;
                        }
                        int[] nextnode={node[0]+dh[j],node[1]+dx[j],node[2]+dy[j]};
                        MyQueue.add(nextnode);
                    }
                }
            }
            day_counted=false;
        }
        return day;
    }

    static boolean makeTomato(int Z,int X,int Y){
        if (Z<0||X<0||Y<0||X>=M||Y>=N||Z>=H){
            return false;
        }
        if (Tomato[Z][X][Y]==0){
            Tomato[Z][X][Y]=1;
            return true;
        }
        else{
            return false;
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import java.util.StringTokenizer;

public class BJ_2667_단지번호붙이기_이사야 {
    static int[][] jido;
    static int N;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        N=Integer.parseInt(input.readLine());
        jido=new int[N][N];
        for(int i=0;i<N;i++){
            String OneLine=input.readLine();
            for (int j=0;j<N;j++){
                jido[i][j]=OneLine.charAt(j)-'0';
            }
        }
        List<Integer> answer=search();
        Integer[] ANSWER=answer.toArray(new Integer[0]);
        Arrays.sort(ANSWER);
        output.append(ANSWER.length).append("\n");
        for (int A:ANSWER){
            output.append(A).append("\n");
        }
        System.out.println(output);
    }


    static List<Integer> search(){
        List<Integer> sede=new ArrayList<>();
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if(jido[i][j]==1){
                    count=0;
                    danji(i,j);
                    sede.add(count);
                }
            }
        }
        return sede;
    }


    static void danji(int X,int Y){
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        if (X>=N||Y>=N||X<0||Y<0){
            return;
        }

        if (jido[X][Y]==0){
            return;
        }

        jido[X][Y]=0;
        count++;
        for(int i=0;i<4;i++){
            danji(X+dx[i], Y+dy[i]);
        }
    }
}
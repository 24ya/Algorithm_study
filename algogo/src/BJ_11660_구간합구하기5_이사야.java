import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5_이사야 {
    static boolean[] visit;
    static int N;
    static int[] numbers;
    static Integer[] answer_subset={};
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output= new StringBuilder();
        StringTokenizer NM=new StringTokenizer(input.readLine());
        int N=Integer.parseInt(NM.nextToken());
        int M=Integer.parseInt(NM.nextToken());
        int[][] DPtable=new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer Line=new StringTokenizer(input.readLine());
            for(int j=0;j<N;j++){
                if(i==0&&j==0){
                    DPtable[i][j]=Integer.parseInt(Line.nextToken());
                }
                else if (i!=0&&j!=0){
                    DPtable[i][j]=Integer.parseInt(Line.nextToken())+DPtable[i][j-1]+DPtable[i-1][j]-DPtable[i-1][j-1];
                } else if (i==0){
                    DPtable[i][j]=Integer.parseInt(Line.nextToken())+DPtable[i][j-1];
                } else if (j==0){
                    DPtable[i][j]=Integer.parseInt(Line.nextToken())+DPtable[i-1][j];
                }
            }
        }
        for(int i=0; i<M; i++){
            int answer=0;
            StringTokenizer XY=new StringTokenizer(input.readLine());
            int x1=Integer.parseInt(XY.nextToken());
            int y1=Integer.parseInt(XY.nextToken());
            int x2=Integer.parseInt(XY.nextToken());
            int y2=Integer.parseInt(XY.nextToken());
            answer+=DPtable[x2-1][y2-1];
            if(x1!=1){
                answer-=DPtable[x1-2][y2-1];
            }
            if(y1!=1){
                answer-=DPtable[x2-1][y1-2];
            }
            if(x1!=1&&y1!=1){
                answer+=DPtable[x1-2][y1-2];
            }
            output.append(answer).append("\n");
        }
        System.out.println(output);
    }
}



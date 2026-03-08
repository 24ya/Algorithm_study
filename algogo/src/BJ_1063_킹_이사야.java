import java.io.*;
import java.util.*;

public class BJ_1063_킹_이사야 { //64빼면 됨
    static int[] dx={0,0,-1,1,1,-1,1,-1};
    static int[] dy={1,-1,0,0,1,1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer st= new StringTokenizer(input.readLine());
        String king=st.nextToken();
        String dole=st.nextToken();
        int N=Integer.parseInt(st.nextToken());
        int kingx=king.charAt(0)-'A'+1;
        int kingy=king.charAt(1)-'0';
        int dolex=dole.charAt(0)-'A'+1;
        int doley=dole.charAt(1)-'0';
        for(int i=0;i<N;i++){
            String command=input.readLine();
            int nextx=0,nexty=0,arrow=-1;
            switch(command){
                case "T":
                    arrow=0;
                    break;
                case "B":
                    arrow=1;
                    break;
                case "L":
                    arrow=2;
                    break;
                case "R":
                    arrow=3;
                    break;
                case "RT":
                    arrow=4;
                    break;
                case "LT":
                    arrow=5;
                    break;
                case "RB":
                    arrow=6;
                    break;
                case "LB":
                    arrow=7;
                    break;
            }
            nextx=kingx+dx[arrow];
            nexty=kingy+dy[arrow];
            if (nextx>=1&&nextx<=8&&nexty>=1&&nexty<=8){
                if(nextx==dolex&&nexty==doley){
                    if (dolex+dx[arrow]>=1&&dolex+dx[arrow]<=8&&doley+dy[arrow]>=1&&doley+dy[arrow]<=8){
                        dolex=dolex+dx[arrow];
                        doley=doley+dy[arrow];
                        kingx=nextx;
                        kingy=nexty;
                    }
                }
                else{
                    kingx=nextx;
                    kingy=nexty;
                }
            }
        }
        output.append((char)(kingx+64)).append(kingy).append("\n").append((char)(dolex+64)).append(doley);
        System.out.println(output);
    }
}
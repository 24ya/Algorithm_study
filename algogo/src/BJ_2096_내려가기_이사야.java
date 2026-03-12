import java.io.*;
import java.util.StringTokenizer;

public class BJ_2096_내려가기_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        int[][] dpmax=new int[N][3];
        int[][] dpmin=new int[N][3];
        for (int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(input.readLine());
            for(int j=0;j<3;j++){
                int now=Integer.parseInt(st.nextToken());
                if (i==0){
                    dpmax[0][j]=now;
                    dpmin[0][j]=now;
                } else {
                    if (j==0){
                        dpmax[i][j]=Math.max(dpmax[i-1][j],dpmax[i-1][j+1])+now;
                        dpmin[i][j]=Math.min(dpmin[i-1][j],dpmin[i-1][j+1])+now;
                    } else if(j==1){
                        dpmax[i][j]=Math.max(Math.max(dpmax[i-1][j],dpmax[i-1][j+1]),dpmax[i-1][j-1])+now;
                        dpmin[i][j]=Math.min(Math.min(dpmin[i-1][j],dpmin[i-1][j+1]),dpmin[i-1][j-1])+now;
                    } else{
                        dpmax[i][j]=Math.max(dpmax[i-1][j],dpmax[i-1][j-1])+now;
                        dpmin[i][j]=Math.min(dpmin[i-1][j],dpmin[i-1][j-1])+now;
                    }
                }
            }
        }
        output.append(Math.max(Math.max(dpmax[N-1][0], dpmax[N-1][1]),dpmax[N-1][2])).append(" ").append(Math.min(Math.min(dpmin[N-1][0], dpmin[N-1][1]),dpmin[N-1][2]));
        System.out.println(output);
    }
}


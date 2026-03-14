import java.io.*;
import java.util.*;

public class BJ_14888_연산자끼워넣기_이사야 {
    static int[] num, dix;
    static boolean visited[];
    static int N,M,m;
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        N=Integer.parseInt(input.readLine());
        num=new int[N];
        dix=new int[N-1];
        visited=new boolean[N-1];
        M=Integer.MIN_VALUE;
        m=Integer.MAX_VALUE;
        StringTokenizer st=new StringTokenizer(input.readLine());
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(input.readLine());
        int start=0;
        for(int i=0;i<4;i++){
            int end=Integer.parseInt(st.nextToken());
            for(int j=start;j<start+end;j++){
                dix[j]=i;
            }
            start+=end;
        }
        DFS(num[0],0);
        output.append(M).append("\n").append(m);
        System.out.println(output);
    }
    static void DFS(int result,int depth){
        if (depth==N-1){
            if (result>M){
                M=result;
            }
            if (result<m){
                m=result;
            }
            return;
        }
        for (int i=0;i<N-1;i++){
            if (!visited[i]){
                visited[i]=true;
                if (dix[i]==0){
                    DFS(result+num[depth+1],depth+1);
                }else if (dix[i]==1){
                    DFS(result-num[depth+1],depth+1);
                }else if (dix[i]==2){
                    DFS(result*num[depth+1],depth+1);
                }else if (dix[i]==3){
                    DFS(result/num[depth+1],depth+1);
                }
                visited[i]=false;
            }
        }
    }
}
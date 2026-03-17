import java.io.*;
import java.util.StringTokenizer;

public class BJ_2467_용액_이사야 {
    static int parents[];
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        int[] plask=new int[N];
        StringTokenizer st=new StringTokenizer(input.readLine());
        for(int i=0;i<N;i++){
            plask[i]=Integer.parseInt(st.nextToken());
        }
        int L=0,R=N-1;
        int[] check=new int[3];
        check[2]=Integer.MAX_VALUE;
        while(L<R){
            int SUM=plask[L]+plask[R];
            if (check[2]>=Math.abs(plask[L]+plask[R])){
                check[0]=L;check[1]=R;check[2]=Math.abs(plask[L]+plask[R]);
            }
            if (SUM<0) L++;
            else if(SUM>0) R--;
            else break;
        }
        output.append(plask[check[0]]).append(" ").append(plask[check[1]]);
        System.out.println(output);
    }
}